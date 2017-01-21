package com.example.jpec.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;

/**
 * Created by jpec on 12/01/17.
 */

public class Login_DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME="mydb.db";
    private static final String TABLE_NAME="members";
    public static final String COL1="ID";
    private static final String COL2="USERNAME";
    private static final String COL3="PASSWORD";

    Login_DbHelper(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+"USERNAME TEXT, "+"PASSWORD TEXT) ";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);

    }

    boolean addData(String item1, String item2){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);
        contentValues.put(COL3, item2);

        long result=db.insert(TABLE_NAME, null, contentValues); //RENVOIE -1 si erreur d'insertion

        if (result== -1){
            return false;
        }else {
            return true;
        }

    }

    Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT USERNAME, PASSWORD FROM "+TABLE_NAME, null );
    }


    Cursor getPseudo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor d=db.rawQuery("SELECT USERNAME FROM "+TABLE_NAME, null );
        return d;



    }
}
