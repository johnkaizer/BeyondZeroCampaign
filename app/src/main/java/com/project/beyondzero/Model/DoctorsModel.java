package com.project.beyondzero.Model;

public class DoctorsModel {
    int image;
    int title_image;
    String name;
    String patients;
    String time;
    String title;

    public DoctorsModel(int image, int title_image, String name, String patients, String time, String title) {
        this.image = image;
        this.title_image = title_image;
        this.name = name;
        this.patients = patients;
        this.time = time;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getTitle_image() {
        return title_image;
    }

    public void setTitle_image(int title_image) {
        this.title_image = title_image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatients() {
        return patients;
    }

    public void setPatients(String patients) {
        this.patients = patients;
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
}
