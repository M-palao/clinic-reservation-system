package student_management_package;

import clinicreservation_main.DBConnection;
import java.sql.*;
import clinicreservation_main.scanner;

public class InsertStudent {

    public static void insert() {
        
        String firstName;
        String lastName;
        String email;
        String contactNum = "";
        String age = "";
        String program;
        String yearLevel = "";

        do {
            System.out.print("Enter New First Name: ");
            firstName = scanner.nextLine();
        } while (firstName.isEmpty() || firstName.isBlank() || firstName.length() < 1);

        do {
            System.out.print("Enter New Last Name: ");
            lastName = scanner.nextLine();
        } while (lastName.isEmpty() || lastName.isBlank() || lastName.length() < 1);

        do {
            System.out.print("Enter New Email: ");
            email = scanner.nextLine();
        } while (email.isEmpty() || email.isBlank() || email.length() < 1 || !email.contains("@"));

        do {
            System.out.print("Enter New Contact Number: ");
            contactNum = scanner.nextLine();
        } while (contactNum.isEmpty() || contactNum.isBlank() || !contactNum.matches("\\d+"));

        do {
            System.out.print("Enter New Age: ");
            age = scanner.nextLine();
        } while (age.isEmpty() || age.isBlank() || !age.matches("\\d+"));

        do {
            System.out.print("Enter New Program: ");
            program = scanner.nextLine();
        } while (program.isEmpty() || program.isBlank());

        do {
            System.out.print("Enter New Year Level: ");
            yearLevel = scanner.nextLine();
        } while (yearLevel.isEmpty() || yearLevel.isBlank() || !yearLevel.matches("\\d+"));

        insertSQL(firstName, lastName, email, contactNum, age, program, yearLevel);
    }

    private static void insertSQL(String firstName, String lastName, String email,
            String contactNum, String age, String program, String yearLevel) {

        String sql = "INSERT INTO STUDENT "
                + "(first_Name, last_Name, email, contact_number, age, program, year_level) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, contactNum);
            ps.setString(5, age);
            ps.setString(6, program);
            ps.setString(7, yearLevel);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}