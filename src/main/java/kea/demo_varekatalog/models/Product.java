package kea.demo_varekatalog.models;

public class Product {

    private int id;
    private String name;
    private int price;

    public Product (int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return "Product name: " + name + " <br> Product price: " + price;
    }
}
