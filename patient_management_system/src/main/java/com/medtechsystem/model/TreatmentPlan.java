package com.medtechsystem.model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class TreatmentPlan 
{
   private int planId;
   private int patientId;
   private int doctorId;
   private String description;
   private Date startDate;
   private Date endDate;

   public TreatmentPlan(int planId,int patientId, int doctorId, String description, Date starDate, Date endDate)
   {
    this.planId = planId;
    this.patientId=patientId;
    this.doctorId=doctorId;
    this.description=description;
    this.startDate =starDate;
    this.endDate=endDate;
   }

//insert method
public void insertTreatmentplan()
{
   String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
   String user = "root";
   String password = "0073";
   String insertQuery = "INSERT INTO treatment_plan (planId, patientId, description, startDate,endDate) VALUES (?, ?,?, ?, ?)";

   try 
   {
      Connection c= DriverManager.getConnection(url, user, password);
      PreparedStatement pres =c.prepareStatement(insertQuery);
    pres.setInt(1, planId);  
    pres.setInt(2, patientId);
     pres.setString(3, description);
     pres.setDate(4, startDate);
     pres.setDate(5, endDate);
     pres.executeUpdate();
     System.out.println("Treatment Plan inserted successfully!");
         
    }
      catch (SQLException e)
      {
         e.printStackTrace();
      }
   }

   // Getters and Setters
    public int getPlanId()
     {
       return planId;
       }
    public void setPlanId(int planId)
     { 
      this.planId = planId;
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

    public String getDescription() 
    {
       return description;
       }
    public void setDescription(String description) 
    {
       this.description = description;
       }

    public Date getStartDate()
     {
       return startDate;
       }
    public void setStartDate(Date startDate) 
    {
       this.startDate = startDate; 
      }

    public Date getEndDate() 
    {
       return endDate; 
      }
    public void setEndDate(Date endDate) 
    { 
      this.endDate = endDate; 
   }

}


