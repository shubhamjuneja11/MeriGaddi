package com.example.android.merigaddi;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class FirstPage extends AppCompatActivity {
    ArrayAdapter<String>adapter;
    String cars[]={"Alto 800","Wagon R","Ciaz","i20","Verna","EON","Innova","Corolla","Etios","Tiago","Nano","Aria",
                    "X1","1 Series","3 Series","Benz A class","Benz CLA",
                    "City", "Jazz", "Amaze","Spark","Beat","Cruze"};
    String a;
    AutoCompleteTextView at;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
       at=(AutoCompleteTextView)findViewById(R.id.editText);
        adapter=new ArrayAdapter<String>(this,android.R.layout.select_dialog_item,cars);
        at.setAdapter(adapter);
        at.setThreshold(1);

    }
    public void find(View view){
        Intent intent=new Intent(this,Brands.class);
        startActivity(intent);
    }
    public void compare(View view)
    {
        Intent intent=new Intent(this,Compare.class);
        startActivity(intent);
    }
    public void search(View view){
        Intent intent=new Intent(this,FinalResult.class);
        a=at.getText().toString();
        intent.putExtra("key",a);
        startActivity(intent);
    }
}
