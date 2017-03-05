package com.example.cagla.inspiringphotos.data.network;


import com.example.cagla.inspiringphotos.data.network.response.RecentPhotoRes;

import rx.Observable;

/**
 * Created by cagla on 04/03/2017.
 */

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

    public Observable<RecentPhotoRes> recentPhotosService(String serviceMethod, String apiKey, String format, String jsonCallback){
        return inspiringPhotoService.getRecentPhotos(serviceMethod, apiKey, format, jsonCallback);
    }

}
