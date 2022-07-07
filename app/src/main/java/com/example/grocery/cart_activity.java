package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class cart_activity extends AppCompatActivity {


    public static  int Item_Counter = 0;
    int ItemImage;
    Integer total;
    String itemName,itemPrice;
    static List<Product> list = new ArrayList<>() ;
    TextView totalText;
    Button orderNowBtn;
    static List<Integer> priceList = new ArrayList<>();


    RecyclerView recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_activity);

        total = 0;

       recyclerViewAdapter = findViewById(R.id.recyclerview2_id);
       totalText = findViewById(R.id.tv_order_total);
       orderNowBtn = findViewById(R.id.btn_total);

       Bundle bundel = getIntent().getExtras();

       if(bundel != null) {
           itemName = bundel.getString("ItemName");
           System.out.println(itemName);
           itemPrice = bundel.getString("ItemPrice");
           String temp = itemPrice;
           temp = temp.substring(1);
           int tempInt = parseInt(temp);

           priceList.add(tempInt);

           ItemImage = bundel.getInt("ItemImage");
           list.add(new Product(itemName,itemPrice,ItemImage));
       }
        RecyclerView myrv2 = findViewById(R.id.recyclerview2_id);
        RecyclerViewAdapter2 myAdapter=new RecyclerViewAdapter2(list,this);
        myrv2.setLayoutManager(new GridLayoutManager(this,1));
        myrv2.setAdapter(myAdapter);

        orderNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTotal(priceList);
                String tempTotal = "Total amount is ₹"+total;
                totalText.setText(tempTotal);
            }
        });


       /* Intent intent = getIntent();
       itemName= intent.getStringExtra("ItemName");
       itemPrice= intent.getStringExtra("ItemPrice");
       ItemImage= intent.getExtras().getInt("ItemImage");*/
    }

    void getTotal(List<Integer> priceList) {
        if(priceList != null) {
            for(int i=0;i<priceList.size();i++) {
                total = total + priceList.get(i);
            }
        }
    }
}
