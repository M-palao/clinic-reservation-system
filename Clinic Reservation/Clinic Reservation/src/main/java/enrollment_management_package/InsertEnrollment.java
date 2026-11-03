/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import com.mycompany.clinicreservation.CheckTable;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public abstract class InsertEnrollment {
    public static void insert(){
        Scanner inputScanner = new Scanner(System.in);
        String studentId = "";
        String classId;
        
        do{
            try{
                System.out.print("Enter New Student ID: ");
                studentId = inputScanner.next();
                Integer.valueOf(studentId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ studentId + "] " + "Contains non Integer values");
                studentId = "";
            }
            
            if (CheckTable.checkStudent(studentId) == false){
                 System.out.println("Student ID " + studentId + " not found in Student!");
            }
            
        } while(CheckTable.checkStudent(studentId) == false || studentId.isEmpty() || studentId.isBlank());
        inputScanner.nextLine();
        
        do{
            System.out.print("Enter New Class ID: ");
            classId = inputScanner.nextLine();   
            
            if (CheckTable.checkClass(classId) == false){
                 System.out.println("Class ID " + classId + " not found in Class!");
            }
            
        } while(CheckTable.checkClass(classId) == false || classId.isEmpty() || classId.isBlank());
        inputScanner.close();
        
        insertSql(studentId, classId);
    }
    
     private static void insertSql(String studentId, String classId){
        String sql = "INSERT INTO ENROLLMENT " 
                     + "(student_id, class_id) " 
                     + "VALUES (?, ?)";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, studentId);
             ps.setString(2, classId);
             
            int rows = ps.executeUpdate();
                
            if (rows > 0) {
                    System.out.println("Class inserted successfully!");
            }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
