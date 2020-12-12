package com.hoanglong_322.passiocoffe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter_322 extends BaseAdapter {
    private Context context;
    private List<User_322> user_322List;

    public UserAdapter_322(Context context, List<User_322> user_322List) {
        this.context = context;
        this.user_322List = user_322List;
    }

    @Override
    public int getCount() {
        return user_322List.size();
    }

    @Override
    public Object getItem(int position) {
        return user_322List.get(position);
    }

    @Override
    public long getItemId(int position) {
        return user_322List.get(position).getId_322();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.activity_profile_322,null);
        TextView fullname=(TextView)v.findViewById(R.id.txtFullName);
        TextView phone=(TextView)v.findViewById(R.id.txt_phoneNub);
        fullname.setText(user_322List.get(position).getFullName_322());
        phone.setText(user_322List.get(position).getPhone_322());
        return  v;
    }
}
