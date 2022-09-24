package com.project.beyondzero.Model;


public class NewsFeedModel {

    int image;
    String date;
    String header;

    public NewsFeedModel(int image, String date, String header) {
        this.image = image;
        this.date = date;
        this.header = header;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
