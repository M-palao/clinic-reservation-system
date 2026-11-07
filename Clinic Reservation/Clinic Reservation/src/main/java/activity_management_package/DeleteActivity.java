/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activity_management_package;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author Samuel Trinidad
 */
public class DeleteActivity {

    public static void delete() {
        Scanner scanner = new Scanner(System.in);

        String activityId = "";

        do {
            try {
                System.out.print("Enter Activity ID: ");
                activityId = scanner.nextLine();
                Integer.valueOf(activityId);

            } catch (NumberFormatException e) {
                System.out.println("ERROR: Invalid Activity ID!");
                activityId = "";
            }

        } while (activityId.isEmpty() || activityId.isBlank());

        deleteSQL(activityId);
    }

    private static void deleteSQL(String activityId) {

        String sql = "DELETE FROM ACTIVITY WHERE activity_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, activityId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Activity deleted successfully!");
            } else {
                System.out.println("Activity ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
