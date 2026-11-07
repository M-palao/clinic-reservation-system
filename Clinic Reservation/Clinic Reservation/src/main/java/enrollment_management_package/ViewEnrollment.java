/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enrollment_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import clinicreservation_main.scanner;

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
    
    public static void viewStudentCount(){
        String sql = "SELECT class_id, COUNT(*) as count " +
                    "FROM ENROLLMENT " +
                    "GROUP BY class_id";
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-10s %-10s%n",
                    "CLASS ID", "COUNT");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String class_id = rs.getString("class_id");
                String count = rs.getString("count");

                System.out.printf( "%-10s %-10s%n", class_id, count);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        } 
    }
    
    public static void viewStudentsFromClass(){
        
        String classId = "";
        do{
            System.out.print("Input Class ID: ");
            classId = scanner.nextLine();
            if (!CheckTable.checkClass(classId)){
                System.out.println("Class ID doesn't exist in Class!");
            }
        
        }while(!CheckTable.checkClass(classId));
        
        executeClassSQL(classId);
    }
    
    private static void executeClassSQL(String classId){
        String sql = "SELECT * " +
                     "FROM STUDENT " +
                     "WHERE student_id " +
                     "IN(SELECT student_id FROM ENROLLMENT WHERE class_id = ?)";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ){
            
            ps.setString(1, classId);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-5s %-20s %-20s %-25s %-25s %-5s %-25s %-10s%n",
                    "ID", "First Name", "Last Name", "Email", "Contact Number", "Age", "Program", "Year Level");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("student_id");
                String first_Name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String age = rs.getString("age");
                String program = rs.getString("program");
                String year_level = rs.getString("year_level");

                System.out.printf("%-5s %-20s %-20s %-25s %-25s %-5s %-25s %-10s%n",
                        id, first_Name, last_Name, email, contact_number, age, program, year_level);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
    
    }
}
