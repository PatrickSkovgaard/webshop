package kea.demo_varekatalog.models;

public class Product {

    private int product_id;
    private String product_name;
    private int product_price;

    public Product (int product_id, String product_name, int product_price){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public Product(String product_name, int product_price){
        this.product_name = product_name;
        this.product_price = product_price;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }


    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }


    @Override
    public String toString(){

        return "Product name: " + product_name + " | Product price: " + product_price;
    }
}
