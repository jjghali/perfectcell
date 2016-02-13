package com.amc.applets.perfectcell.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amc.applets.perfectcell.R;

public class ReceiverHistoriqueFragment extends Fragment {

    private Context mContext;


    LinearLayout mRelativeLayout;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        super.onCreate(savedInstanceState);
        // Get the application context
        mContext = getActivity();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_receiver_historique, container, false);
        mRelativeLayout = (LinearLayout) v.findViewById(R.id.rl);
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();

        for(int i=0; i<=4; i++){
            renderCardViews("Summit"+i,500*i);
        }
    }

    private void renderCardViews(String nom, double montant){
        // Initialize a new CardView
        CardView card = new CardView(mContext);

        // Set the CardView layoutParams
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10,10,10,10);
        card.setLayoutParams(params);


        // Set CardView corner radius
        card.setRadius(9);

        // Set cardView content padding
        card.setContentPadding(15, 15, 15, 15);


        /*// Set a background color for CardView
        card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));*/

                // Set the CardView maximum elevation
                //card.setMaxCardElevation(15);

                // Set CardView elevation
                card.setCardElevation(9);

        // Initialize a new TextView to put in CardView
        TextView tv_nom = new TextView(mContext);
        tv_nom.setLayoutParams(params);
        tv_nom.setText(nom +"\n"+ montant );
        tv_nom.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
        tv_nom.setTextColor(Color.BLUE);


        // Put the TextView in CardView
        card.addView(tv_nom,0);


        // Finally, add the CardView in root layout
        mRelativeLayout.addView(card);
    }


}
