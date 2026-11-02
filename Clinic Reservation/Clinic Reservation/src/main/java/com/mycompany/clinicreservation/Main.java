package com.mycompany.clinicreservation;

import com.mycompany.clinicreservation.student_management_package.ViewStudent;
import com.mycompany.clinicreservation.student_management_package.DeleteStudent;
import com.mycompany.clinicreservation.student_management_package.UpdateStudent;
import com.mycompany.clinicreservation.student_management_package.InsertStudent;
import com.mycompany.clinicreservation.facilitator_management_package.*;
import com.mycompany.clinicreservation.nurse_management_package.*;
import java.sql.*;
import java.util.*;

public class Main {

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
            System.out.println("3. Nurse Management");
            System.out.println("4. Clearance Management");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentMenu(scanner);
                    break;

                case 2:
                    facilitatorMenu(scanner);
                    break;

                case 3:
                    nurseMenu(scanner);
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
                    InsertStudent.insert();
                    break;

                case 2:
                    ViewStudent.view();
                    break;

                case 3:
                    UpdateStudent.update();
                    break;

                case 4:
                    DeleteStudent.delete();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
    
    public static void facilitatorMenu(Scanner scanner){
        int choice = 0;
        
        do {
            System.out.println("\n===== FACILITATOR MANAGEMENT =====");
            System.out.println("1. Insert Facilitator");
            System.out.println("2. View Facilitator");
            System.out.println("3. Update Facilitator");
            System.out.println("4. Delete Facilitator");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertFacilitator.insert();
                    break;

                case 2:
                    ViewFacilitator.view();
                    break;

                case 3:
                    UpdateFacilitator.update();
                    break;

                case 4:
                    DeleteFacilitator.delete();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
    
    public static void nurseMenu(Scanner scanner) {

    int choice = 0;

    do {
        System.out.println("\n===== NURSE MANAGEMENT =====");
        System.out.println("1. Insert Nurse");
        System.out.println("2. View Nurse");
        System.out.println("3. Update Nurse");
        System.out.println("4. Delete Nurse");
        System.out.println("5. Return to Main Menu");

        System.out.print("Enter Choice: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                InsertNurse.insert();
                break;

            case 2:
                ViewNurse.view();
                break;

            case 3:
                UpdateNurse.update();
                break;

            case 4:
                DeleteNurse.delete();
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