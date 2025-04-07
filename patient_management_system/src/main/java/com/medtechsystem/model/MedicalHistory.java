package com.medtechsystem.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class MedicalHistory 
{
    private int historyId;
    private int patientId;
    private String diagnosis;
    private String treatment;
    private Date dateOfDiagnosis;


    //constructor

    public MedicalHistory(int historyId, int patientId, String diagnosis, String treatment, Date dateOfDiagnosis) {
        this.historyId = historyId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.dateOfDiagnosis = dateOfDiagnosis;
    }
 public MedicalHistory()
 {
    // default consttructor
 }

  // insert method
  public void insertMedicalHistory()
   {
        String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
        String user = "root";
        String password = "0073";

        String insertQuery = "INSERT INTO medical_history (patientId, diagnosis, treatment, dateofDiagnosis) VALUES (?, ?, ?, ?)";

        try 
        {
            Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(insertQuery);

            pstmt.setInt(1, patientId);
            pstmt.setString(2, diagnosis);
            pstmt.setString(3, treatment);
            pstmt.setDate(4, dateOfDiagnosis);

            pstmt.executeUpdate();
            System.out.println("Medical History inserted successfully!");

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
}

    // Getters and Setters
    public int getHistoryId() 
    { 
        return historyId; 
    }
    public void setHistoryId(int historyId) 
    {
        this.historyId = historyId;
     }

    public int getPatientId() 
    {
        return patientId;
     }
    public void setPatientId(int patientId) 
    { 
        this.patientId = patientId;
     }

    public String getDiagnosis() 
    { 
        return diagnosis;
     }
    public void setDiagnosis(String diagnosis)
     { 
        this.diagnosis = diagnosis;
     }

    public String getTreatment()
     {
         return treatment; 
    }
    public void setTreatment(String treatment) 
    { 
        this.treatment = treatment; 
    }

    public Date getDateOfDiagnosis() 
    { 
        return dateOfDiagnosis;
     }
    public void setDateOfDiagnosis(Date dateOfDiagnosis) 
    { 
        this.dateOfDiagnosis = dateOfDiagnosis;
     }


}