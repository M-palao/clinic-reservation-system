package clearance_management_package;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;

public abstract class DeleteClearance {
    public static void delete() {    
        String clearanceId = "";
        
        do {
            try {
                System.out.print("Enter Clearance ID: ");
                clearanceId = scanner.nextLine();
                Integer.valueOf(clearanceId);
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Clearance ID!");
                clearanceId = "";
            }
        } while (clearanceId.isEmpty() || clearanceId.isBlank());
        
        deleteSQL(clearanceId);
        
    }
    
    private static void deleteSQL(String clearanceId) {
        String sql = "DELETE FROM CLEARANCE WHERE clearance_id = ?";
        
        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ) {
            ps.setString(1, clearanceId);
            
            int rows = ps.executeUpdate();
            
            if(rows > 0) {
                System.out.println("Clearance deleted successfully!");
            } else {
                System.out.println("Clearance ID not found!");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    }
    
    
    
    
    
    
    
    
}
