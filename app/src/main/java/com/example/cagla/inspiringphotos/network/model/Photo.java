package com.example.cagla.inspiringphotos.network.model;

import com.google.gson.annotations.SerializedName;

public class Photo {

    @SerializedName("id")
    public String photoId;

    @SerializedName("owner")
    public String photoOwner;

    @SerializedName("secret")
    public String photoSecret;

    @SerializedName("server")
    public String photoServer;

    @SerializedName("farm")
    public int photoFarm;

    @SerializedName("title")
    public String photoTitle;

    @SerializedName("ispublic")
    public int isPublic;

    @SerializedName("isfriend")
    public int isFriend;

    @SerializedName("isfamily")
    public int isFamily;

}
