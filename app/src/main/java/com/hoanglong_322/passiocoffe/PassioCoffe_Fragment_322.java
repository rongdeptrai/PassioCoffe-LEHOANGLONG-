package com.hoanglong_322.passiocoffe;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PassioCoffe_Fragment_322 extends Fragment {
    View v;
    private Context context_322;
    private RecyclerView recyclerView_322;
    private List<PassioCoffe_322> list_322;
    SQLiteDatabase sqLiteDatabase;
    public PassioCoffe_Fragment_322(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.passiocoffe_list_322, container, false);
        recyclerView_322=v.findViewById(R.id.recyclerview_passiocoffe);
        PassioCoffe_Fragment_Adapter_322 adapter=  new PassioCoffe_Fragment_Adapter_322(getContext(),list_322);
        recyclerView_322.setLayoutManager( new GridLayoutManager(getActivity(),2));
        recyclerView_322.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list_322= new ArrayList<>();
        list_322.add(new PassioCoffe_322("Iced Espresso","40.000 đ",R.drawable.ice_espresso));
        list_322.add(new PassioCoffe_322("Passio Capuccino","40.000 đ",R.drawable.xmascofee  ));
        list_322.add(new PassioCoffe_322("Passio Choco","40.000 đ",R.drawable.choco));
        list_322.add(new PassioCoffe_322("Bạc Xỉu","40.000 đ",R.drawable.bacxiu));
        list_322.add(new PassioCoffe_322("Cream Choco","40.000 đ",R.drawable.caramel));
        list_322.add(new PassioCoffe_322("Passio Caramel","40.000 đ",R.drawable.ice_espresso));
        list_322.add(new PassioCoffe_322("Iced ChocoLate","40.000 đ",R.drawable.caramel));
        list_322.add(new PassioCoffe_322("Iced Capuccino","40.000 đ",R.drawable.macha));
        list_322.add(new PassioCoffe_322("Iced Cafe mocha","40.000 đ",R.drawable.ice_espresso));
        list_322.add(new PassioCoffe_322("Iced whiteCoffe","40.000 đ",R.drawable.icechocolate));
        list_322.add(new PassioCoffe_322("Iced Espresso","40.000 đ",R.drawable.caramel));
    }



}
