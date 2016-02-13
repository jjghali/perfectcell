package com.amc.applets.perfectcell;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by steve on 2016-02-12.
 */
public class MainReceveur extends AppCompatActivity{

    @Bind(R.id.snack)
    CoordinatorLayout snack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_receveur);
        ButterKnife.bind(this);
        setTitle(getString(R.string.role_receveur));
        Snackbar.make(snack,"hello world!!", Snackbar.LENGTH_SHORT).show();
    }
}
