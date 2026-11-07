package class_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clinicreservation_main.scanner;

public abstract class InsertClass {
    public static void insert(){
        String classId;
        String faciId = "";
        String subjectId;
        
        do{
            System.out.print("Enter Class ID: ");
            classId = scanner.nextLine();
            
            if (CheckTable.checkClass(classId)){
                System.out.println("Class ID already Exists!");
            }
            
        } while(CheckTable.checkClass(classId) || classId.isEmpty() || classId.isBlank());
        
        do{
            try{
                System.out.print("Enter Facilitator ID: ");
                faciId = scanner.next();
                Integer.valueOf(faciId);
                
                if (!CheckTable.checkFacilitator(faciId)){
                System.out.println("No such ID found in Subject");
                }    
                
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ faciId + "] " + "Contains non Integer values");
                faciId = "";
            }
            
        } while(!CheckTable.checkFacilitator(faciId) || faciId.isEmpty() || faciId.isBlank());
        scanner.nextLine();
        
        do{
            System.out.print("Enter Subject ID: ");
            subjectId = scanner.nextLine();
            if (!CheckTable.checkSubject(subjectId)){
                System.out.println("No such ID found in Subject");
            } 
            
        } while(!CheckTable.checkSubject(subjectId) || subjectId.isEmpty() || subjectId.isBlank());
        insertSql(classId, faciId, subjectId);
    }
    
    private static void insertSql(String id, String faciId, String subjectId){
        String sql = "INSERT INTO CLASS " 
                     + "(class_id, facilitator_id, subject_id) " 
                     + "VALUES (?, ?, ?)";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, id);
             ps.setString(2, faciId);
             ps.setString(3, subjectId);
             
            int rows = ps.executeUpdate();
                
            if (rows > 0) {
                    System.out.println("Class inserted successfully!");
            }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
