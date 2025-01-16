package com.ebtechgroup.UI;

import com.ebtechgroup.model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {

    public static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient Menu");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);}

    private static void showBookAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select a date: ");
            //Mostrar las fecha que agendaron fechas
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsWithAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsWithAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsWithAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc : doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println("El doctor selecionado es: " + doctorSelected.getName() +". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +  " .Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment: \n 1. Yes\n 2. Change appointment" );
            response = Integer.valueOf(sc.nextLine());

            if (response == 1) {
                //logica para agendar
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected, doctorSelected.getAvailableAppointments().get(indexDate).getDate(null), doctorSelected.getAvailableAppointments().get(indexDate).getTime());


                showPatientMenu();
            }



    }while (response!=0);
    }

    private static void showPatientMyAppointment() {
        int response = 0;
        do {
            System.out.println("::My appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0) {
                System.out.println("No appointments found");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;

                System.out.println(j + ". " + "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() + "Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() + "\n Doctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. Return to main menu");

        }while (response != 0);
    }
}
