package com.amc.applets.perfectcell;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.bt_donneur)
    Button bt_donneur;

    @Bind(R.id.bt_receveur)
    Button bt_receveur;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bt_donneur.setOnClickListener(this);
        bt_receveur.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.bt_donneur:
                intent = new Intent(this,MainDonneur.class);
                startActivity(intent);
                break;
            case R.id.bt_receveur:
                intent = new Intent(this,MainReceveur.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}
