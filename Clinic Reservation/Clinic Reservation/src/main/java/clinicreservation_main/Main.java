package clinicreservation_main;

import student_management_package.*;
import facilitator_management_package.*;
import nurse_management_package.*;
import subject_management_package.*;
import class_management_package.*;
import enrollment_management_package.*;
import activity_management_package.*;
import clearance_management_package.*;

import java.sql.*;
import clinicreservation_main.scanner;

public class Main {
    public static void main(String[] args) {
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
            System.out.println("3. Nurse Management");
            System.out.println("4. Subject Management");
            System.out.println("5. Class Management");
            System.out.println("6. Enrollment Management");
            System.out.println("7. Activity Management");
            System.out.println("8. Clearance Management");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: studentMenu(); break;
                case 2: facilitatorMenu(); break;
                case 3: nurseMenu(); break;
                case 4: subjectMenu(); break;
                case 5: classMenu(); break;
                case 6: enrollmentMenu(); break;   
                case 7: activityMenu(); break;      
                case 8: clearanceMenu(); break;
                case 9: System.out.println("Exiting system..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 9);

        scanner.close();
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void studentMenu() {
        int choice = 0;

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
                case 1: InsertStudent.insert(); break;
                case 2: ViewStudent.view(); break;
                case 3: UpdateStudent.update(); break;
                case 4: DeleteStudent.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
    
    public static void facilitatorMenu(){
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
                case 1: InsertFacilitator.insert(); break;
                case 2: ViewFacilitator.view(); break;
                case 3: UpdateFacilitator.update(); break;
                case 4: DeleteFacilitator.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
   
    public static void nurseMenu() {
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
                case 1: InsertNurse.insert(); break;
                case 2: ViewNurse.view(); break;
                case 3: UpdateNurse.update(); break;
                case 4: DeleteNurse.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
    
    public static void subjectMenu(){
        int choice = 0;
        
        do {
            System.out.println("\n===== SUBJECT MANAGEMENT =====");
            System.out.println("1. Insert Subject");
            System.out.println("2. View Subject");
            System.out.println("3. Update Subject");
            System.out.println("4. Delete Subject");
            System.out.println("5. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: InsertSubject.insert(); break;
                case 2: ViewSubject.view(); break;
                case 3: UpdateSubject.update(); break;
                case 4: DeleteSubject.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
   
    public static void classMenu(){
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
                case 1: InsertClass.insert(); break;
                case 2: ViewClass.view(); break;
                case 3: UpdateClass.update(); break;
                case 4: DeleteClass.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    }
    
    public static void enrollmentMenu(){
        int choice = 0;
        
        do {
            System.out.println("\n===== ENROLLMENT MANAGEMENT =====");
            System.out.println("1. Insert Enrollment");
            System.out.println("2. View Enrollment");
            System.out.println("3. View Student Count for Each Class");
            System.out.println("4. View Students From Specific Class");
            System.out.println("5. Update Enrollment");
            System.out.println("6. Delete Enrollment");
            System.out.println("7. Return to Main Menu");

            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: InsertEnrollment.insert(); break;
                case 2: ViewEnrollment.view(); break;
                case 3: ViewEnrollment.viewStudentCount(); break;
                case 4: ViewEnrollment.viewStudentsFromClass(); break;
                case 5: UpdateEnrollment.update(); break;
                case 6: DeleteEnrollment.delete(); break;
                case 7: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 7);
    }
    
    public static void activityMenu() {
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
                case 1: InsertActivity.insert(); break;
                case 2: ViewActivity.view(); break;
                case 3: UpdateActivity.update(); break;
                case 4: DeleteActivity.delete(); break;
                case 5: System.out.println("Returning to Main Menu..."); break;
                default: System.out.println("Invalid Choice");
            }
        } while (choice != 5);
    } 
    
    public static void clearanceMenu() {
        int choice = 0;

        do {
            System.out.println("\n===== CLEARANCE MANAGEMENT =====");
            System.out.println("[1] Insert Clearance");
            System.out.println("[2] View Clearances");
            System.out.println("[3] View Approved Clearances");
            System.out.println("[4] View Rejected Clearances");
            System.out.println("[5] View Pending Clearances");
            System.out.println("[6] Update Clearance");
            System.out.println("[7] Delete Clearance");
            System.out.println("[8] Return to Main Menu");
            System.out.print("Enter choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1: InsertClearance.insert(); break;
                    case 2: ViewClearance.view(); break;
                    case 3: ViewClearance.viewStudentStatus("Approved"); break;
                    case 4: ViewClearance.viewStudentStatus("Rejected"); break;
                    case 5: ViewClearance.viewStudentStatus("Pending"); break;
                    case 6: UpdateClearance.update(); break;
                    case 7: DeleteClearance.delete();
                    case 8: System.out.println("Returning to Main Menu..."); break;
                    default: System.out.println("Invalid Choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a number!");
            }
        } while (choice != 8);
    }
}
    

