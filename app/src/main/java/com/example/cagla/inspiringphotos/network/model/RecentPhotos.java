package com.example.cagla.inspiringphotos.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
