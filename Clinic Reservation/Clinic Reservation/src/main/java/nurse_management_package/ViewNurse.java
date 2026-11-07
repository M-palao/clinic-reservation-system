package nurse_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewNurse {

    public static void view() {

        String sql = "SELECT * FROM NURSE";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {

            System.out.println("-----------------------------------------------------------------------------------------------");

            System.out.printf("%-5s %-20s %-20s %-25s %-25s%n",
                    "ID", "First Name", "Last Name", "Email", "Contact Number");

            System.out.println("-----------------------------------------------------------------------------------------------");

            while (rs.next()) {

                String id = rs.getString("nurse_id");
                String first_Name = rs.getString("first_Name");
                String last_Name = rs.getString("last_Name");
                String email = rs.getString("email");
                String contactNumber = rs.getString("contact_number");

                System.out.printf("%-5s %-20s %-20s %-25s %-25s%n",
                        id, first_Name, last_Name, email, contactNumber);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}