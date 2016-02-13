package com.amc.applets.perfectcell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClubDescriptionActivity extends AppCompatActivity {

    @Bind(R.id.club_snackbar)
    CoordinatorLayout coordinatorLayout;

    String clubName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_description);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras().getBundle("extra");
        if(extras == null)
            return;
        clubName = extras.getString("clubName");
        setTitle(clubName);

        Snackbar.make(coordinatorLayout, getResources().getString(R.string.club_snackbar) + " " + clubName, Snackbar.LENGTH_INDEFINITE)
                .setAction("Envoyer courriel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_SENDTO);
                        intent.setData(Uri.parse("mailto:" + clubName + "@ens.etsmtl.ca"));
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Aide pour le club");
                        intent.putExtra(Intent.EXTRA_TEXT, "Bonjour, nous aimerions soutenir votre demarche. " +
                                "SVP Comuniquer avec nous pour plus d'information.");

                        startActivityForResult(Intent.createChooser(intent, "Choose an Email client:"), 1);
                    }
                })
                .show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recreate();
    }
}
