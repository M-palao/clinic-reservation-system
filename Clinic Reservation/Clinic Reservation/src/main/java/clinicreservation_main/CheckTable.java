package clinicreservation_main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class CheckTable {
    private static boolean check(String sql, String id){
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            )
        {
            ps.setString(1, id);
            ResultSet rows = ps.executeQuery();
            rows.next();
            int resultSize = rows.getRow();
            if (resultSize > 0) {
                 return true;
            } else {
                return false;
            }
            
        } catch (SQLException e){
            System.out.println("SQL ERROR: " + e);
            return false;
        }
    }
    
    public static boolean checkFacilitator(String faciId){
        String sql = "SELECT facilitator_id "
                + "FROM FACILITATOR "
                + "WHERE facilitator_id = ?";
        
        return check(sql, faciId);
    }
    
    public static boolean checkSubject(String subjectId){
        String sql = "SELECT subject_id "
                + "FROM SUBJECT "
                + "WHERE subject_id = ?";
        
        return check(sql, subjectId);
    }
    
    public static boolean checkClass(String classId){
        String sql = "SELECT class_id "
                + "FROM CLASS "
                + "WHERE class_id = ?";
        
        return check(sql, classId);
    }
    
    public static boolean checkStudent(String studentId){
        String sql = "SELECT student_id "
                + "FROM STUDENT "
                + "WHERE student_id = ?";
        
        return check(sql, studentId);
    }
    
    public static boolean checkEnrollment(String enrollmentId){
        String sql = "SELECT enrollment_id "
                + "FROM ENROLLMENT "
                + "WHERE enrollment_id = ?";
        
        return check(sql, enrollmentId);
    }
}
