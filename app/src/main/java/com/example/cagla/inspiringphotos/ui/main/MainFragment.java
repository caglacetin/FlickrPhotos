package com.example.cagla.inspiringphotos.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cagla.inspiringphotos.Globals;
import com.example.cagla.inspiringphotos.R;
import com.example.cagla.inspiringphotos.enums.PhotoTypes;
import com.example.cagla.inspiringphotos.service.DataManager;
import com.example.cagla.inspiringphotos.service.response.AllPhotosRes;
import com.example.cagla.inspiringphotos.ui.photo_detail.PhotoDetailActivity;
import com.example.cagla.inspiringphotos.utilities.ItemClickSupport;
import com.tapadoo.alerter.Alerter;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment implements   MainView,
                                                        MainActivity.OnChangedPhotoTypeListener{

    @BindView(R.id.gridview_all_photos)
    RecyclerView allPhotosRecyclerView;

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

        mainSwipeRefreshLayout.setColorSchemeColors(pink);
    }

    private MainPresenter mainPresenter;
    private void initMainPresenter() {
        mainPresenter = new MainPresenter(DataManager.getInstance());
        mainPresenter.attachView(this);
    }

    private void callRecentPhotoService() {
        if (mainPresenter!=null){
            mainPresenter.getAllPhotos( Globals.GET_RECENT_METHOD,
                                        Globals.API_KEY,
                                        Globals.FORMAT,
                                        Globals.NO_JSON_CALLBACK,
                                        Globals.USER_ID);
        }
    }

    private void callPopularPhotoService() {
        if (mainPresenter!=null){
            mainPresenter.getAllPhotos( Globals.GET_POPULAR_METHOD,
                                        Globals.API_KEY,
                                        Globals.FORMAT,
                                        Globals.NO_JSON_CALLBACK,
                                        Globals.USER_ID);
        }
    }

    @Override
    public void showLoading() {
        mainSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mainSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showErrorMessage() {

    }

    @Override
    public void getAllPhotoService(final AllPhotosRes allPhotosRes) {
        PhotoAdapter photoAdapter = new PhotoAdapter(allPhotosRes.allPhotos.photoList);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        glm.setOrientation(LinearLayoutManager.VERTICAL);

        allPhotosRecyclerView.setLayoutManager(glm);
        allPhotosRecyclerView.setNestedScrollingEnabled(false);
        allPhotosRecyclerView.setAdapter(photoAdapter);

        if (allPhotosRes.allPhotos.photoList.size()==0){
            Alerter.create(getActivity()).setTitle("No Photo Found!").setBackgroundColor(R.color.orange).show();
        }

        ItemClickSupport.addTo(allPhotosRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                String farmId = String.valueOf(allPhotosRes.allPhotos.photoList.get(position).photoFarm);
                String photoServerID = allPhotosRes.allPhotos.photoList.get(position).photoServer;
                String photoId = allPhotosRes.allPhotos.photoList.get(position).photoId;
                String photoSecret = allPhotosRes.allPhotos.photoList.get(position).photoSecret;
                String photoUrl = Globals.HTTP_FARM + farmId + Globals.PHOTO_STATIC_URL + photoServerID + "/" + photoId +"_"+ photoSecret + ".jpg";

                Intent intent = new Intent(getActivity(), PhotoDetailActivity.class);
                intent.putExtra(getString(R.string.photo_url_format), photoUrl);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPhotoTypeChanged(final int position) {
        if (position == PhotoTypes.RECENT_PHOTOS.getPhotoType()){
            callRecentPhotoService();
        }
        else if (position == PhotoTypes.POPULAR_PHOTOS.getPhotoType()){
            callPopularPhotoService();
        }

        mainSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (position==0){
                    callRecentPhotoService();
                }
                else if (position==1){
                    callPopularPhotoService();
                }
            }
        });
    }

}
