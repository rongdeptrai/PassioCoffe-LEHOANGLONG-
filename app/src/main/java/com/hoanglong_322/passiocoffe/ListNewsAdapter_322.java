package com.hoanglong_322.passiocoffe;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ListNewsAdapter_322 extends ArrayAdapter {
    Activity activity_322;
    int row_layout_322;
    ArrayList<News_322> news_322;
    public ListNewsAdapter_322(@NonNull Activity activity, int row_layout, @NonNull ArrayList<News_322> news_322) {
        super(activity, row_layout, news_322);
        this.activity_322=activity;
        this.row_layout_322=row_layout;
        this.news_322=news_322;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=activity_322.getLayoutInflater();
        convertView=layoutInflater.inflate(row_layout_322,null);
        ImageView avata=(ImageView) convertView.findViewById(R.id.img_news);
        TextView title=(TextView) convertView.findViewById(R.id.txt_tile);
        TextView des=(TextView) convertView.findViewById(R.id.txt_description) ;
        avata.setImageResource(news_322.get(position).getImage_322());
        des.setText(news_322.get(position).getDesciption_322());
        title.setText(news_322.get(position).getTitle_322());
        return convertView;
    }

}
