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

    public int updateProduct(String formerProduct_name, String product_name, int product_price){

        ResultSet rs = executeQuery("SELECT * FROM product " +
                "WHERE product.product_name = \"" + formerProduct_name + "\" ;");

        String formerName = "";
        int id = 0;

        try{
            rs.next();
            formerName = rs.getString("product_name");
            id = rs.getInt("product_id");
        }
        catch(Exception e){
            System.out.println("Gik galt i update product " + e.getMessage());
            e.printStackTrace();
        }

        executeUpdate("UPDATE product " +
                        "SET product.product_name =\"" + product_name + "\", " +
                        "product.product_price =" + product_price + " " +
                        "WHERE product.product_name =\"" + formerName + "\";");

        return id;
    }


    public void updateProductName(String product_name){
            executeUpdate("UPDATE product " +
                    "SET product.product_name = \" " + product_name + "\";");
        }

    public void updateProductPrice(int product_price){
        executeUpdate("UPDATE product " +
                "SET product.product_price =  " + product_price + ";");
    }

    public int getSpecificId(String product_name){
        ResultSet rs = executeQuery("SELECT product.product_id FROM product " +
                        "WHERE product.product_name =\"" + product_name + "\";");

        int id = -1;

        try{
            rs.next();
            id = rs.getInt("product_id");
        }
        catch(Exception e){
            System.out.println("Get specific ID gik galt " + e.getMessage());
            e.printStackTrace();
        }

        return id;

    }

    //SEARCH FOR PRODUCT METHOD???

    public Product getProduct(String product_name){
        ResultSet rs = executeQuery("SELECT * FROM product WHERE \" " + product_name + "\";");
        Product product = null;
        try {
            rs.next();
            product = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("product_price"));
        }
        catch(Exception e){
            System.out.println("Get Product gik galt " + e.getMessage());
            e.printStackTrace();
        }
        return product;
    }

    public ArrayList<Product> getProducts(){
        ResultSet res = executeQuery("SELECT * FROM product;");
        ArrayList<Product> products = new ArrayList<>();

        try{
            while(res.next()){
                products.add(new Product(res.getInt("product_id"), res.getString("product_name"), res.getInt("product_price")));
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

