package kea.demo_varekatalog.services;

import kea.demo_varekatalog.models.Product;

public class ProductHandler {

    private Product product;

    public Product addNewProduct(String product_name, int product_price){
        product = new Product(product_name, product_price);
    }
}
