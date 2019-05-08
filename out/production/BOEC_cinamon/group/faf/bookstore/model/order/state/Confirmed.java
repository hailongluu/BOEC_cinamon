package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public class Confirmed implements OrderState {
    public static final String name = "Confirmed";


    private static Confirmed instance = new Confirmed();

    public Confirmed() {
    }

    public static Confirmed getInstance() {
        return instance;
    }

    @Override
    public void updateState(Order order) {
        order.setcurrentState(Paid.getInstance());
    }
}
