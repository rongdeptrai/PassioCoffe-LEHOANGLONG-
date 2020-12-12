package com.hoanglong_322.passiocoffe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PassioCoffe_Fragment_Adapter_322 extends RecyclerView.Adapter<PassioCoffe_Fragment_Adapter_322.PassioCoffeOder_ViewHolder> {
    Context context;
    List<PassioCoffe_322> passioCoffe_322List;

    public PassioCoffe_Fragment_Adapter_322(Context context, List<PassioCoffe_322> passioCoffe_322List) {
        this.context = context;
        this.passioCoffe_322List = passioCoffe_322List;
    }

    @NonNull
    @Override
    public PassioCoffeOder_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.passiocoffe_iteam_322, parent, false);
        return new PassioCoffe_Fragment_Adapter_322.PassioCoffeOder_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PassioCoffeOder_ViewHolder holder, int position) {
        holder.imgCoffe_322.setImageResource(passioCoffe_322List.get(position).getImg_coffe_322());
        holder.txtNameCoffe_322.setText(passioCoffe_322List.get(position).getCoffename_322());
        holder.txtPrice_322.setText(passioCoffe_322List.get(position).getPrice_322());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Home_322_Activity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return passioCoffe_322List.size();
    }

    public static final class PassioCoffeOder_ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgCoffe_322;
        TextView txtNameCoffe_322, txtPrice_322;

        public PassioCoffeOder_ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCoffe_322 = itemView.findViewById(R.id.imagecoffe);
            txtNameCoffe_322= itemView.findViewById(R.id.txtNameCoffe);
            txtPrice_322 = itemView.findViewById(R.id.txtPrice);

        }
    }
}
