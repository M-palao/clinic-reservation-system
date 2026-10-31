/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bareminimum.facilitator_management_package;

import com.mycompany.bareminimum.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class DeleteFacilitator {
    public static void delete(){
        Scanner inputScanner = new Scanner(System.in);
        String faciId = "";
        
        
        do{
            try{
                System.out.print("Enter Facilitator ID to delete: ");
                faciId = inputScanner.next();
                Integer.valueOf(faciId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ faciId + "] " + "Contains non Integer values");
                faciId = "";
            }
            
        } while(faciId.isEmpty() || faciId.isBlank());
        
        String sql = "DELETE FROM FACILITATOR "
                     + "WHERE facilitator_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
            )
        {
            ps.setString(1, faciId);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Facilitator deleted sucessfully.");
            } else {
                System.out.println("Facilitator not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        inputScanner.close();
    }
}
