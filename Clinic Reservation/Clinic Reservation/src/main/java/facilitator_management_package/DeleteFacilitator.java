package facilitator_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

public class DeleteFacilitator {
    public static void delete(){
        
        String faciId = "";
        
        
        do{
            try{
                System.out.print("Enter Facilitator ID to delete: ");
                faciId = scanner.next();
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
        

    }
}
