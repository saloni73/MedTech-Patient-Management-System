package com.medtechsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        
    try
    {   
        // Establish connection to MySQL database

        String url = "jdbc:mysql://localhost:3306/patients_database_management_system";
        String user = "root";
        String  pass ="0073";
        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stm = con.createStatement();
        System.out.println("Connected Succesfully");

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit)
        {
            // display the main menu
          System.out.println("\n ------MEDTECH DATABASE MENU------");
          System.out.println("1. Create Database");
          System.out.println("2. Create Tables");
          System.out.println("3. Insert Sample Data");
          System.out.println("4. Display All Data");
          System.out.println("5. Exit");
          System.out.print("Enter your choice: ");
          int choice = sc.nextInt();
          sc.nextLine();  // Consume newline 

          switch (choice)
           {
            case 1:
                    // Create database
                     DatabaseOperation.createDatabase(stm);
                     break;
            case 2:
                    // prompt user to select tables to create
                     System.out.println("Select tables to create:");
                     System.out.println("a. Patients");
                     System.out.println("b. Doctors");
                     System.out.println("c. Medical History");
                     System.out.println("d. Appointments");
                     System.out.println("e. Treatment Plans");
                    System.out.println("f. All Tables");
                     System.out.print("Enter your choice: ");

                 String tableChoice = sc.nextLine().toLowerCase();

                 switch (tableChoice)
                  {
                    case "a":
                            // create patient table
                             DatabaseOperation.createPatientsTable(stm);
                             break;
                    case "b":
                             // create Doctor table
                             DatabaseOperation.createDoctorsTable(stm);
                             break;
      
                    case "c":
                             // create Medical history table
                             DatabaseOperation.createMedicalHistoryTable(stm);
                             break;
                    case "d":
                             // create Appointment table
                             DatabaseOperation.createAppointmentTable(stm);
                             break;
                    case "e":
                              // create Treatment plan table
                             DatabaseOperation.createTreatmentPlanTable(stm);
                             break;
                    case "f":
                              // create all tables
                             DatabaseOperation.CreateallTablesData(stm);
                             break;
                    default:
                             //Invalid table  option
                             System.out.println(" Invalid option.");
                 }         
                 break;
            case 3: 
                   //prompt user to select data insertion option 
                   System.out.println("choose the inserted tables");
                   System.out.println(" A. insertPatientDataFromUser ");
                     System.out.println("B. insertDoctorDataFromUser");
                     System.out.println("C. insertMedicalHistoryFromUserInput");
                     System.out.println("D.insertTreatmentPlanFromUserInput ");
                     System.out.println("E.insertAppointmentFromUserInput ");
                    System.out.println("F. All Tables");
                     System.out.print("Enter your choice: ");


                   String choice2 = sc.nextLine().toUpperCase();
                    switch (choice2)
                     {
                        case "A": 
                                  // Insert patient data from user 
                                  DatabaseOperation.insertPatientDataFromUser();
                                  break;
                        case "B":
                                   // Insert doctor data from user 
                                  DatabaseOperation.insertDoctorDataFromUser();
                                  break;     
                        case "C":
                                 // Insert medical history data from user
                                  DatabaseOperation.insertMedicalHistoryFromUserInput();
                                  break;
                        case "D":
                                   // Insert Treatment plan data from user
                                  DatabaseOperation.insertTreatmentPlanFromUserInput();
                                  break;
                        case "E":
                                    //Insert Appointment data from user
                                  DatabaseOperation.insertAppointmentFromUserInput();
                                  break;
                        case "F":
                                 //Insert datainto all tables from user
                                  DatabaseOperation.InsertAllTableData(stm);
                                  break;
                                  
                         default:   
                                  // invalid insertion option
                                  System.out.println("INVALID option");
                                  
                    }
                    break;
            case 4:  
                   // Prompt user to select data to display
                  System.out.println("Select data to display");
                    System.out.println("a. Patients");
                    System.out.println("b. Doctors");
                    System.out.println("c. Medical History");
                    System.out.println("d. Appointments");
                    System.out.println("e. Treatment Plans");
                    System.out.println("f. All Tables");
                    System.out.print("Enter your choice: ");

                   String displayChoice = sc.nextLine().toLowerCase();
                    switch (displayChoice) 
                    {
                        case "a":
                                 //Display Patients data
                                 DatabaseOperation.DisplayPatients(stm);
                                 break;
                        case "b":
                                 //Display doctor data
                                 DatabaseOperation.displayDoctors(stm);
                                 break;
                        case "c":
                                 //Display Medicalhistory data
                                 DatabaseOperation.displayMedicalHistory(stm);
                                 break;
                        case "d":
                                 //Display Appointment data
                                 DatabaseOperation.displayAppointments(stm);
                                 break;
                        case "e":
                                 //Display treatment plan data
                                 DatabaseOperation.displayTreatmentPlans(stm);
                                 break;
                        case "f":
                                  //Display all tables data
                                  DatabaseOperation.DisplayallTablesData(stm);
                                  break;
                        default:
                                // invalid display option
                            System.out.println("Invalid option.");
                    }
                    break;
                 
            case 5:
                    // exit the appplication 
                   exit=true;
                   System.out.println("Existing..... GoodBye!");
                    break;             
         default:
                  // invalid main menu choice 
                   System.out.println("Invalid choice . Try again");
                   break;
        }
    }
      // Close scanner and database connection
      sc.close();
      con.close();          
    }
      catch(Exception e)
     {
        //  Print stack trace for exceptions
        e.printStackTrace();
     }
        
    }
}
