/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class_management_package;

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
public abstract class DeleteClass {
    public static void delete()
    {
        Scanner inputScanner = new Scanner(System.in);
        String classId;
        
        do{
            System.out.print("Enter Class ID to Delete: ");
            classId = inputScanner.nextLine();
            
            if (!CheckTable.checkClass(classId)){
                System.out.println("Class " + classId + " not found.");
            }
            
        } while(!CheckTable.checkClass(classId) || classId.isEmpty() || classId.isBlank());
        
        String sql = "DELETE FROM CLASS "
                     + "WHERE class_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
            )
        {
            ps.setString(1, classId);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Class " + classId + " deleted sucessfully.");
            } else {
                System.out.println("Class " + classId + " not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        inputScanner.close();
    }
}
