package com.hoanglong_322.passiocoffe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class OrderActivity_322 extends AppCompatActivity {
    TabLayout tabLayout_322;
    ViewPager viewPager_322;
    Order_Fragment_Adapter_322 adapter_322;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_322);

        tabLayout_322 = findViewById(R.id.tabLayout);
        viewPager_322 = findViewById(R.id.viewPager);
        adapter_322= new Order_Fragment_Adapter_322(getSupportFragmentManager());
        //add
        adapter_322.AddFragment(new PassioCoffe_Fragment_322(),"Green xmas");
        adapter_322.AddFragment(new PassioCoffe_Fragment_322(),"Ice blended");
        adapter_322.AddFragment(new PassioCoffe_Fragment_322(),"Tea/soda");
        adapter_322.AddFragment(new PassioCoffe_Fragment_322(),"Passio coffe");
        adapter_322.AddFragment(new PassioCoffe_Fragment_322(),"Fresh & easy");
        tabLayout_322.setupWithViewPager(viewPager_322);
        viewPager_322.setAdapter(adapter_322);
    }
}