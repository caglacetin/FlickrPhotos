package com.example.cagla.inspiringphotos.data.ui.base;

/**
 * Created by cagla on 04/03/2017.
 */

public class BasePresenter<T extends MvpView> implements Presenter<T> {

    private T mvpView;

    @Override
    public void attachView(T mvpView) {
        this.mvpView = mvpView;
    }

    @Override
    public void detachView() {
        mvpView = null;
    }

    public T getMvpView() {
        return mvpView;
    }
}
