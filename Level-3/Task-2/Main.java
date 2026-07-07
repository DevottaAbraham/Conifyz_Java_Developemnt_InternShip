import java.util.Scanner;

public class Main {

    

    private static int nextorderId = 1001;

    private static int nextProductId = 1;
    public static void main(String[] args) {
        

        Scanner sc = new Scanner(System.in);

        // Create Inventory
        Inventory inventory = new Inventory();

        // Create Owner
        System.out.print("Enter Owner Name : ");
        String ownerName = sc.nextLine();

        Owner owner = new Owner(ownerName, inventory);

        // Add Products
        System.out.print("Enter Number of Products : ");
        int totalProducts = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= totalProducts; i++) {

            System.out.println("\nEnter Product " + i + " Details");

           

            System.out.print("Product Name : ");
            String productName = sc.nextLine();

            System.out.print("Product Price : ");
            double productPrice = sc.nextDouble();

            System.out.print("Stock : ");
            int stock = sc.nextInt();
            sc.nextLine();

            Product product = new Product(
                    nextProductId++,
                    productName,
                    productPrice,
                    stock);

            owner.addProduct(product);
        }

        // Display Products
        owner.viewProducts();

        // Customer Orders
        System.out.print("\nEnter Number of Customers : ");
        int totalCustomers = sc.nextInt();
        sc.nextLine();

        Thread[] threads = new Thread[totalCustomers];

        for (int i = 0; i < totalCustomers; i++) {

            System.out.println("\nCustomer " + (i + 1));

            System.out.print("Customer Name : ");
            String customerName = sc.nextLine();


            System.out.print("Product Name: ");
            String productName = sc.nextLine();

            System.out.print("Quantity : ");
            int quantity = sc.nextInt();
            sc.nextLine();

            Product product = inventory.getProductByName(productName);

            if (product == null) {

                System.out.println("Invalid Product ID");
                i--;
                continue;
            }

           

            Order order = new Order(
                    nextorderId++,
                    customerName,
                    productName,
                    product.getProductName(),
                    quantity,
                    "PENDING");

            Customer customer =
                    new Customer(customerName,
                            inventory,
                            order);

            threads[i] = new Thread(customer);

            threads[i].start();
        }

        // Wait for all customers
        for (Thread thread : threads) {

            try {

                thread.join();

            } catch (InterruptedException e) {

                e.printStackTrace();

            }
        }

        System.out.println("\n========== FINAL PRODUCTS ==========");
        inventory.viewProducts();

        System.out.println("\n========== ALL ORDERS ==========");
        inventory.viewOrders();

        sc.close();
        
    }
}