package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class Paid implements OrderState {
    public static final String name = "Paid";

    private static Paid instance = new Paid();

    public Paid() {
    }

    public static Paid getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order order) {
        order.setcurrentState(this.getInstance());
    }
}
