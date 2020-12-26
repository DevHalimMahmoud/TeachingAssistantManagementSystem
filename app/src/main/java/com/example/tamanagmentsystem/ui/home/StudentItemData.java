package com.example.tamanagmentsystem.ui.home;

public class StudentItemData {
    private String name;
    private String gpa;
    private String ID;

    public StudentItemData() {
    }

    public StudentItemData(String name, String gpa, String ID) {
        this.name = name;
        this.gpa = gpa;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}



