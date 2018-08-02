package com.example.shahalam.rvfabvptl;

import java.io.Serializable;

public class MyDataModel implements Serializable{
    private String title, description;

    public MyDataModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
