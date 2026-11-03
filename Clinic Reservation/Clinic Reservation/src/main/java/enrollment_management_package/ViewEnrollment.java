/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public abstract class ViewEnrollment {    
    public static void view(){
        String sql = "SELECT  enrollment_id, first_name, last_name, class_id " + 
                     "FROM ENROLLMENT E " +
                     "JOIN STUDENT S ON S.student_id = E.student_id "
                     + "ORDER BY class_id";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-10s %-20s %-20s%n",
                    "ID", "Student", "Class ID");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String id = rs.getString("enrollment_id");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                String subjectId = rs.getString("class_id");


                System.out.printf( "%-10s %-20s %-20s%n",
                id, firstName + " " + lastName, subjectId);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        } 
    }
}
