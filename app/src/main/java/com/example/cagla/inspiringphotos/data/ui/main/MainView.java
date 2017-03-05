package com.example.cagla.inspiringphotos.data.ui.main;

import com.example.cagla.inspiringphotos.data.network.response.RecentPhotoRes;
import com.example.cagla.inspiringphotos.data.ui.base.MvpView;

/**
 * Created by cagla on 04/03/2017.
 */

public interface MainView extends MvpView{

    void showLoading();

    void hideLoading();

    void showErrorMessage();

    void bindRecentPhotoService(RecentPhotoRes recentPhotoRes);

}
