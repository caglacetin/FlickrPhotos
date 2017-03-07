package com.example.cagla.inspiringphotos.data.ui.photo_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.cagla.inspiringphotos.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cagla on 06/03/2017.
 */

public class PhotoDetailFragment extends Fragment {

    @BindView(R.id.photo_detail_imageview)
    ImageView photoDetailImageView;

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
        Bundle bundle = getActivity().getIntent().getExtras();
        String photoDetailUrl = bundle.getString(getString(R.string.photo_url_format));
        Picasso.with(getContext()).load(photoDetailUrl).into(photoDetailImageView);

    }


}


