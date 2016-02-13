package com.amc.applets.perfectcell.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.model.Receiver;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by komlan on 13/02/16.
 */
public class ReceiverRecycleAdapter extends RecyclerView.Adapter<ReceiverRecycleAdapter.ViewHolder> {
    private ArrayList<Receiver> mList;
    private int itemLayout;
    private Context context;

    public ReceiverRecycleAdapter(Context context,ArrayList<Receiver> mList, int itemLayout) {
        this.mList = mList;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Receiver receiver = mList.get(position);
        holder.nameView.setText(receiver.getName());
        holder.descriptionView.setText(receiver.getDescription());
        Picasso.with(context).load(R.drawable.logo_applets).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public  TextView nameView;
        public TextView descriptionView;
        public ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.receivernameTextView);
             descriptionView = (TextView)itemView.findViewById(R.id.receiverDescriptionTextView);
            imageView = (ImageView)itemView.findViewById(R.id.logoImageView);
        }
    }

    public void addItem(Receiver dataObj, int index) {
        mList.add(index, dataObj);
        notifyItemInserted(index);
    }

}
