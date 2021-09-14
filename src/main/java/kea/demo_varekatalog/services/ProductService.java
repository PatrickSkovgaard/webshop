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
        product = new Product(product_name, product_price);

        pRepo.addProduct(product);
    }

    public Product getProductByName (String product_name){
        return pRepo.getProductByName(product_name);
    }

    public Product getProductByIdAndPrice (int id, int price){

        return pRepo.getProductByIdAndPrice(id, price);
    }

    public ArrayList<Product> getProductOrProductsByPrice (int price){
        return pRepo.getProductOrProductsByPrice(price);
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
        int size = getProducts().size();

        return size + 1;
    }
}
