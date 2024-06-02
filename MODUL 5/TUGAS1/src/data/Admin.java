package data;

import com.main.Main;
import util.iMenu;
import exception.custom.IllegalAdminAccess;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import books.Book;
import books.HistoryBook;
import books.TextBook;
import books.StoryBook;

public class Admin extends User implements iMenu {
    private static String adminUsername = "admin";
    private static String adminPassword = "admin";
    public ArrayList<Student> studentList = new ArrayList<>();
    private static Admin instance = null;
    public ArrayList<Book> bookList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    private Admin() {}

    public static Admin getInstance() {
        if (instance == null) {
            instance = new Admin();
        }
        return instance;
    }

    @Override
    public void menu(ArrayList<Student> studentList) {
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            try {
                System.out.println("======DASHBOARD ADMIN======");
                System.out.println("1. Add Student");
                System.out.println("2. Add Book");
                System.out.println("3. Display Book");
                System.out.println("4. Display Students");
                System.out.println("5. Kembali ke menu awal");
                System.out.print("Pilihan anda: ");
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        inputBook();
                        break;
                    case 3:
                        displayBook();
                        break;
                    case 4:
                        displayStudents();
                        break;
                    case 5:
                        System.out.println("TERIMAKASIH SUDAH MENGGUNAKAN PROGRAM INI");
                        Main main = new Main();
                        logout(main);
                        return;
                    default:
                        System.err.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.err.println("Terjadi kesalahan: " + e.getMessage());
                scan.nextLine();
            }

            if (isLanjutkan) {
                boolean inputValid = false;
                do {
                    System.out.print("Apakah Anda ingin melanjutkan program? (y/n): ");
                    String lanjutkan = scan.next();
                    if (lanjutkan.equalsIgnoreCase("y")) {
                        inputValid = true;
                    } else if (lanjutkan.equalsIgnoreCase("n")) {
                        isLanjutkan = false;
                        System.out.println("TERIMA KASIH SUDAH MENGGUNAKAN PROGRAM INI");
                        inputValid = true;
                    } else {
                        System.out.println("Masukkan inputan yang valid!");
                    }
                } while (!inputValid);
            }
        }
    }


    public void logout(Main main) {
        System.out.println("Logging out...");
        main.firstMenu();
    }

    public boolean loginAdmin() {
        String inputUsn;
        String inputPass;

        boolean isAdminLoggedIn = false;

        do {
            System.out.print("Username: ");
            inputUsn = scan.next();
            System.out.print("Password: ");
            inputPass = scan.next();

            try {
                isAdminLoggedIn = Admin.isAdmin(inputUsn, inputPass);
            } catch (IllegalAdminAccess e) {
                System.out.println(e.getMessage());
            }

            if (!isAdminLoggedIn) {
                System.out.println("Masukkan username dan password yang benar!");
            } else {
                menu(studentList);

            }
        } while (!isAdminLoggedIn);
        return isAdminLoggedIn;
    }

    public boolean loginStudent() {
        System.out.println("====== LOGIN AS STUDENT ======");
        System.out.print("Enter NIM: ");
        String nim = scan.next();

        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                System.out.println("Login successful!");
                student.menu(studentList);
                return true;
            }
        }

        System.out.println("Login failed. NIM not found.");
        return false;
    }


    public static boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        } else {
            throw new IllegalAdminAccess ("Invalid credentials");
        }
    }

    String generateId() {
        String uniqueID = UUID.randomUUID().toString();
        String id = uniqueID.replaceAll("-", "").toLowerCase();
        return String.format("%s-%s-%s", id.substring(0, 4), id.substring(4, 8), id.substring(8, 12));
    }

    public void addStudent() {
        scan.nextLine();
        System.out.print("Nama Mahasiswa:");
        String name = scan.nextLine();

        String nim;

        do {
            System.out.print("NIM Mahasiswa: ");
            nim = scan.nextLine();

            if (nim.length() != 15) {
                System.out.println("Inputan NIM tidak valid, NIM harus memiliki panjang 15 digit!");
            }
        } while (nim.length() != 15);

        System.out.print("Fakultas Mahasiswa: ");
        String faculty = scan.nextLine();

        System.out.print("Program Studi Mahasiswa: ");
        String major = scan.nextLine();

        Student newStudent = new Student();
        newStudent.setName(name);
        newStudent.setNim(nim);
        newStudent.setFaculty(faculty);
        newStudent.setMajor(major);

        studentList.add(newStudent);
        System.out.println("DATA BERHASIL DITAMBAHKAN!");
    }

    public void displayStudents() {
        System.out.println("=======================================================================================");
        System.out.printf("| %-20s | %-15s | %-20s | %-20s |\n", "Nama", "NIM", "Fakultas", "Program Studi");
        System.out.println("=======================================================================================");
        for (Student student : studentList) {
            System.out.printf("| %-20s | %-15s | %-20s | %-20s |\n",
                    student.getName(),
                    student.getNim(),
                    student.getFaculty(),
                    student.getMajor());
        }
        System.out.println("========================================================================================");
    }

    public void inputBook() {
        int bookCount = 0;
        System.out.println("Masukan kategori buku yang ingin ditambahkan : ");
        System.out.println("1. History Book ");
        System.out.println("2. Story Book");
        System.out.println("3. Text Book");
        System.out.print("Pilihan anda: ");
        int option = scan.nextInt();
        scan.nextLine();

        String id = generateId();

        System.out.print("Masukkan judul: ");
        String title = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        String author = scan.nextLine();
        System.out.print("Masukkan stok: ");
        int stock = scan.nextInt();

        Book newBook;

        switch (option){
            case 1:
                newBook = new HistoryBook(id, title, author, stock, "History");
                break;
            case 2:
                newBook = new StoryBook(id, title, author, stock, "Story");
                break;
            case 3:
                newBook = new TextBook(id, title, author, stock, "Text");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                return;
        }

        bookList.add(newBook); // Menggunakan admin.bookList untuk menambahkan buku ke bookList
    }

    //overloading method
    public void inputBook(String category) {
        String id = generateId();

        scan.nextLine();

        System.out.print("Masukkan judul: ");
        String title = scan.nextLine();
        System.out.print("Masukkan penulis: ");
        String author = scan.nextLine();
        System.out.print("Masukkan stok: ");
        int stock = scan.nextInt();

        Book newBook;

        switch (category.toLowerCase()) {
            case "history":
                newBook = new HistoryBook(id, title, author, stock, "History");
                break;
            case "story":
                newBook = new StoryBook(id, title, author, stock, "Story");
                break;
            case "text":
                newBook = new TextBook(id, title, author, stock, "Text");
                break;
            default:
                System.out.println("Kategori tidak valid.");
                return;
        }

        bookList.add(newBook);
    }

    public void displayBook() {
        System.out.println("==============================================================================================================");
        System.out.printf("| %-15s | %-30s | %-20s | %-20s | %-10s |\n", "ID", "Judul", "Penulis", "Kategori", "Stok");
        System.out.println("==============================================================================================================");
        for (Book book : bookList) {
            System.out.printf("| %-15s | %-30s | %-20s | %-20s | %-10d |\n",
                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getCategory(),
                    book.getStock());
        }
        System.out.println("==============================================================================================================");
    }

    public Book[] getBookList() {
        return bookList.toArray(new Book[0]);
    }
}
