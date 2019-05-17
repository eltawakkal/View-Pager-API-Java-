package com.example.viewpagerapi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.viewpagerapi.retroift.ImgModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VPagerAdapter extends PagerAdapter {

    Context context;
    List<ImgModel> listImg;

    public VPagerAdapter(Context context, List<ImgModel> listImg) {
        this.context = context;
        this.listImg = listImg;
    }

    @Override
    public int getCount() {
        return listImg.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        Picasso.get()
                .load(listImg.get(position).getImg())
                .fit()
                .centerCrop()
                .into(imageView);

        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
