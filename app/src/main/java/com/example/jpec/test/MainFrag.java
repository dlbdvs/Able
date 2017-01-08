package com.example.jpec.test;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by jpec on 27/12/16.
 */

public class MainFrag extends FragmentActivity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        android.support.v4.app.FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction transaction =fm.beginTransaction();
        FragmentStart startFragment = new FragmentStart();

        transaction.add(R.id.fragment_placeholder, startFragment);
        transaction.commit();

    }

    public void onSelectFragment(View view){

        Fragment newFragment;
        if (view == findViewById(R.id.button)){
            newFragment=new FragmentStart();

        }else if (view == findViewById(R.id.button2)){
            newFragment=new Fragment1();

        }else if (view == findViewById(R.id.button3)){
            newFragment=new Fragment2();

        }else {
            newFragment= new FragmentStart();

        }

        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_placeholder, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}
