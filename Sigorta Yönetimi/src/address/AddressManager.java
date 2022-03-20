package address;

import account.User;

import java.util.List;
import java.util.Scanner;

public class AddressManager {

    public static void addAddress(User user) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Adres tipini giriniz, (E)v veya (İ)ş: ");
        String type = sc.nextLine();
        if (type.toLowerCase().equals("e")) {
            System.out.print("Adresi giriniz: ");
            String address = sc.nextLine();
            HomeAddress home = new HomeAddress(address);
            user.addAddress(home);
            System.out.println("Adres başarı ile eklendi!");
        } else if (type.equals("İ") || type.equals("i")) {
            System.out.print("Adresi giriniz: ");
            String address = sc.nextLine();
            BusinessAddress business = new BusinessAddress(address);
            user.addAddress(business);
            System.out.println("Adres başarı ile eklendi!");
        } else {
            System.out.println("Geçersiz girdi! Adres ekleme işlemi başarısız!");

        }
    }

    public static void removeAddress(User u){
        Scanner sc = new Scanner(System.in);
        List<Address> list = u.getAddressList();
        if(list.size()==0){
            System.out.println("Adres listesi zaten boş!");
            return;
        }
        for(int i=0;i<list.size();i++){
            System.out.println((i+1)+" - "+list.get(i).getType()+" Adresi - "+list.get(i).getAddress());
        }
        System.out.print("Silmek istediğiniz adresin numarasını giriniz: ");
        int selection = 0;
        try{
            selection = Integer.parseInt(sc.next());
        }
        catch(Exception e){
            System.out.println("Geçersiz girdi! İşlem başarısız!");
            return;
        }
        selection-=1;
        if(selection<0 || selection>=list.size()){
            System.out.println("Geçersiz girdi! İşlem başarısız!");
        }
        else{
            u.removeAddress(selection);
            System.out.println("İşlem başarı ile gerçekleştirildi!");
        }
    }
}
