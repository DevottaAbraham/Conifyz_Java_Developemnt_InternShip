import java.util.ArrayList;

public class ProductService {
    

    private ArrayList <Product> products = new ArrayList<>();

    public void addProduct(Product product){

            products.add(product);

    }

    public ArrayList<Product> getProducts(){

        return products;
    }

    public void deleteProduct(String productId){
        products.removeIf(product -> product.getProductId().equals(productId));
    }

    public void updateProduct(Product updateProduct){

        for(int i=0;i<products.size();i++){
            if(products.get(i).getProductId().equals(updateProduct.getProductId())){

                products.set(i, updateProduct);

                return;
            }
        }

    }
}
