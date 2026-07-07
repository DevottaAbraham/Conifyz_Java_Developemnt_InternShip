public class Customer implements Runnable {

    private String customerName;
    private Inventory inventory;
    private Order order;

    public Customer(String customerName,
                    Inventory inventory,
                    Order order) {

        this.customerName = customerName;
        this.inventory = inventory;
        this.order = order;
    }

    // View Products
    public void viewProducts() {

        inventory.viewProducts();

    }

    // Place Order
    public void placeOrder() {

        boolean status = inventory.placeOrder(order);

        if (status) {

            System.out.println("--------------------------------");
            System.out.println("Customer : " + customerName);
            System.out.println("Order Placed Successfully");
            System.out.println("--------------------------------");

        } else {

            System.out.println("--------------------------------");
            System.out.println("Customer : " + customerName);
            System.out.println("Order Failed");
            System.out.println("--------------------------------");

        }

    }

    // Cancel Order
    public void cancelOrder() {

        inventory.cancelOrder(order.getOrderId());

    }

    @Override
    public void run() {

        System.out.println("\n================================");
        System.out.println("Customer : " + customerName);
        System.out.println("================================");

        placeOrder();

    }

}