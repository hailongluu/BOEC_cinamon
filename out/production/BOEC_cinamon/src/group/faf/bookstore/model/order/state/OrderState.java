package group.faf.bookstore.model.order.state;

import group.faf.bookstore.model.order.Order;

public interface OrderState {
    public void updateState(Order order);
}
