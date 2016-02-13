package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.adapter.ReceiverAdapter;
import com.amc.applets.perfectcell.model.Receiver;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

public class ReceiverListActivity extends AppCompatActivity {


    private ListView mListView;
    private TextView emptyListReceiverTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);

        setTitle(R.string.receiver_title);
        emptyListReceiverTextView = (TextView) findViewById(R.id.emptyListReceiver);
        mListView = (ListView) findViewById(R.id.receiverListView);
        mListView.setAdapter(new ReceiverAdapter(this, getDateSet()));
        mListView.setEmptyView(emptyListReceiverTextView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ReceiverListActivity.this, ReceiverProfileActivity.class);
                startActivity(i);
            }
        });


    }

    public ArrayList<Receiver> getDateSet() {
        ArrayList<Receiver> receivers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Receiver r = new Receiver(LoremIpsum.getInstance().getName(), LoremIpsum.getInstance().getParagraphs(1, 1));
            receivers.add(r);
        }
        return receivers;
    }

}
