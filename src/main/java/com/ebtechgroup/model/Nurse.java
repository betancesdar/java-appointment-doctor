package com.ebtechgroup.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Nurse extends User{
    private int id;
    private ArrayList<AvailableAppointments> availableAppointments = new ArrayList<>();



    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void showDataUser() {

    }

    public ArrayList<AvailableAppointments> getAvailableAppointments() {
        return availableAppointments;
    }

    public void addAvailableAppointments(String date, String time) {
        availableAppointments.add(new Nurse.AvailableAppointments(date, time));
    }

    public static class AvailableAppointments{
        private int id;
        private Date date;
        private String time;


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


        public AvailableAppointments(String date, String time) {
            try {
                this.date = formatter.parse(date);

            }catch (ParseException e) {
                e.printStackTrace();
            }
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate() {
            return formatter.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time + " hrs.";
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "Available Appointments \n Date: " + date + "\n Time: " + time;
        }
    }


}
