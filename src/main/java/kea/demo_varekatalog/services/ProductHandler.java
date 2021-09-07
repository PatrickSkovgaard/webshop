package kea.demo_varekatalog.services;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.repositories.ProductRepository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductHandler {

    private Product product;
    ProductRepository pRepo = new ProductRepository();


    public ArrayList<Product> showProducts(){
        return pRepo.getProducts();
    }


    public Product addNewProduct(String product_name, int product_price){
        product = new Product(product_name, product_price);

        pRepo.addProduct(product);

        return product;
    }

    //GET PRODUCT METHOD???


    public Product updateProduct (String product_name, int product_price) {
        pRepo.updateProduct(product_name, product_price);

        return (Product) pRepo.getProduct(product_name);
    }
}
