package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public interface DeliveryState {
    public void updateState(Order order);
}
