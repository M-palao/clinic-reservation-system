/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bareminimum.facilitator_management_package;

import com.mycompany.bareminimum.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class ViewFacilitator {
    public static void view(){
        String sql = "SELECT * FROM FACILITATOR";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-5s %-20s %-20s %-25s %-25s %-5s",
                    "ID", "First Name", "Last Name", "Email", "Contact Number", "Department");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String id = rs.getString("facilitator_id");
                String first_Name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String department = rs.getString("department");

                System.out.printf( "%-5s %-20s %-20s %-25s %-25s %-5s%n",
                id, first_Name, last_Name, email, contact_number, department);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
        
    }
}
