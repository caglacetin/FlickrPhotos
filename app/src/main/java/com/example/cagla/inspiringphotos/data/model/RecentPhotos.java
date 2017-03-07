package com.example.cagla.inspiringphotos.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cagla on 04/03/2017.
 */

public class RecentPhotos {

    @SerializedName("page")
    public int page;

    @SerializedName("pages")
    public int pages;

    @SerializedName("perpage")
    public int perPage;

    @SerializedName("total")
    public int total;

    @SerializedName("photo")
    public List<Photo> recentPhotoList;
}
