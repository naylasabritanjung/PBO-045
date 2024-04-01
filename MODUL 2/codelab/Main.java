import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    Mahasiswa mahasiswa = new Mahasiswa();

    int opsi;

    public void menu() {
        do {
        System.out.println("Menu: ");
        System.out.println("1. Tambah Data Mahasiswa");
        System.out.println("2. Tampilkan Data Mahasiswa");
        System.out.println("3. Keluar");
        System.out.print("Pilihan anda: ");
        opsi = scan.nextInt();

        switch (opsi) {
            case 1: 
            Mahasiswa.tampilUniversitas();
            break;

            case 2: 
            Mahasiswa.tampilMahasiswa();
            break;

            case 3:
            System.out.println("Terimakasih sudah menggunakan program ini");
            return;

            default:
            System.out.println("Inputan anda tidak valid!\n");
        }
    } while (opsi != 3);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

}
