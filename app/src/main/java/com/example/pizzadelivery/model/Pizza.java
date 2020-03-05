package com.example.pizzadelivery.model;

public class Pizza {
    private String name;
    private String components;
    private String photoId;
    private int price;

    public String getName() {
        return name;
    }

    public String getComponents() {
        return components;
    }

    public String getPhotoId() {
        return photoId;
    }

    public int getPrice() {
        return price;
    }

    public Pizza(String photoId, String name, String components, int price) {
        this.photoId = photoId;
        this.name = name;
        this.components = components;
        this.price = price;
    }
}
