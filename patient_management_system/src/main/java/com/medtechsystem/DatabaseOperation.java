package com.medtechsystem;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.medtechsystem.model.Appointment;
import com.medtechsystem.model.Doctor_Details;
import com.medtechsystem.model.MedicalHistory;
import com.medtechsystem.model.Patient_Details;
import com.medtechsystem.model.TreatmentPlan;


public class DatabaseOperation
{
    // Create database if it doesn't exist and select it
    public static void createDatabase(Statement stm) throws SQLException
    {
        stm.executeUpdate("create Database if not exists Patients_database_management_system");
        stm.execute("use Patients_database_management_system");
        System.out.println("----- Database created and selected-----");

    }
  // System.out.println("-----------------tables created---------------");
  // Create Patients Table
  public static void createPatientsTable(Statement stm) throws SQLException 
  {
    String query = "CREATE TABLE IF NOT EXISTS patients (" +
            "id INT PRIMARY KEY AUTO_INCREMENT, " +
            "first_name VARCHAR(50), last_name VARCHAR(50), " +
            "age INT, gender VARCHAR(10), contactInfo VARCHAR(120))";
    stm.executeUpdate(query);
    System.out.println(" Patients table created.");
}
  // Create Doctor Table
   public static void createDoctorsTable(Statement stm) throws SQLException
    {
      String query = "CREATE TABLE IF NOT EXISTS doctor_details (" +
            "doctor_id INT PRIMARY KEY AUTO_INCREMENT, " +
            "firstName VARCHAR(50), lastName VARCHAR(50), " +
            "specialty VARCHAR(100), contactNumber VARCHAR(20), email VARCHAR(100))";
      stm.executeUpdate(query);
       System.out.println(" Doctor Details table created.");
   }
    // Create Medical history Table
   public static void createMedicalHistoryTable(Statement stm) throws SQLException 
   {
     String query = "CREATE TABLE IF NOT EXISTS medical_history (" +
            "historyId INT PRIMARY KEY AUTO_INCREMENT, " +
            "patientId INT, diagnosis VARCHAR(255), " +
            "treatment VARCHAR(255), dateOfDiagnosis DATE)";
     stm.executeUpdate(query);
     System.out.println(" Medical History table created.");
   }
     // Create appointment Table
   public static void createAppointmentTable(Statement stm) throws SQLException 
   {
      String query = "CREATE TABLE IF NOT EXISTS appointment (" +
            "appointmentId INT PRIMARY KEY AUTO_INCREMENT, " +
            "patientId INT, doctorId INT, " +
            "appointmentDate DATE, status VARCHAR(20) DEFAULT 'Scheduled')";
      stm.executeUpdate(query);
      System.out.println(" Appointment table created.");
   } 
//  Create treatmentplan Table

 public static void createTreatmentPlanTable(Statement stm) throws SQLException
 {
      String query = "CREATE TABLE IF NOT EXISTS treatment_plan (" +
            "planId INT PRIMARY KEY AUTO_INCREMENT, " +
            "patientId INT, description TEXT, " +
            "startDate DATE, endDate DATE)";
      stm.executeUpdate(query);
      System.out.println(" Treatment Plan table created.");
 }

 //-----------Create a New method to call all created table 
 public static void CreateallTablesData(Statement stm) throws SQLException
 {
    createPatientsTable(stm);
    createDoctorsTable(stm);
    createMedicalHistoryTable(stm);
    createAppointmentTable(stm);
 }

 // ====================== insert Secton ======-===============
 
// --------Patient data inserted----------
public static void insertPatientDataFromUser()
{     
     Scanner sc = new Scanner(System.in);
    System.out.print("Enter First Name: ");
    String firstName = sc.nextLine();
    System.out.print("Enter Last Name: ");
    String lastName = sc.nextLine();
    System.out.print("Enter Age: ");
    int age = sc.nextInt();
    sc.nextLine(); 
    System.out.print("Enter Gender: ");
    String gender = sc.nextLine();
    System.out.print("Enter Contact Number: ");
    String contact = sc.nextLine();

    Patient_Details patient = new Patient_Details(0, firstName, lastName, age, gender, contact);
    patient.insertPatient();
}

//-----------doctor data inserted-------------
public static  void insertDoctorDataFromUser()
{
    Scanner sc = new Scanner(System.in);

        System.out.print("Enter Doctor's First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Doctor's Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Specialty: ");
        String specialty = sc.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        Doctor_Details doctor = new Doctor_Details(0, firstName, lastName, specialty, contactNumber, email);
        doctor.insertDoctor();

}
//-----------Medical History data inserted-------------

    public static void insertMedicalHistoryFromUserInput() 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();

        System.out.print("Enter Treatment: ");
        String treatment = sc.nextLine();

        System.out.print("Enter Date of Diagnosis (yyyy-mm-dd): ");
        String dateInput = sc.nextLine();
        Date dateOfDiagnosis = Date.valueOf(dateInput);  

        MedicalHistory medicalHistory = new MedicalHistory(0, patientId, diagnosis, treatment, dateOfDiagnosis);
        medicalHistory.insertMedicalHistory();
    }


