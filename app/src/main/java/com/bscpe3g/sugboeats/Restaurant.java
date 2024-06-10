// Restaurant.java

package com.bscpe3g.sugboeats;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String name;
    private String location;
    private int imageResourceId;

    public Restaurant(String name, String location, int imageResourceId) {
        this.name = name;
        this.location = location;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}