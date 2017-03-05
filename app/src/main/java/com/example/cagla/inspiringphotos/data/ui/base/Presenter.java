package com.example.cagla.inspiringphotos.data.ui.base;

import android.view.View;

/**
 * Created by cagla on 04/03/2017.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);
    void detachView();

}
