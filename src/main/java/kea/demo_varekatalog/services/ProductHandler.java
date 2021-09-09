package kea.demo_varekatalog.services;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.repositories.ProductRepository;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductHandler {

    private Product product;
    ProductRepository pRepo = new ProductRepository();


    public ArrayList<Product> getProducts(){
        return pRepo.getProducts();
    }


    public Product addNewProduct(String product_name, int product_price){
        product = new Product(product_name, product_price);

        pRepo.addProduct(product);

        return product;
    }

    public Product getProduct (String product_name){
        product = pRepo.getProduct(product_name);

        return product;
    }


    public void updateProduct (int id, String formerProduct_name, String product_name, int product_price) {

        String[] strAsArray = product_name.split(",");
        String newName = strAsArray[id-1];
        pRepo.updateProduct(formerProduct_name, newName, product_price);
    }

    public int returnSpecificId(String product_name){

        return pRepo.getSpecificId(product_name);
    }
}
