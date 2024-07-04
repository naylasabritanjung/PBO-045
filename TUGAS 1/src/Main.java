import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    public String nama;
    public int age;
    public int weight;
    public String hobby;

    public void input() {
        System.out.println("Nama Singa: " );
        String nama = sc.nextLine();
        System.out.println("Umur Singa: ");
        int age = sc.nextInt();
        System.out.println("Berat Singa: ");
        int weight = sc.nextInt();
        System.out.println("Hobby Singa: " );
        String nama = sc.nextLine();
    }

    public static void main(String[] args) {
        Singa singa = new Singa();
    }
}
