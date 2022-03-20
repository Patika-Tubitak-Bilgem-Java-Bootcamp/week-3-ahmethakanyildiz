import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Aklından Bir Sayı Tut","John Verdon",800,2010);
        Book book2 = new Book("Savaş ve Barış","Tolstoy",700,1866);
        Book book3 = new Book("1984","John Verdon",900,1949);
        Book book4 = new Book("Suç ve Ceza","Dostoyevski",400,1866);
        Book book5 = new Book("Sekizinci Gün","Glenn Meade",300,2002);

        TreeSet<Book> bookSet = new TreeSet<>();

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        for(Book b : bookSet){
            System.out.println(b.getTitle()+" - "+b.getPageCount());
        }

        System.out.println("==============================");

        bookSet= new TreeSet<>(new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageCount() - o2.getPageCount();
            }
        });

        bookSet.add(book1);
        bookSet.add(book2);
        bookSet.add(book3);
        bookSet.add(book4);
        bookSet.add(book5);

        for(Book b : bookSet){
            System.out.println(b.getTitle()+" - "+b.getPageCount());
        }

    }
}
