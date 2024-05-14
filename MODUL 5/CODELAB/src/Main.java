import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> mahasiswa = new ArrayList<>();
        int count = 1;

        while (true) {
            System.out.println("Masukkan nama mahasiswa ke " + count + ": ");
            String input = scan.nextLine();

            if (input.equalsIgnoreCase("selesai")) {
                break;
            }

            try {
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                } else {
                    mahasiswa.add(input);
                    count++;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Daftar mahasiswa yang diinput: ");
        for (String nama : mahasiswa) {
            System.out.println("- " + nama);
        }
    }
}