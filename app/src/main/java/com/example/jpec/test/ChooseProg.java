package com.example.jpec.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jpec on 02/01/17.
 */

public class ChooseProg extends Activity {
    private Button w1;
    private Button w2;
    private Button w3;
    private Button w4;
    private Button w5;
    private Button w6;
    private Button w7;
    private Button w8;
    private Button w9;
    private Button w10;
    private Button w11;
    private Button w12;
    private Button w13;
    private Button w14;
    private Button main;


    int compteur_exo=1;
    int compteur_serie=1;
    public boolean isCreated= true;

    protected Exercise exoo1;
    protected Exercise exoo2;
    protected Exercise exoo3;
    protected Exercise exoo4;
    protected Exercise exoo5;
    protected Exercise exoo6;
    protected Exercise exoo7;
    protected Exercise exoo8;
    int[] rest;
    String nameworkout1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseprog);
        main=(Button)findViewById(R.id.main);
        main.setOnClickListener(onClick);

        w1=(Button)findViewById(R.id.workout1);
        w1.setOnClickListener(onClick);
        w2=(Button)findViewById(R.id.workout2);
        w2.setOnClickListener(onClick);
        w3=(Button)findViewById(R.id.workout3);
        w3.setOnClickListener(onClick);
        w4=(Button)findViewById(R.id.workout4);
        w4.setOnClickListener(onClick);


        w5=(Button)findViewById(R.id.workoutperso1);
        SharedPreferences sharedPreferences=getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
        String nameworkout1 = sharedPreferences.getString("nameWorkout1","");
        w5.setText(nameworkout1);
        w5.setOnClickListener(onClick);

        w6=(Button)findViewById(R.id.workoutperso2);
        sharedPreferences=getSharedPreferences("userWorkout2", Context.MODE_PRIVATE);
        String nameworkout2 = sharedPreferences.getString("nameWorkout1","");
        w6.setText(nameworkout2);
        w6.setOnClickListener(onClick);

        w7=(Button)findViewById(R.id.workoutperso3);
        sharedPreferences=getSharedPreferences("userWorkout3", Context.MODE_PRIVATE);
        String nameworkout3 = sharedPreferences.getString("nameWorkout1","");
        w7.setText(nameworkout3);
        w7.setOnClickListener(onClick);

        w8=(Button)findViewById(R.id.workoutperso4);
        sharedPreferences=getSharedPreferences("userWorkout4", Context.MODE_PRIVATE);
        String nameworkout4 = sharedPreferences.getString("nameWorkout1","");
        w8.setText(nameworkout4);
        w8.setOnClickListener(onClick);

        w9=(Button)findViewById(R.id.workoutperso5);
        sharedPreferences=getSharedPreferences("userWorkout5", Context.MODE_PRIVATE);
        String nameworkout5 = sharedPreferences.getString("nameWorkout1","");
        w9.setText(nameworkout5);
        w9.setOnClickListener(onClick);

        w10=(Button)findViewById(R.id.workoutperso6);
        sharedPreferences=getSharedPreferences("userWorkout6", Context.MODE_PRIVATE);
        String nameworkout6 = sharedPreferences.getString("nameWorkout1","");
        w10.setText(nameworkout6);
        w10.setOnClickListener(onClick);

        w11=(Button)findViewById(R.id.workoutperso7);
        sharedPreferences=getSharedPreferences("userWorkout7", Context.MODE_PRIVATE);
        String nameworkout7 = sharedPreferences.getString("nameWorkout1","");
        w11.setText(nameworkout7);
        w11.setOnClickListener(onClick);

        w12=(Button)findViewById(R.id.workoutperso8);
        sharedPreferences=getSharedPreferences("userWorkout8", Context.MODE_PRIVATE);
        String nameworkout8 = sharedPreferences.getString("nameWorkout1","");
        w12.setText(nameworkout8);
        w12.setOnClickListener(onClick);

        w13=(Button)findViewById(R.id.workoutperso9);
        sharedPreferences=getSharedPreferences("userWorkout9", Context.MODE_PRIVATE);
        String nameworkout9 = sharedPreferences.getString("nameWorkout1","");
        w13.setText(nameworkout9);
        w13.setOnClickListener(onClick);

        w14=(Button)findViewById(R.id.workoutperso10);
        sharedPreferences=getSharedPreferences("userWorkout10", Context.MODE_PRIVATE);
        String nameworkout10 = sharedPreferences.getString("nameWorkout1","");
        w14.setText(nameworkout10);
        w14.setOnClickListener(onClick);
        personalButtonLayout();



    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.main :
                    Intent ii=new Intent(v.getContext(), MainActivity.class);
                    startActivity(ii);
                    break;

                case R.id.workout1:
                    exoo1=new CloseGripPullUps(5,10,90.0);
                    Intent i1 = new Intent(v.getContext(), ProgrammActivity.class);
                    i1.putExtra("name_workout", "Armstrong -Pull ups- DAY 1");
                    extraIntent(i1);
                    startActivity(i1);
                    break;

                case R.id.workout2:
                    exoo1=new RegularPullUps(3,10,60.0);
                    exoo2=new CloseGripPullUps(3,10,60.0);
                    exoo3=new WidePullUps(3,10,60.0);
                    Intent i2 = new Intent(v.getContext(), ProgrammActivity.class);
                    i2.putExtra("name_workout", "Armstrong -Pull ups- DAY 3");
                    extraIntent(i2);
                    startActivity(i2);
                    break;

                case R.id.workout3:
                    exoo1=new RegularPullUps(3,10,60.0);
                    exoo2=new CloseGripPullUps(3,10,60.0);
                    exoo3=new WidePullUps(3,10,60.0);
                    Intent i3 = new Intent(v.getContext(), ProgrammActivity.class);
                    i3.putExtra("name_workout", "Armstrong -Pull ups- DAY 3");
                    extraIntent(i3);
                    startActivity(i3);
                    break;
                case R.id.workout4:
                    exoo1=new CloseGripPullUps(20,10,60.0);
                    Intent i4 = new Intent(v.getContext(), ProgrammActivity.class);
                    i4.putExtra("name_workout", "Armstrong -Pull ups- DAY 1");
                    extraIntent(i4);
                    startActivity(i4);
                    break;
                case R.id.workoutperso1:
                    whichPreference(v);

                    Intent i5=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i5);
                    startActivity(i5);

                    break;

                case R.id.workoutperso2:
                    whichPreference(v);

                    Intent i6=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i6);

                    startActivity(i6);

                    break;

                case R.id.workoutperso3:
                    whichPreference(v);

                    Intent i7=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i7);
                    startActivity(i7);

                    break;

                case R.id.workoutperso4:
                    whichPreference(v);

                    Intent i8=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i8);
                    startActivity(i8);
                    break;
                case R.id.workoutperso5:
                    whichPreference(v);

                    Intent i9=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i9);
                    startActivity(i9);
                    break;

                case R.id.workoutperso6:
                    whichPreference(v);

                    Intent i10=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i10);
                    startActivity(i10);
                    break;
                case R.id.workoutperso7:
                    whichPreference(v);

                    Intent i11=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i11);
                    startActivity(i11);
                    break;
                case R.id.workoutperso8:
                    whichPreference(v);

                    Intent i12=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i12);
                    startActivity(i12);
                    break;
                case R.id.workoutperso9:
                    whichPreference(v);

                    Intent i13=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i13);
                    startActivity(i13);
                    break;
                case R.id.workoutperso10:
                    whichPreference(v);

                    Intent i14=new Intent(v.getContext(), ProgrammActivity.class);
                    extraIntentPerso(i14);
                    startActivity(i14);
                    break;


            }

        }};
    public void personalButtonLayout (){
        SharedPreferences sharedPreferences=getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w5.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout2", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w6.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout3", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w7.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout4", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w8.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout5", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w9.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout6", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w10.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout7", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w11.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout8", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w12.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout9", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w13.setVisibility(View.GONE);
        }
        sharedPreferences=getSharedPreferences("userWorkout10", Context.MODE_PRIVATE);
        if (!sharedPreferences.contains("nameWorkout1")){
            w14.setVisibility(View.GONE);
        }
    }
    public void extraIntent(Intent i1){
        i1.putExtra("exoo1", exoo1);
        i1.putExtra("exoo2", exoo2);
        i1.putExtra("exoo3", exoo3);
        i1.putExtra("exoo4", exoo4);
        i1.putExtra("exoo5", exoo5);
        i1.putExtra("exoo6", exoo6);
        i1.putExtra("exoo7", exoo7);
        i1.putExtra("exoo8", exoo8);
        i1.putExtra("compteur_exo", compteur_exo);
        i1.putExtra("compteur_serie", compteur_serie);
        i1.putExtra("isCreated", isCreated);
    }

    public void extraIntentPerso(Intent i8){
        i8.putExtra("isCreated", isCreated);
        i8.putExtra("name_workout", nameworkout1);
        i8.putExtra("exoo1", exoo1);
        i8.putExtra("exoo2", exoo2);
        i8.putExtra("exoo3", exoo3);
        i8.putExtra("exoo4", exoo4);
        i8.putExtra("exoo5", exoo5);
        i8.putExtra("exoo6", exoo6);
        i8.putExtra("exoo7", exoo7);
        i8.putExtra("exoo8", exoo8);
        i8.putExtra("compteur_exo", compteur_exo);
        i8.putExtra("compteur_serie", compteur_serie);
        i8.putExtra("restspecial",rest);
    }

    //On récupère les données des exos stockés dans SharedPreferences.
    public void whichPreference(View v){
        SharedPreferences sharedPreferences=getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
        //Le switch permet de définir quel entraînement on choisit en modifiant la source que l'on choisit de consulter
        switch (v.getId()){
            case R.id.workoutperso1:
                break;
            case R.id.workoutperso2:
                sharedPreferences=getSharedPreferences("userWorkout2", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso3:
                sharedPreferences=getSharedPreferences("userWorkout3", Context.MODE_PRIVATE);
                break;

            case R.id.workoutperso4:
                sharedPreferences=getSharedPreferences("userWorkout4", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso5:
                sharedPreferences=getSharedPreferences("userWorkout5", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso6:
                sharedPreferences=getSharedPreferences("userWorkout6", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso7:
                sharedPreferences=getSharedPreferences("userWorkout7", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso8:
                sharedPreferences=getSharedPreferences("userWorkout8", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso9:
                sharedPreferences=getSharedPreferences("userWorkout9", Context.MODE_PRIVATE);
                break;
            case R.id.workoutperso10:
                sharedPreferences=getSharedPreferences("userWorkout10", Context.MODE_PRIVATE);
                break;

        }
        nameworkout1 = sharedPreferences.getString("nameWorkout1","");
        String exo1 = sharedPreferences.getString("exo1","");
        String exo2 = sharedPreferences.getString("exo2","");
        String exo3 = sharedPreferences.getString("exo3","");
        String exo4 = sharedPreferences.getString("exo4","");
        String exo5 = sharedPreferences.getString("exo5","");
        String exo6 = sharedPreferences.getString("exo6","");
        String exo7 = sharedPreferences.getString("exo7","");
        String exo8 = sharedPreferences.getString("exo8","");
        int reps1 = sharedPreferences.getInt("reps1",0);
        int reps2 = sharedPreferences.getInt("reps2",0);
        int reps3 = sharedPreferences.getInt("reps3",0);
        int reps4 = sharedPreferences.getInt("reps4",0);
        int reps5 = sharedPreferences.getInt("reps5",0);
        int reps6 = sharedPreferences.getInt("reps6",0);
        int reps7 = sharedPreferences.getInt("reps7",0);
        int reps8 = sharedPreferences.getInt("reps8",0);
        int series1=sharedPreferences.getInt("series1",0);
        int series2=sharedPreferences.getInt("series2",0);
        int series3=sharedPreferences.getInt("series3",0);
        int series4=sharedPreferences.getInt("series4",0);
        int series5=sharedPreferences.getInt("series5",0);
        int series6=sharedPreferences.getInt("series6",0);
        int series7=sharedPreferences.getInt("series7",0);
        int series8=sharedPreferences.getInt("series8",0);
        int rest1=sharedPreferences.getInt("rest1",0);
        int rest2=sharedPreferences.getInt("rest2",0);
        int rest3=sharedPreferences.getInt("rest3",0);
        int rest4=sharedPreferences.getInt("rest4",0);
        int rest5=sharedPreferences.getInt("rest5",0);
        int rest6=sharedPreferences.getInt("rest6",0);
        int rest7=sharedPreferences.getInt("rest7",0);
        int rest8=sharedPreferences.getInt("rest8",0);
        int weight1=sharedPreferences.getInt("weight1",0);
        int weight8=sharedPreferences.getInt("weight8",0);
        int weight2=sharedPreferences.getInt("weight2",0);
        int weight3=sharedPreferences.getInt("weight3",0);
        int weight4=sharedPreferences.getInt("weight4",0);
        int weight5=sharedPreferences.getInt("weight5",0);
        int weight6=sharedPreferences.getInt("weight6",0);
        int weight7=sharedPreferences.getInt("weight7",0);
        int r1=sharedPreferences.getInt("specialRest1", 0);
        int r2=sharedPreferences.getInt("specialRest2", 0);
        int r3=sharedPreferences.getInt("specialRest3", 0);
        int r4=sharedPreferences.getInt("specialRest4", 0);
        int r5=sharedPreferences.getInt("specialRest5", 0);
        int r6=sharedPreferences.getInt("specialRest6", 0);


        rest= new int[]{r1, r2, r3, r4, r5, r6};




        exoo1=getExercise(exo1);
        exoo2=getExercise(exo2);
        exoo3=getExercise(exo3);
        exoo4=getExercise(exo4);
        exoo5=getExercise(exo5);
        exoo6=getExercise(exo6);
        exoo7=getExercise(exo7);
        exoo8=getExercise(exo8);
        setExercise(exoo1, reps1, series1, rest1, weight1);
        setExercise(exoo2, reps2, series2, rest2, weight2);
        setExercise(exoo3, reps3, series3, rest3, weight3);
        setExercise(exoo4, reps4, series4, rest4, weight4);
        setExercise(exoo5, reps5, series5, rest5, weight5);
        setExercise(exoo6, reps6, series6, rest6, weight6);
        setExercise(exoo7, reps7, series7, rest7, weight7);
        setExercise(exoo8, reps8, series8, rest8, weight8);
    }


    public Exercise getExercise(String s){
        switch (s) {
            case "Bulgarian Split":
                return new BulgarianSplit();
            case "Lunge":
                return new Lunges();
            case "Squat":
                return new Squat();
            case "Squat Hold":
                return new SquatHold();


            case "Narrow Push Up":
                return new NarrowPushUp();
            case "Pike Push Up":
                return new PikePushUp();
            default:
                return null;  //PAR DEFAUT

        }
    }
    public void setExercise(Exercise e, int a, int b, int c, int d){
        if (e != null) {
            try {
                e.setNbreps(a);
                e.setNbseries(b);
                e.setRepos(c);
                e.setPoids(d);
            }catch (Exception z){}
        }


    }
}
