package kea.demo_varekatalog.repositories;

import kea.demo_varekatalog.models.Product;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository extends Repository  {

    public ResultSet showProducts(){
       return executeQuery("SELECT * FROM product;");
    }

    public void addProduct (Product product){
        executeQuery("INSERT INTO product(product_name, product_price) VALUES (\"" +
                         product.getProduct_name()
                         + "\", " + product.getProduct_price() + "); ");
    }

    public void updateProduct(String product_name, int product_price){
        executeUpdate("UPDATE product " +
                        "SET product.product_name = \" " + product_name + "\", " +
                        "product.product_price =  " + product_price + ";");
    }


    public void updateProductName(String product_name){
            executeUpdate("UPDATE product " +
                    "SET product.product_name = \" " + product_name + "\";");
        }

    public void updateProductPrice(int product_price){
        executeUpdate("UPDATE product " +
                "SET product.product_price =  " + product_price + ";");
    }


    //SEARCH FOR PRODUCT METHOD???

    public ResultSet getProduct(String product_name){
        return executeQuery("SELECT * FROM product WHERE \" " + product_name + "\";");
    }

    public ArrayList<Product> getProducts(){
        ResultSet res = executeQuery("SELECT * FROM product;");
        ArrayList<Product> products = new ArrayList<>();

        try{
            while(res.next()){
                products.add(new Product(res.getString("product_name"), res.getInt("product_price")));
            }
        }
        catch(Exception e){
            System.out.println("Error getting products from repo " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }


    public void removeProduct (String product_name){
        executeUpdate("DELETE product FROM product WHERE product.product_name = \" " + product_name + "\";");
    }
}

