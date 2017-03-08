package com.example.cagla.inspiringphotos.network.response;

import com.example.cagla.inspiringphotos.network.model.RecentPhotos;
import com.google.gson.annotations.SerializedName;

public class RecentPhotoRes {

    @SerializedName("photos")
    public RecentPhotos recentPhotos;

    @SerializedName("stat")
    public String stat;

}
