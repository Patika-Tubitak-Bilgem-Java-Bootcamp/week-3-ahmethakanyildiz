import java.util.List;

public class Phone extends Product{
    private int battery;
    private String color;
    public Phone(int battery, String color,String name, int price, int stock, Brand brand, int ram, int storage, double screenSize) {
        super(name, price, stock, brand, ram, storage, screenSize);
        this.battery=battery;
        this.color=color;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
