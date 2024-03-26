public class HistoryBook extends Book {

    private String category;


    public HistoryBook(String bookId, String title, String author, int stock, String category) {
        super(bookId, title, author, stock);
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: " + category);
    }


}
