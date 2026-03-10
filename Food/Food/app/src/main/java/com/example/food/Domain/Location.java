package com.example.food.Domain;

import java.security.PrivateKey;

public class Location {
    private int Id;
    private String Value;

    public Location(){

    }

    @Override
    public String toString() {
        return Value;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        this.Value = value;
    }
}
