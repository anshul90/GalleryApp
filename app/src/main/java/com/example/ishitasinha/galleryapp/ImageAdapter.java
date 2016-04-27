package com.example.ishitasinha.galleryapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ishitasinha on 18/04/16.
 */
public class ImageAdapter extends PagerAdapter {

    Context context;
    ArrayList<String> imgUrls;

    ImageAdapter(Context context, ArrayList<String> imgUrls) {
        this.context = context;
        this.imgUrls = imgUrls;
    }

    @Override
    public int getCount() {
        return imgUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_view, container, false);
        ImageView photo = (ImageView) itemView.findViewById(R.id.photo);
        Log.v("ImgUrl", imgUrls.get(position));
        Picasso.with(context).load(imgUrls.get(position)).into(photo);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
