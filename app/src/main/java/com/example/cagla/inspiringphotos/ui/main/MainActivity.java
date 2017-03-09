package com.example.cagla.inspiringphotos.ui.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.cagla.inspiringphotos.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.spinner_photo_type)
    Spinner photoTypeSpinner;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attachFragment(savedInstanceState);
        ButterKnife.bind(this);

        setSpinner();
        setToolbar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
    }

    private void attachFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new MainFragment())
                    .commit();
        }
    }

    private void setSpinner() {
        photoTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onPhotoTypeChanged(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    OnChangedPhotoTypeListener mCallback;
    public interface OnChangedPhotoTypeListener{
        void onPhotoTypeChanged(int position);

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        try {
            mCallback = (OnChangedPhotoTypeListener) fragment;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(fragment.toString()
                    + " must implement OnChangedPhotoTypeListener");
        }
    }
}
