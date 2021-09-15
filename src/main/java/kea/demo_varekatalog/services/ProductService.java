package kea.demo_varekatalog.services;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ProductService {

    private Product product;
    private ProductRepository pRepo = new ProductRepository();


    public ArrayList<Product> getProducts(){
        return pRepo.getProducts();
    }

    public void addNewProduct(int id, String product_name, int product_price){
        product = new Product(id, product_name, product_price);

        pRepo.addProduct(product);
    }

    public Product getProductById (int id){
        return pRepo.getProductById(id);
    }

    public void updateProduct (Product product) {
        pRepo.updateProduct(product);
    }

    public void deleteProduct(int id){
        pRepo.removeProduct(id);
    }

    public int calculateNextId(){
        int size = (getProductById(getProducts().size()).getId() + 2);
        System.out.println(size);
        return size;
    }
}
