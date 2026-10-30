package com.mycompany.clinicreservationsystem;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Samuel Trinidad
 */
public class InsertStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter First Name: ");
        String first_Name = scanner.nextLine();
        
        System.out.println("Enter Last Name: ");
        String last_Name = scanner.nextLine();
        
        System.out.println("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Enter Contact Number: ");
        String contact_number = scanner.nextLine();
        
        System.out.println("Enter age: ");
        String age = scanner.nextLine();
        
        System.out.println("Enter Program: ");
        String program = scanner.nextLine();
        
        System.out.println("Enter Year Level: ");
        String year_level = scanner.nextLine();
        
        String sql = 
                "INSERT INTO STUDENT " 
               + "(first_Name, last_Name, email, contact_number, age, program, year_level) " 
               + "VALUES (?, ?, ?, ?, ?, ?, ?)";
                
         try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

                ps.setString(1, first_Name);
                ps.setString(2, last_Name);
                ps.setString(3, email);
                ps.setString(4, contact_number);
                ps.setString(5, age);
                ps.setString(6, program);
                ps.setString(7, year_level);
            
                int rows = ps.executeUpdate();
                
                if (rows > 0) {
                    System.out.println("Student inserted nicely.");
                }

    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
}