package com.example.android.merigaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;


import java.util.ArrayList;

public class Brands extends AppCompatActivity {
    ArrayList<String> al;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brands);
        al=new ArrayList<>();
    }
    public void budget(View view)
    {
        Intent intent=new Intent(this,Budget.class);
       // Toast.makeText(this,"0",Toast.LENGTH_LONG).show();
        checkstatus();
        intent.putStringArrayListExtra("brands",al);
        startActivity(intent);
    }
    public void checkstatus(){
       CheckBox c=(CheckBox)findViewById(R.id.checkBox);
        if(c.isChecked())
        { al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox2);
        if(c.isChecked())
        { al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox3);
        if(c.isChecked())
        {  al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox4);
        if(c.isChecked())
        { al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox5);
        if(c.isChecked())
        {  al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox6);
        if(c.isChecked())
        {    al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox7);
        if(c.isChecked())
        {  al.add(c.getText().toString());}
        c=(CheckBox)findViewById(R.id.checkBox8);
        if(c.isChecked())
        { al.add(c.getText().toString());}
    }
    /*public void checked(View view){
        boolean check=((CheckBox)view).isChecked();
        if(check)
        {
            switch(view.getId()){
                case R.id.checkBox: brand="Maruti";
                                    break;
                case R.id.checkBox2: brand="Hyundai";
                    break;
                case R.id.checkBox3: brand="Toyota";
                    break;
                case R.id.checkBox4: brand="Tata";
                    break;
                case R.id.checkBox5: brand="BMW";
                    break;
                case R.id.checkBox6: brand="Mercedes";
                    break;
                case R.id.checkBox7: brand="Honda";
                    break;
                case R.id.checkBox8: brand="Chevrolet";
                    break;
            }
        }
    }*/
}
