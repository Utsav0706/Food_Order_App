package com.example.food.Domain;

import java.io.Serializable;

public class Category implements Serializable {
    private int Id;
    private String ImagePath;
    private String Name;

    public Category(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }
}
