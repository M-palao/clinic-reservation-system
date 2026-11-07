package subject_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ViewSubject{
    public static void view() {
        String sql = "SELECT * FROM SUBJECT ";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-10s %-50s%n",
                    "ID", "Subject Description");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String subjectID = rs.getString("subject_id");
                String subjectDesc = rs.getString("subject_description");


                System.out.printf("%-10s %-50s%n",
                subjectID, subjectDesc);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
        
    }
}
