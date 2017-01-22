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
    public static final String COL31="EXERCISE1";
    public static final String COL41="REPS1";
    public static final String COL51="SERIES1";
    public static final String COL61="WEIGHT1";
    public static final String COL71="REST1";

    public static final String COL32="EXERCISE2";
    public static final String COL42="REPS2";
    public static final String COL52="SERIES2";
    public static final String COL62="WEIGHT2";
    public static final String COL72="REST2";

    public static final String COL33="EXERCISE3";
    public static final String COL43="REPS3";
    public static final String COL53="SERIES3";
    public static final String COL63="WEIGHT3";
    public static final String COL73="REST3";

    public static final String COL34="EXERCISE4";
    public static final String COL44="REPS4";
    public static final String COL54="SERIES4";
    public static final String COL64="WEIGHT4";
    public static final String COL74="REST4";

    public static final String COL35="EXERCISE5";
    public static final String COL45="REPS5";
    public static final String COL55="SERIES5";
    public static final String COL65="WEIGHT5";
    public static final String COL75="REST5";

    public static final String COL36="EXERCISE6";
    public static final String COL46="REPS6";
    public static final String COL56="SERIES6";
    public static final String COL66="WEIGHT6";
    public static final String COL76="REST6";

    public static final String COL37="EXERCISE7";
    public static final String COL47="REPS7";
    public static final String COL57="SERIES7";
    public static final String COL67="WEIGHT7";
    public static final String COL77="REST7";

    public static final String COL38="EXERCISE8";
    public static final String COL48="REPS8";
    public static final String COL58="SERIES8";
    public static final String COL68="WEIGHT8";
    public static final String COL78="REST8";

    public static final String COL8="DAY";
    public static final String COL91="RESTSPE1";
    public static final String COL92="RESTSPE2";
    public static final String COL93="RESTSPE3";
    public static final String COL94="RESTSPE4";
    public static final String COL95="RESTSPE5";
    public static final String COL96="RESTSPE6";




    public Workout_DbHelper (Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createtable = "CREATE TABLE "+TABLE_NAME+" (ID INTEGER PRIMARY KEY AUTOINCREMENT, "+"USERNAME TEXT, "+"WORKOUTNAME TEXT, "+
                "EXERCISE1 TEXT,"+"REPS1 INT,"+"SERIES1 INT,"+"WEIGHT1 INT,"+"REST1 INT,"+
                "EXERCISE2 TEXT,"+"REPS2 INT,"+"SERIES2 INT,"+"WEIGHT2 INT,"+"REST2 INT,"+
                "EXERCISE3 TEXT,"+"REPS3 INT,"+"SERIES3 INT,"+"WEIGHT3 INT,"+"REST3 INT,"+
                "EXERCISE4 TEXT,"+"REPS4 INT,"+"SERIES4 INT,"+"WEIGHT4 INT,"+"REST4 INT,"+
                "EXERCISE5 TEXT,"+"REPS5 INT,"+"SERIES5 INT,"+"WEIGHT5 INT,"+"REST5 INT,"+
                "EXERCISE6 TEXT,"+"REPS6 INT,"+"SERIES6 INT,"+"WEIGHT6 INT,"+"REST6 INT,"+
                "EXERCISE7 TEXT,"+"REPS7 INT,"+"SERIES7 INT,"+"WEIGHT7 INT,"+"REST7 INT,"+
                "EXERCISE8 TEXT,"+"REPS8 INT,"+"SERIES8 INT,"+"WEIGHT8 INT,"+"REST8 INT,"+
                "DAY TEXT,"+"RESTSPE1 INT, RESTSPE2 INT, RESTSPE3 INT, RESTSPE4 INT, RESTSPE5 INT, RESTSPE6 INT) ";
        db.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+ TABLE_NAME);

    }

    public boolean addData(String user, String workoutname,String exo1, int reps1, int series1, int weight1, int rest1,String exo2, int reps2, int series2, int weight2, int rest2, String exo3, int reps3, int series3, int weight3, int rest3, String exo4, int reps4, int series4, int weight4, int rest4, String exo5, int reps5, int series5, int weight5, int rest5, String exo6, int reps6, int series6, int weight6, int rest6, String exo7, int reps7, int series7, int weight7, int rest7, String exo8, int reps8, int series8, int weight8, int rest8, String day, int restspe1, int restspe2, int restspe3, int restspe4, int restspe5, int restspe6){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, user);
        contentValues.put(COL2BIS, workoutname);

        contentValues.put(COL31, exo1);
        contentValues.put(COL41,reps1);
        contentValues.put(COL51,series1);
        contentValues.put(COL61,weight1);
        contentValues.put(COL71,rest1);

        contentValues.put(COL32, exo2);
        contentValues.put(COL42,reps2);
        contentValues.put(COL52,series2);
        contentValues.put(COL62,weight2);
        contentValues.put(COL72,rest2);

        contentValues.put(COL33, exo3);
        contentValues.put(COL43,reps3);
        contentValues.put(COL53,series3);
        contentValues.put(COL63,weight3);
        contentValues.put(COL73,rest3);

        contentValues.put(COL34, exo4);
        contentValues.put(COL44,reps4);
        contentValues.put(COL54,series4);
        contentValues.put(COL64,weight4);
        contentValues.put(COL74,rest4);

        contentValues.put(COL35, exo5);
        contentValues.put(COL45,reps5);
        contentValues.put(COL55,series5);
        contentValues.put(COL65,weight5);
        contentValues.put(COL75,rest5);

        contentValues.put(COL36, exo6);
        contentValues.put(COL46,reps6);
        contentValues.put(COL56,series6);
        contentValues.put(COL66,weight6);
        contentValues.put(COL76,rest6);

        contentValues.put(COL37, exo7);
        contentValues.put(COL47,reps7);
        contentValues.put(COL57,series7);
        contentValues.put(COL67,weight7);
        contentValues.put(COL77,rest7);

        contentValues.put(COL38, exo8);
        contentValues.put(COL48,reps8);
        contentValues.put(COL58,series8);
        contentValues.put(COL68,weight8);
        contentValues.put(COL78,rest8);

        contentValues.put(COL8,day);
        contentValues.put(COL91,restspe1);
        contentValues.put(COL92,restspe2);
        contentValues.put(COL93,restspe3);
        contentValues.put(COL94,restspe4);
        contentValues.put(COL95,restspe5);
        contentValues.put(COL96,restspe6);


        long result=db.insert(TABLE_NAME, null, contentValues); //RENVOIE -1 si erreur d'insertion

        return result != -1;

    }

    Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT USERNAME, WORKOUTNAME," +
                "EXERCISE1, REPS1, SERIES1, WEIGHT1, REST1," +
                "EXERCISE2, REPS2, SERIES2, WEIGHT2, REST2," +
                "EXERCISE3, REPS3, SERIES3, WEIGHT3, REST3," +
                "EXERCISE4, REPS4, SERIES4, WEIGHT4, REST4," +
                "EXERCISE5, REPS5, SERIES5, WEIGHT5, REST5," +
                "EXERCISE6, REPS6, SERIES6, WEIGHT6, REST6," +
                "EXERCISE7, REPS7, SERIES7, WEIGHT7, REST7," +
                "EXERCISE8, REPS8, SERIES8, WEIGHT8, REST8," +
                "DAY, RESTSPE1, RESTSPE2, RESTSPE3, RESTSPE4, RESTSPE5, RESTSPE6 FROM "+TABLE_NAME, null );
    }


    public Cursor getPseudo(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor d=db.rawQuery("SELECT USERNAME FROM "+TABLE_NAME, null );
        return d;



    }
}
