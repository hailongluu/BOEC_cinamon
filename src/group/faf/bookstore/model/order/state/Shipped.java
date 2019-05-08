package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class Shipped implements DeliveryState {
    public static final String name = "Shipped";

    public static Shipped instance = new Shipped();

    public static Shipped getInstance() {
        return instance;
    }

    public Shipped() {
    }

    @Override
    public void updateState(Order order) {
    order.setCurrentDeliveryState(OutForDelivery.getInstance());
    }
}
