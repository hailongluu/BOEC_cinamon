package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class Packaged implements DeliveryState {
    public static final String name = "Packaged";

    public static Packaged instance = new Packaged();

    public static Packaged getInstance() {
        return instance;
    }

    public Packaged() {
    }

    @Override
    public void updateState(Order order) {
       order.setCurrentDeliveryState(Shipped.getInstance());
    }
}
