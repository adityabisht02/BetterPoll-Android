package com.example.betterpoll_android;

public class ShuttleModel {

    private String course_name;

    private int course_image;

    // Constructor
    public ShuttleModel(String course_name,  int course_image) {
        this.course_name = course_name;

        this.course_image = course_image;
    }

    // Getter and Setter
    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }


    public int getCourse_image() {
        return course_image;
    }

    public void setCourse_image(int course_image) {
        this.course_image = course_image;
    }
}
