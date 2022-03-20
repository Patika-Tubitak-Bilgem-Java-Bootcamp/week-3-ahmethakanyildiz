package address;

public class BusinessAddress implements Address{
    private String type;
    private String address;

    public BusinessAddress(String address) {
        this.type = "İş";
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
