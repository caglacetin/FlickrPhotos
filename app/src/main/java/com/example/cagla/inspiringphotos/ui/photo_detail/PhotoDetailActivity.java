package com.example.cagla.inspiringphotos.ui.photo_detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.cagla.inspiringphotos.R;

import butterknife.ButterKnife;

public class PhotoDetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ButterKnife.bind(this);
        attachFragment(savedInstanceState);
    }

    private void attachFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.photo_detail_container, new PhotoDetailFragment())
                    .commit();
        }
    }


}
