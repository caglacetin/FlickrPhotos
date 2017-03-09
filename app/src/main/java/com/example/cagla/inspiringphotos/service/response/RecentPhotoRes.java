package com.example.cagla.inspiringphotos.service.response;

import com.example.cagla.inspiringphotos.service.model.RecentPhotos;
import com.google.gson.annotations.SerializedName;

public class RecentPhotoRes {

    @SerializedName("photos")
    public RecentPhotos recentPhotos;

    @SerializedName("stat")
    public String stat;

}
