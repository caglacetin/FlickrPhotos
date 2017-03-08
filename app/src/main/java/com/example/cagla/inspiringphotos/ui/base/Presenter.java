package com.example.cagla.inspiringphotos.ui.base;


public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);
    void detachView();

}
