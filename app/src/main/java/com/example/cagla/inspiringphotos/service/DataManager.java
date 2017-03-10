package com.example.cagla.inspiringphotos.service;

import com.example.cagla.inspiringphotos.service.response.AllPhotosRes;

import rx.Observable;

public class DataManager {

    private static DataManager dataManager;

    private InspiringPhotoService inspiringPhotoService;

    public static DataManager getInstance(){
        if (dataManager == null){
            dataManager = new DataManager();
        }
        return dataManager;
    }

    private DataManager(){
        inspiringPhotoService = InspiringPhotoServiceFactory.makeServiceConnection();
    }

    public Observable<AllPhotosRes> bindPhotosService(String serviceMethod, String apiKey, String format, String jsonCallback, String userId){
        return inspiringPhotoService.bindPhotosService(serviceMethod, apiKey, format, jsonCallback, userId);
    }

}
