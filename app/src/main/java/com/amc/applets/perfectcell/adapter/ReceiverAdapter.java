package com.amc.applets.perfectcell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.model.Receiver;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by komlan on 13/02/16.
 */
public class ReceiverAdapter extends ArrayAdapter<Receiver> {
    private ArrayList<Receiver> mList;
    private Context mContext;
    private LayoutInflater inflater;



    public ReceiverAdapter(Context context, ArrayList<Receiver> data) {
        super(context, 0, data);
        mContext = context;
        mList = data;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Receiver getItem(int position) {
        return mList.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_receiver, null);
        }

        Receiver receiver = getItem(position);
        TextView nameView = (TextView) convertView.findViewById(R.id.receivernameTextView);
        TextView descriptionView = (TextView)convertView.findViewById(R.id.receiverDescriptionTextView);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.logoImageView);

        nameView.setText(receiver.getName());
        descriptionView.setText(receiver.getDescription());
     //   Picasso.with(mContext).load(R.drawable.logo_applets).into(imageView);

        return convertView;
    }

}

