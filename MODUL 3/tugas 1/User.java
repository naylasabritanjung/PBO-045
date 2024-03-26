import java.util.Scanner;
import java.util.UUID;

public class User {
    protected static int nextBookId = 1; 
    public int bookCount;
    protected Book[] bookList;

    public User(Book[] bookList) {
        this.bookList = bookList;
    }

    public User() {

    }

    String generateId() {
        String uniqueID = UUID.randomUUID().toString(); // Menghasilkan UUID (Universally Unique Identifier)
        String id = uniqueID.substring(0, Math.min(uniqueID.length(), 6)); // Mengambil 6 karakter pertama dari UUID
        return id.toUpperCase(); // Mengembalikan ID dalam huruf kapital
    }

    void addBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih kategori buku:");
        System.out.println("1. Buku Sejarah");
        System.out.println("2. Buku Cerita");
        System.out.println("3. Buku Pelajaran");
        System.out.print("Masukkan pilihan Anda: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Masukkan judul: ");
        String title = scanner.nextLine();
        System.out.print("Masukkan penulis: ");
        String author = scanner.nextLine();
        System.out.print("Masukkan stok: ");
        int stock = scanner.nextInt();

        String id = generateId(); // Menghasilkan ID baru

        switch (choice) {
            case 1:
                HistoryBook historyBook = new HistoryBook(id, title, author, stock, "History");
                bookList[bookCount++] = historyBook;
                break;
            case 2:
                StoryBook storyBook = new StoryBook(id, title, author, stock, "Story");
                bookList[bookCount++] = storyBook;
                break;
            case 3:
                TextBook textBook = new TextBook(id, title, author, stock, "Text");
                bookList[bookCount++] = textBook;
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    void displayBooks() {
        System.out.println("---------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-30s | %-20s | %-6s |\n", "ID", "Judul", "Penulis", "Stok");
        System.out.println("------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < bookList.length; i++) {
            Book book = bookList[i];
            if (book != null) {
                System.out.printf("| %-10s | %-30s | %-20s | %-6d |\n", book.getBookId(), book.getTitle(), book.getAuthor(), book.getStock());
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        if (bookCount == 0) {
            System.out.println("Belum ada buku yang ditambahkan, tolong tambahkan buku terlebih dahulu.");
        }
    }
}
