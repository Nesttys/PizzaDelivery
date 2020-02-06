package com.example.pizzadelivery.Model;

public class Stocks {
    String photoId;
    String name;
    String components;

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public Stocks(String photoId, String name, String components) {
        this.photoId = photoId;
        this.name = name;
        this.components = components;
    }
}
