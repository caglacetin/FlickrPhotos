package com.example.cagla.inspiringphotos.data.ui.main;

import com.example.cagla.inspiringphotos.data.network.DataManager;
import com.example.cagla.inspiringphotos.data.network.response.RecentPhotoRes;
import com.example.cagla.inspiringphotos.data.ui.base.BasePresenter;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by cagla on 04/03/2017.
 */

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

    public void getRecentPhotos(String serviceMethod, String apiKey, String format, String jsonCallback){
        getMvpView().showLoading();
        subscription = dataManager.recentPhotosService(serviceMethod, apiKey, format, jsonCallback)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<RecentPhotoRes>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().hideLoading();
                        getMvpView().showErrorMessage();
                    }

                    @Override
                    public void onNext(RecentPhotoRes recentPhotoRes) {
                        getMvpView().hideLoading();
                        if (recentPhotoRes!=null){
                            getMvpView().bindRecentPhotoService(recentPhotoRes);
                        }
                        else {
                            getMvpView().showErrorMessage();
                        }
                    }
                });
    }
}
