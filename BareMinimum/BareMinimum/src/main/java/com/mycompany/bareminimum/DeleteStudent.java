/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bareminimum;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Samuel Trinidad
 */
public class DeleteStudent {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Student ID to delete: ");
        int student_id = scanner.nextInt();
        
        
        
        String sql = 
                "DELETE FROM STUDENT "
                + "WHERE student_id = ?";
                
    
    
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, student_id);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Student deleted sucessfully.");
            } else {
                System.out.println("Student not found.");
            }
    
} catch (Exception e) {
    e.printStackTrace();
}
}
    
}
