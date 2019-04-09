package com.example.recycler.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("have")
    @Expose
    private Have have;

    public String getId() {
        return id;
    }



    public String getImage() {
        return image;
    }



    public String getTitle() {
        return title;
    }



    public Have getHave() {
        return have;
    }



}
