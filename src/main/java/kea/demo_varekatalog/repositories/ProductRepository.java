package kea.demo_varekatalog.repositories;

import kea.demo_varekatalog.models.Product;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepository extends Repository  {

            //Create
    public void addProduct (Product product){
        executeUpdate("INSERT INTO product(p_name, price) VALUES (\"" +
                         product.getName()
                         + "\", " + product.getPrice() + ");");
    }

            //Read one (ID)
    public Product getProductById (int id){
        ResultSet rs = executeQuery("SELECT * FROM product WHERE product.id = " + id + ";");

        return getProductQuery(rs);
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

            //Delete (ID)
    public void removeProduct (int id){
        executeUpdate("DELETE product FROM product WHERE product.id = "
                + id + ";");
    }

      //Hjælpe metode til at lave en query på et produkt, fremfor kodeduplikation
    public Product getProductQuery(ResultSet rs){
        Product product;
        try {
            rs.next();
            product = new Product(rs.getInt("id"), rs.getString("p_name"),
                    rs.getInt("price"));
        }
        catch(Exception e){
            product = new Product("tomt", 0);
        }
        return product;
    }
}

