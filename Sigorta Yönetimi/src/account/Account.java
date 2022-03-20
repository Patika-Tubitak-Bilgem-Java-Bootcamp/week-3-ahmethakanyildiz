package account;

import account.enums.AuthenticationStatus;
import account.exceptions.InvalidAuthenticationException;
import address.Address;
import address.AddressManager;
import insurance.Insurance;

import java.util.ArrayList;
import java.util.Date;

public abstract class Account implements Comparable<Account> {

    private User user;
    private AuthenticationStatus authStatus;
    private ArrayList<Insurance> insuranceList;

    public Account(User user) {
        this.user = user;
        this.authStatus = AuthenticationStatus.FAIL;
        this.insuranceList = new ArrayList<>();
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getEmail().compareTo(o.getUser().getEmail());
    }

    public int hashCode(){
        return this.getUser().getEmail().hashCode();
    }

    public boolean equals(Account a){
        if(this == a) return true;
        if(a == null) return false;
        if(this.getClass()!=a.getClass()) return false;
        return this.getUser().getEmail().equals(a.getUser().getEmail());
    }



    public void addAddress(){
        AddressManager.addAddress(this.user);
    }

    public void removeAddress(){
        AddressManager.removeAddress(this.user);
    }

    public void login(String email, String password) throws InvalidAuthenticationException {
        if(this.user.getEmail().equals(email) && this.user.getPassword().equals(password)){
            this.setAuthStatus(AuthenticationStatus.SUCCESS);
            this.getUser().setLastLogin(new Date());
            System.out.println("Giriş başarılı!");
        }
        else{
            throw new InvalidAuthenticationException("Giriş başarısız!");
        }
    }

    public void logout(){
        this.setAuthStatus(AuthenticationStatus.FAIL);
        System.out.println("Çıkış başarılı!");
    }

    public boolean isLoggedIn(){
        if(this.authStatus==AuthenticationStatus.SUCCESS) return true;
        else return false;
    }

    public abstract void addInsurancePolicy(String name, double price, Date startDate, Date finishDate,int type);

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public final void showUserInfo(){
        System.out.println("Hesap Bilgileri---------");
        System.out.println("Ad: "+this.getUser().getName()+
                "\nSoyad: "+this.getUser().getSurname()+
                "\nMail: "+this.getUser().getEmail()+
                "\nİş: "+this.getUser().getJob()+
                "\nYaş: "+this.getUser().getAge()+
                "\nSon Başarılı Giriş: "+this.getUser().getLastLogin());
        System.out.println("Adresler");
        for(Address a:this.getUser().getAddressList()){
            System.out.println(a.getType()+" Adresi - "+a.getAddress());
        }
    }

    public AuthenticationStatus getAuthStatus() {
        return authStatus;
    }

    public void setAuthStatus(AuthenticationStatus authStatus) {
        this.authStatus = authStatus;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return new ArrayList<>(this.insuranceList);
    }

    public void setInsuranceList(ArrayList<Insurance> insuranceList) {
        this.insuranceList = insuranceList;
    }
}
