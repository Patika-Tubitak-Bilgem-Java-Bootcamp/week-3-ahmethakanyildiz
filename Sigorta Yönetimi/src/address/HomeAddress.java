package address;

public class HomeAddress implements Address{
    private String type;
    private String address;

    public HomeAddress(String address) {
        this.type = "Ev";
        this.address = address;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }
}
