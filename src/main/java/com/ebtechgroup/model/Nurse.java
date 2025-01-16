package com.ebtechgroup.model;

public class Nurse extends User{
    private int id;

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
}
