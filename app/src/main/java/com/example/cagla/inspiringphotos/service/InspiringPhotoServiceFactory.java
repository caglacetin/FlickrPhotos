package com.example.cagla.inspiringphotos.service;

import android.support.annotation.NonNull;
import android.support.compat.BuildConfig;

import com.example.cagla.inspiringphotos.Globals;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InspiringPhotoServiceFactory {

    public static InspiringPhotoService makeServiceConnection() {
        OkHttpClient okHttpClient = makeOkHttpClient(makeLoggingInterceptor());
        return makeServiceConnection(okHttpClient);
    }

    public static InspiringPhotoService makeServiceConnection(@NonNull OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Globals.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        return retrofit.create(InspiringPhotoService.class);
    }

    public static OkHttpClient makeOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @NonNull
    public static HttpLoggingInterceptor makeLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return logging;
    }
}
