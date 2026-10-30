package com.mycompany.bareminimum;

import java.sql.*;
import java.util.*;

public class BareMinimum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Java connected to your sql.");
        } else {
            System.out.println("Database connection failed.");
            return;
        }

        int choice;

        do {
            System.out.println("\n===== CLINIC RESERVATION SYSTEM =====");
            System.out.println("1. Student Management");
            System.out.println("2. Facilitator Management");
            System.out.println("3. Activity Management");
            System.out.println("4. Clearance Management");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentMenu(scanner);
                    break;

                case 2:
                    System.out.println("Facilitator Management");
                    break;

                case 3:
                    System.out.println("Activity Management");
                    break;

                case 4:
                    System.out.println("Clearance Management");
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        scanner.close();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // STUDENT MENU
    public static void studentMenu(Scanner scanner) {

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT =====");
            System.out.println("1. Insert Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertStudent.main(new String[]{});
                    break;

                case 2:
                    ViewStudent.main(new String[]{});
                    break;

                case 3:
                    UpdateStudent.main(new String[]{});
                    break;

                case 4:
                    DeleteStudent.main(new String[]{});
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}