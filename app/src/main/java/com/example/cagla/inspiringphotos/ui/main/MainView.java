package com.example.cagla.inspiringphotos.ui.main;


import com.example.cagla.inspiringphotos.service.response.AllPhotosRes;
import com.example.cagla.inspiringphotos.ui.base.MvpView;

public interface MainView extends MvpView {

    void showLoading();

    void hideLoading();

    void showErrorMessage();

    void getAllPhotoService(AllPhotosRes allPhotosRes);

}
