package com.example.android.merigaddi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Compare extends AppCompatActivity {
Spinner sp1,sp2;
    public static String cars[]={"Alto 800","Wagon R","Ciaz","i20","Verna","EON","Innova","Corolla","Etios","Tiago","Nano","Aria",
            "X1","1 Series","3 Series","Benz A class","Benz CLA",
            "City", "Jazz", "Amaze","Spark","Beat","Cruze"};

    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        sp1=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,cars);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);
    }
    public void compare_result(View view){
        String s,r;
                r=sp1.getSelectedItem().toString();
                s=sp2.getSelectedItem().toString();
        Intent intent=new Intent(this,CompareResult.class);
        intent.putExtra("a",r);
        intent.putExtra("b",s);
        startActivity(intent);
    }
}
