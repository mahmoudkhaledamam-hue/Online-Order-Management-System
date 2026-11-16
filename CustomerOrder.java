import java.time.LocalDate;

public class CustomerOrder {
    protected int orderId;
    protected String customer;
    protected LocalDate orderDate;

    public CustomerOrder(int orderId, String customer, LocalDate orderDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public int getOrderId() { return orderId; }
    public String getCustomer() { return customer; }
    public LocalDate getOrderDate() { return orderDate; }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customer);
        System.out.println("Order Date: " + orderDate);
    }
}