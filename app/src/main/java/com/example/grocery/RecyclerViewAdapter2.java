package com.example.grocery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.MyViewHolder1> {

        private List<Product> mData;
        private Context mContext;



        public RecyclerViewAdapter2(List<Product> mData, Context mContext) {
            this.mData = mData;
            this.mContext = mContext;
        }


    @NonNull
    @Override
    public MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(mContext).inflate(R.layout.cardview_cart_item,parent,false);
            return new MyViewHolder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        holder.tv_product_name.setText(mData.get(position).getProduct_Name());
        holder.tv_product_price.setText(mData.get(position).getDescription());
        holder.img_product_thumbnail.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
        public int getItemCount() {
            return mData.size();
        }

        public static class MyViewHolder1 extends RecyclerView.ViewHolder
        {
            public TextView tv_product_name;
            public ImageView img_product_thumbnail;
            public TextView tv_product_price;

            public MyViewHolder1(@NonNull View itemView) {
                super(itemView);
                tv_product_name = (TextView)itemView.findViewById(R.id.tv_cart_product_name);
                img_product_thumbnail = (ImageView)itemView.findViewById(R.id.img_cart_product);
                tv_product_price = (TextView)itemView.findViewById(R.id.tv_cart_product_price);
            }
        }
    }


