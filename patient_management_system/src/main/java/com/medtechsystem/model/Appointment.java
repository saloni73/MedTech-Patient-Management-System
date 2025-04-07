package com.medtechsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Date;


// Appointment class to handle appointment-related data and operations

public class Appointment
{
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private Date appointmentDate;
    private String status;

     // Constructor to initialize an Appointment object
    public Appointment(int appointmentId, int patientId, int doctorId, Date appointmentDate,  String status) 
    {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        
        this.status = status;
    }
      
    // Method to insert the appointment details into the database

    public void insertAppointment()
    {
    // Database connection details
        String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
        String user = "root";
        String password = "0073";

        // SQL query to insert appointment data into the database
        String insertQuery = "INSERT INTO appointment (patientId, doctorId, appointmentDate, status) VALUES (?, ?, ?, ?)";

        try 
        {     
             // Establishing a connection to the database
             Connection conn = DriverManager.getConnection(url, user, password);

            // Preparing the SQL statement with placeholders
            PreparedStatement pstmt = conn.prepareStatement(insertQuery); 

           // Setting the values for the placeholders
            pstmt.setInt(1, patientId);
            pstmt.setInt(2, doctorId);
            pstmt.setDate(3, appointmentDate);
            pstmt.setString(4, status);

              // Execute the insert query
              pstmt.executeUpdate();
            System.out.println("Appointment inserted successfully!");

        conn.close();   // Closing the database connection
        } 
        catch (Exception e)
         {
            // Print the stack trace in case of any exceptions
            e.printStackTrace();
        }
    }

        // Getters and Setters for appointmentId
        public int getappointmentId() 
        { 
            return appointmentId;
         }
        public void setappointmentId(int appointmentId)
         {
             this.appointmentId = appointmentId;
         }
    
        public int getPatientId() 
        { 
            return patientId;
         }
        public void setPatientId(int patientId) 
        { 
            this.patientId = patientId;
         }
    
        public int getDoctorId() 
        {
             return doctorId;
         }
        public void setDoctorId(int doctorId)
         {
             this.doctorId = doctorId; 
        }
    
        public Date getAppointmentDate()
         {
             return appointmentDate;
             }
        public void setAppointmentDate(Date appointmentDate) 
        {
             this.appointmentDate = appointmentDate; 
        }
    
        public String getStatus() 
        { 
            return status;
         }
        public void setStatus(String status)
         {
             this.status = status;
             }
    
    }


