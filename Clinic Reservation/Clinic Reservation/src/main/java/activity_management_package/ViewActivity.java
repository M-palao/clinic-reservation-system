package activity_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class ViewActivity {
     public static void view() {
        String sql = "SELECT * FROM ACTIVITY";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            System.out.printf("%-15s %-25s %-30s %-15s %-15s %-15s %-15s%n",
                    "Activity ID", "Activity Name", "Activity Location",
                    "Start Date", "Start Time", "End Date", "End Time");

            while (rs.next()) {

                int activityId = rs.getInt("activity_id");
                String activityName = rs.getString("activity_name");
                String activityLocation = rs.getString("activity_location");
                String startDate = rs.getString("start_date");
                String startTime = rs.getString("start_time");
                String endDate = rs.getString("end_date");
                String endTime = rs.getString("end_time");

                System.out.printf("%-15d %-25s %-30s %-15s %-15s %-15s %-15s%n",
                        activityId, activityName, activityLocation,
                        startDate, startTime, endDate, endTime);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

