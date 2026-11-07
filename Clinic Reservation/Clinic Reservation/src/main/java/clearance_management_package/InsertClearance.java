package clearance_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clinicreservation_main.scanner;
import java.sql.*;

public abstract class InsertClearance {
    public static void insert() {
        String enrollment_id;
        String activity_id;
        String nurse_id;
        String physician_first_name;
        String physician_last_name;
        String evaluated_date;
        String evaluated_time;
        String status = "PENDING";
        String rejection_reason = "";
        
        do{
            try {
                System.out.print("Enter Enrollment ID: ");
                enrollment_id = scanner.next();
                Integer.valueOf(enrollment_id);
  
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Enrollment ID!");
                enrollment_id = "";
            } 
           
        } while (enrollment_id.isEmpty() || enrollment_id.isBlank());
            
        do{
            try {
                System.out.print("Enter Activity ID: ");
                activity_id = scanner.next();
                Integer.valueOf(activity_id);
                
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Activity ID!");
                activity_id = "";
        }
   
    } while (activity_id.isEmpty() || activity_id.isBlank());
        
         do{
            try {
                System.out.print("Enter Nurse ID: ");
                nurse_id = scanner.next();
                Integer.valueOf(nurse_id);
  
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Nurse ID!");
                nurse_id = "";
            } 
           
        } while (nurse_id.isEmpty() || nurse_id.isBlank());
        
        do{
            System.out.print("Enter Physician First Name: ");
            physician_first_name = scanner.next();
        } while (physician_first_name.isEmpty() || physician_first_name.isBlank());
        
        do{
            System.out.print("Enter Physician Last Name: ");
            physician_last_name = scanner.next();
        } while (physician_last_name.isEmpty() || physician_last_name.isBlank());      
        
        do {
            System.out.print("Enter Evaluated Date (YYYY-MM-DD): ");
            evaluated_date = scanner.next();
        } while (!evaluated_date.matches("\\d{4}-\\d{2}-\\d{2}"));
      
        do {
            System.out.print("Enter Evaluated Time (HH:MM:SS): ");
            evaluated_time = scanner.next();
        } while (!evaluated_time.matches("\\d{2}:\\d{2}:\\d{2}"));       
        
            insertSQL(enrollment_id, activity_id, nurse_id,
                physician_first_name, physician_last_name,
                evaluated_date, evaluated_time, status, rejection_reason);    
        
        
    }
    
    private static void insertSQL(String enrollmentId, String activityId,
            String nurseId, String physicianFirstName, String physicianLastName,
            String evaluatedDate, String evaluatedTime, String status,
            String rejectionReason) {
        
        String sql = "INSERT INTO CLEARANCE "
                    + "(enrollment_id, activity_id, nurse_id, physician_first_name, physician_last_name, evaluated_date, evaluated_time, status, rejection_reason) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (   Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ) 
        {
            ps.setString(1, enrollmentId);
            ps.setString(2, activityId);
            ps.setString(3, nurseId);
            ps.setString(4, physicianFirstName);
            ps.setString(5, physicianLastName);
            ps.setString(6, evaluatedDate);
            ps.setString(7, evaluatedTime);
            ps.setString(8, status);
            ps.setString(9, rejectionReason);
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Clearance inserted successfully!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
    
    
    
