package com.example.pizzadelivery.Model;

public class Stocks {
    private String photoId;
    private String name;
    private String components;

    public String getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }


    public String getComponents() {
        return components;
    }


    public Stocks(String photoId, String name, String components) {
        this.photoId = photoId;
        this.name = name;
        this.components = components;
    }
}
