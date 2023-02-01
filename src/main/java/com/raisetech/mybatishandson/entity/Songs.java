package com.raisetech.mybatishandson.entity;

public class Songs {

    private int id;
    private String title;
    private String artist;
    private int year;

    public Songs(){}

    public Songs(int id, String title, String artist, int year) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getYear() {
        return year;
    }
}
