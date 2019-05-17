package com.example.viewpagerapi.retroift;

import com.google.gson.annotations.SerializedName;

public class ImgModel {

    @SerializedName("img")
    String img;

    public ImgModel(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }
}
