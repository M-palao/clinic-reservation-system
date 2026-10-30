/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bareminimum;
import java.sql.*;

/**
 *
 * @author Samuel Trinidad
 */
public class ViewStudent {
    public static void main (String[] args) {
        
        String sql = "SELECT * FROM STUDENT"; 
        
    try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            System.out.println("-----------------------------------------------");
            System.out.printf("%-5s %-20s %-20s %-25s %-25s %-5s %-25s %-10s%n",
                    "ID", "First Name", "Last Name", "Email", "Contact Number", "Age", "Program", "Year Level");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {     
                
                String id = rs.getString("student_id");
                String first_Name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String age = rs.getString("age");
                String program = rs.getString("program");
                String year_level = rs.getString("year_level");

                System.out.printf( "%-5s %-20s %-20s %-25s %-25s %-5s %-25s %-10s%n",
                   id, first_Name, last_Name, email, contact_number, age, program, year_level);
                
    
}
}  
    catch (Exception e) {

            e.printStackTrace();
    }

}
}