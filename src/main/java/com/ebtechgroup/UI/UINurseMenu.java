package com.ebtechgroup.UI;

import com.ebtechgroup.model.Nurse;

import java.util.ArrayList;
import java.util.Scanner;

public class UINurseMenu {
    public static ArrayList<Nurse> nursesWithAvailableAppointments = new ArrayList<>();

    public static void showNurseMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Nurse Menu");
            System.out.println("Welcome: " + UIMenu.nurseLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {
                case 1:
                    showAddAvailableAppointmentMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response != 2);
    }

    private static void showAddAvailableAppointmentMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("::Add Available Appointments");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return to Menu");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1,2,3
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected - 1]);

                System.out.println("Insert the date available : [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n 1. Correct \n 2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + "[16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is:  " + time + "\n 1. Correct \n 2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);

                //asignar a nuestro doctor logged la fecha
                UIMenu.nurseLogged.addAvailableAppointments(date,time);
                checkNurseAvailableAppointments(UIMenu.nurseLogged);
            } else if (response == 0) {
                showNurseMenu();

            }
        }while (response != 0);
    }
    private static void checkNurseAvailableAppointments(Nurse nurse) {
        if(!nurse.getAvailableAppointments().isEmpty() && !nurse.getAvailableAppointments().contains(nurse)) {
            nursesWithAvailableAppointments.add(nurse);
        }
    }

}
