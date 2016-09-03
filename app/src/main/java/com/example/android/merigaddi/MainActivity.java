package com.example.android.merigaddi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread t=new Thread(){
          public void run()
          {
              try{
                  sleep(3000);
              }
              catch(Exception e){}
              finally {
                  Intent intent=new Intent(MainActivity.this,FirstPage.class);
                  startActivity(intent);
              }
          }
        };t.start();

    }
}
