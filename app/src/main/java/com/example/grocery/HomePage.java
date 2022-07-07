package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {

    List<Product> lstItem;
    ImageView cartImg;
    TextView totalItemsTv;
    List<Product> addCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        cartImg = findViewById(R.id.cart_Img);
        //totalItemsTv = findViewById(R.id.tv_qty);
            addCart = new ArrayList<>();

        lstItem = new ArrayList<>();
        lstItem.add(new Product("Tropicana mix juice","Tropicana","₹45",R.drawable.tropica));
        lstItem.add(new Product("Hide & Seek","Parle","₹30",R.drawable.hide_seek));
        lstItem.add(new Product("Solid Masti","Balaji","₹35",R.drawable.sld));
        lstItem.add(new Product("Kurkure","Balaji","₹55",R.drawable.kurkure));
        lstItem.add(new Product("Kissan Ketchup","Kissan","₹60",R.drawable.kissan));
        lstItem.add(new Product("Lays Waffers","Lays","₹40",R.drawable.lays));
        lstItem.add(new Product("Balaji Simply Salted","Balaji","₹20",R.drawable.balaji));
        lstItem.add(new Product("Nestle Maggi","nestle","₹20",R.drawable.maggi));
        lstItem.add(new Product("SAffola gold oil","Saffola","₹260",R.drawable.saffola));
        lstItem.add(new Product("Solid Masti","Balaji","₹55",R.drawable.sld));
        lstItem.add(new Product("Dark Fantasy","ITC","₹40",R.drawable.dark));
        lstItem.add(new Product("Brinjal","Kissan","₹30",R.drawable.brinjal));
        lstItem.add(new Product("Madhur Sugar","Madhur","₹300",R.drawable.sugar));
        lstItem.add(new Product("Pedigree  ","Balaji","₹180",R.drawable.pedi));
        lstItem.add(new Product("Surf excel  ","Balaji","₹130",R.drawable.surf));
        lstItem.add(new Product("Sprite  ","Balaji","₹35",R.drawable.sprite));
        lstItem.add(new Product("5 Star chocolate  ","5","₹99",R.drawable.star));


        cartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //List<Product> list = RecyclerViewAdapter.list;
                Intent cartIntent = new Intent(HomePage.this,cart_activity.class);
                startActivity(cartIntent);
            }
        });

        RecyclerView myrv =findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter=new RecyclerViewAdapter(addCart,lstItem,this);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }


}
