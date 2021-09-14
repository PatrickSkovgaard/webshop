package kea.demo_varekatalog.repositories;

import kea.demo_varekatalog.models.Product;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository extends Repository  {

            //Create
    public void addProduct (Product product){
        executeQuery("INSERT INTO product(p_name, price) VALUES (\"" +
                         product.getName()
                         + "\", " + product.getPrice() + ");");
    }

            //Read one (name)
    public Product getProductByName(String product_name){
        ResultSet rs = executeQuery("SELECT * FROM product WHERE product.p_name =" +
                "\"" + product_name + "\";");


        return getProductQuery(rs);
    }

            //Read one (ID)
    public Product getProductById (int id){
        ResultSet rs = executeQuery("SELECT * FROM product WHERE product.id = " + id + ";");

        return getProductQuery(rs);
    }

    public Product getProductByIdAndPrice (int id, int price){
        ResultSet rs = executeQuery("SELECT * FROM product WHERE product.id = " + id +
                                        "AND product.price = " + price + ";");

        return getProductQuery(rs);
    }

            //Read one or many (price)
    public ArrayList<Product> getProductOrProductsByPrice (int price){
        ResultSet rs = executeQuery("SELECT * FROM product " +
                                        "WHERE product.price = " + price + ";");

        ArrayList<Product> products = new ArrayList<>();

        try {
            while (rs.next()) {
                Product product = new Product(getProductQuery(rs).getName(),
                                              getProductQuery(rs).getPrice());
                products.add(product);
            }
        }
        catch (Exception e){
            System.out.println("Get products by Price gik galt " + e.getMessage());
            e.printStackTrace();
        }

        return products;
    }

            //Read all
    public ArrayList<Product> getProducts(){
        ResultSet res = executeQuery("SELECT * FROM product;");
        ArrayList<Product> products = new ArrayList<>();

        try{
            while(res.next()){
                products.add(new Product(res.getInt("id"),res.getString("p_name"),
                        res.getInt("price")));
            }
        }
        catch(Exception e){
            System.out.println("Error getting products from repo " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }

            //Update
    public void updateProduct(Product product){

        executeUpdate("UPDATE product SET p_name = \"" + product.getName()
                            + "\", price = " + product.getPrice() +
                            " WHERE product.id = " + product.getId() + ";");
    }

            //Delete (name)
    public void removeProduct (String product_name){
        executeUpdate("DELETE product FROM product WHERE product.p_name = \" "
                + product_name + "\";");
    }

            //Delete (ID)
    public void removeProduct (int id){
        executeUpdate("DELETE product FROM product WHERE product.id = "
                + id + ";");
    }


      //Hjælpe metode til at lave en query på et produkt, fremfor kodeduplikation
    public Product getProductQuery(ResultSet rs){
        Product product = null;
        try {
            rs.next();
            product = new Product(rs.getInt("id"), rs.getString("p_name"),
                    rs.getInt("price"));
        }
        catch(Exception e){
            System.out.println("Get Product gik galt " + e.getMessage());
            e.printStackTrace();
        }
        return product;
    }


    public ResultSet showProducts(){
        return executeQuery("SELECT * FROM product;");
    }


    public void updateProductName(String product_name){
            executeUpdate("UPDATE product " +
                    "SET product.p_name = \" " + product_name + "\";");
        }

    public void updateProductPrice(int product_price){
        executeUpdate("UPDATE product " +
                "SET product.price =  " + product_price + ";");
    }

    /*
    public int getSpecificId(String product_name){
        ResultSet rs = executeQuery("SELECT product.product_id FROM product " +
                        "WHERE product.product_name =\"" + product_name + "\";");

        int id = 0;

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
*/
    //SEARCH FOR PRODUCT METHOD???
}

