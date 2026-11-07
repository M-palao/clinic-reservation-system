package clinicreservation_main;

import nurse_management_package.InsertNurse;
import nurse_management_package.ViewNurse;
import nurse_management_package.UpdateNurse;
import nurse_management_package.DeleteNurse;
import facilitator_management_package.DeleteFacilitator;
import facilitator_management_package.ViewFacilitator;
import facilitator_management_package.UpdateFacilitator;
import facilitator_management_package.InsertFacilitator;
import clearance_management_package.UpdateClearance;
import clearance_management_package.ViewClearance;
import clearance_management_package.InsertClearance;
import clearance_management_package.DeleteClearance;
import class_management_package.*;
import student_management_package.ViewStudent;
import student_management_package.DeleteStudent;
import student_management_package.UpdateStudent;
import student_management_package.InsertStudent;
import enrollment_management_package.*;
import activity_management_package.*;


import java.sql.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Connection connection = DBConnection.getConnection();

        if (connection != null) {
            System.out.println("Database connected successfully!");
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
            System.out.println("3. Class Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Nurse Management");
            System.out.println("6. Clearance Management");
            System.out.println("7. Activity Management");
            System.out.println("8. Exit");

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
                    classMenu(scanner);
                    break;
                case 4:
                    enrollmentMenu(scanner);
                    break;
                case 5:
                    nurseMenu(scanner);
                    break;

                case 6:
                    clearanceMenu(scanner);
                    break;
                    
                case 7:
                    activityMenu(scanner);
                    break;                    

                case 8:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 8);

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
    
    public static void classMenu(Scanner scanner){
        int choice = 0;
        
        do {
            System.out.println("\n===== CLASS MANAGEMENT =====");
            System.out.println("1. Insert Class");
            System.out.println("2. View Class");
            System.out.println("3. Update Class");
            System.out.println("4. Delete Class");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertClass.insert();
                    break;

                case 2:
                    ViewClass.view();
                    break;

                case 3:
                    UpdateClass.update();
                    break;

                case 4:
                    DeleteClass.delete();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    
    }
    
    public static void enrollmentMenu(Scanner scanner){
        int choice = 0;
        
        do {
            System.out.println("\n===== ENROLLMENT MANAGEMENT =====");
            System.out.println("1. Insert Enrollment");
            System.out.println("2. View Enrollment");
            System.out.println("3. Update Enrollment");
            System.out.println("4. Delete Enrollment");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertEnrollment.insert();
                    break;

                case 2:
                    ViewEnrollment.view();
                    break;

                case 3:
                    UpdateEnrollment.update();
                    break;

                case 4:
                    DeleteEnrollment.delete();
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
    
public static void clearanceMenu(Scanner scanner) {
    int choice = 0;

    do {
        System.out.println("\n===== CLEARANCE MANAGEMENT =====");
        System.out.println("[1] Insert Clearance");
        System.out.println("[2] View Clearance");
        System.out.println("[3] Update Clearance");
        System.out.println("[4] Delete Clearance");
        System.out.println("[5] Return to Main Menu");
        System.out.print("Enter choice: ");

        try {
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    InsertClearance.insert();
                    break;

                case 2:
                    ViewClearance.view();
                    break;

                case 3:
                    UpdateClearance.update();
                    break;

                case 4:
                    DeleteClearance.delete();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("ERROR: Invalid choice!");
            }

        } catch (NumberFormatException e) {
            System.out.println("ERROR: Please enter a number!");
        }

    } while (choice != 5);
}
    
public static void activityMenu(Scanner scanner) {
    int choice;
    
    do{
        System.out.println("\n===== ACTIVITY MANAGEMENT =====");
        System.out.println("[1] Insert Activity");
        System.out.println("[2] View Activities");
        System.out.println("[3] Update Activity");
        System.out.println("[4] Delete Activity");
        System.out.println("[5] Return to Main Menu");
        System.out.print("Enter choice: ");      
        
        choice = scanner.nextInt();
        
      

        switch (choice) {
            case 1:
                InsertActivity.insert();
                break;

            case 2:
                ViewActivity.view();
                break;

            case 3:
                UpdateActivity.update();
                break;

            case 4:
                DeleteActivity.delete();
                break;

            case 5:
                System.out.println("Returning to Main Menu...");
                break;

            default:
                System.out.println("Invalid choice!");
        }

    } while (choice != 5);
}
    
    
    
}
    

