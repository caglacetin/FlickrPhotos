package com.example.cagla.inspiringphotos.enums;

public enum PhotoTypes {

    RECENT_PHOTOS(0),
    POPULAR_PHOTOS(1);

    private final int type;

    PhotoTypes(int type){
        this.type = type;
    }

    public int getPhotoType(){
        return type;
    }

}
