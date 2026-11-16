import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();

        manager.addOrder(new OnlineOrder(1001, "Emma", LocalDate.of(2026, 11, 15),
                "12 Main St, Downtown City", "TRK123456"));
        manager.addOrder(new OnlineOrder(1002, "Omar", LocalDate.of(2026, 11, 15),
                "Rural Village Road, Delta", "TRK234567"));
        manager.addOrder(new OnlineOrder(1003, "Lina", LocalDate.of(2026, 11, 14),
                "45 Park Ave, International Zone", "TRK345678"));

        System.out.println("=== All Orders ===");
        manager.displayAll();

        // تحديث الطلب تاني عن تريق الرقم
        OnlineOrder order = manager.findByTracking("TRK123456");
        if (order != null) {
            order.updateTrackingStatus("Shipped");
            order.updateTrackingStatus("Out for Delivery");
            order.displayHistory();
        }

        // بحث باسم العميل 
        System.out.println("\nOrders for Omar:");
        for (OnlineOrder o : manager.findByCustomer("Omar")) {
            o.displayOrder();
        }
    }
}