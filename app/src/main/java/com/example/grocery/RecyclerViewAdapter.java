package com.example.grocery;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Product> mData;
    private Context mContext;
    static int temp_count;
    static List<Product> list = new ArrayList<>();
    List<Product> addCart = new ArrayList<>();

    public static int getTemp_count() {
        return temp_count;
    }

    public RecyclerViewAdapter() {
    }

    public RecyclerViewAdapter(List<Product> addCart,List<Product> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        this.addCart=addCart;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  final MyViewHolder holder, final int position) {

        holder.tv_product_name.setText(mData.get(position).getProduct_Name());
        holder.tv_product_price.setText(mData.get(position).getDescription());
        holder.img_product_thumbnail.setImageResource(mData.get(position).getThumbnail());


        holder.btn_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //temp_count = cartActivity.Item_Counter++ ;
                String Item_name = holder.tv_product_name.getText().toString();
                String Item_price = holder.tv_product_price.getText().toString();
                int imgRef = mData.get(position).getThumbnail();
                Product product = new Product(Item_name,Item_price,imgRef);
                addCart.add(product);
                Intent cartIntent = new Intent(mContext,cart_activity.class);
                /*if(addCart.size() > 0)
                {
                    for (int i=0; i<addCart.size(); i++)
                    {
                        Toast.makeText(mContext, ""+addCart.get(i).getProduct_Name()+" "+addCart.get(i).getDescription(), Toast.LENGTH_LONG).show();
                    }
                } */
                Toast.makeText(mContext,Item_name + " added to cart.", Toast.LENGTH_SHORT).show();
                cartIntent.putExtra("ItemName",Item_name);
                cartIntent.putExtra("ItemPrice",Item_price);
                cartIntent.putExtra("ItemImage",imgRef);
                mContext.startActivity(cartIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tv_product_name;
        ImageView img_product_thumbnail;
        TextView tv_product_price, totalItem;
        Button btn_add_cart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_product_name = (TextView)itemView.findViewById(R.id.product_name_id);
            img_product_thumbnail = (ImageView)itemView.findViewById(R.id.product_img_id);
            tv_product_price = (TextView)itemView.findViewById(R.id.product_price_id);
            btn_add_cart= (Button)itemView.findViewById(R.id.btn_add_to_cart);

           // totalItem = f
        }
    }
}
