package com.bscpe3g.sugboeats;

public class MenuItem {

    private final String name;
    private final String description;
    private final double price;
    private final int imageResourceId;

    public MenuItem(String name, String description, double price, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return String.format("%.2f", price); // Format price with two decimal places
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}