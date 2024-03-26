import java.util.Scanner;

public class Admin extends User {
    String adminUsername = "admin";
    String adminPassword = "admin";
    User[] studentList = new User[100];
    int studentCount = 0;

    public Admin(Book[] bookList) {
        super(bookList);
    }

    void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();
        String nim;
        do {
            System.out.print("Masukkan NIM: ");
            nim = scanner.nextLine();
            if (nim.length() != 15) {
                System.out.println("NIM tidak valid. NIM harus memiliki panjang 15 karakter.");
            }
        } while (nim.length() != 15);
        System.out.print("Masukkan fakultas: ");
        String faculty = scanner.nextLine();
        System.out.print("Masukkan program studi: ");
        String programStudi = scanner.nextLine();

        Student newStudent = new Student();
        newStudent.Student(name, faculty, nim, programStudi);
        studentList[studentCount++] = newStudent;
        System.out.println("Siswa dengan nama" + " " + name + " " + "berhasil ditambahkan.");
    }

    void addBook() {
        super.addBook();
    }

    void displayBooks() {
        super.displayBooks();
    }

    void displayStudents() {
        System.out.println("Daftar mahasiswa yang terdaftar:");
        for (int i = 0; i < studentCount; i++) {
            Student student = (Student) studentList[i];
            if (student != null) {
                student.displayInfo();
            }
        }
    }
}
