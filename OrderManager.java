import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderManager {
    private List<OnlineOrder> orders = new ArrayList<>();
    private Map<String, OnlineOrder> trackingIndex = new HashMap<>();

    public void addOrder(OnlineOrder order) {
        orders.add(order);
        trackingIndex.put(order.getTrackingNumber(), order);
    }

    // بحث سريع برقم التتبع (HashMap)
    public OnlineOrder findByTracking(String trackingNumber) {
        return trackingIndex.get(trackingNumber);
    }

    // بحث باسم العميل (ممكن يكون له أكتر من طلب)
    public List<OnlineOrder> findByCustomer(String name) {
        List<OnlineOrder> result = new ArrayList<>();
        for (OnlineOrder o : orders) {
            if (o.getCustomer().equalsIgnoreCase(name)) {
                result.add(o);
            }
        }
        return result;
    }

    public void displayAll() {
        for (OnlineOrder o : orders) {
            o.displayOrder();
            System.out.println("-----------------------");
        }
    }
}