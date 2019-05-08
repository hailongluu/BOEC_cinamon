package group.faf.bookstore.model.product;

import group.faf.bookstore.model.product.book.Book;
import group.faf.bookstore.model.product.clother.Clother;
import group.faf.bookstore.model.product.electronic.Electronic;

import java.util.ArrayList;
import java.util.List;

public class TestProduct {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Book());
        products.add(new Clother());
        products.add(new Electronic());
        for (Product product : products) {
            System.out.println(product.getClass().getSimpleName());
        }

    }
}
