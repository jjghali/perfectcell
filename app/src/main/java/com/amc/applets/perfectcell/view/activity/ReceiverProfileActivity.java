package com.amc.applets.perfectcell.view.activity;

import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

public class ReceiverProfileActivity extends AppCompatActivity {

    private TextView receiverNameTextView;
    private TextView receiverDescriptionTextView;
    private TextView missionTextView;
    private TextView missionDescriptionTextView;
    private ListView needListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_profile);

        receiverNameTextView = (TextView) findViewById(R.id.receivernameTextView);

        receiverDescriptionTextView = (TextView) findViewById(R.id.receiverDescriptionTextView);

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
