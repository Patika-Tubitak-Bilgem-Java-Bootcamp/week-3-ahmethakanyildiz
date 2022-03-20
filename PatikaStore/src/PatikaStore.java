import java.util.*;

public class PatikaStore {

    Scanner sc = new Scanner(System.in);

    public void run(){
        List<Brand> brandList = new ArrayList();
        brandList.add(new Brand(0, "Samsung"));
        brandList.add(new Brand(1, "Lenovo"));
        brandList.add(new Brand(2, "Apple"));
        brandList.add(new Brand(3, "Huawei"));
        brandList.add(new Brand(4, "Casper"));
        brandList.add(new Brand(5, "Asus"));
        brandList.add(new Brand(6, "HP"));
        brandList.add(new Brand(7, "Xiaomi"));
        brandList.add(new Brand(8, "Monster"));
        brandList.sort(new Comparator<Brand>() {
            @Override
            public int compare(Brand o1, Brand o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        List<Phone> phoneList = new ArrayList<>();
        List<Notebook> notebookList = new ArrayList<>();
        System.out.println("PATİKA STORE'A HOŞGELDİNİZ!");
        int selection;
        while(true){
            System.out.println("-----ANA MENÜ-----");
            System.out.println("1 - Notebook İşlemleri");
            System.out.println("2 - Cep Telefonu İşlemleri");
            System.out.println("3 - Marka Listele");
            System.out.println("4 - Çıkış Yap");
            System.out.print("Seçiminizi giriniz: ");
            try{
                selection = Integer.parseInt(sc.next());
            }catch(Exception e){
                System.out.println("Geçersiz girdi!");
                continue;
            }
            if(selection<1 || selection>4){
                System.out.println("Geçersiz girdi!");
                continue;
            }
            else if(selection==1){
                System.out.println("-----NOTEBOOK İŞLEMLERİ-----");
                while(true){
                    selection = productMenu();
                    if(selection<1 || selection>5){
                        System.out.println("Geçersiz girdi!");
                        continue;
                    }
                    else if(selection==1){
                        listNotebooks(notebookList,-1);
                    }
                    else if(selection==2){
                        selection = brandSelection(brandList);
                        listNotebooks(notebookList,selection);
                    }
                    else if(selection==3)  addProduct(phoneList,notebookList,brandList,0);
                    else if(selection==4) deleteProduct(phoneList,notebookList,0);
                    else if(selection==5){
                        break;
                    }
                }
            }
            else if(selection==2){
                System.out.println("-----CEP TELEFONU İŞLEMLERİ-----");
                while(true){
                    selection=productMenu();
                    if(selection<1 || selection>5){
                        System.out.println("Geçersiz girdi!");
                        continue;
                    }
                    else if(selection==1) listPhones(phoneList,-1);
                    else if(selection==2){
                        selection = brandSelection(brandList);
                        listPhones(phoneList,selection);
                    }
                    else if(selection==3) addProduct(phoneList,notebookList,brandList,1);
                    else if(selection==4) deleteProduct(phoneList,notebookList,1);
                    else if(selection==5){
                        break;
                    }
                }
            }
            else if(selection==3){
                System.out.println("Markalarımız\n--------------");
                for(Brand b:brandList){
                    System.out.println((b.getId()+1)+" - "+b.getName());
                }
            }
            else if(selection==4){
                System.out.println("Çıkış yapıldı");
                break;
            }
        }
    }

    private int productMenu(){
        System.out.println("1 - Listele");
        System.out.println("2 - Marka Filtresi ile Listele");
        System.out.println("3 - Ekle");
        System.out.println("4 - Sil");
        System.out.println("5 - Ana Menüye Dön");
        System.out.print("Seçiminizi giriniz: ");
        try{
            return Integer.parseInt(this.sc.next());
        }catch(Exception e){
            System.out.println("Geçersiz girdi!");
            return -1;
        }
    }

    private void deleteProduct(List<Phone> phoneList, List<Notebook> notebookList,int type){
        int id=0;
        boolean isError=false;
        try{
            System.out.print("Ürün ID'sini giriniz: ");
            id=Integer.parseInt(sc.next());
        }catch(Exception e){
            System.out.println("Geçersiz girdi!");
            isError=true;
        }
        if(!isError){
            if(type==0){
                for(Notebook n:notebookList){
                    if(n.getId()==id){
                        notebookList.remove(n);
                        System.out.println("Ürün başarı ile silindi!");
                        return;
                    }
                }
                System.out.println("İşlem başarısız!");
            }
            else{
                for(Phone p:phoneList){
                    if(p.getId()==id){
                        phoneList.remove(p);
                        System.out.println("Ürün başarı ile silindi!");
                        return;
                    }
                }
                System.out.println("İşlem başarısız!");
            }
        }

    }

    private void addProduct(List<Phone> phoneList, List<Notebook> notebookList,List<Brand> brandList, int type){
        try{
            System.out.print("Marka numarası: ");
            int brandId = Integer.parseInt(sc.next())-1;
            if(brandId<0 || brandId>=brandList.size()){
                System.out.println("Geçersiz marka numarası!");
                throw new Exception();
            }
            System.out.print("Model: ");
            String name = sc.next();
            System.out.print("Fiyat(TL): ");
            int price = Integer.parseInt(sc.next());
            if(price<=0) throw new Exception("Fiyat sıfırdan küçük olamaz!");
            System.out.print("Adet: ");
            int stock = Integer.parseInt(sc.next());
            if(stock<=0) throw new Exception("Stok sıfırdan küçük olamaz!");
            System.out.print("RAM: ");
            int ram = Integer.parseInt(sc.next());
            if(ram<=0) throw new Exception("Ram sıfırdan küçük olamaz!");
            System.out.print("Depolama: ");
            int storage = Integer.parseInt(sc.next());
            if(storage<=0) throw new Exception("Depolama alanı sıfırdan küçük olamaz!");
            System.out.print("Ekran Boyutu: ");
            double screenSize = Double.parseDouble(sc.next());
            if(screenSize<=0) throw new Exception("Depolama alanı sıfırdan küçük olamaz!");
            Brand brand=null;
            for(Brand b:brandList){
                if(b.getId()==brandId) brand=b;
            }
            if(type==0){
                notebookList.add(new Notebook(name,price,stock,brand,ram,storage,screenSize));
                System.out.println("Ürün başarı ile eklendi!");
            }
            else{
                System.out.print("Batarya Kapasitesi: ");
                int battery = Integer.parseInt(sc.next());
                if(battery<=0) throw new Exception("Batarya kapasitesi sıfırdan küçük olamaz!");
                System.out.print("Renk: ");
                String color = sc.next();
                phoneList.add(new Phone(battery,color,name,price,stock,brand,ram,storage,screenSize));

            }

        }catch(Exception e){
            if(e.getMessage().contains("Exception")) System.out.println("Ürün eklenemedi, lütfen tekrar deneyiniz.");
            else System.out.println(e.getMessage()+"\nÜrün eklenemedi, lütfen tekrar deneyiniz.");

        }
    }

    private int brandSelection(List<Brand> brandList){
        int selection;
        while(true){
            System.out.print("Marka numarasını giriniz: ");
            try{
                selection = Integer.parseInt(this.sc.next())-1;
            }catch(Exception e){
                System.out.println("Geçersiz girdi!");
                continue;
            }
            if(selection<0 || selection>=brandList.size()){
                System.out.println("Geçersiz girdi!");
                continue;
            }
            else{
                return selection;
            }
        }
    }

    private void listNotebooks(List<Notebook> list, int selection){
        List<Notebook> newList = new ArrayList<>();
        if(selection==-1) newList = list;
        else{
            for(Notebook n: list){
                if(n.getBrand().getId()==selection) newList.add(n);
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-3s | %-33s| %-9s TL | %-14s| %-6s| %-16s | %-3s |","ID","Ürün Adı","Fiyat","Marka","Adet","Ekran Boyutu","RAM"));
        System.out.println("----------------------------------------------------------------------------------------------------------");
        if (!newList.isEmpty()) {
            for (Notebook n : newList) {
                String productName = n.getBrand().getName() + " " + n.getName();

                System.out.printf("| %-3s | %-33s| %-9s TL | %-14s| %-6s| %-16s | %-3s |\n",
                        n.getId(), productName, n.getPrice(), n.getBrand().getName(), n.getStorage(),
                        n.getScreenSize(), n.getRam());
            }
        }
        else System.out.println("-----------------------------------------------BOŞ--------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------------");
    }

    private void listPhones(List<Phone> list,int selection){
        List<Phone> newList = new ArrayList<>();
        if(selection==-1) newList = list;
        else{
            for(Phone p: list){
                if(p.getBrand().getId()==selection) newList.add(p);
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-3s | %-33s| %-9s TL | %-14s| %-6s| %-8s | %-14s | %-4s | %-9s |","ID","Ürün Adı","Fiyat","Marka","Adet","Batarya","Ekran Boyutu","RAM","Renk"));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
        if (!newList.isEmpty()) {
            for (Phone p : newList) {
                String productName = p.getBrand().getName() + " " + p.getName();

                System.out.printf("| %-3s | %-33s| %-9s TL | %-14s| %-6s| %-8s | %-14s | %-4s | %-9s |\n",
                        p.getId(), productName, p.getPrice(), p.getBrand().getName(), p.getStorage(),
                        p.getBattery(),p.getScreenSize(), p.getRam(), p.getColor());
            }
        }
        else System.out.println("----------------------------------------------------------BOŞ-------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------");
    }
}
