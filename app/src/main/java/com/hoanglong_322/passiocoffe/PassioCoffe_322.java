package com.hoanglong_322.passiocoffe;

import android.widget.ImageView;

public class PassioCoffe_322 {
    int img_coffe_322;
String coffename_322;
String price_322;

    public PassioCoffe_322(String coffename_322, String price_322,int img_coffe_322) {
        this.coffename_322 = coffename_322;
        this.price_322 = price_322;
        this.img_coffe_322=img_coffe_322;
    }

    public String getCoffename_322() {
        return coffename_322;
    }

    public void setCoffename_322(String coffename_322) {
        this.coffename_322 = coffename_322;
    }

    public String getPrice_322() {
        return price_322;
    }

    public void setPrice_322(String price_322) {
        this.price_322 = price_322;
    }

    public int getImg_coffe_322() {
        return img_coffe_322;
    }

    public void setImg_coffe_322(int img_coffe_322) {
        this.img_coffe_322 = img_coffe_322;
    }
}
