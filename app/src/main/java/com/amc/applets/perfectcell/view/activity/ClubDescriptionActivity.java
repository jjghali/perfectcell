package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClubDescriptionActivity extends AppCompatActivity {

    @Bind(R.id.club_snackbar)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.missionDescriptionTextView)
    public TextView missionDescriptionTextView;
    @Bind(R.id.logoImageView)
    public ImageView logoImageView;
    /*@Bind(R.id.needsListView)
    public ListView needListView;*/

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
        missionDescriptionTextView.setText(LoremIpsum.getInstance().getParagraphs(1, 1));

        if(clubName.toLowerCase().equals("applets"))
            logoImageView.setImageResource(ClubsIcons.Applets.getImage());
        else if(clubName.toLowerCase().equals("eclipse"))
            logoImageView.setImageResource(ClubsIcons.Conjure.getImage());
        else if(clubName.toLowerCase().equals("omer"))
            logoImageView.setImageResource(ClubsIcons.Omer.getImage());
        else if(clubName.toLowerCase().equals("rockets"))
            logoImageView.setImageResource(ClubsIcons.Rockets.getImage());
        else if(clubName.toLowerCase().equals("eclipse") || clubName.toLowerCase().equals("éclipse"))
            logoImageView.setImageResource(ClubsIcons.Eclipse.getImage());
        /*needListView.setAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, getDummyNeeds()));*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        recreate();
    }

    public ArrayList<String> getDummyNeeds(){
        ArrayList needs = new ArrayList();
        for(int i=0;i<10;i++){
            needs.add("Need "+i);
        }
        return needs;
    }

    public enum ClubsIcons{
        Applets(1,R.drawable.ic_applets),
        Conjure(2,R.drawable.ic_conjure),
        Omer(3,R.drawable.ic_omer),
        Rockets(4,R.drawable.ic_rockets),
        Eclipse(5,R.drawable.ic_eclipse);

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }

        private int value;
        private int image;
        ClubsIcons(int value, int drawableId) {
        }


    }
}
