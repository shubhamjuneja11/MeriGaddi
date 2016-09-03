package com.example.android.merigaddi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Budget extends AppCompatActivity {
ArrayList<String>al;
    int budget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        al=getIntent().getStringArrayListExtra("brands");
        setContentView(R.layout.activity_budget);
        /*int t=al.size();
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setText(Integer.toString(t));*/
        RadioGroup radioGroup=(RadioGroup)findViewById(R.id.rg);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
             switch(checkedId){
                 case R.id.r1: budget=1;
                        break;
                 case R.id.r2: budget=2;
                     break;
                 case R.id.r3: budget=3;
                     break;
                 case R.id.r4: budget=4;
                     break;
                 case R.id.r5: budget=5;
                     break;

             }
            }
        });


    }
    public void fuel(View view)
    {
        Intent intent=new Intent(this,Fuel.class);
       intent.putStringArrayListExtra("brands",al);
        intent.putExtra("budget",budget);
        startActivity(intent);
    }

}
