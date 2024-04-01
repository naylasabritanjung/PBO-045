import java.util.Scanner;

public class Mahasiswa {
    static Scanner scan = new Scanner(System.in);
    static String[] namaMahasiswa = new String[100];
    static String[] NIMMahasiswa = new String[100];
    static String[] jurusanMahasiswa = new String[100];
    static int jumlahMahasiswa = 0;

    public static void tampilUniversitas() {
        System.out.print("Nama mahasiswa: ");
        String nama = scan.nextLine();
        
        String NIM;

        do {
            System.out.print("NIM Mahasiswa: ");
            NIM = scan.nextLine();

            if (NIM.length() != 15) {
                System.out.println("NIM harus 15 digit!\n");
                return;
            }
        } while (NIM.length() != 15);

        System.out.print("Jurusan: ");
        String jurusan = scan.nextLine();

        namaMahasiswa[jumlahMahasiswa] = nama;
        NIMMahasiswa[jumlahMahasiswa] = NIM;
        jurusanMahasiswa[jumlahMahasiswa] = jurusan;

        jumlahMahasiswa++;
        System.out.println("Data mahasiswa berhasil ditambahkan\n");
    }

    public static void tampilMahasiswa() {
        if (jumlahMahasiswa == 0) {
            System.out.println("Belum ada data mahasiswa yang ditambahkan.");
            return;
        }

        System.out.println("Daftar Mahasiswa:");
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Nama: " + namaMahasiswa[i]);
            System.out.println("NIM: " + NIMMahasiswa[i]);
            System.out.println("Jurusan: " + jurusanMahasiswa[i]);
            System.out.println();
        }
    }
}
