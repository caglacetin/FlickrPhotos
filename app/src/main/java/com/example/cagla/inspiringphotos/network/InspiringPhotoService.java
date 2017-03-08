package com.example.cagla.inspiringphotos.network;


import com.example.cagla.inspiringphotos.network.response.RecentPhotoRes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface InspiringPhotoService {

    @GET("rest")
    Observable<RecentPhotoRes> getRecentPhotos(@Query("method") String serviceMethod,
                                               @Query("api_key") String apiKey,
                                               @Query("format") String format,
                                               @Query("nojsoncallback") String jsonCallback);
}
