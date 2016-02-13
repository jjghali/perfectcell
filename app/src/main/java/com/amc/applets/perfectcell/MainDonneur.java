package com.amc.applets.perfectcell;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by steve on 2016-02-12.
 */
public class MainDonneur extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_donneur);
        ButterKnife.bind(this);
    }
}
