/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

/**
 *
 * @author USER
 */
public abstract class DeleteEnrollment {
    public static void delete(){
        
        String enrollmentId;
        
        do{
            System.out.print("Enter Enrollment ID to Delete: ");
            enrollmentId = scanner.nextLine();
            
            if (!CheckTable.checkEnrollment(enrollmentId)){
                System.out.println("Enrollment " + enrollmentId + " not found.");
            }
            
        } while(!CheckTable.checkEnrollment(enrollmentId) || enrollmentId.isEmpty() || enrollmentId.isBlank());
        
        String sql = "DELETE FROM ENROLLMENT "
                     + "WHERE enrollment_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
            )
        {
            ps.setString(1, enrollmentId);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Enrollment " + enrollmentId + " deleted sucessfully.");
            } else {
                System.out.println("Enrollment " + enrollmentId + " not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
