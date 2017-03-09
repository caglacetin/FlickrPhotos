package com.example.cagla.inspiringphotos.ui.photo_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.cagla.inspiringphotos.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PhotoDetailFragment extends Fragment {

    @BindView(R.id.photo_detail_imageview)
    ImageView photoDetailImageView;

    @BindView(R.id.photo_detail_progressbar)
    ProgressBar photoDetailProgressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_photo_detail, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        photoDetailProgressBar.setVisibility(View.VISIBLE);

        Bundle bundle = getActivity().getIntent().getExtras();
        String photoDetailUrl = bundle.getString(getString(R.string.photo_url_format));

        //TODO: zooommmmm
        Picasso.with(getContext())
                .load(photoDetailUrl)
                .into(photoDetailImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        photoDetailProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }


}


