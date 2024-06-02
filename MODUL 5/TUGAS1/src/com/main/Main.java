package com.main;

import data.Admin;
import data.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    Admin admin = Admin.getInstance();


    public void firstMenu() {
        int choice = 0;
        do {
            try {
                System.out.println("====== WELCOME TO LIBRARY SYSTEM=======");
                System.out.println("1. Login as Admin");
                System.out.println("2. Login as User");
                System.out.print("Your choice: ");
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        admin.loginAdmin();
                        break;
                    case 2:
                        admin.loginStudent();
                        break;
                    default:
                        System.out.println("Please enter a valid input\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. please enter a number");
                scan.next();
            }
        } while (choice != 1 && choice != 3);
    }

    public String inputNIM() {
        System.out.print("Enter NIM: ");
        return scan.next();
    }

    public Object[] checkNIM(String nim) {
        boolean found = false;
        Student foundStudent = null;

        for (Student student : admin.studentList) {
            if (student.getNim().equals(nim)) {
                found = true;
                foundStudent = student;
                break;
            }

        }

        return new Object[]{found, foundStudent};
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.firstMenu();
        main.scan.close();
    }
}
