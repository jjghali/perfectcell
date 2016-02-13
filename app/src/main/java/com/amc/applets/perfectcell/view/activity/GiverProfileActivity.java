package com.amc.applets.perfectcell.view.activity;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

public class GiverProfileActivity extends AppCompatActivity {

    private TextView giverNameTextView;
    private TextView giverDescriptionTextView;
    private TextView missionTextView;
    private TextView missionDescriptionTextView;
    private ListView needListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giver_profile);

        giverNameTextView = (TextView) findViewById(R.id.givernameTextView);

        giverDescriptionTextView = (TextView) findViewById(R.id.giverDescriptionTextView);

        missionTextView = (TextView) findViewById(R.id.missionTextView);

        missionDescriptionTextView = (TextView) findViewById(R.id.missionDescriptionTextView);
        missionDescriptionTextView.setText(LoremIpsum.getInstance().getParagraphs(1,1));

        needListView = (ListView) findViewById(R.id.needsListView);
        needListView.setAdapter(new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, getDummyNeeds()));

    }

    public ArrayList<String> getDummyNeeds(){
        ArrayList needs = new ArrayList();
        for(int i=0;i<10;i++){
            needs.add("Need "+i);
        }
        return needs;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
