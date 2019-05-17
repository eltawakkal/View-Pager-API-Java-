package com.example.viewpagerapi.retroift;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("rpld/xample-img.php")
    Call<List<ImgModel>> getImages();

}
