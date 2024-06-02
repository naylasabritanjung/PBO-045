package data;

import books.Book;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import java.util.Scanner;
import java.util.ArrayList;

public class User {
    ArrayList<Book> bookList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    /*public void displayBook() {
        System.out.println("Daftar Buku:");
        for (Book book : bookList) {
            System.out.println("- " + book.getTitle());
        }
    }*/

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

    /*public void addBook(Book newBook) {
        bookList.add(newBook);
        System.out.println("Buku berhasil ditambahkan: " + newBook.getTitle());
    }*/

    public Book[] getBookList() {
        return bookList.toArray(new Book[0]);
    }
}
