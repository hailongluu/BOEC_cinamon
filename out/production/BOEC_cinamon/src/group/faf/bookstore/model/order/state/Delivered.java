package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class Delivered implements DeliveryState {
    public static final String name = "Delivered";

    public static Delivered instance = new Delivered();

    public Delivered() {
    }

    public static Delivered getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order order) {
        order.setCurrentDeliveryState(Delivered.getInstance());
    }
}

