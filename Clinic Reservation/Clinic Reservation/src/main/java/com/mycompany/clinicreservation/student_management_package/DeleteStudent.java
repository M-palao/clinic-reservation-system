/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clinicreservation.student_management_package;
import com.mycompany.clinicreservation.DBConnection;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Samuel Trinidad
 */
public class DeleteStudent {
    public static void delete() {
        Scanner inputScanner = new Scanner(System.in);
        String studentId = "";

        do {
            try {
                System.out.print("Enter Student ID to delete: ");
                studentId = inputScanner.next();
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
