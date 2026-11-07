package student_management_package;

import clinicreservation_main.DBConnection;
import java.sql.*;
import clinicreservation_main.scanner;

public class DeleteStudent {
    public static void delete() {
        
        String studentId = "";

        do {
            try {
                System.out.print("Enter Student ID to delete: ");
                studentId = scanner.next();
                Integer.valueOf(studentId);
            } catch (NumberFormatException e) {
                System.out.println("ERROR INVALID INPUT : " + "[" + studentId + "] " + "Contains non Integer values");
                studentId = "";
            }

        } while (studentId.isEmpty() || studentId.isBlank());

        String sql = "DELETE FROM STUDENT "
                + "WHERE student_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, studentId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
