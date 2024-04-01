import java.util.Scanner;
public class codelab1 {
    Scanner scanner = new Scanner(System.in); 

    public void admin() { 
        String username = "admin";
        String password = "admin";
        boolean login = false;

        do {
        System.out.print("Enter your username: ");
        username = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();

        if (username.equals("admin") && password.equals("admin")) { // Menggunakan equals() untuk membandingkan string
            System.out.println("Login success!");
            login = true;
        } else {
            System.out.println("User not found!");
        }
    } while (!login);
    }

    public void student() { 
        String NIM;
        boolean login = false;

        do {
        System.out.print("Enter your NIM: ");
        NIM = scanner.nextLine();

        if (NIM.length() == 15) {
            System.out.println("Successful login as student");
            login = true;
        } else {
            System.out.println("User not found!");
        }
    } while (!login);
}

    public static void main(String[] args) {
        TUGASMODUL1 obj = new TUGASMODUL1();
        int opsi;
        
        do {
        System.out.println("===Library System===");
        System.out.println("1. Login as admin");
        System.out.println("2. Login as student");
        System.out.print("Enter your choice: ");
        opsi = obj.scanner.nextInt();
        obj.scanner.nextLine(); 

        switch (opsi) {
            case 1:
                obj.admin();
                break;

            case 2:
                obj.student();
                break;

            default:
                System.out.println("Enter valid option!");
        }
    } while (opsi != 1 && opsi != 2);
    }
}
