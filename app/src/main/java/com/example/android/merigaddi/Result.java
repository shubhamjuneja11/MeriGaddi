package com.example.android.merigaddi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {
String brands[];
    String query;
    ArrayList<String>al;
    int fuel,budget;
    double pricel=0,priceh=100;
    SQLiteOpenHelper database;
    SQLiteDatabase db;
    ListView lv;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        al=intent.getStringArrayListExtra("brands");
        fuel=intent.getExtras().getInt("fuel");
        budget=intent.getExtras().getInt("budget");
        switch (budget){
            case 1:pricel=0;priceh=5;
                break;
            case 2:pricel=5;priceh=10;
                break;
            case 3:pricel=10;priceh=15;
                break;
            case 4:pricel=15;priceh=20;
                break;
            case 5:pricel=20;priceh=100;
                break;
        }
        al.add(Double.toString(pricel));      al.add(Double.toString(priceh));
        al.add(Integer.toString(fuel));
        brands=new String[al.size()];
        brands=al.toArray(brands);
        database =new Database(this);
        db=database.getReadableDatabase();
        query="SELECT _id,Model FROM Cars WHERE Brand IN("+makePlaceholders(al.size()-3)+ ") AND Price>=? AND Price<=? AND Fuel>=?";
         cursor=db.rawQuery(query,brands);
           lv=(ListView)findViewById(R.id.listView);
        CursorAdapter listadapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{"Model"},new int[]{android.R.id.text1},0);
        lv.setAdapter(listadapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /****************************  LOOK   AT  THIS  YOU  MIRACLE  BOY********************************/
              Cursor cursor1=(Cursor)lv.getItemAtPosition(position);
              String s=cursor1.getString(1);
                Intent intent=new Intent(Result.this,FinalResult.class);
                intent.putExtra("key",s);
                startActivity(intent);
            }
        });
        /*  brands=new String[al.size()];              Brand IN ("+makePlaceholders(al.size())+") AND Fuel=? AND
        brands=al.toArray(brands);//Arraylist  to  String  array
        String brand[]=new String[al.size()+2];
        brands[al.size()]=Double.toString(pricel);
        brands[al.size()+1]=Double.toString(priceh);*/
       // Cursor cursor=db.query("Cars",new String[]{"Brand","Model"},"Fuel<=? AND Price<=? AND Brand=?",new String[]{Integer.toString(fuel),Integer.toString(budget),},)
        // query="SELECT Brand,Model FROM Cars WHERE Fuel=fuel AND Price<=priceh AND Price>=pricel AND Brand IN("+makePlaceholders(brands.length)+")" ;
        // Cursor cursor=db.rawQuery(query,brands);

/*query="SELECT * FROM Cars ";
        Cursor cursor=db.rawQuery(query,null);
            if (cursor.moveToFirst())
            { String s=cursor.getString(2);
            TextView textView = (TextView) findViewById(R.id.tv);
            textView.setText(s);}*/

        //Setting layout
        /*ListView lv=(ListView)findViewById(R.id.listView);
        CursorAdapter listadapter=new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{"Model"},new int[]{android.R.id.text1},0);
        lv.setAdapter(listadapter);*/
        /*
        Cursor cursor=db.rawQuery(query,brands);
        String s=cursor.getString(2);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(s);*/


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();
    }

    String makePlaceholders(int len) {
        if (len < 1) {
            // It will lead to an invalid query anyway ..
            throw new RuntimeException("No placeholders");
        } else {
            StringBuilder sb = new StringBuilder(len * 2 - 1);
            sb.append("?");
            for (int i = 1; i < len; i++) {
                sb.append(",?");
            }
            return sb.toString();
        }
    }

}
