package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class OutForDelivery implements DeliveryState {
    public static final String name = "Out For Delivery";

    public static OutForDelivery instance = new OutForDelivery();

    public OutForDelivery() {
    }

    public static OutForDelivery getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order order) {
        order.setCurrentDeliveryState(Delivered.getInstance());
    }
}
