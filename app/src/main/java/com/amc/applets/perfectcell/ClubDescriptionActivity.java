package com.amc.applets.perfectcell;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        Snackbar snackbar = Snackbar.make(coordinatorLayout, "", Snackbar.LENGTH_LONG);
        // Get the Snackbar's layout view
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        // Hide the text
        TextView textView = (TextView) layout.findViewById(android.support.design.R.id.snackbar_text);
        //textView.setVisibility(View.INVISIBLE);
        textView.setText(getString(R.string.club_snackbar) + " " + clubName);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        layout.setGravity(View.TEXT_ALIGNMENT_CENTER);
        layout.setClickable(true);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + clubName + "@ens.etsmtl.ca"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Aide pour le club");
                intent.putExtra(Intent.EXTRA_TEXT, "Bonjour, nous aimerions soutenir votre demarche. " +
                        "SVP Communiquer avec nous pour plus d'information.");

                startActivityForResult(Intent.createChooser(intent, "Choose an Email client:"), 1);
            }
        });
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(24);
        snackbar.setDuration(Snackbar.LENGTH_INDEFINITE).show();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recreate();
    }
}
