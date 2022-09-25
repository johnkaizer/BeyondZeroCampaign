package com.project.beyondzero.Model;

public class AppointmentsModel {
    int image;
    String name;
    String date;
    String time;
    String title;

    public AppointmentsModel(int image, String name, String date, String time, String title) {
        this.image = image;
        this.name = name;
        this.date = date;
        this.time = time;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
