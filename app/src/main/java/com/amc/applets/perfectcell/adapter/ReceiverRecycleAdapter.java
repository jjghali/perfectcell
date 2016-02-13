package com.amc.applets.perfectcell.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.model.Receiver;

import java.util.ArrayList;

/**
 * Created by komlan on 13/02/16.
 */
public class ReceiverRecycleAdapter extends RecyclerView.Adapter<ReceiverRecycleAdapter.ViewHolder> {
    private ArrayList<Receiver> mList;
    private int itemLayout;

    public ReceiverRecycleAdapter(ArrayList<Receiver> mList, int itemLayout) {
        this.mList = mList;
        this.itemLayout = itemLayout;
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

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public  TextView nameView;
        public TextView descriptionView;
        public ViewHolder(View itemView) {
            super(itemView);
            nameView = (TextView) itemView.findViewById(R.id.receivernameTextView);
             descriptionView = (TextView)itemView.findViewById(R.id.receiverDescriptionTextView);
        }
    }

    public void addItem(Receiver dataObj, int index) {
        mList.add(index, dataObj);
        notifyItemInserted(index);
    }

}
