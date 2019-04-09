package com.example.recycler.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Have {
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("wheretobuy")
    @Expose
    private String Link;
    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("Price")
    @Expose
    private String price;

    public String getDesc() {
        return desc;
    }



    public String getLink() {
        return Link;
    }



    public String getLogo() {
        return logo;
    }



    public String getPrice() {
        return price;
    }


}
