import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products;
    private HashMap<Integer, Order> orders;

    public Inventory() {

        products = new HashMap<>();
        orders = new HashMap<>();

    }

    // Add Product
    public synchronized void addProduct(Product product) {

        products.put(product.getProductId(), product);

        System.out.println(product.getProductName()
                + " added successfully.");

    }

    // Remove Product
    public synchronized void removeProduct(int productId) {

        if (products.containsKey(productId)) {

            products.remove(productId);

            System.out.println("Product Removed Successfully.");

        } else {

            System.out.println("Product Not Found.");

        }

    }

    // View Products
    public void viewProducts() {

        if (products.isEmpty()) {

            System.out.println("No Products Available.");

            return;

        }

        System.out.println("\n========== PRODUCT LIST ==========\n");

        for (Product product : products.values()) {

            product.displayProduct();

        }

    }

    // Place Order
    public synchronized boolean placeOrder(Order order) {

    Product product = getProductByName(order.getProductName());

    if (product == null) {

        System.out.println("Product Not Found.");
        return false;

    }

    if (product.getStock() < order.getQuantity()) {

        System.out.println("Insufficient Stock.");
        return false;

    }

    product.setStock(product.getStock() - order.getQuantity());

    orders.put(order.getOrderId(), order);

    System.out.println("Order Placed Successfully.");

    return true;
}

    // Cancel Order
    public synchronized void cancelOrder(int orderId) {

    Order order = orders.get(orderId);

    if (order == null) {

        System.out.println("Order Not Found.");
        return;

    }

    Product product = getProductByName(order.getProductName());

    if (product != null) {

        product.setStock(product.getStock() + order.getQuantity());

    }

    order.setOrderStatus("CANCELLED");

    orders.remove(orderId);

    System.out.println("Order Cancelled Successfully.");
}

    // getpproduct by Id

    public Product getProductByName(String productName) {

    for (Product product : products.values()) {

        if (product.getProductName().equalsIgnoreCase(productName)) {
            return product;
        }
    }

    return null;


}
    // View Orders
    public void viewOrders() {

        if (orders.isEmpty()) {

            System.out.println("No Orders Found.");

            return;

        }

        System.out.println("\n========== ORDER LIST ==========\n");

        for (Order order : orders.values()) {

            order.displayOrder();

        }

    }

}