package com.example.jpec.test;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jpec on 30/01/17.
 */

public class test2 extends AppCompatActivity {
    Button add;
    int x;
    int y;
    Button pec;
    Button leg;
    Button abs;
    Button back;
    Button done;
    Spinner spin1;
    ArrayAdapter<CharSequence> adap;
    TextView t;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_workout_main);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(onClick);

        t=(TextView)findViewById(R.id.testexo1);
        SharedPreferences sharedPreferences=getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
        String test= sharedPreferences.getString("chosen_exo", "choose an exercise");
        t.setText(test);

    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch ( (v.getId())){
                case R.id.add:
                    chooseMuscle();
                    break;
            }
        }
    };

    private void chooseMuscle(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Choose a muscle");
        builder.setPositiveButton(R.string.close, null);

        LayoutInflater inflater=getLayoutInflater();
        View view =inflater.inflate(R.layout.dialog_workout, null);
        builder.setView(view);
        builder.create().show();

        pec=(Button)view.findViewById(R.id.pec);
        pec.setOnClickListener(onClickListener);
        back=(Button)view.findViewById(R.id.back);
        back.setOnClickListener(onClickListener);
        leg=(Button)view.findViewById(R.id.leg);
        leg.setOnClickListener(onClickListener);
        abs=(Button)view.findViewById(R.id.abs);
        abs.setOnClickListener(onClickListener);
        done=(Button)view.findViewById(R.id.done);
        done.setOnClickListener(onClickListener);

        spin1 = (Spinner)view.findViewById(R.id.spin1);
        adap = ArrayAdapter.createFromResource(this, R.array.listofexos, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adap);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.pec:
                    Toast.makeText(v.getContext(), "Vous avez choisi les pecs", Toast.LENGTH_LONG).show();
                    adap =ArrayAdapter.createFromResource(v.getContext(), R.array.exolist_pec, android.R.layout.simple_spinner_item);
                    adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(adap);
                    spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    break;
                case R.id.back:
                    Toast.makeText(v.getContext(), "Vous avez choisi le dos", Toast.LENGTH_LONG).show();
                    //TODO Plus tard, pas ici
                    //getActivity().getFragmentManager().popBackStack();
                    break;
                case R.id.abs:
                    Toast.makeText(v.getContext(), "Vous avez choisi les abdos", Toast.LENGTH_LONG).show();
                    break;
                case R.id.leg:
                    Toast.makeText(v.getContext(), "Vous avez choisi les jambes", Toast.LENGTH_LONG).show();
                    break;
                case R.id.done:
                    SharedPreferences sharedPreferences=getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("chosen_exo", spin1.getSelectedItem().toString());
                    editor.apply();
                    String test= sharedPreferences.getString("chosen_exo", "choose an exercise");
                    t.setText(test);
                    break;
            }
        }
    };
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int)event.getX();
        y = (int)event.getY();
        /*
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
        }
        */
        return false;
    }
}
