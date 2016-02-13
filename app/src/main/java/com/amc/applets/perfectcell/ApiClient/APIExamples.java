package com.amc.applets.perfectcell.ApiClient;

import com.amc.applets.perfectcell.model.Receiver;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Yves on 2/13/2016.
 * it will not be possible to implement data access as a class with static methods due to the way
 * the onResponse method for retrofit callbacks needs to be implemented. We will need to implement these
 * calls in the activity's onCreate method and update the content with an adapter.
 */
public class APIExamples {

    /**
     * Code used to obtain data and insert in view.
     * Example available @
     * https://github.com/ayon115/Retrofit2.0Sample/blob/master/app/src/main/java/com/iayon/retrofit20tutorial/MainActivity.java
     */
    public void getReceiversExample() {

        //obtain client interface instance
        ApiInterface api = RestClient.getClient();

        //instanciate call
        Call<List<Receiver>> call = api.getReceivers();

        //attempt http call and bind data to view
        call.enqueue(new Callback<List<Receiver>>() {
            @Override
            public void onResponse(Call<List<Receiver>> call, Response<List<Receiver>> response) {
                if (response.isSuccess()) {

                    // request successful (status code 200, 201)
                    List<Receiver> result = response.body();

                    //Use code similar to the following to set content from response into view via adapter.
                    //retrieve items from api model and inject in view.
                    //Commented in example since can't actually bind data to view.

                    //adapter = new ReceiversAdapter(MainActivity.this, receivers);
                    //listView.setAdapter(adapter);

                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors - display message for empty content
                }
            }

            @Override
            public void onFailure(Call<List<Receiver>> call, Throwable t) {

            }
        });
    }
}
