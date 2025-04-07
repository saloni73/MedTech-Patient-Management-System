package com.medtechsystem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;

import com.medtechsystem.model.Appointment;
import com.medtechsystem.model.Doctor_Details;
import com.medtechsystem.model.MedicalHistory;
import com.medtechsystem.model.Patient_Details;
import com.medtechsystem.model.TreatmentPlan;

public class Main 
{
    public static void main( String[] args )
    {
        
    try
    {   
        // connect to Mysql 

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String  pass ="0073";
        Connection con = DriverManager.getConnection(url, user, pass);
        System.out.println("Connected Succesfully");

        Statement stm = con.createStatement();
        
        // create database

    //    String createDatabaseQuery = "create database Patients_database_management_system";
    //    stm.executeUpdate(createDatabaseQuery);
      System.out.println("Database created Succesfully");
        
        // use for created database
        stm.execute("use Patients_database_management_system");

        // create table 
        String createTableQuery = "CREATE TABLE IF NOT EXISTS patients ( "  + "id INT PRIMARY KEY AUTO_INCREMENT ," +
                                   "first_name varchar(50) ," +
                                   "last_name Varchar(50)," +
                                   "age int ," +
                                   "gender varchar(10)," +
                                   "contactInfo varchar(120)" + ")";
        stm.executeUpdate(createTableQuery);
        System.out.println("Table created Succefully");   

        
            //  Create Doctor Details Table
            String createDoctorTable = "CREATE TABLE IF NOT EXISTS doctor_details ("
                    + "doctor_id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "firstName VARCHAR(50), "
                    + "lastName VARCHAR(50), "
                    + "specialty VARCHAR(100), "
                    + "contactNumber VARCHAR(20), "
                    + "email VARCHAR(100)"
                    + ")";

            stm.executeUpdate(createDoctorTable);
            System.out.println("Doctor Details table created Successfully");


            //  Create Treatment Plan Table
            String createTreatmentPlanTable = "CREATE TABLE IF NOT EXISTS treatment_plan ("
                    + "planId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "patientId INT, "
                    + "description TEXT, "
                    + "startDate DATE, "
                    + "endDate DATE"
                    + ")";
            stm.executeUpdate(createTreatmentPlanTable);
            System.out.println("Treatment Plan table created Successfully");

            //  Create Medical History Table
            String createMedicalHistoryTable = "CREATE TABLE IF NOT EXISTS medical_history ("
                    + "historyId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "patientId INT, "
                    + "diagnosis VARCHAR(255), "
                    + "treatment VARCHAR(255), "
                    + "dateOfDiagnosis DATE"
                    + ")";

            stm.executeUpdate(createMedicalHistoryTable);
            System.out.println("Medical History table created Successfully");

            // Create Appointment Table
            String createAppointmentTable = "CREATE TABLE IF NOT EXISTS appointment ("
                    + "appointmentId INT PRIMARY KEY AUTO_INCREMENT, "
                    + "patientId INT, "
                    + "doctorId INT, "
                    + "appointmentDate DATE, "
                    + "status VARCHAR(20) DEFAULT 'Scheduled' "
                    + ")";

            stm.executeUpdate(createAppointmentTable);
            System.out.println("Appointment table created Successfully");

      System.out.println("-------------Data Inserted on table----------------------------");  
            
         //Insert Data  of Patient table 

         Patient_Details p1 = new Patient_Details(0,"Shiv","Shubankar",28,"Male","123-456-789");
         Patient_Details p2 = new Patient_Details(0,"Ridhi","Sharma",29,"female","798-122-365");
         p1.insertPatient();
         p2.insertPatient();
        
        //Insert Data  of Doctor table 
        // Insert first doctor
        Doctor_Details d1 = new Doctor_Details(0, "Dr. ASHUTOSH", "RANA", "Neurology", "552-022-4444", "Dr.@gmail.com");
        d1.insertDoctor();

        // Insert second doctor
        Doctor_Details d2 = new Doctor_Details(0, "Dr. Shima", "RANA", "Neurology", "258-654-7895", "Drshima.@gmail.com");
        d2.insertDoctor();


        //Insert Data  of Medical Histoty  table 
        MedicalHistory m = new MedicalHistory(0, 1, "Hypertension", "Medication: Amlodipine 5mg", Date.valueOf("2022-05-10"));
        m.insertMedicalHistory();

        //Insert Data  of Appointment table
        Appointment app = new Appointment(0, 1, 2, Date.valueOf("2023-04-07"),"Schedule");
        app.insertAppointment();
        
        //Insert Data  of Treatmentplan  table 
        TreatmentPlan t = new TreatmentPlan(0, 1, 0, "Physical Therapy", Date.valueOf("2023-04-23"), Date.valueOf("2023-04-23"));
        t.insertTreatmentplan();


        con.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

    }
}
