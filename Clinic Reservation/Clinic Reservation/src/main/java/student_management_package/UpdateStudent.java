/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package student_management_package;
import clinicreservation_main.DBConnection;
import java.sql.*;
import clinicreservation_main.scanner;



/**
 *
 * @author Samuel Trinidad
 */
public class UpdateStudent {
    public static void update() {
        
        String studentId = "";
        String firstName;
        String lastName;
        String email;
        String contactNum = "";
        String age = "";
        String program;
        String yearLevel = "";

        do {
            try {
                System.out.print("Enter Student ID: ");
                studentId = scanner.next();
                Integer.valueOf(studentId);
            } catch (NumberFormatException e) {
                System.out.println("ERROR INVALID INPUT : " + "[" + studentId + "] " + "Contains non Integer values");
                studentId = "";
            }

        } while (studentId.isEmpty() || studentId.isBlank());

        do {
            System.out.print("Enter New First Name: ");
            firstName = scanner.next();
        } while (firstName.isEmpty() || firstName.isBlank() || firstName.length() < 1);

        do {
            System.out.print("Enter New Last Name: ");
            lastName = scanner.next();
        } while (lastName.isEmpty() || lastName.isBlank() || lastName.length() < 1);

        do {
            System.out.print("Enter New Email: ");
            email = scanner.next();
        } while (email.isEmpty() || email.isBlank() || email.length() < 1 || !email.contains("@"));

        do {
            try {
                System.out.print("Enter New Contact Number: ");
                contactNum = scanner.next();
                Integer.valueOf(contactNum);
            } catch (NumberFormatException e) {
                System.out.println("ERROR INVALID INPUT : " + "[" + contactNum + "] " + "Contains non Integer values");
                contactNum = "";
            }

        } while (contactNum.isEmpty() || contactNum.isBlank());

        do {
            try {
                System.out.print("Enter New Age: ");
                age = scanner.next();
                Integer.valueOf(age);
            } catch (NumberFormatException e) {
                System.out.println("ERROR INVALID INPUT : " + "[" + age + "] " + "Contains non Integer values");
                age = "";
            }

        } while (age.isEmpty() || age.isBlank());

        do {
            System.out.print("Enter New Program: ");
            program = scanner.next();
        } while (program.isEmpty() || program.isBlank());

        do {
            System.out.print("Enter New Year Level: ");
            yearLevel = scanner.next();
        } while (yearLevel.isEmpty() || yearLevel.isBlank());

        updateSQL(studentId, firstName, lastName, email, contactNum, age, program, yearLevel);
    }

    private static void updateSQL(String id, String firstName, String lastName,
            String email, String contactNum, String age, String program, String yearLevel) {

        String sql = "UPDATE STUDENT "
                + "SET first_name = ?, last_name = ?, email = ?, contact_number = ?, "
                + "age = ?, program = ?, year_level = ? "
                + "WHERE student_id = ?";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(8, id);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, contactNum);
            ps.setString(5, age);
            ps.setString(6, program);
            ps.setString(7, yearLevel);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

