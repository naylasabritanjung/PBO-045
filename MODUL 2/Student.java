import java.util.Scanner;
public class Student {
    String name;
    String faculty;
    String programStudi;
    Book[] borrowedBooks = new Book[100];
    int borrowedCount = 0;

    public Student(String name, String faculty, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    void displayBooks(Book[] bookList, int bookCount) {
        for (int i = 0; i < bookCount; i++) {
            Book book = bookList[i];
            System.out.println(book.id + ": " + book.judul+ " by " + book.penulis + ", stok: " + book.jumlah);
        }
    }
    void borrowBook(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan ID buku yang ingin dipinjam: ");
            String id = scanner.nextLine();
            for (int i = 0; i < bookCount; i++) {
                Book book = bookList[i];
                if (book.id.equals(id)) {
                    if (book.jumlah > 0) {
                        book.jumlah--;
                        borrowedBooks[borrowedCount++] = book;
                        System.out.println("Anda telah meminjam buku " + book.judul + ".");
                        return;
                    } else {
                        System.out.println("Maaf, buku ini sedang tidak tersedia.");
                        break;
                    }
                }
                if (i == bookCount - 1) {
                    System.out.println("Buku dengan ID tersebut tidak ditemukan.");
                }
            }
        }
    }

    void displayBorrowedBooks() {
        if (borrowedCount == 0) {
            System.out.println("Anda belum meminjam buku apapun.");
            return;
        }
        System.out.println("Buku yang Anda pinjam:");
        for (int i = 0; i < borrowedCount; i++) {
            Book book = borrowedBooks[i];
            System.out.println(book.id + ": " + book.judul + " by " + book.penulis);
        }
    }

    void logout() {
        System.out.println("Anda telah keluar.");
    }
}
