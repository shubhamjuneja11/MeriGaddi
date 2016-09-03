package com.example.android.merigaddi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {
    String res, query,fish;
    SQLiteDatabase db;
    SQLiteOpenHelper database;
    String brand;
    int fuel, engine, image, star,i;
    double price, mileage;
    boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        res = getIntent().getExtras().getString("key");
        for(i=0;i<Compare.cars.length;i++)
            if(Compare.cars[i].equals(res))
            {b=true;break;}
        database = new Database(this);
        String a;
        db = database.getReadableDatabase();
        query = "Select * FROM Cars WHERE Model=?";
        Cursor cursor = db.rawQuery(query, new String[]{res});

        if(b) {
            if (cursor.moveToFirst())
                brand = cursor.getString(cursor.getColumnIndex("Brand"));
            if (cursor.moveToFirst())
            fuel = cursor.getInt(cursor.getColumnIndex("Fuel"));
            if (cursor.moveToFirst())
            engine = cursor.getInt(cursor.getColumnIndex("Engine"));
            if (cursor.moveToFirst())
            image = cursor.getInt(cursor.getColumnIndex("Image"));
            if (cursor.moveToFirst())
            price = cursor.getDouble(cursor.getColumnIndex("Price"));
            if (cursor.moveToFirst())
            mileage = cursor.getDouble(cursor.getColumnIndex("Mileage"));
            if (cursor.moveToFirst())
            star = cursor.getInt(cursor.getColumnIndex("Star"));
            seteverything();
        }
        else setContentView(R.layout.noresult);
    }

    private void seteverything() {

        TextView tv1, tv2, tv3, tv4, tv5;
        ImageView iv;
        RatingBar bar;
       /* TextView temp=(TextView)findViewById(R.id.temp);
        temp.setText(res);*/
        tv1 = (TextView) findViewById(R.id.brand);
        tv2 = (TextView) findViewById(R.id.price);
        tv3 = (TextView) findViewById(R.id.fuel);
        tv4 = (TextView) findViewById(R.id.mil);
        tv5 = (TextView) findViewById(R.id.engine);
        iv = (ImageView) findViewById(R.id.imageView);
        bar = (RatingBar) findViewById(R.id.ratingBar);
        Drawable progress = bar.getProgressDrawable();
        DrawableCompat.setTint(progress, Color.RED);
        fish=brand + " "+res;
        try {
            iv.setImageResource(image);
            tv1.setText(brand + " "+res);
            tv2.setText(Double.toString(price)+" lacs ");
            if(fuel==3)
                tv3.setText("Petrol,Diesel,CNG");
            else if(fuel==2)
                tv3.setText("Petrol,Diesel");
            else tv3.setText("Petrol");
          tv4.setText(Double.toString(mileage)+"km");
            //tv4.setText("fegrgergergeeg");
            tv5.setText(Integer.toString(engine)+"cc");
            bar.setNumStars(star);
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
}
