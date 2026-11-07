package enrollment_management_package;

import clinicreservation_main.CheckTable;
import clinicreservation_main.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import clinicreservation_main.scanner;

public abstract class InsertEnrollment {
    public static void insert(){
        String studentId = "";
        String classId;
        
        do{
            try{
                System.out.print("Enter New Student ID: ");
                studentId = scanner.next();
                Integer.valueOf(studentId);
            } catch (NumberFormatException e){
                System.out.println("ERROR INVALID INPUT : " + "["+ studentId + "] " + "Contains non Integer values");
                studentId = "";
            }
            
            if (CheckTable.checkStudent(studentId) == false){
                 System.out.println("Student ID " + studentId + " not found in Student!");
            }
            
        } while(CheckTable.checkStudent(studentId) == false || studentId.isEmpty() || studentId.isBlank());
        scanner.nextLine();
        
        do{
            System.out.print("Enter New Class ID: ");
            classId = scanner.nextLine();   
            
            if (CheckTable.checkClass(classId) == false){
                 System.out.println("Class ID " + classId + " not found in Class!");
            }
            
        } while(CheckTable.checkClass(classId) == false || classId.isEmpty() || classId.isBlank());
        insertSql(studentId, classId);
    }
    
     private static void insertSql(String studentId, String classId){
        String sql = "INSERT INTO ENROLLMENT " 
                     + "(student_id, class_id) " 
                     + "VALUES (?, ?)";
        
        try (
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ) 
        {
             ps.setString(1, studentId);
             ps.setString(2, classId);
             
            int rows = ps.executeUpdate();
                
            if (rows > 0) {
                    System.out.println("Class inserted successfully!");
            }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}
