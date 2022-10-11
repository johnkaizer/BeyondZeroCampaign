package com.project.beyondzero.Model;

public class AppointmentsModel {
    private int id;
    byte[]avatar;
    String name;
    String date;
    String time;
    String title;
    int phone;
    String patient;


    public AppointmentsModel(int id, byte[] avatar, String name, String date, String time, String title, int phone, String patient) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.date = date;
        this.time = time;
        this.title = title;
        this.phone = phone;
        this.patient = patient;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }
}
