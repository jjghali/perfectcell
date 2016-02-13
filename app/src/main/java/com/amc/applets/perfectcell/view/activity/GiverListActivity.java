package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.adapter.GiverAdapter;
import com.amc.applets.perfectcell.adapter.ReceiverAdapter;
import com.amc.applets.perfectcell.model.Giver;
import com.amc.applets.perfectcell.model.Receiver;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

public class GiverListActivity extends AppCompatActivity {


    private ListView mListView;
    private TextView emptyListGiverTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giver_list);

        setTitle(R.string.givers_title);
        emptyListGiverTextView = (TextView) findViewById(R.id.emptyListGiver);
        mListView = (ListView) findViewById(R.id.giverListView);
        mListView.setAdapter(new GiverAdapter(this, getDateSet()));
        mListView.setEmptyView(emptyListGiverTextView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(GiverListActivity.this, ReceiverProfileActivity.class);
                startActivity(i);
            }
        });


    }

    public ArrayList<Giver> getDateSet() {
        ArrayList<Giver> givers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Giver g = new Giver(LoremIpsum.getInstance().getName(), LoremIpsum.getInstance().getParagraphs(1, 1));
            givers.add(g);
        }
        return givers;
    }

}
