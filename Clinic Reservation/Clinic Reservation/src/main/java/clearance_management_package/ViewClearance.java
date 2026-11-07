/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clearance_management_package;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Samuel Trinidad
 */
public class ViewClearance {
    public static void view() {
        String sql = "SELECT * FROM CLEARANCE_FULL_VIEW";
         try(
             Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(); 
                
            ) {
            System.out.printf("%-15s %-15s %-10s %-25s %-12s %-20s %-15s %-15s %-12s %-20s%n",
                    "Clearance ID", "Student", "Class ID", "Activity", "Nurse ID",
                    "Physician", "Evaluated Date",
                    "Evaluated Time", "Status", "Rejection Reason");
             
             while(rs.next()) {
                 String clearanceId = rs.getString("clearance_id");
                 String firstName = rs.getString("first_name");
                 String lastName = rs.getString("last_name");
                 String classId = rs.getString("class_id");
                 String activity = rs.getString("activity_name");
                 String nurseId = rs.getString("nurse_id");
                 String physicianFirstName = rs.getString("physician_first_name");
                 String physicianLastName = rs.getString("physician_last_name");
                 String evaluatedDate = rs.getString("evaluated_date");
                 String evaluatedTime = rs.getString("evaluated_time");
                 String status = rs.getString("status");
                 String rejectionReason = rs.getString("rejection_reason");
                 
                System.out.printf("%-15s %-15s %-10s %-25s %-12s %-20s %-15s %-15s %-12s %-20s%n",
                 clearanceId, firstName + " " + lastName, classId, activity, nurseId,
                 physicianFirstName + " " + physicianLastName,
                 evaluatedDate, evaluatedTime, status, rejectionReason);
            }
        
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void viewStudentStatus(String status){
        Scanner inputScanner = new Scanner(System.in);
        String response = "";
        System.out.print("Input Activity Name To Check(type [A] to view all Students): ");
        response = inputScanner.nextLine();
        if (response.equals("A")){
            viewAllStatusSQL(status);
        } else {
            viewStatusSQL(response, status);
        }
        
    }
    
    private static void viewAllStatusSQL(String status){
        String sql = "SELECT first_name, last_name, class_id, activity_name, rejection_reason "
                    + "FROM CLEARANCE_FULL_VIEW "
                    + "WHERE status = ?";
        try(
             Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);   
            ) {
            
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery(); 
            System.out.printf("%-15s %-10s %-25s %-20s%n",
                    "Student", "Class ID", "Activity", "Rejection Reason"); 
            
             while(rs.next()) {
                 String firstName = rs.getString("first_name");
                 String lastName = rs.getString("last_name");
                 String classId = rs.getString("class_id");
                 String activity = rs.getString("activity_name");
                 String rejectionReason = rs.getString("rejection_reason");
                 
                System.out.printf("%-15s %-10s %-25s %-20s%n",
                 firstName + " " + lastName, classId, activity, rejectionReason);
            }
        
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void viewStatusSQL(String activity, String status){
        String sql = "SELECT first_name, last_name, class_id, rejection_reason "
                   + "FROM CLEARANCE_FULL_VIEW "
                   + "WHERE status = ? AND activity_name = ?";
        
        try(
             Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);   
            ) {
            
            ps.setString(1, status);
            ps.setString(2, activity);
            ResultSet rs = ps.executeQuery(); 
            System.out.printf("%-15s %-10s %-20s%n",
                    "Student", "Class ID", "Rejection Reason"); 
            
             while(rs.next()) {
                 String firstName = rs.getString("first_name");
                 String lastName = rs.getString("last_name");
                 String classId = rs.getString("class_id");
                 String rejectionReason = rs.getString("rejection_reason");
                 
                System.out.printf("%-15s %-10s %-20s%n",
                 firstName + " " + lastName, classId, rejectionReason);
            }
        
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
