import java.util.ArrayList;

class Order {
    private Customer customer;
    private ArrayList<OrderItem> items;
    private OrderType orderType;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item, int quantity) {
        items.add(new OrderItem(item, quantity));
    }

    public void setOrderType(OrderType type) {
        this.orderType = type;
    }

    public void displayOrderDetails() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Order Type: " + orderType);
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println(item.getQuantity() + " x " + item.getMenuItem().getName() + " = Rp" + item.getTotalPrice());
        }
        System.out.println("Total Price: Rp" + getTotalPrice());
    }

    public double getTotalPrice() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }
}
