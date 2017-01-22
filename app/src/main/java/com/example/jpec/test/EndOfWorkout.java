package com.example.jpec.test;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by jpec on 31/12/16.
 */

public class EndOfWorkout extends Activity {

    Workout_DbHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testviewcontents_layout);


        ListView listView = (ListView) findViewById(R.id.listView);
        myDB = new Workout_DbHelper(this);

        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();
        if (data.getCount() == 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                //CE QUE L'ON VEUT MONTRER ICI
                theList.add("LOGIN " + data.getString(0) + " MDP :" + data.getString(1)+ " MDP :" + data.getString(2)+ " MDP :" + data.getString(3)+ " MDP :" + data.getString(4)+ " MDP :" + data.getString(5)+ " MDP :" + data.getString(6)+ " MDP :" + data.getString(7)+ " MDP :" + data.getString(8)+ " MDP :" + data.getString(9)+ " MDP :" + data.getString(10)+ " MDP :" + data.getString(11)+ " MDP :" + data.getString(12)+ " MDP :" + data.getString(13)+ " MDP :" + data.getString(14)+ " MDP :" + data.getString(15)+ " MDP :" + data.getString(16)+ " MDP :" + data.getString(17)+ " MDP :" + data.getString(18)+ " MDP :" + data.getString(19)+ " MDP :" + data.getString(20));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);


            }
        }
    }
}