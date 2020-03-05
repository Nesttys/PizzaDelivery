package com.example.pizzadelivery.model;

public class Drinks {
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

    public Drinks(String photoId, String name, String components) {
        this.photoId = photoId;
        this.name = name;
        this.components = components;
    }
}
