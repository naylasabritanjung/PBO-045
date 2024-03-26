
public class Book {
    // Atribut
    private String bookId;
    private String title;
    private String author;
    private int stock;
    private int duration;


    public Book(String bookId, String title, String author, int stock) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public void displayBookInfo() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Stock: " + stock);
        System.out.println("Duration: " + duration);
    }


}