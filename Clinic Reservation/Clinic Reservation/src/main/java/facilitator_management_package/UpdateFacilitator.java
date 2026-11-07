/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facilitator_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clinicreservation_main.scanner;

/**
 *
 * @author USER
 */
public class UpdateFacilitator {
    public static void update(){
        
        String faciId = "";
        String firstName;
        String lastName;
        String email;
        String contactNum = "";
        String department;
        
        do{
            try{
                System.out.print("Enter Facilitator ID: ");
                faciId = scanner.next();
                Integer.valueOf(faciId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ faciId + "] " + "Contains non Integer values");
                faciId = "";
            }
            
        } while(faciId.isEmpty() || faciId.isBlank());
        
        do{
            System.out.print("Enter New First Name: ");
            firstName = scanner.next();
        } while(firstName.isEmpty() || firstName.isBlank() || firstName.length() < 1);
        
        do{
            System.out.print("Enter New Last Name: ");
            lastName = scanner.next();
        } while(lastName.isEmpty() || lastName.isBlank() || lastName.length() < 1);
        
        do{
            System.out.print("Enter New Email: ");
            email = scanner.next();
        } while(email.isEmpty() || email.isBlank() || email.length() < 1 || !email.contains("@"));
        
        do{
            try{
                System.out.print("Enter New Contact Number: ");
                contactNum = scanner.next();
                Integer.valueOf(contactNum);
            } catch(NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ contactNum + "] " + "Contains non Integer values");
                contactNum = "";
            }
            
            
        } while(contactNum.isEmpty() || contactNum.isBlank());
        
        do{
            System.out.print("Enter New Department: ");
            department = scanner.next();
        } while(department.isEmpty() || department.isBlank());
        

        
        updateSQL(faciId, firstName, lastName, email, contactNum, department);
    }
    
    private static void updateSQL(String id, String firstName, String lastName, String email, String contactNum, String department){
        String sql = "UPDATE FACILITATOR "
                     + "SET first_name = ?, last_name = ?, email = ?, contact_number = ?, department = ? "
                     + "WHERE facilitator_id = ?";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(6, id);
             ps.setString(1, firstName);
             ps.setString(2, lastName);
             ps.setString(3, email);
             ps.setString(4, contactNum);
             ps.setString(5, department);
             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Facilitator Updated Successfully");
             } else {
                 System.out.println("Facilitator not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
