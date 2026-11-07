package class_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ViewClass{
    public static void view() {
        String sql = "SELECT  class_id, first_name, last_name, subject_id " + 
                     "FROM CLASS C " +
                     "JOIN FACILITATOR F ON F.facilitator_id = C.facilitator_id";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-10s %-20s %-20s%n",
                    "ID", "Facilitator", "Subject ID");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String id = rs.getString("class_id");
                String firstName = rs.getString("first_Name");
                String lastName = rs.getString("last_Name");
                String subjectId = rs.getString("subject_id");


                System.out.printf( "%-10s %-20s %-20s%n",
                id, firstName + " " + lastName, subjectId);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
        
    }
}
