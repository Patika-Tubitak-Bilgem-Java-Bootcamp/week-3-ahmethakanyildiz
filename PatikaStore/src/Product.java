import java.util.Comparator;
import java.util.List;

public abstract class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private Brand brand;
    private int ram;
    private int storage;
    private double screenSize;
    private static int idCount=0;

    public Product(String name, int price, int stock, Brand brand, int ram, int storage, double screenSize) {
        this.id=idCount;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
        idCount++;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}
