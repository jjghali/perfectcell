package com.amc.applets.perfectcell.ApiClient;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Yves on 2/13/2016.
 * Provide a static method to create the client API interface.
 */
public class RestClient {

    private static ApiInterface apiInterface ;

    /**
     * Define API Base URL
     */
    private final static String apiUrl = "http://159.203.31.79:8080";

    /**
     * Return an instance of the API access interface for calling endpoints.
     * @return Interface granting access to api methods as defined in ApiInterface.
     */
    public static ApiInterface getClient() {
        if (apiInterface == null) {

            //Instanciate api client
            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            //Instanciate retrofit instance with JSON object converter. (GSON based)
            Retrofit client = new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            apiInterface = client.create(ApiInterface.class);
        }
        return apiInterface;
    }
}
