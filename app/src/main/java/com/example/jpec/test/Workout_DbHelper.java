package com.example.jpec.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jpec on 21/01/17.
 */

public class Workout_DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="myworkouts.db";
    public static final String TABLE_NAME="workouts";
    public static final String COL1="ID";
    public static final String COL2="USERNAME"; //Permet d'identifier à qui appartient un entraînement
    public static final String COL2BIS="WORKOUTNAME";
    public static final String COL3="EXERCISE";
    public static final String COL4="REPS";
    public static final String COL5="SERIES";
    public static final String COL6="WEIGHT";
    public static final String COL7="REST";
    public static final String COL8="DAY";
    public static final String COL9="RESTSPE";



    public Workout_DbHelper (Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+"USERNAME TEXT, "+"WORKOUTNAME TEXT, "+"EXERCISE TEXT,"
                +"REPS INT,"+"SERIES INT,"+"WEIGHT INT,"+"REST INT,"+"DAY TEXT,"+"RESTSPE INT) ";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);

    }

    public boolean addData(String user, String exo,String workoutname, int reps, int series, int weight, int rest,String day, int restspe){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, user);
        contentValues.put(COL2BIS, workoutname);
        contentValues.put(COL3, exo);
        contentValues.put(COL4,reps);
        contentValues.put(COL5,series);
        contentValues.put(COL6,weight);
        contentValues.put(COL7,rest);
        contentValues.put(COL8,day);
        contentValues.put(COL9,restspe);

        long result=db.insert(TABLE_NAME, null, contentValues); //RENVOIE -1 si erreur d'insertion

        if (result== -1){
            return false;
        }else {
            return true;
        }

    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT USERNAME, EXERCISE, REPS, SERIES, WEIGHT, REST, DAY, RESTSPE FROM "+TABLE_NAME, null );
    }


    public Cursor getPseudo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor d=db.rawQuery("SELECT USERNAME FROM "+TABLE_NAME, null );
        return d;



    }
}
