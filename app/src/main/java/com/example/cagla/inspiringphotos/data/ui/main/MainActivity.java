package com.example.cagla.inspiringphotos.data.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cagla.inspiringphotos.R;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        attachFragment(savedInstanceState);
    }

    private void attachFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, new MainFragment())
                    .commit();
        }
    }
}
