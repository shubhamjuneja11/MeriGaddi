package com.example.android.merigaddi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CompareResult extends AppCompatActivity {
    String  query,fish,a,b,fish1;
    SQLiteDatabase db;
    SQLiteOpenHelper database;
    String brand1,brand2;
    int fuel1,fuel2, engine1,engine2, image1,image2, star1,star2;
    double price1,price2, mileage1,mileage2;
    Cursor cursor,cursor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_result);
        a=getIntent().getExtras().getString("a");
        b=getIntent().getExtras().getString("b");
        database = new Database(this);
        db = database.getReadableDatabase();
        query = "Select * FROM Cars WHERE Model=?";
        cursor = db.rawQuery(query, new String[]{a});
        cursor2=db.rawQuery(query,new String[]{b});
        if (cursor.moveToFirst())
            brand1 = cursor.getString(cursor.getColumnIndex("Brand"));
        if (cursor.moveToFirst())
            fuel1 = cursor.getInt(cursor.getColumnIndex("Fuel"));
        if (cursor.moveToFirst())
            engine1 = cursor.getInt(cursor.getColumnIndex("Engine"));
        if (cursor.moveToFirst())
            image1 = cursor.getInt(cursor.getColumnIndex("Image"));
        if (cursor.moveToFirst())
            price1 = cursor.getDouble(cursor.getColumnIndex("Price"));
        if (cursor.moveToFirst())
            mileage1 = cursor.getDouble(cursor.getColumnIndex("Mileage"));
        if (cursor.moveToFirst())
            star1 = cursor.getInt(cursor.getColumnIndex("Star"));
       if(cursor2.moveToFirst())
           brand2 = cursor2.getString(cursor2.getColumnIndex("Brand"));
        if(cursor2.moveToFirst())
        fuel2 = cursor2.getInt(cursor2.getColumnIndex("Fuel"));
        if(cursor2.moveToFirst())
        engine2 = cursor2.getInt(cursor2.getColumnIndex("Engine"));
        if(cursor2.moveToFirst())
        image2 = cursor2.getInt(cursor2.getColumnIndex("Image"));
        if (cursor2.moveToFirst())
        price2 = cursor2.getDouble(cursor2.getColumnIndex("Price"));
        if (cursor2.moveToFirst())
        mileage2 = cursor2.getDouble(cursor2.getColumnIndex("Mileage"));
        if (cursor2.moveToFirst())
        star2 = cursor2.getInt(cursor2.getColumnIndex("Star"));
        seteverything();
        seteverything2();
    }

    private void seteverything2() {
        TextView tv1, tv2, tv3, tv4, tv5;
        ImageView iv;
        RatingBar bar;
       /* TextView temp=(TextView)findViewById(R.id.temp);
        temp.setText(res);*/
        tv1 = (TextView) findViewById(R.id.brand2);
        tv2 = (TextView) findViewById(R.id.TextView3);
        tv3 = (TextView) findViewById(R.id.fuel2);
        tv4 = (TextView) findViewById(R.id.mileage2);
        tv5 = (TextView) findViewById(R.id.engine2);
        iv = (ImageView) findViewById(R.id.image2);
        bar = (RatingBar) findViewById(R.id.ratingBar3);
        Drawable progress = bar.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.RED);
        fish1=brand2+ " "+b;
        try {
            iv.setImageResource(image2);
            tv1.setText(brand2 + " "+b);
            tv2.setText(Double.toString(price2)+" lacs ");
            if(fuel2==3)
                tv3.setText("Petrol,Diesel,CNG");
            else if(fuel2==2)
                tv3.setText("Petrol,Diesel");
            else tv3.setText("Petrol");
            tv4.setText(Double.toString(mileage2)+"km");
            //tv4.setText("fegrgergergeeg");
            tv5.setText(Integer.toString(engine2)+"cc");
            bar.setNumStars(star2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void seteverything() {

        TextView tv1, tv2, tv3, tv4, tv5;
        ImageView iv;
        RatingBar bar;
       /* TextView temp=(TextView)findViewById(R.id.temp);
        temp.setText(res);*/
        tv1 = (TextView) findViewById(R.id.brand1);
        tv2 = (TextView) findViewById(R.id.TextView2);
        tv3 = (TextView) findViewById(R.id.fuel1);
        tv4 = (TextView) findViewById(R.id.mileage1);
        tv5 = (TextView) findViewById(R.id.engine1);
        iv = (ImageView) findViewById(R.id.image1);
        bar = (RatingBar) findViewById(R.id.ratingBar2);
        Drawable progress = bar.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.RED);
        fish=brand1+ " "+a;
        try {
            iv.setImageResource(image1);
            tv1.setText(brand1 + " "+a);
            tv2.setText(Double.toString(price1)+" lacs ");
            if(fuel1==3)
                tv3.setText("Petrol,Diesel,CNG");
            else if(fuel1==2)
                tv3.setText("Petrol,Diesel");
            else tv3.setText("Petrol");
            tv4.setText(Double.toString(mileage1)+"km");
            //tv4.setText("fegrgergergeeg");
            tv5.setText(Integer.toString(engine1)+"cc");
            bar.setNumStars(star1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }
    public void more(View view){
        Uri uri=Uri.parse("http://www.google.com/search?q="+fish);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void more2(View view){
        Uri uri=Uri.parse("http://www.google.com/search?q="+fish1);
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}

