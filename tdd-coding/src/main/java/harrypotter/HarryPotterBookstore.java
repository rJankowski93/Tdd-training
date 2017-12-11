package harrypotter;

import java.util.*;
import java.util.stream.Collectors;

public class HarryPotterBookstore {

	Integer DEFAULT_PRICE = 8;

	Integer MAIN_LEVEL_DISCOUNT = 5;

	public double buy(Order order) {
		if (order.getBooks().size() == 1) {
			return DEFAULT_PRICE * order.getBooks().firstEntry().getValue();
		}
		return getTotalPrice(order);
	}

	private double getTotalPrice(Order order) {
		MAIN_LEVEL_DISCOUNT = order.getBooks().size();
		List<Double> results = new ArrayList<>();
		for (int i = 0; i < MAIN_LEVEL_DISCOUNT; i++) {
			LinkedHashMap<String, Integer> basket = order.getBooks().entrySet()
					.stream()
					.sorted(Map.Entry.comparingByValue((o1, o2) -> (-1) * o1.compareTo(o2)))
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
							(e1, e2) -> e1, LinkedHashMap::new));
			double total = 0;
			while (!basket.isEmpty()) {
				Integer discountLevel = calculateDiscountLevel(basket);
				double discount = getDiscount(discountLevel);
				double price = getPriceForBiggestDiscount(basket, discountLevel);
				total += price - (discount * price);
			}
			MAIN_LEVEL_DISCOUNT--;
			results.add(total);
		}
		return Collections.min(results);
	}

	private double getPriceForBiggestDiscount(LinkedHashMap<String, Integer> basket, Integer discountLevel) {
		double price = 0;
		Iterator<Map.Entry<String, Integer>> iterator = basket.entrySet().iterator();
		for (int i = 0; i < discountLevel; i++) {
			Map.Entry<String, Integer> basketItem = iterator.next();
			basketItem.setValue(basketItem.getValue() - 1);
			price += DEFAULT_PRICE;
			if (basketItem.getValue() == 0) {
				iterator.remove();
			}
		}
		return price;
	}

	private Integer calculateDiscountLevel(LinkedHashMap<String, Integer> basket) {
		if (MAIN_LEVEL_DISCOUNT <= basket.size()) {
			return MAIN_LEVEL_DISCOUNT;
		}
		return basket.size();
	}

	private double getDiscount(Integer discountLevel) {
		if (discountLevel == 2) {
			return 0.05;
		}
		if (discountLevel == 3) {
			return 0.1;
		}
		if (discountLevel == 4) {
			return 0.2;
		}
		if (discountLevel == 5) {
			return 0.25;
		}
		return 0;
	}
}
