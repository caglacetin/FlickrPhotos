package com.example.cagla.inspiringphotos.ui.main;

import com.example.cagla.inspiringphotos.service.DataManager;
import com.example.cagla.inspiringphotos.service.response.AllPhotosRes;
import com.example.cagla.inspiringphotos.ui.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainView> {

    private DataManager dataManager;
    private Subscription subscription;

    public MainPresenter(DataManager dataManager){
        this.dataManager = dataManager;
    }

    @Override
    public void attachView(MainView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (subscription!=null){
            subscription.unsubscribe();
        }
    }

    public void getAllPhotos(String serviceMethod, String apiKey, String format, String jsonCallback, String userId){
        getMvpView().showLoading();
        subscription = dataManager.bindPhotosService(serviceMethod, apiKey, format, jsonCallback, userId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AllPhotosRes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().hideLoading();
                        getMvpView().showErrorMessage();
                    }

                    @Override
                    public void onNext(AllPhotosRes recentPhotoRes) {
                        getMvpView().hideLoading();
                        if (recentPhotoRes!=null
                                && recentPhotoRes.allPhotos!=null
                                && recentPhotoRes.allPhotos.photoList!=null){
                            getMvpView().getAllPhotoService(recentPhotoRes);
                        }
                        else {
                            getMvpView().showErrorMessage();
                        }
                    }
                });
    }
}
