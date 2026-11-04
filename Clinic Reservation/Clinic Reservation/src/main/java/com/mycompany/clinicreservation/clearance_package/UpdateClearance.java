/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicreservation.clearance_package;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Samuel Trinidad
 */
public class UpdateClearance {
    public static void update() {
        Scanner scanner = new Scanner(System.in);
        
        String clearanceId;
        String enrollmentId;
        String activityId;
        String nurseId;
        String physicianFirstName;
        String physicianLastName;
        String evaluatedDate;
        String evaluatedTime;
        String status;
        String rejectionReason = "";
        
         do {
            try {
                System.out.print("Enter Clearance ID: ");
                clearanceId = scanner.next();
                Integer.valueOf(clearanceId);

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Clearance ID!");
                clearanceId = "";
            }

        } while (clearanceId.isEmpty() || clearanceId.isBlank());
        
         do{
            try {
                System.out.print("Enter Enrollment ID: ");
                enrollmentId = scanner.next();
                Integer.valueOf(enrollmentId);
  
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Enrollment ID!");
                enrollmentId = "";
            } 
         } while (enrollmentId.isEmpty() || enrollmentId.isBlank());       
        
        do{
            try {
                System.out.print("Enter Activity ID: ");
                activityId = scanner.next();
                Integer.valueOf(activityId);
                
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Activity ID!");
                activityId = "";
        }
   
    } while (activityId.isEmpty() || activityId.isBlank());        
    
         do{
            try {
                System.out.print("Enter Nurse ID: ");
                nurseId = scanner.next();
                Integer.valueOf(nurseId);
  
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Nurse ID!");
                nurseId = "";
            } 
           
        } while (nurseId.isEmpty() || nurseId.isBlank());        
        
         do{
            System.out.print("Enter Physician First Name: ");
            physicianFirstName = scanner.next();
        } while (physicianFirstName.isEmpty() || physicianFirstName.isBlank());
        
        do{
            System.out.print("Enter Physician Last Name: ");
            physicianLastName = scanner.next();
        } while (physicianLastName.isEmpty() || physicianLastName.isBlank());      
        
        do {
            System.out.print("Enter Evaluated Date (YYYY-MM-DD): ");
            evaluatedDate = scanner.next();
        } while (!evaluatedDate.matches("\\d{4}-\\d{2}-\\d{2}"));
      
        do {
            System.out.print("Enter Evaluated Time (HH:MM:SS): ");
            evaluatedTime = scanner.next();
        } while (!evaluatedTime.matches("\\d{2}:\\d{2}:\\d{2}"));       
        
        do {
        System.out.print("Enter Status (APPROVED / REJECTED / PENDING): ");
        status = scanner.next().toUpperCase();

        if (!status.equals("APPROVED")
                && !status.equals("REJECTED")
                && !status.equals("PENDING")) {
            System.out.println("ERROR: Invalid Status!");
        }

} while (!status.equals("APPROVED")
        && !status.equals("REJECTED")
        && !status.equals("PENDING"));
        if (status.equals("REJECTED")) {
            System.out.print("Enter Rejection Reason: ");
            scanner.nextLine(); // Consume leftover newline
            rejectionReason = scanner.nextLine();
        }
        
        updateSQL(clearanceId, enrollmentId, activityId, nurseId,
                physicianFirstName, physicianLastName,
                evaluatedDate, evaluatedTime, status, rejectionReason);   
        
        
    }       
            private static void updateSQL(String clearanceId, String enrollmentId,
            String activityId, String nurseId,
            String physicianFirstName, String physicianLastName,
            String evaluatedDate, String evaluatedTime, String status,
            String rejectionReason) {
                
                String sql = "UPDATE CLEARANCE "
                + "SET enrollment_id = ?, activity_id = ?, nurse_id = ?, "
                + "physician_first_name = ?, physician_last_name = ?, "
                + "evaluated_date = ?, evaluated_time = ?, status = ?, "
                + "rejection_reason = ? "
                + "WHERE clearance_id = ?";   
                

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, enrollmentId);
            ps.setString(2, activityId);
            ps.setString(3, nurseId);
            ps.setString(4, physicianFirstName);
            ps.setString(5, physicianLastName);
            ps.setString(6, evaluatedDate);
            ps.setString(7, evaluatedTime);
            ps.setString(8, status);
            ps.setString(9, rejectionReason);
            ps.setString(10, clearanceId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Clearance updated successfully!");
            } else {
                System.out.println("Clearance ID not found!");
            }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
