package com.example.cagla.inspiringphotos.ui.main;


import com.example.cagla.inspiringphotos.service.response.RecentPhotoRes;
import com.example.cagla.inspiringphotos.ui.base.MvpView;

public interface MainView extends MvpView {

    void showLoading();

    void hideLoading();

    void showErrorMessage();

    void bindRecentPhotoService(RecentPhotoRes recentPhotoRes);

}
