package kea.demo_varekatalog.service;

import kea.demo_varekatalog.models.Product;
import kea.demo_varekatalog.repositories.ProductRepository;
import kea.demo_varekatalog.services.ProductService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTesting {
    /*
    ProductService productService = new ProductService();
    ProductRepository productRepository = new ProductRepository();


    @Test
    void getCorrectId(){

        int id = 3;


        Product product = productService.getProduct("yolo");

        int actualId = productService.returnSpecificId(product.getName());

        assertEquals(id, product.getId());
        assertEquals(id, actualId);
    }

    @Test
    void updateProject(){

        String newName = "lort";
        ArrayList<Product> products = productService.getProducts();
        System.out.println(products.size());
        productRepository.updateProduct(products.get(2).getName(), 15, newName);

        assertEquals(newName, productService.getProduct(newName).getName());
    }

     */
}
