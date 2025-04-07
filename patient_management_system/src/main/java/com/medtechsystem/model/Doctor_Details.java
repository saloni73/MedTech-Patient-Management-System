package com.medtechsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Doctor_Details 
{
    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialty;
    private String contactNumber;
    private String email;

    // constructor
    public Doctor_Details(int doctorId, String firstName, String lastName, String specialty, String contactNumber, String email) 
    {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    //insert method
    public void insertDoctor() 
    {
        String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
        String user = "root";
        String password = "0073";

        String insertQuery = "INSERT INTO doctor_details (firstName, lastName, specialty, contactNumber, email) VALUES (?, ?, ?, ?, ?)";

        try
        { 
            Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery); 

            pstmt.setString(1, "Dr. ASHUTOSH");
            pstmt.setString(2, "RANA");
            pstmt.setString(3, "Neurology");
            pstmt.setString(4, "552-022-4444");
            pstmt.setString(5, "Dr.@gmail.com");
            //pstmt.executeUpdate(); //insert first doctor

            pstmt.setString(1, "Dr. Shima");
            pstmt.setString(2, "RANA");
            pstmt.setString(3, "Neurology");
            pstmt.setString(4, "258-654-7895");
            pstmt.setString(5, "Drshima.@gmail.com");
          //  pstmt.executeUpdate(); //insert second doctor
         
            System.out.println("Doctor data inserted Successfully!");
            
        }
         catch (Exception e) 
         {
            e.printStackTrace();
        }
    }
}


