package com.taras_vk.weatherapp.models;

/**
 * Created by taras on 10/14/17.
 */
public class City {

    private long id;
    private String name;

    public City() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
