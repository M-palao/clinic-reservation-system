package facilitator_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import clinicreservation_main.scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ViewFacilitator {
    public static void view(){
        String sql = "SELECT * FROM FACILITATOR";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            
            
            System.out.println("-----------------------------------------------");
            System.out.printf("%-5s %-20s %-20s %-25s %-25s %-5s",
                    "ID", "First Name", "Last Name", "Email", "Contact Number", "Department");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                String id = rs.getString("facilitator_id");
                String first_Name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");
                String email = rs.getString("email");
                String contact_number = rs.getString("contact_number");
                String department = rs.getString("department");

                System.out.printf( "%-5s %-20s %-20s %-25s %-25s %-5s%n",
                id, first_Name, last_Name, email, contact_number, department);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
    }
    
    public static void viewClassesHandled() {
        
        String facilitatorId = "";
        do{
            System.out.print("Input Facilitator ID: ");
            facilitatorId = scanner.nextLine();
            if (!CheckTable.checkFacilitator(facilitatorId)){
                System.out.println("Facilitator ID doesn't exist in Facilitator!");
            }
        
        }while(!CheckTable.checkFacilitator(facilitatorId));
        
        executeClassesHandledSQL(facilitatorId);
    }
    
    private static void executeClassesHandledSQL(String facilitatorId){
        String sql = "SELECT C.class_id, C.subject_id, S.subject_description " +
                     "FROM CLASS C " +
                     "JOIN SUBJECT S ON C.subject_id = S.subject_id " +
                     "WHERE C.facilitator_id = ?";
        
        try ( Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ){
            
            ps.setString(1, facilitatorId);
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-12s %s%n",
                    "Class ID", "Subject ID", "Subject Descsription");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String classID = rs.getString("class_id");
                String subjectID = rs.getString("subject_id");
                String subjectDesc = rs.getString("subject_description");

                System.out.printf("%-10s %-12s %s%n",
                        classID, subjectID, subjectDesc);
            }
        
        } catch(SQLException e){
            e.printStackTrace();
        
        }
    }
}
