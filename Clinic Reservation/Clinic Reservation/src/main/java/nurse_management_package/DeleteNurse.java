package nurse_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

public class DeleteNurse {
    public static void delete() {
        
        String nurse_Id = "";
        
        
        do{
            try {
                System.out.print("Enter Nurse ID to delete: ");
                nurse_Id = scanner.next();
                Integer.valueOf(nurse_Id);
            } catch(NumberFormatException e) {
                System.out.println("ERROR: Invalid Nurse ID.");
                nurse_Id = "";
            }
        } while(nurse_Id.isEmpty() || nurse_Id.isBlank());
        
        String sql = "DELETE FROM NURSE "
                + "WHERE nurse_id = ?";
        
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql))
        {
         ps.setString(1, nurse_Id);
         
         int rows = ps.executeUpdate();
         
         if(rows > 0) {
             System.out.println("Nurse deleted sucessfully.");
         } else {
             System.out.println("Nurse not found.");
         }
        
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
