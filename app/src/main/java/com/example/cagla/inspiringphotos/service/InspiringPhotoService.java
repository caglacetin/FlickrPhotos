package com.example.cagla.inspiringphotos.service;

import com.example.cagla.inspiringphotos.service.response.AllPhotosRes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface InspiringPhotoService {

    @GET("rest")
    Observable<AllPhotosRes> bindPhotosService (@Query("method") String serviceMethod,
                                                @Query("api_key") String apiKey,
                                                @Query("format") String format,
                                                @Query("nojsoncallback") String jsonCallback,
                                                @Query("user_id") String userId);
}
