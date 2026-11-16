import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OnlineOrder extends CustomerOrder {
    private String deliveryAddress;
    private String trackingNumber;
    private String trackingStatus;
    private List<String> statusHistory = new ArrayList<>();

    public OnlineOrder(int orderId, String customer, LocalDate orderDate,
                       String deliveryAddress, String trackingNumber) {
        super(orderId, customer, orderDate);
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        this.trackingStatus = "Order Placed";
        statusHistory.add(trackingStatus);
    }

    public String getTrackingNumber() { return trackingNumber; }
    public String getTrackingStatus() { return trackingStatus; }

    public int calculateDeliveryDays() {
        String addr = deliveryAddress.toLowerCase();
        if (addr.contains("international") || addr.contains("overseas")) {
            return 14;
        } else if (addr.contains("rural") || addr.contains("village")) {
            return 7;
        } else if (addr.contains("city") || addr.contains("downtown")) {
            return 2;
        }
        return 5;
    }

    public LocalDate getEstimatedDeliveryDate() {
        return orderDate.plusDays(calculateDeliveryDays());
    }

    public void updateTrackingStatus(String newStatus) {
        this.trackingStatus = newStatus;
        statusHistory.add(newStatus);
        System.out.println("Tracking [" + trackingNumber + "] updated to: " + newStatus);
    }

    public void displayHistory() {
        System.out.println("History of " + trackingNumber + ": "
                + String.join(" -> ", statusHistory));
    }

    @Override
    public void displayOrder() {
        super.displayOrder();
        System.out.println("Delivery Address: " + deliveryAddress);
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Status: " + trackingStatus);
        System.out.println("Estimated Delivery: " + getEstimatedDeliveryDate()
                + " (" + calculateDeliveryDays() + " days)");
    }
}