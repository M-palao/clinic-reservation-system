package subject_management_package;

import class_management_package.*;
import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

public abstract class DeleteSubject {
    public static void delete()
    {
        
        String subjectId;
        
        do{
            System.out.print("Enter Subject ID to Delete: ");
            subjectId = scanner.nextLine();
            
            if (!CheckTable.checkClass(subjectId)){
                System.out.println("Subject " + subjectId + " not found.");
            }
            
        } while(!CheckTable.checkClass(subjectId) || subjectId.isEmpty() || subjectId.isBlank());
        
        String sql = "DELETE FROM SUBJECT "
                     + "WHERE class_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
            )
        {
            ps.setString(1, subjectId);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Subject " + subjectId + " deleted sucessfully.");
            } else {
                System.out.println("Subject " + subjectId + " not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
