public class StoryBook extends Book {

    private String category;


    public StoryBook(String bookId, String title, String author, int stock, String category) {
        super(bookId, title, author, stock);
        this.category = category;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Category: " + category);
    }
}