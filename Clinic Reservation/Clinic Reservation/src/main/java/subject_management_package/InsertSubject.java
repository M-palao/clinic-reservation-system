package subject_management_package;

import class_management_package.*;
import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public abstract class InsertSubject {
    public static void insert(){
        Scanner inputScanner = new Scanner(System.in);
        String subjectId;
        String subjectDesc;
        
        do{
            System.out.print("Enter Subject ID: ");
            subjectId = inputScanner.nextLine();
            
            if (CheckTable.checkClass(subjectId)){
                System.out.println("Subject ID already Exists!");
            }
            
        } while(CheckTable.checkClass(subjectId) || subjectId.isEmpty() || subjectId.isBlank());
        
        do{
            System.out.print("Enter Subject Description: ");
            subjectDesc = inputScanner.nextLine();
            
            if (CheckTable.checkClass(subjectDesc)){
                System.out.println("Subject description already Exists!");
            }
            
        } while(CheckTable.checkClass(subjectDesc) || subjectDesc.isEmpty() || subjectDesc.isBlank());
        
        inputScanner.close();
        insertSql(subjectId, subjectDesc);
    }
    
    private static void insertSql(String subjectId, String subjectDesc){
        String sql = "INSERT INTO SUBJECT " 
                     + "(subjectId, subjectDesc) " 
                     + "VALUES (?, ?)";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, subjectId);
             ps.setString(2, subjectDesc);
             
            int rows = ps.executeUpdate();
                
            if (rows > 0) {
                    System.out.println("Subject inserted successfully!");
            }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
