public class Owner implements Runnable {

    private String ownerName;
    private Inventory inventory;

    public Owner(String ownerName, Inventory inventory) {

        this.ownerName = ownerName;
        this.inventory = inventory;
    }

    // Add Product
    public void addProduct(Product product) {

        inventory.addProduct(product);

        System.out.println("--------------------------------");
        System.out.println("Owner : " + ownerName);
        System.out.println(product.getProductName() + " Added Successfully");
        System.out.println("--------------------------------");
    }

    // Remove Product
    public void removeProduct(int productId) {

        inventory.removeProduct(productId);

    }

    // View Products
    public void viewProducts() {

        inventory.viewProducts();

    }

    @Override
    public void run() {

        System.out.println(ownerName + " is managing the inventory...");

    }

}