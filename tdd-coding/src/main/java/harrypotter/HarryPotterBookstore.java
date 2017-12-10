package harrypotter;

import org.apache.commons.lang3.SerializationUtils;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

public class HarryPotterBookstore {

    Integer DEFAULT_PRICE = 8;

    public double buy(Order order) {
        if (order.getBooks().size() == 1) {
            return DEFAULT_PRICE * order.getBooks().firstEntry().getValue();
        }
        return getTotalPrice(order);
    }

    private double getTotalPrice(Order order) {
        LinkedHashMap<String, Integer> basket = order.getBooks().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> (-1) * o1.compareTo(o2)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        double total = 0;
        while (!basket.isEmpty()) {
            double discount = getDiscount(basket);
            double price = getPriceForBiggestDiscount(basket);
            total += price - (discount * price);
        }
        return total;
    }

    private double getPriceForBiggestDiscount(LinkedHashMap<String, Integer> basket) {
        double price = 0;
        Iterator<Map.Entry<String, Integer>> iterator = basket.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> basketItem = iterator.next();
            basketItem.setValue(basketItem.getValue() - 1);
            price += DEFAULT_PRICE;
            if (basketItem.getValue() == 0) {
                iterator.remove();
            }
        }
        return price;
    }

    private double getDiscount(LinkedHashMap<String, Integer> basket) {
        double discount = 0;
        if (basket.size() == 2) {
            discount = 0.05;
        }
        if (basket.size() == 3) {
            discount = 0.1;
        }
        if (basket.size() == 4) {
            discount = 0.2;
        }
        if (basket.size() == 5) {
            discount = 0.25;
        }
        return discount;
    }
}
