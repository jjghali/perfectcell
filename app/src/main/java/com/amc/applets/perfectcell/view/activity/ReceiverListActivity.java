package com.amc.applets.perfectcell.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.adapter.ReceiverRecycleAdapter;
import com.amc.applets.perfectcell.model.Receiver;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;

public class ReceiverListActivity extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private ReceiverRecycleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static String LOG_TAG = "CardViewActivity";
    ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.receiverList_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ReceiverRecycleAdapter(this,getDateSet(), R.layout.list_item_receiver);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }
    public ArrayList<Receiver> getDateSet(){
        ArrayList<Receiver> receivers = new ArrayList<>();

        for(int i = 0 ; i<10;i++){
            Receiver r = new Receiver(LoremIpsum.getInstance().getName(),LoremIpsum.getInstance().getParagraphs(1, 1));
            receivers.add(r);
        }
        return  receivers;
    }
}
