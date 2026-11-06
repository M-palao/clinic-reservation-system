package nurse_management_package;

import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertNurse {

    public static void insert() {

        Scanner inputScanner = new Scanner(System.in);

        String firstName;
        String lastName;
        String email;
        String contactNum = "";

        do {
            System.out.print("Enter New First Name: ");
            firstName = inputScanner.next();

        } while (firstName.isEmpty() || firstName.isBlank());

        do {
            System.out.print("Enter New Last Name: ");
            lastName = inputScanner.next();

        } while (lastName.isEmpty() || lastName.isBlank());

        do {
            System.out.print("Enter New Email: ");
            email = inputScanner.next();

        } while (email.isEmpty() || email.isBlank() || !email.contains("@"));

        do {
            try {
                System.out.print("Enter New Contact Number: ");
                contactNum = inputScanner.next();

                Integer.valueOf(contactNum);

            } catch (NumberFormatException e) {

                System.out.println("ERROR INVALID INPUT: [" 
                        + contactNum + "] Contains non-integer values");

                contactNum = "";
            }

        } while (contactNum.isEmpty() || contactNum.isBlank());

        insertSQL(firstName, lastName, email, contactNum);
    }

    private static void insertSQL(String firstName, String lastName,
            String email, String contactNum) {

        String sql = "INSERT INTO NURSE "
                + "(first_name, last_name, email, contact_number) "
                + "VALUES (?, ?, ?, ?)";

        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, contactNum);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Nurse inserted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}