package com.amc.applets.perfectcell.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.amc.applets.perfectcell.ApiClient.ApiInterface;
import com.amc.applets.perfectcell.ApiClient.RestClient;
import com.amc.applets.perfectcell.R;
import com.amc.applets.perfectcell.adapter.GiverAdapter;
import com.amc.applets.perfectcell.model.Giver;
import com.amc.applets.perfectcell.model.Receiver;
import com.thedeanda.lorem.LoremIpsum;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainDonneur extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.giverListView)
    public ListView mListView;
    @Bind(R.id.emptyListGiver)
    public TextView emptyListGiverTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_donneur);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //obtain client interface instance
        ApiInterface api = RestClient.getClient();
        Call<List<Giver>> call = api.listUsers();

        //attempt http call and bind data to view
        call.enqueue(new Callback<List<Giver>>() {
            @Override
            public void onResponse(Call<List<Giver>> call, Response<List<Giver>> response) {
                if (response.isSuccess()) {

                    // request successful (status code 200, 201)
                    List<Giver> result = response.body();
                    ArrayList<Giver> users = new ArrayList<>(result);
                    ArrayList<Giver> filteredGivers = new ArrayList<>();

                    for(Giver giver : users){
                        if(giver.getTypeUsager().equals("receiver")){
                            filteredGivers.add(giver);
                        }
                    }
                    mListView.setAdapter(new GiverAdapter(MainDonneur.this, filteredGivers));
                    mListView.setEmptyView(emptyListGiverTextView);

                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors - display message for empty content
                }
            }

            @Override
            public void onFailure(Call<List<Giver>> call, Throwable t) {
                String sec = "::";
            }
        });


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent clubIntent = new Intent(MainDonneur.this, ClubDescriptionActivity.class);
                Bundle args = new Bundle();
                args.putString("clubName", "applets");
                clubIntent.putExtra("extra", args);
                startActivity(clubIntent);
            }
        });
    }

    public ArrayList<Giver> getDateSet() {
        ArrayList<Giver> givers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Giver g = new Giver(LoremIpsum.getInstance().getName(), LoremIpsum.getInstance().getParagraphs(1, 1), "giver");
            givers.add(g);
        }
        return givers;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_donneur, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.ets) {
            /*Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "applets");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);*/
        } else if (id == R.id.udem) {
            /*Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "baja");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);*/

        } else if (id == R.id.uqam) {
            /*Intent clubIntent = new Intent(this, ClubDescriptionActivity.class);
            Bundle args = new Bundle();
            args.putString("clubName", "conjure");
            clubIntent.putExtra("extra", args);
            startActivity(clubIntent);*/

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
