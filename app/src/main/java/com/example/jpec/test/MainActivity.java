package com.example.jpec.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by jpec on 02/01/17.
 */

public class MainActivity extends Activity {

    private Button create_prog;
    private Button choose_prog;
    private TextView username;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(TextView)findViewById(R.id.jpec);
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String uname=sharedPreferences.getString("username","");
        username.setText("Bienvenue "+uname+" !");
        purgeDatabase();
        create_prog=(Button)findViewById(R.id.create_prog);
        choose_prog=(Button)findViewById(R.id.choose_prog);
        create_prog.setOnClickListener(onClick);
        choose_prog.setOnClickListener(onClick);


    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.create_prog:
                    Intent i = new Intent(v.getContext(), CreateProgrammActivity.class);
                    startActivity(i);

                    break;
                case R.id.choose_prog:
                    Intent intent =new Intent(v.getContext(), ChooseProg.class);
                    startActivity(intent);

                    break;
            }

        }
    };

    public void purgeDatabase(){
        Workout_DbHelper db=new Workout_DbHelper(this);
        db.getWritableDatabase().execSQL("DELETE FROM "+Workout_DbHelper.TABLE_NAME+" WHERE "+Workout_DbHelper.COL41+" = "+Workout_DbHelper.COL42+" = "+Workout_DbHelper.COL43+" = "+Workout_DbHelper.COL44+" = "+Workout_DbHelper.COL45+" = "+Workout_DbHelper.COL46+" = "+Workout_DbHelper.COL47+" = "+Workout_DbHelper.COL48+" = 0");

    }

}
