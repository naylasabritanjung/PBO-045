import java.util.Scanner;
import java.time.Period;
import java.time.LocalDate;

public class ConvertUmur {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Nama: ");
        String nama = scan.nextLine();

        System.out.print("Jenis Kelamin (P/L): ");
        char gender = scan.next().toUpperCase().charAt(0); 

        if (gender != 'P' && gender != 'l') { 
            System.out.println("Masukan inputan yang valid! (P/L)");
            return; 
        }

        System.out.print("Tanggal lahir (yyyy-MM-dd): ");
        String tanggalLahir = scan.next();

        LocalDate waktuLahir = LocalDate.parse(tanggalLahir);
        LocalDate sekarang = LocalDate.now();
        Period periode = Period.between(waktuLahir, sekarang);

        int tahun = periode.getYears();
        int bulan = periode.getMonths();
        int hari = periode.getDays();
        System.out.println("Umur anda adalah: " + tahun + " tahun " + bulan + " bulan " + hari + " hari ");
    }
}
