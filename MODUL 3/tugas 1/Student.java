import java.util.Scanner;

public class Student extends User {
    public Student(Book[] bookList) {
        super(bookList);
    }

    public Student() {
    }


    private String name;
    private String faculty;
    private String nim;
    private String programStudi;

    private Book[] borrowedBooks = new Book[100];
    int borrowedCount = 0;

    
    public void Student(String name, String faculty, String nim, String programStudi) {
        this.name = name;
        this.faculty = faculty;
        this.nim = nim;
        this.programStudi = programStudi;
    }

    void displayInfo() {
        System.out.println("Nama: " + name);
        System.out.println("Fakultas: " + faculty);
        System.out.println("NIM: " + nim);
        System.out.println("Program Study: " + programStudi);
    }

    public void displayBooks(Book[] bookList, int bookCount) {
        System.out.println("=======================================================================================");
        System.out.printf("| %-10s | %-30s | %-20s | %-5s |\n", "ID", "Judul", "Penulis", "Stok");
        System.out.println("=======================================================================================");
        for (int i = 0; i < bookCount; i++) {
            Book book = bookList[i];
            if (book != null) {
                System.out.printf("| %-10s | %-30s | %-20s | %-5d |\n", 
                                  book.getBookId(), book.getTitle(), book.getAuthor(), 
                                  book.getStock());
            }
        }
        System.out.println("========================================================================================");
        if (bookCount == 0) {
            System.out.println("Belum ada buku yang ditambahkan, minta tolong admin tambahkan buku terlebih dahulu.");
        }
    }
    
    void borrowBook(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the book ID you want to borrow: ");
            String id = scanner.nextLine();
            for (int i = 0; i < bookCount; i++) {
                Book book = bookList[i];
                if (book.getBookId().equals(id)) {
                    if (book.getStock() > 0) {
                        System.out.print("Enter the loan duration (in days): ");
                        int duration = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("You have borrowed the book " + book.getTitle() + " for " + duration + " days.");
    
                        book.setDuration(duration); 
                        borrowedBooks[borrowedCount++] = book;
                        return;
                    } else {
                        System.out.println("Sorry, this book is currently unavailable.");
                        break;
                    }
                }
                if (i == bookCount - 1) {
                    System.out.println("Book with that ID not found.");
                }
            }
        }
    }
    
    
        public void displayBorrowedBooks() {
            System.out.println("======================================================================================");
            System.out.printf("| %-10s | %-30s | %-20s | %-8s |\n", "ID", "Judul", "Penulis", "Durasi");
            System.out.println("======================================================================================");
            for (int i = 0; i < borrowedCount; i++) {
                Book book = borrowedBooks[i];
                System.out.printf("| %-10s | %-30s | %-20s | %-8d |\n", 
                                  book.getBookId(), book.getTitle(), book.getAuthor(), 
                                  book.getDuration());
            }
            System.out.println("====================================================================================");
            if (borrowedCount == 0) {
                System.out.println("Anda belum meminjam buku apapun.");
            }
        }


    void logout() {
        System.out.println("Anda telah keluar.");
    }

    void returnBooks(Book[] bookList, int bookCount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book ID you want to return: ");
        String id = scanner.nextLine();
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i].getBookId().equals(id)) {
                for (int j = 0; j < bookCount; j++) {
                    if (bookList[j].getBookId().equals(id)) {
                        bookList[j].setStock(bookList[j].getStock() + 1);
                        borrowedBooks[i] = null;
                        System.out.println("You have returned the book " + bookList[j].getTitle() + ".");
                        borrowedCount--;
                        return;
                    }
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getProgramStudi() {
        return programStudi;
    }

    public String getNim() {
        return nim;
    }
}