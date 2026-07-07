public class Product {

    private int productId;
    private String productName;
    private double productPrice;
    private int stock;

    public Product(int productId,
                   String productName,
                   double productPrice,
                   int stock) {

        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.stock = stock;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getStock() {
        return stock;
    }

    // Setter
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Display Product Details
    public void displayProduct() {

        System.out.println("----------------------------------------");
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : Rs" + productPrice);
        System.out.println("Stock        : " + stock);
        System.out.println("----------------------------------------");
    }

}