//-----------Treatment Plan data inserted-------------
    public static void insertTreatmentPlanFromUserInput()
     {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();
        sc.nextLine();  

        System.out.print("Enter Description of the Treatment Plan: ");
        String description = sc.nextLine();

        System.out.print("Enter Start Date of the Treatment Plan (yyyy-mm-dd): ");
        String startDateInput = sc.nextLine();
        Date startDate = Date.valueOf(startDateInput);  // Convert input to Date format

        System.out.print("Enter End Date of the Treatment Plan (yyyy-mm-dd): ");
        String endDateInput = sc.nextLine();
        Date endDate = Date.valueOf(endDateInput);  // Convert input to Date format

        // Create the TreatmentPlan object and insert it into the database
        TreatmentPlan treatmentPlan = new TreatmentPlan(0, patientId, doctorId, description, startDate, endDate);
        treatmentPlan.insertTreatmentplan();
    }

//-----------Appointment data inserted-------------
public static void insertAppointmentFromUserInput()
 {
        Scanner sc = new Scanner(System.in);

        // Input for patientId, doctorId, status, and appointmentDate
        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();

        System.out.print("Enter Doctor ID: ");
        int doctorId = sc.nextInt();

        sc.nextLine();  // Clear the buffer

        System.out.print("Enter Status (e.g., Scheduled, Completed, Cancelled): ");
        String status = sc.nextLine();

        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
        String appointmentDateInput = sc.nextLine();
        Date appointmentDate = Date.valueOf(appointmentDateInput);  // Convert input to Date format

        // Create the Appointment object and insert it into the database
        Appointment appointment = new Appointment(0, patientId, doctorId, appointmentDate, status);
        appointment.insertAppointment();
    }

    // Create a new method to call all the inserted method 
    public static void InsertAllTableData(Statement stm) throws SQLException
   {
      insertPatientDataFromUser();
      insertDoctorDataFromUser();
      insertMedicalHistoryFromUserInput();
      insertTreatmentPlanFromUserInput();
      insertAppointmentFromUserInput();
    }

    //----------Display the All Data-------------------
  // display patients 
    public static void DisplayPatients(Statement stm) throws SQLException
    {
        ResultSet rs = stm.executeQuery("select * from patients");
        System.out.println("------Patients Table-----");
        while(rs.next())
        {
            int id = rs.getInt("id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");
            String contactInfo = rs.getString("contactInfo");
            System.out.printf("ID: %d, Name: %s %s, Age: %d, Gender: %s, Contact: %s%n",
                              id, firstName, lastName, age, gender, contactInfo); 
        }
        rs.close();
    }

    //-------Display the Doctor Data-----------
    public static void displayDoctors(Statement stm) throws SQLException
     {
        ResultSet rs = stm.executeQuery("SELECT * FROM doctor_details");
        System.out.println("----- Doctors Table -----");
        while (rs.next()) 
        {
            int id = rs.getInt("doctor_id");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            String specialty = rs.getString("specialty");
            String contactNumber = rs.getString("contactNumber");
            String email = rs.getString("email");
            System.out.printf("ID: %d, Name: %s %s, Specialty: %s, Contact: %s, Email: %s%n",
                              id, firstName, lastName, specialty, contactNumber, email);
        }
        rs.close();
    }
  
    //-------Display the Medical History Data-----------
    public static void displayMedicalHistory(Statement stm) throws SQLException
    {
        ResultSet rs = stm.executeQuery("SELECT * FROM medical_history");
        System.out.println("----- Medical History Table -----");
        while (rs.next())
         {
            int historyId = rs.getInt("historyId");
            int patientId = rs.getInt("patientId");
            String diagnosis = rs.getString("diagnosis");
            String treatment = rs.getString("treatment");
            Date dateOfDiagnosis = rs.getDate("dateOfDiagnosis");
            System.out.printf("History ID: %d, Patient ID: %d, Diagnosis: %s, Treatment: %s, Date: %s%n",
                              historyId, patientId, diagnosis, treatment, dateOfDiagnosis);
        }
        rs.close();
    }
    
      //-------Display the Treatment Plan Data-----------
      public static void displayTreatmentPlans(Statement stm) throws SQLException
       {
        ResultSet rs = stm.executeQuery("SELECT * FROM treatment_plan");
        System.out.println("----- Treatment Plans Table -----");
        while (rs.next())
         {
            int planId = rs.getInt("planId");
            int patientId = rs.getInt("patientId");
            String description = rs.getString("description");
            Date startDate = rs.getDate("startDate");
            Date endDate = rs.getDate("endDate");
            System.out.printf("Plan ID: %d, Patient ID: %d, Description: %s, Start Date: %s, End Date: %s%n",
                              planId, patientId, description, startDate, endDate);
        }
        rs.close();
    }
    
      //-------Display the Appointment Data-----------
      public static void displayAppointments(Statement stm) throws SQLException
       {
        ResultSet rs = stm.executeQuery("SELECT * FROM appointment");
        System.out.println("----- Appointments Table -----");
        while (rs.next())
         {
            int appointmentId = rs.getInt("appointmentId");
            int patientId = rs.getInt("patientId");
            int doctorId = rs.getInt("doctorId");
            Date appointmentDate = rs.getDate("appointmentDate");
            String status = rs.getString("status");
            System.out.printf("Appointment ID: %d, Patient ID: %d, Doctor ID: %d, Date: %s, Status: %s%n",
                              appointmentId, patientId, doctorId, appointmentDate, status);
        }
        rs.close();
    }
    
    // Create a method for calling all the display method into a one method
    public static void DisplayallTablesData(Statement stm) throws SQLException
    {
        DisplayPatients(stm);
        displayDoctors(stm);
        displayMedicalHistory(stm);
        displayAppointments(stm);
        displayTreatmentPlans(stm);
       
    }  
 }



