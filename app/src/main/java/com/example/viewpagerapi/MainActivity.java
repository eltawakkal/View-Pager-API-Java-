package com.example.viewpagerapi;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.viewpagerapi.adapter.VPagerAdapter;
import com.example.viewpagerapi.retroift.ApClient;
import com.example.viewpagerapi.retroift.ApiInterface;
import com.example.viewpagerapi.retroift.ImgModel;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ViewPager pagerImage;
    List<ImgModel> listImg;

    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerImage = findViewById(R.id.pager_img);

        apiInterface = ApClient.getRetrofit().create(ApiInterface.class);

        Call<List<ImgModel>> callImage = apiInterface.getImages();
        callImage.enqueue(new Callback<List<ImgModel>>() {
            @Override
            public void onResponse(Call<List<ImgModel>> call, Response<List<ImgModel>> response) {
                listImg = new ArrayList<>();

                listImg = response.body();

                setimageToViewPager(listImg);

                Toast.makeText(MainActivity.this, "ImgUrl: " + listImg.size(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<ImgModel>> call, Throwable t) {
                Log.d("gagal", "Error: " + t.toString());
            }
        });

    }

    private void setimageToViewPager(List<ImgModel> listImg) {
        VPagerAdapter adapter = new VPagerAdapter(this, listImg);

        pagerImage.setAdapter(adapter);
    }
}
