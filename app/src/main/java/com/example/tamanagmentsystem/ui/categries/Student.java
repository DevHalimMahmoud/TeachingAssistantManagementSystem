package com.example.tamanagmentsystem.ui.categries;

public class Student {
    private String name, id, gpa, phone;

    public Student(String name, String id, String gpa, String phone) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
