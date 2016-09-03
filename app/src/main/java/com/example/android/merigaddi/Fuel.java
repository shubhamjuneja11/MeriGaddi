package com.example.android.merigaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Fuel extends AppCompatActivity {
ArrayList<String>al;
    int budget,fuel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);
        al=getIntent().getStringArrayListExtra("brands");
        budget=getIntent().getExtras().getInt("budget");

    }
    public void fuel(View view)
    {
        switch (view.getId()){
            case R.id.c1: fuel=1;
                break;
            case R.id.c2: fuel=2;
                break;
            case R.id.c3: fuel=3;
                break;
        }
    }
    public void result(View view){
        Intent intent=new Intent(this,Result.class);
        intent.putStringArrayListExtra("brands",al);
        intent.putExtra("budget",budget);
        intent.putExtra("fuel",fuel);
        startActivity(intent);
    }
}