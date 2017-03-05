package com.example.cagla.inspiringphotos.data.network.response;

import com.example.cagla.inspiringphotos.data.model.RecentPhotos;
import com.google.gson.annotations.SerializedName;

/**
 * Created by cagla on 04/03/2017.
 */

public class RecentPhotoRes {

    @SerializedName("photos")
    public RecentPhotos recentPhotos;

    @SerializedName("stat")
    public String stat;

}
