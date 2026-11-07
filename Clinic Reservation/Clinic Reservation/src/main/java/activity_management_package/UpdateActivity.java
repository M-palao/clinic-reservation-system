/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package activity_management_package;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import clinicreservation_main.scanner;
/**
 *
 * @author Samuel Trinidad
 */
public class UpdateActivity {

    public static void update() {
        

        String activityId;
        String activityName;
        String activityLocation;
        String startDate;
        String startTime;
        String endDate;
        String endTime;

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

        do {
            System.out.print("Enter Activity Name: ");
            activityName = scanner.nextLine();
        } while (activityName.isEmpty() || activityName.isBlank());

        do {
            System.out.print("Enter Activity Location: ");
            activityLocation = scanner.nextLine();
        } while (activityLocation.isEmpty() || activityLocation.isBlank());

        do {
            System.out.print("Enter Start Date (YYYY-MM-DD): ");
            startDate = scanner.nextLine();
        } while (!startDate.matches("\\d{4}-\\d{2}-\\d{2}"));

        do {
            System.out.print("Enter Start Time (HH:MM:SS): ");
            startTime = scanner.nextLine();
        } while (!startTime.matches("\\d{2}:\\d{2}:\\d{2}"));

        do {
            System.out.print("Enter End Date (YYYY-MM-DD): ");
            endDate = scanner.nextLine();
        } while (!endDate.matches("\\d{4}-\\d{2}-\\d{2}"));

        do {
            System.out.print("Enter End Time (HH:MM:SS): ");
            endTime = scanner.nextLine();
        } while (!endTime.matches("\\d{2}:\\d{2}:\\d{2}"));

        updateSQL(activityId, activityName, activityLocation,
                startDate, startTime, endDate, endTime);
    }

    private static void updateSQL(String activityId,
            String activityName, String activityLocation,
            String startDate, String startTime,
            String endDate, String endTime) {

        String sql = "UPDATE ACTIVITY "
                + "SET activity_name = ?, activity_location = ?, "
                + "start_date = ?, start_time = ?, "
                + "end_date = ?, end_time = ? "
                + "WHERE activity_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, activityName);
            ps.setString(2, activityLocation);
            ps.setString(3, startDate);
            ps.setString(4, startTime);
            ps.setString(5, endDate);
            ps.setString(6, endTime);
            ps.setString(7, activityId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Activity updated successfully!");
            } else {
                System.out.println("Activity ID not found!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}