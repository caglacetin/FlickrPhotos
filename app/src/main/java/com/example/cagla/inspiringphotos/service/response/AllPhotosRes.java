package com.example.cagla.inspiringphotos.service.response;

import com.example.cagla.inspiringphotos.service.model.AllPhotos;
import com.google.gson.annotations.SerializedName;

public class AllPhotosRes {

    @SerializedName("photos")
    public AllPhotos allPhotos;

    @SerializedName("stat")
    public String stat;

}
