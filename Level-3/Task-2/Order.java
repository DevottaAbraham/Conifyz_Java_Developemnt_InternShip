public class Order {

    private int orderId;
    private String customerName;
    private int productId;
    private String productName;
    private int quantity;
    private String orderStatus;

    public Order(int orderId,
                 String customerName,
                 String productName,
                 String string, int quantity,
                 String orderStatus) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.orderStatus = orderStatus;
    }

    // Getters

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    // public int getProductId() {
    //     return productId;
    // }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    // Setter

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    // Display Order

    public void displayOrder() {

        System.out.println("======================================");
        System.out.println("Order ID      : " + orderId);
        System.out.println("Customer Name : " + customerName);
        System.out.println("Product ID    : " + productId);
        System.out.println("Product Name  : " + productName);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Order Status  : " + orderStatus);
        System.out.println("======================================");
    }
}