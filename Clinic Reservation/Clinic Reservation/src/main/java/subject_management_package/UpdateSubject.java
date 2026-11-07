package subject_management_package;

import class_management_package.*;
import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public abstract class UpdateSubject {
     public static void update(){
        Scanner inputScanner = new Scanner(System.in);
        String subjectId;
        String subjectDesc;
        
        do{
            System.out.print("Enter Subject ID: ");
            subjectId = inputScanner.nextLine();   
        } while(subjectId.isEmpty() || subjectId.isBlank());
        
        do{
            System.out.print("Enter New Subject Description: ");
            subjectDesc = inputScanner.nextLine();   
        } while(CheckTable.checkSubject(subjectDesc) == false || subjectDesc.isEmpty() || subjectDesc.isBlank());
        
        inputScanner.close();
        updateSQL(subjectId, subjectDesc);
    }
    
    private static void updateSQL(String subjectId, String subjectDesc){
        String sql = "UPDATE SUBJECT "
                     + "SET subject_description = ? "
                     + "WHERE subject_id = ?";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, subjectDesc);
             ps.setString(2, subjectId);
             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Subject Updated Successfully");
             } else {
                 System.out.println("Subject not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
