package com.example.cagla.inspiringphotos.service.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AllPhotos {

    @SerializedName("page")
    public int page;

    @SerializedName("pages")
    public int pages;

    @SerializedName("perpage")
    public int perPage;

    @SerializedName("total")
    public int total;

    @SerializedName("photo")
    public List<Photo> photoList;
}
