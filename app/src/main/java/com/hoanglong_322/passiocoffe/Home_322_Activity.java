package com.hoanglong_322.passiocoffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home_322_Activity extends AppCompatActivity {
    ArrayList<News_322> news_322;
    ListView listView_322;
    final Context context = this;
    ListNewsAdapter_322 adapter_322;
    List<News_322> arrayList_322= new ArrayList<News_322>();
    TextView txt_title_322,txt_ds_322,txtName_322;
    ImageButton img_order_322,img_profile_322,img_location_322;
    final String DBNAME_322="PassioCoffe.sqlite";

    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_322_);
        txtName_322=findViewById(R.id.txt_name);
        img_location_322=findViewById(R.id.location);
        img_location_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home_322_Activity.this,MapsActivity_322.class);
                startActivity(intent);
            }
        });
        final String sdt_322 =getIntent().getStringExtra("phone_number");
        sqLiteDatabase=Database.initDatabase(Home_322_Activity.this,Database.DBNAME);
        Cursor cursor=sqLiteDatabase.rawQuery("Select * from User where Phone= ? ", new String[]{sdt_322+""});
        cursor.moveToFirst();
        txtName_322.setText(cursor.getString(1));
        img_profile_322=findViewById(R.id.btn_profile);
        img_profile_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Home_322_Activity.this,ProfileActivity_322.class);
                intent.putExtra("phone_number",sdt_322);
                intent.putExtra("user_name",txtName_322.getText().toString());
                startActivity(intent);
            }
        });
        img_order_322=findViewById(R.id.img_oder);
        img_order_322.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Home_322_Activity.this,OrderActivity_322.class);
                startActivity(intent);
            }
        });

        listView_322=findViewById(R.id.listview);
        txt_title_322=findViewById(R.id.txt_tile);
        txt_ds_322=findViewById(R.id.txt_description);
        news_322= new ArrayList<News_322>();
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.greenxmas));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, dự án container PassioCoffe",R.drawable.container));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, Khai trương quán mới",R.drawable.grand));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mua 1 tặng 1",R.drawable.m11));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.cea));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.chm));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.grand));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.cea));
        news_322.add(new News_322("GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH","GEEN XMAX - GIÁNG SINH XANH, GIÁNG SINH AN LÀNH, mùa đông giáng sinh lại đến đánh dấu sự.....",R.drawable.container));
        adapter_322 =new ListNewsAdapter_322(this,R.layout.list_news_iteam_322,news_322);
        listView_322.setAdapter(adapter_322);

        listView_322.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });

         getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}