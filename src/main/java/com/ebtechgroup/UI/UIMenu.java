package com.ebtechgroup.UI;

import com.ebtechgroup.model.Doctor;
import com.ebtechgroup.model.Patient;
import com.ebtechgroup.model.Nurse;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static Nurse nurseLogged;

    public static void showMenu() {
        System.out.println("Welcome to my Appoiments");
        System.out.println("Select an option:");

        int response;
        do {
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Nurses");
            System.out.println("0. Exit");

            Scanner myScanner = new Scanner(System.in);
            response = Integer.parseInt(myScanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    System.out.println("Patient");
                    authUser(2);
                    break;
                case 3:
                    System.out.println("Nurse");
                    authUser(3);
                    break;
                case 0:
                    System.out.println("Thank you for your visit!");
                    break;
                default:
                    System.out.println("Invalid option, please select a correct option");
            }
        } while (response != 0);
    }
    private static void authUser(int userType) {
        //userType 1 = Doctor
        //userType 2 = patient

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Jose Martinez", "josemartinez@email.com"));
        doctors.add(new Doctor("Roberto Mata", "rmata@email.com"));
        doctors.add(new Doctor("Ana Feliz", "afeliz@email.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Dario Betances", "betancesdar08@gmail.com"));
        patients.add(new Patient("Andy Sosa", "asosa@email.com"));
        patients.add(new Patient("Nathalie Caba", "ncaba@email.com"));

        ArrayList<Nurse> nurses = new ArrayList<>();
        nurses.add(new Nurse("Martha Gomez", "gomez@email.com"));
        nurses.add(new Nurse("John Smith", "smith@email.com"));

        boolean emailCorrect = false;
        do{
            System.out.println("Please enter your email: [info@email.com] ");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1) {
                for (Doctor d : doctors) {
                    if (d.getEmail().equals(email)) {
                        emailCorrect = true;
                        //Obtener los datos del usuario logeado
                        doctorLogged = d;
                        //Show doctor menu
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if (userType == 2) {
                for (Patient p : patients) {
                    if (p.getEmail().equals(email)) {
                        emailCorrect = true;
                        patientLogged = p;
                        //show patient menu
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
            if (userType == 3) {
                for (Nurse n : nurses) {
                    if (n.getEmail().equals(email)) {
                        emailCorrect = true;
                        nurseLogged = n;
                        //Show Nurse Menu.
                    }
                }
            }
        }while (!emailCorrect);


    }

    private static void showPatientMenu() {
        int response;
        do {
            System.out.println("\n\n");
            System.out.println("Patient Menu");
            System.out.println("1. Book an appoinment");
            System.out.println("2. My appoinments");
            System.out.println("0. Return");

            Scanner myScanner = new Scanner(System.in);
            response = Integer.parseInt(myScanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("::Book an appointment");
                    for(int i = 1; i < 4; i++) {
                        System.out.println(i +". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid option, please select a correct option");
            }
        }while (response != 0);

    }
}
