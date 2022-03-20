package account;

import insurance.Insurance;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.TreeSet;

public class AccountManager {
    private static TreeSet<Account> accountSet = new TreeSet<>();

    public static void run(){
        Individual indAccount = new Individual( new User("Ahmet","Yıldız","ahmet@gmail.com","123","CENG",21));
        Enterprise entAccount = new Enterprise( new User("Steve","Jobs","steve@apple.com","apple","CEO",60));
        accountSet.add(indAccount);
        accountSet.add(entAccount);
        Account account = null;
        System.out.println("SİGORTA SİSTEMİMİZE HOŞGELDİNİZ!");
        Scanner sc = new Scanner(System.in);
        String dateFormat = "dd/MM/yyyy";
        while(true){
            if(account==null){
                System.out.println("Lütfen giriş yapınız.");
                System.out.print("Mail: ");
                String mail = sc.nextLine();
                System.out.print("Şifre: ");
                String password = sc.nextLine();
                account = login(mail,password);
                if(account==null){
                    System.out.println("Giriş yapılamadı!");
                    continue;
                }
            }
            System.out.println("ANA MENÜ--------");
            System.out.println("1 - Bilgileri Listele");
            System.out.println("2 - Hesap Türünü Öğren");
            System.out.println("3 - Poliçeleri Listele");
            System.out.println("4 - Poliçe Ekle");
            System.out.println("5 - Çıkış Yap");
            System.out.print("Seçiminizi giriniz: ");
            String selection = sc.nextLine();
            if(selection.equals("1")){
                account.showUserInfo();
            }
            else if(selection.equals("2")){
                if(account.getClass().toString().equals("class account.Individual")){
                    System.out.println("Bireysel Sigorta hizmetimizden faydalanıyorsunuz.");
                }
                else{
                    System.out.println("Kurumsal Sigorta hizmetimizden faydalanıyorsunuz.");
                }
            }
            else if(selection.equals("3")){
                System.out.println("Kayıtlı Poliçeler");
                for(Insurance i : account.getInsuranceList()){
                    //calculate fonksiyonu yapıldıktan sonra burası güncellenebilir!
                    System.out.println(i.getName()+"------");
                    System.out.println("Başlangıç Tarihi: "+i.getStartDate());
                    System.out.println("Bitiş Tarihi: "+i.getFinishDate());
                }
            }
            else if(selection.equals("4")){
                System.out.println("Sigorta Türleri");
                System.out.println("1 - Sağlık");
                System.out.println("2 - Araba");
                System.out.println("3 - Konut");
                System.out.println("4 - Seyahat");
                System.out.print("Seçiminizi giriniz: ");
                selection = sc.nextLine();
                int type=1;
                if(selection.equals("1")) type=1;
                else if(selection.equals("2")) type=2;
                else if(selection.equals("3")) type=3;
                else if(selection.equals("4")) type=4;
                else{
                    System.out.println("Geçersiz girdi!");
                    continue;
                }
                System.out.print("Sigorta Adı: ");
                String name = sc.nextLine();
                double price=0;
                System.out.print("Ücret: ");
                try{
                    price = Double.parseDouble(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("Geçersiz girdi! İşlem başarısız!");
                    continue;
                }
                System.out.print("Başlangıç Tarihi (gg/AA/yyyy): ");
                Date startDate=new Date();
                try{
                    startDate = new SimpleDateFormat(dateFormat).parse(sc.nextLine());
                }catch(Exception e){
                    System.out.println("Geçersiz girdi! İşlem başarısız!");
                    continue;
                }
                System.out.print("Bitiş Tarihi (gg/AA/yyyy): ");
                Date finishDate = new Date();
                try{
                    finishDate = new SimpleDateFormat(dateFormat).parse(sc.nextLine());
                }catch(Exception e){
                    System.out.println("Geçersiz girdi! İşlem başarısız!");
                    continue;
                }
                if(!finishDate.after(startDate)){
                    System.out.println("Bitiş tarihi başlangıç tarihinden önce/eşit olamaz!");
                    continue;
                }
                account.addInsurancePolicy(name,price,startDate,finishDate,type);

            }
            else if(selection.equals("5")){
                account.logout();
                account=null;
            }
            else{
                System.out.println("Geçersiz girdi!");
            }
        }
    }

    private static Account login(String email, String password){
        for(Account a: accountSet){
            try{
                a.login(email, password);
                return a;
            }catch(Exception e){
                continue;
            }
        }
        return null;
    }
}
