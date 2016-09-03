package com.example.android.merigaddi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by junejaspc on 13/7/16.
 */
public class Database extends SQLiteOpenHelper {
    static String name="MeriGaddi";
    static int version=1;
    public Database(Context context) {
        super(context,name,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("CREATE TABLE Cars( _id INTEGER PRIMARY KEY AUTOINCREMENT,Brand varchar(50),Model varchar(100),Fuel INTEGER,Price double,Engine INTEGER,Mileage double,Image INTEGER,Star INTEGER);");
    insertCars(db);
    }

    private void insertCars(SQLiteDatabase db) {
        //Maruti
        insert(db,"Maruti","Alto 800",3,3.8,796,24.7,R.drawable.alto,2);
        insert(db,"Maruti","Wagon R",3,5.2,998,25.2,R.drawable.wagonr,3);
        insert(db,"Maruti","Ciaz",2,10.5,1248,28.09,R.drawable.ciaz,3);

        //Hyundai
        insert(db,"Hyundai","i20",2,8.8,1396,22.54,R.drawable.i20,4);
        insert(db,"Hyundai","Verna",2,13.1,1582,23.9,R.drawable.verna,4);
        insert(db,"Hyundai","EON",3,4.5,814,21.1,R.drawable.eon,3);

        //Toyota
        insert(db,"Toyota","Innova",1,16.7,2494,12.99,R.drawable.innova,4);
        insert(db,"Toyota","Etios",3,8.9,1364,8.9,R.drawable.etios,3);
        insert(db,"Toyota","Corolla",2,18.7,1798,14.28,R.drawable.corolla,5);

        //Tata
        insert(db,"Tata","Tiago",3,5.5,1199,23.8,R.drawable.tiago,3);
        insert(db,"Tata","Nano",3,2.0,624,23.9,R.drawable.nano,1);
        insert(db,"Tata","Aria",2,16.3,2179,15.05,R.drawable.aria,5);

        //BMW
        insert(db,"BMW","X1",2,41.0,1995,20.68,R.drawable.x1,5);
        insert(db,"BMW","3 Series",2,45.9,1995,22.69,R.drawable.series3,5);
        insert(db,"BMW","1 Series",2,31,1995,23.26,R.drawable.series1,5);

        //Mercedes
        insert(db,"Mercedes","Benz A class",1,28.5,2143,20.0,R.drawable.benzaclass,5);
        insert(db,"Mercedes","Benz CLA",1,70.9,2143,17.9,R.drawable.cla,5);

        //Honda
        insert(db,"Honda","City",2,12.5,1497,17.4,R.drawable.city,5);
        insert(db,"Honda","Jazz",3,9.0,1498,27.3,R.drawable.jazz,4);
        insert(db,"Honda","Amaze",2,8.4,1199,18.1,R.drawable.amaze,3);

        //Chevrolet
        insert(db,"Chevrolet","Beat",3,6.6,1199,17.8,R.drawable.beat,3);
        insert(db,"Chevrolet","Cruze",2,17.5,1998,14.81,R.drawable.cruze,4);
        insert(db,"Chevrolet","Spark",3,4.2,995,16.2,R.drawable.spark,2);



    }

    public static  void insert(SQLiteDatabase db,String brand,String model,int fuel,double price,int engine,double mileage,int image,int star)
{
    ContentValues contentValues=new ContentValues();
    contentValues.put("Brand",brand);
    contentValues.put("Model",model);
    contentValues.put("Fuel",fuel);
    contentValues.put("Price",price);
    contentValues.put("Engine",engine);
    contentValues.put("Mileage",mileage);
    contentValues.put("Image",image);
    contentValues.put("Star",star);
    db.insert("Cars",null,contentValues);
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
