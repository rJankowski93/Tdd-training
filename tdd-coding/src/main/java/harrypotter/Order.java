package harrypotter;

import java.io.Serializable;
import java.util.TreeMap;

public class Order implements Serializable{

    TreeMap<String, Integer> books = new TreeMap<String, Integer>();

    public void addBook(String name, Integer amount) {
        books.put(name, amount);
    }

    public TreeMap<String, Integer> getBooks() {
        return books;
    }

}
