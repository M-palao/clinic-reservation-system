/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bareminimum.facilitator_management_package;

import com.mycompany.bareminimum.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class InsertFacilitator {
    public static void insert(){
        Scanner inputScanner = new Scanner(System.in);
        String firstName;
        String lastName;
        String email;
        String contactNum = "";
        String department;
        
        do{
            System.out.print("Enter New First Name: ");
            firstName = inputScanner.next();
        } while(firstName.isEmpty() || firstName.isBlank() || firstName.length() < 1);
        
        do{
            System.out.print("Enter New Last Name: ");
            lastName = inputScanner.next();
        } while(lastName.isEmpty() || lastName.isBlank() || lastName.length() < 1);
        
        do{
            System.out.print("Enter New Email: ");
            email = inputScanner.next();
        } while(email.isEmpty() || email.isBlank() || email.length() < 1 || !email.contains("@"));
        
        do{
            try{
                System.out.print("Enter New Contact Number: ");
                contactNum = inputScanner.next();
                Integer.valueOf(contactNum);
            } catch(NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ contactNum + "] " + "Contains non Integer values");
                contactNum = "";
            }
            
            
        } while(contactNum.isEmpty() || contactNum.isBlank());
        
        do{
            System.out.print("Enter New Department: ");
            department = inputScanner.next();
        } while(department.isEmpty() || department.isBlank());
        
        inputScanner.close();
        
        insertSQL(firstName, lastName, email, contactNum, department);
    }
    
    private static void insertSQL(String firstName, String lastName, String email, String contactNum, String department)
    {
        String sql = "INSERT INTO FACILITATOR " 
                     + "(first_Name, last_Name, email, contact_number, department) " 
                     + "VALUES (?, ?, ?, ?, ?)";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, firstName);
             ps.setString(2, lastName);
             ps.setString(3, email);
             ps.setString(4, contactNum);
             ps.setString(5, department);
             
            int rows = ps.executeUpdate();
                
            if (rows > 0) {
                    System.out.println("Facilitator inserted successfully!");
            }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
