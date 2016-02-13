package com.amc.applets.perfectcell.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.model.Giver;
import com.amc.applets.perfectcell.model.Receiver;

import java.util.ArrayList;

/**
 * Created by komlan on 13/02/16.
 */
public class GiverAdapter extends ArrayAdapter<Giver> {
    private ArrayList<Giver> mList;
    private Context mContext;
    private LayoutInflater inflater;



    public GiverAdapter(Context context, ArrayList<Giver> data) {
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
    public Giver getItem(int position) {
        return mList.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_giver, null);
        }

        Giver giver = getItem(position);
        TextView nameView = (TextView) convertView.findViewById(R.id.givernameTextView);
        TextView descriptionView = (TextView)convertView.findViewById(R.id.giverDescriptionTextView);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.logoImageView);

        nameView.setText(giver.getName());
        descriptionView.setText(giver.getDescription());
     //   Picasso.with(mContext).load(R.drawable.logo_applets).into(imageView);

        return convertView;
    }

}

