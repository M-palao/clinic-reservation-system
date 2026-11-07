package subject_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clinicreservation_main.scanner;

/**
 *
 * @author USER
 */
public abstract class UpdateSubject {
     public static void update(){
        
        String subjectId;
        String subjectDesc;
        
        do{
            System.out.print("Enter Subject ID: ");
            subjectId = scanner.nextLine();   
        } while(subjectId.isEmpty() || subjectId.isBlank());
        
        do{
            System.out.print("Enter New Subject Description: ");
            subjectDesc = scanner.nextLine();   
        } while(CheckTable.checkSubject(subjectDesc) == false || subjectDesc.isEmpty() || subjectDesc.isBlank());
        
        updateSQL(subjectId, subjectDesc);
    }
    
    private static void updateSQL(String subjectId, String subjectDesc){
        String sql = "UPDATE SUBJECT "
                     + "SET subject_description = ? "
                     + "WHERE subject_id = ?";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, subjectDesc);
             ps.setString(2, subjectId);
             
            int rows = ps.executeUpdate();
             
             if (rows > 0) {
                 System.out.println("Subject Updated Successfully");
             } else {
                 System.out.println("Subject not found.");
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
