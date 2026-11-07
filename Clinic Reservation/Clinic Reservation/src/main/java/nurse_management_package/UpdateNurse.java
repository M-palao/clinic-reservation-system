/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nurse_management_package;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
/**
 *
 * @author Samuel Trinidad
 */
public class UpdateNurse {
    public static void update() {
        Scanner scanner = new Scanner(System.in);
        String nurse_Id = "";
        String first_Name;
        String last_Name;
        String email;
        String contactNum = "";
        
        do {
            try{
                System.out.print("Enter Nurse ID: ");
                nurse_Id = scanner.next();
                Integer.valueOf(nurse_Id);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Nurse ID.");
                nurse_Id = "";
            }
        } while(nurse_Id.isEmpty() || nurse_Id.isBlank());
        
        do{
            System.out.print("Enter New First Name: ");
            first_Name = scanner.next();
        } while(first_Name.isEmpty() || first_Name.isBlank() || first_Name.length() < 1);
        
        do{
            System.out.print("Enter New Last Name: ");
            last_Name = scanner.next();
        } while(last_Name.isEmpty() || last_Name.isBlank() || last_Name.length() < 1);
        
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
        
        updateSQL(nurse_Id, first_Name, last_Name, email, contactNum);
        
    }
    
   private static void updateSQL(String id, String first_Name, String last_Name, String email, String contactNum){
        String sql = "UPDATE NURSE "
                     + "SET first_name = ?, last_name = ?, email = ?, contact_number = ? "
                     + "WHERE nurse_id = ?";  
        
        
          try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(5, id);
             ps.setString(1, first_Name);
             ps.setString(2, last_Name);
             ps.setString(3, email);
             ps.setString(4, contactNum);

             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Nurse Updated Successfully");
             } else {
                 System.out.println("Nurse not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
