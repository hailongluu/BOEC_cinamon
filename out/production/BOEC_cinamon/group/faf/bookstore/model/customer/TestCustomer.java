package group.faf.bookstore.model.customer;

public class TestCustomer {
    static CustomerDAOImpl customerDAO = new CustomerDAOImpl();
    public static void main(String[] args) {
//        getCustomer();
//        addCus();
    }
    public static void getCustomer(){
        System.out.println(customerDAO.getCustomerByAccount(1));
    }
    public static void addCus(){
        Account account = new Account("halo","123456");
        FullName fullName = new FullName("Hoang", "Van", "B");
        Address address = new Address(1,"Dinh cong ha hoang mai","30",null,null,null,null);
        Customer customer = new Customer(account,fullName,address,1);
        customerDAO.addCustomer(customer);
    }
}
