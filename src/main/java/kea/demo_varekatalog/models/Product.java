package kea.demo_varekatalog.models;

public class Product {

    private int product_id = 0;
    private String product_name = new String();
    private int product_price = 0;

    public Product (int product_id, String product_name, int product_price){
        this.product_id = product_id;
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
}
