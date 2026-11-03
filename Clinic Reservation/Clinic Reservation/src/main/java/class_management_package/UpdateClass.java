/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package class_management_package;

import com.mycompany.clinicreservation.CheckTable;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public abstract class UpdateClass {
     public static void update(){
        Scanner inputScanner = new Scanner(System.in);
        String classId;
        String faciId = "";
        String subjectId;
        
        do{
            System.out.print("Enter Class ID: ");
            classId = inputScanner.nextLine();   
        } while(classId.isEmpty() || classId.isBlank());
        
        do{
            try{
                System.out.print("Enter New Facilitator ID: ");
                faciId = inputScanner.next();
                Integer.valueOf(faciId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ faciId + "] " + "Contains non Integer values");
                faciId = "";
            }
            
        } while(CheckTable.checkFacilitator(faciId) == false || faciId.isEmpty() || faciId.isBlank());
        inputScanner.nextLine();
        do{
            System.out.print("Enter New Subject ID: ");
            subjectId = inputScanner.nextLine();   
        } while(CheckTable.checkSubject(subjectId) == false || subjectId.isEmpty() || subjectId.isBlank());
        inputScanner.close();
        updateSQL(classId, faciId, subjectId);
    }
    
    private static void updateSQL(String classId, String faciId, String subjectId){
        String sql = "UPDATE CLASS "
                     + "SET facilitator_id = ?, subject_id = ? "
                     + "WHERE class_id = ?";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(3, classId);
             ps.setString(1, faciId);
             ps.setString(2, subjectId);
             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Class Updated Successfully");
             } else {
                 System.out.println("Class not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
