package com.example.pizzadelivery.Model;

public class Pizza {
    private String name;
    String components;
    String photoId;
    int price;

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

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Pizza(String photoId, String name, String components, int price) {
        this.photoId = photoId;
        this.name = name;
        this.components = components;
        this.price = price;
    }
//    private List<Pizza> pizzaList;
//
//    private void initializeData() {
//        pizzaList = new ArrayList<>();
//        pizzaList.add(new Pizza("Пеперони", "Моцарелла, Салями", R.drawable.ic_launcher_background, 150));
//        pizzaList.add(new Pizza("Пеперони", "Моцарелла, Салями", R.drawable.ic_launcher_background, 150));
//        pizzaList.add(new Pizza("Пеперони", "Моцарелла, Салями", R.drawable.ic_launcher_background, 150));
//        pizzaList.add(new Pizza("Пеперони", "Моцарелла, Салями", R.drawable.ic_launcher_background, 150));
//    }
}
