package com.example.betterpoll_android;

public class InteractCardItem {
    private int imageResource; //image is stored as an int
    private String name;
    private String postContent;
    private String date;

    //constructor
    public InteractCardItem(String name,String date,String postContent){
    this.name=name;
    this.date=date;
    this.postContent=postContent;

    }

    public String getName(){
        return name;
    }
    public String getDate(){
        return date;
    }
    public String getPostContent(){
        return postContent;
    }



}
