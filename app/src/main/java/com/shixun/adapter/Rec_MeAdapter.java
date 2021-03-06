package com.shixun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.shixun.R;
import com.shixun.model.bean.MeBean;


import java.util.ArrayList;

public class Rec_MeAdapter extends RecyclerView.Adapter<Rec_MeAdapter.Vh> {
    private ArrayList<MeBean> list;
    private Context con;

    public Rec_MeAdapter(ArrayList<MeBean> list, Context con) {
        this.list = list;
        this.con = con;
    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(con, R.layout.item_own, null);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.tv.setText(list.get(position).getText());
        Glide.with(con).load(list.get(position).getImgpath()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tv;
        public Vh(@NonNull View itemView) {
            super(itemView);
           img = itemView.findViewById(R.id.iv_me_item);
           tv = itemView.findViewById(R.id.tv_me_item_text);
        }
    }
}
