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
import com.shixun.model.bean.IndexBean;


import java.util.List;

public class Rec_specialAdapter extends RecyclerView.Adapter<Rec_specialAdapter.Vh> {
    private List<IndexBean.DataBean.TopicListBean> list;
    private Context con;

    public Rec_specialAdapter(List<IndexBean.DataBean.TopicListBean> list, Context context) {

    }

    @NonNull
    @Override
    public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(con, R.layout.item_special, null);
        return new Vh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Vh holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.desc.setText(list.get(position).getSubtitle());
        holder.price.setText(list.get(position).getPrice_info()+"元起");
        Glide.with(con).load(list.get(position).getItem_pic_url()).into(holder.img);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Vh extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView desc;
        TextView price;
        public Vh(@NonNull View itemView) {
            super(itemView);
            img =  itemView.findViewById(R.id.iv_item_zhuanti_img);
            title =  itemView.findViewById(R.id.tv_item_zhuanti_title);
            desc =  itemView.findViewById(R.id.tv_item_zhuanti_desc);
            price =  itemView.findViewById(R.id.tv_item_zhuanti_price);
        }
    }
}
