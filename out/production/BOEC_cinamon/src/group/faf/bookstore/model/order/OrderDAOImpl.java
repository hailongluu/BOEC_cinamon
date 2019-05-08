package group.faf.bookstore.model.order;

import java.sql.ResultSet;

import group.faf.bookstore.model.product.Product;
import group.faf.bookstore.model.product.book.Book;
import group.faf.bookstore.model.common.TimeConvert;
import group.faf.bookstore.model.connection.DBconnection;
import group.faf.bookstore.model.customer.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class OrderDAOImpl implements OrderDAO {

    private List<Order> listOrders;
    Connection connection;

    public OrderDAOImpl() {
        DBconnection dBconnection = new DBconnection();
        try {
            connection = dBconnection.getConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrder() {
        return null;
    }

    @Override
    public Order getAllOrder() {


        return null;
    }

    @Override
    public List<Order> getListOrder(int OrderStatus) {
        return null;
    }

    @Override
    public int addOrder(Order order) {
        try {
            String sql="INSERT INTO order (`Status`, `CreateTime`, `PaymentMethod`, `CustomerId`, `cartId`, `deliverySate`) VALUES (?,?,?,?,?,?);\n;";
            PreparedStatement pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pre.setString(1,order.getCurrentState().getClass().getSimpleName());
            pre.setString(2, TimeConvert.convertToString(order.getCreateTime()));
            pre.setString(3,order.getPaymentMethod().name());
            pre.setInt(4,order.getIdCustomer());
            pre.setInt(5,order.getCart().getId());
            pre.setString(6,order.getCurrentDeliveryState().getClass().getSimpleName());

            pre.executeUpdate();
            ResultSet rs= pre.getGeneratedKeys();
            int orderId = 0;
            while (rs.next()){
                orderId = rs.getInt(1);
            }
            addCart(order.getCart(),orderId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
         private void addCart(Cart cart,int orderId) throws SQLException {
            String sql2 = "INSERT INTO cart (`customerId`, `customerName`) VALUES (?, ?);\n";
            PreparedStatement preCart = connection.prepareStatement(sql2,Statement.RETURN_GENERATED_KEYS);
            preCart.setInt(1,cart.getCustomerId());
            preCart.setString(2,cart.getCustomerName());
            preCart.executeUpdate();
            ResultSet rs = preCart.getGeneratedKeys();
            int idCard=0;
            while (rs.next()){
                idCard = rs.getInt(1);
            };


            String sql ="INSERT INTO productcart (`cartId`, `productId`, `table`, `quantity`) VALUES;\n";
        StringBuilder sb = new StringBuilder(sql);
        for (Map.Entry<Product, Integer> productIntegerEntry : cart.getProducts().entrySet()) {
            sb.append("(").append(idCard).append(",").append(productIntegerEntry.getKey().getId()).append(",").append(productIntegerEntry.getKey().getClass().getSimpleName()).append(",").append(productIntegerEntry.getValue()).append("),");

        }
//        for (Product product : cart.getProducts()) {
//            sb.append("(").append(idCard).append(product.getId()).append(",").append(product.getClass().getSimpleName()).append(",").append("),");
//        }
        sb.deleteCharAt(sb.length()-1);

        PreparedStatement pre =connection.prepareStatement(sb.toString());
        pre.executeUpdate();
    }

    @Override
    public int updateOrder(int id, int status) {
        try {
            String sql = "UPDATE order SET `Status`=? WHERE `ID`=?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1,status);
            pre.setInt(2,id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Order> getListOrderOfCustomer(Customer customer) {
        return null;
    }

}