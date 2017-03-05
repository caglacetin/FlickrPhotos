package com.example.cagla.inspiringphotos.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cagla on 04/03/2017.
 */

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
