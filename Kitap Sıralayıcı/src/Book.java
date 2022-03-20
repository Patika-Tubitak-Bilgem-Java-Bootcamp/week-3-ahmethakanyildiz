public class Book implements Comparable<Book>{

    private String title;
    private String author;
    private int pageCount;
    private int publishYear;

    public Book(String title, String author, int pageCount, int publishYear) {
        this.title = title;
        this.author = author;
        this.pageCount = pageCount;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    @Override
    public int compareTo(Book o) {
        return this.getTitle().compareTo(o.getTitle());
    }
}
