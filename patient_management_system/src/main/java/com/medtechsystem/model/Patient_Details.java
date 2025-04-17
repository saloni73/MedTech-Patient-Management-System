package com.medtechsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Patient_Details
 {
    
    
    private int patientId;         // Unique ID for the patient
    private String firstName;      // Patient's first name
    private String lastName;       // Patient's last name
    private int age;               // Patient's age
    private String gender;         // Patient's gender (e.g., Male, Female)
    private String contactNumber;  // Patient's contact number (phone or email)

    // Constructor to initialize the patient object with specific values
    public Patient_Details(int patientId, String firstName, String lastName, int age, String gender, String contactNumber) {
        this.patientId = patientId;           // Assigning patient ID
        this.firstName = firstName;         // Assigning first name
        this.lastName = lastName;           // Assigning last name
        this.age = age;                     // Assigning age
        this.gender = gender;               // Assigning gender
        this.contactNumber = contactNumber; // Assigning contact number
    }


    // Getter methods (Accessors) to retrieve private data
    public int getPatientId() 
    {
        return patientId;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public int getAge()
     {
        return age;
    }

    public String getGender() 
    {
        return gender;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    // Setter methods  to modify private data
    public void setPatientId(int patientId) 
    {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) 
    {
        this.lastName = lastName;
    }

    public void setAge(int age)
     {
        this.age = age;
    }

    public void setGender(String gender)
     {
        this.gender = gender;
    }

    public void setContactNumber(String contactNumber)
     {
        this.contactNumber = contactNumber;
     }


     // Insert Patient into Database
    public void insertPatient() 
    {
        String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
        String user = "root";
        String password = "0073";
        String insertQuery = "INSERT INTO patients (first_name, last_name, age, gender, contactInfo) VALUES (?, ?, ?, ?, ?)";

        try 
        {
           Connection conn = DriverManager.getConnection(url, user, password);
           PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, age);
            pstmt.setString(4, gender);
            pstmt.setString(5, contactNumber);

            pstmt.executeUpdate();
            System.out.println("Patient data inserted successfully!");
            
        } 
        catch (SQLException e)
         {
            e.printStackTrace();
        }

        
    }
}
