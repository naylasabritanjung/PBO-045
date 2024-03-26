import java.util.Scanner;

public class Main {
    String Book, User, Student;
    Book[] bookList = new Book[100];
    int bookCount = 0;
    User[] userStudent = new User[100];
    int studentCount = 0;
    Admin admin = new Admin(bookList);
    Student student;
    private User[] studentList;
    private boolean checkNim;

    void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login Admin");
            System.out.println("2. Login Student");
            System.out.println("3. Keluar");
            System.out.print("Pilih opsi (1-3) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    if (loginAdmin()) {
                        menuAdmin();
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;
                case 2:
                    if (inputNim()) {
                        menuStudent();
                    } else {
                        System.out.println("NIM tidak ditemukan.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("maaf, inputan tidak valid");
                    System.out.println();
            }
        }
    }

    boolean loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        String username, password;
        do {
            System.out.print("Masukkan username: ");
            username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            password = scanner.nextLine();
            if (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password)) {
                System.out.println("Username atau password salah. Silakan coba lagi.");
            }
        } while (!admin.adminUsername.equals(username) || !admin.adminPassword.equals(password));
        return true;
    }

    boolean inputNim() {
        Scanner scanner = new Scanner(System.in);
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM tidak valid.");
            }
        } while (nim.length() != 15);
        return checkNim(nim, admin.studentList);
    }




    boolean checkNim(String nim, User[] studentList) {
        for (int i = 0; i < admin.studentCount; i++) {
            if (studentList[i] instanceof Student && ((Student) studentList[i]).getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }


    void menuAdmin() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("===== Admin Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Book");
            System.out.println("3. Display Registered Student");
            System.out.println("4. Display available Books");
            System.out.println("5. Logout");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    admin.addStudent();
                    studentList = admin.studentList;
                    studentCount = admin.studentCount;
                    System.out.println("Siswa berhasil ditambahkan.");
                    break;
                case 2:
                    admin.addBook();
                    bookList = admin.bookList;
                    bookCount = admin.bookCount;
                    System.out.println("Buku berhasil ditambahkan.");
                    break;
                case 3:
                    admin.displayStudents();
                    break;
                case 4:
                    admin.displayBooks();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("inputan tidak valid");
            }
        }
    }

    void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        while (true) {
            System.out.println();
            System.out.println("===== Student Menu =====");
            System.out.println("1. Tampilkan Buku");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Tampilkan buku yang dipinjam");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Logout");
            System.out.print("Pilih opsi (1-5) : ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    student.displayBooks(bookList, bookCount);
                    break;
                case 2:
                    student.borrowBook(bookList, bookCount);
                    break;
                case 3:
                    student.displayBorrowedBooks();
                    break;
                case 4:
                    student.returnBooks(bookList, bookCount);
                    break;
                case 5:
                    student.logout();
                    return;
                default:
                    System.out.println("Inputan tidak valid");
            }
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
