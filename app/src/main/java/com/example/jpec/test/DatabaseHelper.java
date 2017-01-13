package com.example.jpec.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jpec on 12/01/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    //PREMIERE ETAPE : définition des différentes variables de la bdd

    public static final String DATABASE_NAME="mylist.db";
    public static final String TABLE_NAME="mylist_data";
    public static final String COL1="ID";
    public static final String COL2="ITEM1";


    //CONSTRUCTEUR (toujours du même type)
    public DatabaseHelper (Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    //METHODES IMPLEMENTEES A REMPLIR SUR CE PRINCIPE EN REMPLACANT LES REQUETES SQL
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+"ITEM1 TEXT) ";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);
    }
//-------------------------------------------------------------------------

    //ETAPE 2 : ECRITURE DES DONNEES
    public boolean addData(String item1){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);

        long result=db.insert(TABLE_NAME, null, contentValues); //RENVOIE -1 si erreur d'insertion

        if (result== -1){
            return false;
        }else {
            return true;
        }

    }
    //ACCES A TOUS LES ELEMENTS DE LA BDD
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+TABLE_NAME, null );
        return data;
    }
}
