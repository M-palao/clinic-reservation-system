/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public abstract class UpdateEnrollment {
    public static void update(){
        Scanner inputScanner = new Scanner(System.in);
        String enrollmentId = "";
        String studentId = "";
        String classId;
        
        do{
            
             try{
                System.out.print("Enter Enrollment ID: ");
                enrollmentId = inputScanner.nextLine();   
                Integer.valueOf(enrollmentId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ enrollmentId + "] " + "Contains non Integer values");
                enrollmentId = "";
            }
            
             if (CheckTable.checkEnrollment(enrollmentId) == false){
                 System.out.println("Enrollment ID " + enrollmentId + " not found in Enrollment!");
             }
            
        } while(CheckTable.checkEnrollment(enrollmentId) == false || enrollmentId.isEmpty() || enrollmentId.isBlank());
        
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
        
        updateSQL(enrollmentId, studentId, classId);
    }
    
    private static void updateSQL(String enrollmentId, String studentId, String classId){
        String sql = "UPDATE ENROLLMENT "
                     + "SET student_id = ?, class_id = ? "
                     + "WHERE enrollment_id = ?";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(3, enrollmentId);
             ps.setString(1, studentId);
             ps.setString(2, classId);
             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Enrollment Updated Successfully");
             } else {
                 System.out.println("Enrollment not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
