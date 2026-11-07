package class_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

public abstract class DeleteClass {
    public static void delete()
    {
        String classId;
        
        do{
            System.out.print("Enter Class ID to Delete: ");
            classId = scanner.nextLine();
            
            if (!CheckTable.checkClass(classId)){
                System.out.println("Class " + classId + " not found.");
            }
            
        } while(!CheckTable.checkClass(classId) || classId.isEmpty() || classId.isBlank());
        
        String sql = "DELETE FROM CLASS "
                     + "WHERE class_id = ?";
        
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
            )
        {
            ps.setString(1, classId);
    
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                System.out.println("Class " + classId + " deleted sucessfully.");
            } else {
                System.out.println("Class " + classId + " not found.");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
