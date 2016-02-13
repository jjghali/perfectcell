package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.amc.applets.perfectcell.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.ll_donneur)
    LinearLayout ll_donneur;

    @Bind(R.id.ll_receveur)
    LinearLayout ll_receveur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ll_donneur.setOnClickListener(this);
        ll_receveur.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.ll_donneur:
                intent = new Intent(this,MainDonneur.class);
                startActivity(intent);
                break;
            case R.id.ll_receveur:
                intent = new Intent(this,MainReceveur.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
