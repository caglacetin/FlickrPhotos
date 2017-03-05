package com.example.cagla.inspiringphotos.data.network;

import com.example.cagla.inspiringphotos.data.network.response.RecentPhotoRes;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cagla on 04/03/2017.
 */

public interface InspiringPhotoService {

    @GET("rest")
    Observable<RecentPhotoRes> getRecentPhotos(@Query("method") String serviceMethod,
                                               @Query("api_key") String apiKey,
                                               @Query("format") String format,
                                               @Query("nojsoncallback") String jsonCallback);
}
