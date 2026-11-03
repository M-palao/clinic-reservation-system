/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import com.mycompany.clinicreservation.CheckTable;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public abstract class DeleteEnrollment {
    public static void delete(){
        Scanner inputScanner = new Scanner(System.in);
        String enrollmentId;
        
        do{
            System.out.print("Enter Enrollment ID to Delete: ");
            enrollmentId = inputScanner.nextLine();
            
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
        
        inputScanner.close();
    
    }
}
