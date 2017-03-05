package com.example.cagla.inspiringphotos.data.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cagla.inspiringphotos.R;
import com.example.cagla.inspiringphotos.data.Globals;
import com.example.cagla.inspiringphotos.data.network.DataManager;
import com.example.cagla.inspiringphotos.data.network.response.RecentPhotoRes;
import com.squareup.picasso.Picasso;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by cagla on 05/03/2017.
 */

public class MainFragment extends Fragment implements MainView, SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.stat_text)
    TextView textviewStat;

    @BindView(R.id.gridview_recent_photos)
    RecyclerView recentPhotosRecyclerView;

    @BindView(R.id.swipe_refresh_layout_main)
    SwipeRefreshLayout mainSwipeRefreshLayout;

    @BindColor(R.color.colorAccent)
    int pink;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initMainPresenter();
        callRecentPhotoService();

        mainSwipeRefreshLayout.setOnRefreshListener(this);
        mainSwipeRefreshLayout.setColorSchemeColors(pink);
    }

    private MainPresenter mainPresenter;
    private void initMainPresenter() {
        mainPresenter = new MainPresenter(DataManager.getInstance());
        mainPresenter.attachView(this);
    }

    private void callRecentPhotoService() {
        if (mainPresenter!=null){
            mainPresenter.getRecentPhotos(Globals.SERVICE_METHOD, Globals.API_KEY, Globals.FORMAT, Globals.NO_JSON_CALLBACK);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {
        mainSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void bindRecentPhotoService(RecentPhotoRes recentPhotoRes) {
        textviewStat.setText(recentPhotoRes.stat);

        PhotoAdapter photoAdapter = new PhotoAdapter(recentPhotoRes.recentPhotos.recentPhotos);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        recentPhotosRecyclerView.setLayoutManager(glm);
        recentPhotosRecyclerView.setNestedScrollingEnabled(false);
        recentPhotosRecyclerView.setAdapter(photoAdapter);
    }

    @Override
    public void onRefresh() {
        callRecentPhotoService();
    }
}
