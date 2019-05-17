package com.example.viewpagerapi.retroift;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApClient {

    private static final String BASE_URL = "http://hidayatullahmakassar.com/";
    public static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

}
