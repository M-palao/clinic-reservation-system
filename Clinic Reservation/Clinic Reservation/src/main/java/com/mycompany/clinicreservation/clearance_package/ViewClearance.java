/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicreservation.clearance_package;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Samuel Trinidad
 */
public class ViewClearance {
    public static void view() {
        String sql = "SELECT * FROM CLEARANCE";
        
        try(
             Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery(); 
                
            ) {
             System.out.printf("%-15s %-15s %-15s %-12s %-20s %-20s %-15s %-15s %-12s %-20s%n",
                    "Clearance ID", "Enrollment ID", "Activity ID", "Nurse ID",
                    "Physician First", "Physician Last", "Evaluated Date",
                    "Evaluated Time", "Status", "Rejection Reason");
             
             while(rs.next()) {
                 int clearanceId = rs.getInt("clearance_id");
                 int enrollmentId = rs.getInt("enrollment_id");
                 int activityId = rs.getInt("activity_id");
                 int nurseId = rs.getInt("nurse_id");
                 String physicianFirstName = rs.getString("physician_first_name");
                 String physicianLastName = rs.getString("physician_last_name");
                 String evaluatedDate = rs.getString("evaluated_date");
                 String evaluatedTime = rs.getString("evaluated_time");
                 String status = rs.getString("status");
                 String rejectionReason = rs.getString("rejection_reason");
                 
                System.out.printf("%-15d %-15d %-15d %-12d %-20s %-20s %-15s %-15s %-12s %-20s%n",
                 clearanceId, enrollmentId, activityId, nurseId,
                 physicianFirstName, physicianLastName,
                 evaluatedDate, evaluatedTime, status, rejectionReason);       
                 
        
        }
        
        
    } catch (SQLException e) {
        e.printStackTrace();
}
    }
}
