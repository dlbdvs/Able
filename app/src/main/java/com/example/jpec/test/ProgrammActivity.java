package com.example.jpec.test;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by jpec on 23/12/16.
 */

public class ProgrammActivity extends Activity implements Serializable{

    String exoo1name;
    String exoo2name;
    String exoo3name;
    String exoo4name;
    String exoo5name;
    String exoo6name;
    String exoo7name;
    String exoo8name;

    int exoo1serie;
    int exoo2serie;
    int exoo3serie;
    int exoo4serie;
    int exoo5serie;
    int exoo6serie;
    int exoo7serie;
    int exoo8serie;

    int exoo1weight;
    int exoo2weight;
    int exoo3weight;
    int exoo4weight;
    int exoo5weight;
    int exoo6weight;
    int exoo7weight;
    int exoo8weight;

    int exoo1rest;
    int exoo2rest;
    int exoo3rest;
    int exoo4rest;
    int exoo5rest;
    int exoo6rest;
    int exoo7rest;
    int exoo8rest;

    int currentrep=0;



    private boolean started=false;
    private TextView exo8;
    private TextView exo7;
    private TextView exo6;
    private TextView exo5;
    private TextView exo4;
    private TextView exo3;
    private TextView exo2;
    private TextView exo1;
    private String name_workout;
    private TextView namew;

    private LinearLayout L2;
    private LinearLayout L3;
    private LinearLayout L4;
    private LinearLayout L5;
    private LinearLayout L6;
    private LinearLayout L7;
    private LinearLayout L8;
    private TextView restbis1;
    private TextView restbis2;
    private TextView restbis3;
    private TextView restbis4;
    private TextView restbis5;
    private TextView restbis6;
    private TextView restbis7;

    private TextView currentexo;
    private TextView currentserie;


    protected Exercise exoo1=new Lunges(1, 20);
    protected Exercise exoo2;
    protected Exercise exoo3;
    protected Exercise exoo4;
    protected Exercise exoo5;
    protected Exercise exoo6;
    protected Exercise exoo7;
    protected Exercise exoo8;
    protected Exercise currentExo=exoo1;

    private Button start_workout;
    private Button done;
    private NumberPicker numberPicker;
    Workout_DbHelper db;
    int pickednumber=0;

    int[] rest= new int[6];
    int compteur_exo=1;
    int compteur_serie=1;
    int current_rest;
    public boolean isCreated=false;
    public boolean next=false;



    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.start_workout:
                    try{
                        whichExercise();                        //Méthode permettant de savoir quel est l'exercice courant à partir du compteur_exo

                        //TODO Faire un test sur les noms : void isHold() avec la liste des exo de gainage
                        if (isHoldExo()){
                            Intent i = new Intent(v.getContext(), HoldCountDownActivity.class);
                            i.putExtra("next", next);
                            i.putExtra("compteur_exo", compteur_exo);
                            i.putExtra("compteur_serie", compteur_serie);
                            i.putExtra("current_rest", current_rest);
                            i.putExtra("currentExo", currentExo);
                            i.putExtra("exoo1", exoo1);
                            i.putExtra("isCreated", isCreated);
                            i.putExtra("exoo2", exoo2);
                            i.putExtra("exoo3", exoo3);
                            i.putExtra("exoo4", exoo4);
                            i.putExtra("exoo5", exoo5);
                            i.putExtra("exoo6", exoo6);
                            i.putExtra("exoo7", exoo7);
                            i.putExtra("exoo8", exoo8);
                            i.putExtra("name_workout", name_workout);
                            i.putExtra("restspecial", rest);
                            i.putExtra("pickednumber", pickednumber);
                            i.putExtra("currentrep", currentrep);
                            compteur_serie++;
                            workoutDatabase();
                            startActivity(i);



                        }else{

                    setContentView(R.layout.activity_exercise);

                        /*Gestion de l'affichage de l'exo à faire apparaître*/

                        currentexo=(TextView)findViewById(R.id.current_exo);
                    currentserie=(TextView)findViewById(R.id.current_repserie);
                    if (currentExo != null) {
                        currentexo.setText(currentExo.getNom());
                        if (compteur_serie+1 > currentExo.getNbseries()){
                            if (rest[compteur_exo-1] != 0) {
                                current_rest = rest[compteur_exo - 1];
                            }
                        }
                        currentserie.setText("Serie n° : " + compteur_serie + " / " + currentExo.getNbseries() + "\nReps : " + currentExo.getNbreps() + "\n " + current_rest);
                        numberPicker=(NumberPicker)findViewById(R.id.numberPicker);
                        numberPicker.setMaxValue(500);
                        numberPicker.setMinValue(0);
                        numberPicker.setWrapSelectorWheel(false);
                        numberPicker.setValue(currentExo.getNbreps());
                    }
                    compteur_serie++;

                        workoutDatabase();

                        done=(Button)findViewById(R.id.done);
                        done.setOnClickListener(onClick);}
                    }catch (Exception e){
                        //Ceci est effectué si une exception est attrapée ie si on arrive à la fin de l'entraînement
                        //Mise à jour de la base de données au niveau des répétitions effectuées
                        db=new Workout_DbHelper(v.getContext());
                        updateDatabase2(currentrep+pickednumber);
                        //Lance la page de fin de l'entraînement
                        Intent intent = new Intent(v.getContext(), EndOfWorkout.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.done:
                    pickednumber=numberPicker.getValue(); //Récupère la valeur indiquée par l'utilisateur après un exercice
                    nextExercice();//Détermine le prochain exo
                    /*
                    On rajoute des données que l'on transfère de pages en pages
                     */
                    Intent intent = new Intent(v.getContext(), CountDownActivity.class);
                    intent.putExtra("next", next);
                    intent.putExtra("compteur_exo", compteur_exo);
                    intent.putExtra("compteur_serie", compteur_serie);
                    intent.putExtra("current_rest", current_rest);
                    intent.putExtra("currentExo", currentExo);
                    intent.putExtra("exoo1", exoo1);
                    intent.putExtra("isCreated", isCreated);
                    intent.putExtra("exoo2", exoo2);
                    intent.putExtra("exoo3", exoo3);
                    intent.putExtra("exoo4", exoo4);
                    intent.putExtra("exoo5", exoo5);
                    intent.putExtra("exoo6", exoo6);
                    intent.putExtra("exoo7", exoo7);
                    intent.putExtra("exoo8", exoo8);
                    intent.putExtra("name_workout", name_workout);
                    intent.putExtra("restspecial", rest);
                    intent.putExtra("pickednumber", pickednumber);
                    intent.putExtra("currentrep", currentrep);
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Intent intent = getIntent();            //Récupération de données
        Bundle b = intent.getExtras();
        if(b!=null)
        {

            compteur_exo = (int) b.get("compteur_exo");
            compteur_serie = (int) b.get("compteur_serie");
            if (b.get("restspecial") !=null){
                rest = (int[])b.get("restspecial");
            }
            if(b.get("isCreated") != null){
                isCreated=(boolean) b.get("isCreated");
            }
            if (isCreated) {
                name_workout=(String) b.get("name_workout");
                exoo1 = intent.getParcelableExtra("exoo1");
                exoo2 = intent.getParcelableExtra("exoo2");
                exoo3 = intent.getParcelableExtra("exoo3");
                exoo4 = intent.getParcelableExtra("exoo4");
                exoo5= intent.getParcelableExtra("exoo5");
                exoo6= intent.getParcelableExtra("exoo6");
                exoo7= intent.getParcelableExtra("exoo7");
                exoo8= intent.getParcelableExtra("exoo8");

            }

            if (intent.getParcelableExtra("currentExo") != null){
                currentExo =intent.getParcelableExtra("currentExo");

            }
            if (b.get("started") != null){
                started=(boolean)b.get("started");
                pickednumber=(int)b.get("pickednumber");
                currentrep=(int)b.get("currentrep");
            }

            //TODO Rajout d'un test
try {
    whichExercise(); //Gère l'affichage de l'exo à effectuer
}catch (Exception e ){
    Intent z =new Intent(this, EndOfWorkout.class);
    startActivity(z);
}




            }

        restbis1=(TextView)findViewById(R.id.btwexo1);
        restbis2=(TextView)findViewById(R.id.btwexo2);
        restbis3=(TextView)findViewById(R.id.btwexo3);
        restbis4=(TextView)findViewById(R.id.btwexo4);
        restbis5=(TextView)findViewById(R.id.btwexo5);
        restbis6=(TextView)findViewById(R.id.btwexo6);
        restbis7=(TextView)findViewById(R.id.btwexo7);

        //Permet l'affichage des temps de repos entre exercices précisés par l'utilisateur dans CreateProgramm
        setViewSpecialRest();




        //Initialisation des différents exos
        /*
        NB : Cette initialisation se fait toujours en trois étapes :
            -private TextView textv;
            -textv=(TextView) findViewById(R...);  (ne pas oublier le cast)
            -textv.setText("");                     (si cela n'est pas fait dans cet ordre : Exception)
         */
        L2 = (LinearLayout)findViewById(R.id.L2);
        L3 = (LinearLayout)findViewById(R.id.L3);
        L4 = (LinearLayout)findViewById(R.id.L4);
        L5 = (LinearLayout)findViewById(R.id.L5);
        L6 = (LinearLayout)findViewById(R.id.L6);
        L7 = (LinearLayout)findViewById(R.id.L7);
        L8 = (LinearLayout)findViewById(R.id.L8);

        exo1=(TextView)findViewById(R.id.exo1);
        exo1.setText(exoo1.getNom()+"\nSerie(s) : "+exoo1.getNbseries()+"  Reps : "+exoo1.getNbreps()+"  Weight : "+exoo1.getPoids()+"  Rest : "+(int)exoo1.getRepos());
        /*
        Permet l'affichage sur ProgrammActivity des exos non nuls indiqués dans le programme (on cache les layout sinon)
         */
        attribution(exoo2,exo2, R.id.exo2, L2);
        attribution(exoo3,exo3, R.id.exo3, L3);
        attribution(exoo4,exo4, R.id.exo4, L4);
        attribution(exoo5,exo5, R.id.exo5, L5);
        attribution(exoo6,exo6, R.id.exo6, L6);
        attribution(exoo7,exo7, R.id.exo7, L7);
        attribution(exoo8,exo8, R.id.exo8, L8);

        exo2=(TextView)findViewById(R.id.exo2);
        exo3=(TextView)findViewById(R.id.exo3);
        exo4=(TextView)findViewById(R.id.exo4);
        exo5=(TextView)findViewById(R.id.exo5);
        exo6=(TextView)findViewById(R.id.exo6);
        exo7=(TextView)findViewById(R.id.exo7);
        exo8=(TextView)findViewById(R.id.exo8);

        namew=(TextView)findViewById(R.id.name_workout);
        namew.setText(name_workout);

        //Fin de l'initialisation des différents exos

        start_workout=(Button)findViewById(R.id.start_workout);
        start_workout.setOnClickListener(onClick);

        if (started) {
            try {

                //TODO ICI le travail pour un exo Hold

                whichExercise();

                if (isHoldExo()) {
                    Intent i = new Intent(this, HoldCountDownActivity.class);
                    i.putExtra("next", next);
                    i.putExtra("compteur_exo", compteur_exo);
                    i.putExtra("compteur_serie", compteur_serie);
                    i.putExtra("current_rest", current_rest);
                    i.putExtra("currentExo", currentExo);
                    i.putExtra("exoo1", exoo1);
                    i.putExtra("isCreated", isCreated);
                    i.putExtra("exoo2", exoo2);
                    i.putExtra("exoo3", exoo3);
                    i.putExtra("exoo4", exoo4);
                    i.putExtra("exoo5", exoo5);
                    i.putExtra("exoo6", exoo6);
                    i.putExtra("exoo7", exoo7);
                    i.putExtra("exoo8", exoo8);
                    i.putExtra("name_workout", name_workout);
                    i.putExtra("restspecial", rest);
                    i.putExtra("pickednumber", pickednumber);
                    i.putExtra("currentrep", currentrep);

                    compteur_serie++;
                    workoutDatabase();
                    startActivity(i);
                }else {
                    setContentView(R.layout.activity_exercise);
                    currentexo = (TextView) findViewById(R.id.current_exo);
                    currentserie = (TextView) findViewById(R.id.current_repserie);
                if (currentExo != null) { //Test inutile
                    currentexo.setText(currentExo.getNom());
                    currentserie.setText("Serie n° : " + compteur_serie + " / " + currentExo.getNbseries() + "\nReps : " + currentExo.getNbreps() + "\n " + (int) currentExo.getRepos());
                    numberPicker=(NumberPicker)findViewById(R.id.numberPicker);
                    numberPicker.setMaxValue(500);
                    numberPicker.setMinValue(0);
                    numberPicker.setWrapSelectorWheel(false);
                    numberPicker.setValue(currentExo.getNbreps());
                }

                compteur_serie++;

                done = (Button) findViewById(R.id.done);
                done.setOnClickListener(onClick);

                }


                //FIN AJOUT
/*
                setContentView(R.layout.activity_exercise);
                whichExercise();
                currentexo = (TextView) findViewById(R.id.current_exo);
                currentserie = (TextView) findViewById(R.id.current_repserie);
                if (currentExo != null) { //Test inutile
                    currentexo.setText(currentExo.getNom());
                    currentserie.setText("Serie n° : " + compteur_serie + " / " + currentExo.getNbseries() + "\nReps : " + currentExo.getNbreps() + "\n " + (int) currentExo.getRepos());
                    numberPicker=(NumberPicker)findViewById(R.id.numberPicker);
                    numberPicker.setMaxValue(500);
                    numberPicker.setMinValue(0);
                    numberPicker.setWrapSelectorWheel(false);
                    numberPicker.setValue(currentExo.getNbreps());
                }
                compteur_serie++;


                done = (Button) findViewById(R.id.done);
                done.setOnClickListener(onClick);*/
             } catch (Exception e) {
            Intent intent2 = new Intent(this, EndOfWorkout.class);//TODO
                startActivity(intent2);
            }
        }







    }

    public boolean isHoldExo(){
        switch (currentExo.getNom()){
            case "Squat Hold" :
                return true;

        }
        return false;
    }

    //Met à jour la base de données en fonction de l'exo effectué
    public void updateDatabase2(int value){
        String col="";
        if (currentExo == exoo1){
            col=Workout_DbHelper.COL41;
        }
        if (currentExo == exoo2){
            col=Workout_DbHelper.COL42;
        }
        if (currentExo == exoo3){
            col=Workout_DbHelper.COL43;
        }
        if (currentExo == exoo4){
            col=Workout_DbHelper.COL44;
        }
        if (currentExo == exoo5){
            col=Workout_DbHelper.COL45;
        }
        if (currentExo == exoo6){
            col=Workout_DbHelper.COL46;
        }
        if (currentExo == exoo7){
            col=Workout_DbHelper.COL47;
        }
        if (currentExo == exoo8){
            col=Workout_DbHelper.COL48;
        }
        db.getWritableDatabase().execSQL("UPDATE "+Workout_DbHelper.TABLE_NAME+" SET "+col+" ='"+value+"' WHERE ID = (SELECT MAX(ID) FROM "+Workout_DbHelper.TABLE_NAME+" ) ");
    }

    //Cette méthode prépare la mise à jour de la db en attrapant les exceptions qui pourraient provenir d'un exo=null
    public void prepaDatabase(){
        try{
            exoo1name=exoo1.getNom();
            exoo1serie=exoo1.getNbseries();
            exoo1weight=exoo1.getPoids();
            exoo1rest=(int)exoo1.getRepos();
        }catch (Exception a){}
        try{
            exoo2name=exoo2.getNom();
            exoo2serie=exoo2.getNbseries();
            exoo2weight=exoo2.getPoids();
            exoo2rest=(int)exoo2.getRepos();
        }catch (Exception a){}
        try{
            exoo3name=exoo3.getNom();
            exoo3serie=exoo3.getNbseries();
            exoo3weight=exoo3.getPoids();
            exoo3rest=(int)exoo3.getRepos();
        }catch (Exception a){}

        try{
            exoo4name=exoo4.getNom();
            exoo4serie=exoo4.getNbseries();
            exoo4weight=exoo4.getPoids();
            exoo4rest=(int)exoo4.getRepos();
        }catch (Exception a){}

        try{
            exoo5name=exoo5.getNom();
            exoo5serie=exoo5.getNbseries();
            exoo5weight=exoo5.getPoids();
            exoo5rest=(int)exoo5.getRepos();
        }catch (Exception a){}

        try{
            exoo6name=exoo6.getNom();
            exoo6serie=exoo6.getNbseries();
            exoo6weight=exoo6.getPoids();
            exoo6rest=(int)exoo6.getRepos();
        }catch (Exception a){}

        try{
            exoo7name=exoo7.getNom();
            exoo7serie=exoo7.getNbseries();
            exoo7weight=exoo7.getPoids();
            exoo7rest=(int)exoo7.getRepos();
        }catch (Exception a){}

        try{
            exoo8name=exoo8.getNom();
            exoo8serie=exoo8.getNbseries();
            exoo8weight=exoo8.getPoids();
            exoo8rest=(int)exoo8.getRepos();
        }catch (Exception a){}

    }

//Création d'une ligne dans la base de données que l'on pourra modifier par la suite grâce à updateDatabase
    public void workoutDatabase(){
        prepaDatabase();
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String uname=sharedPreferences.getString("username","");
        String day="test";
        db=new Workout_DbHelper(this);
        db.addData(uname,name_workout,
                exoo1name,0, exoo1serie,exoo1weight,exoo1rest,
                exoo2name,0, exoo2serie,exoo2weight,exoo2rest,
                exoo3name,0, exoo3serie,exoo3weight,exoo3rest,
                exoo4name,0, exoo4serie,exoo4weight,exoo4rest,
                exoo5name,0, exoo5serie,exoo5weight,exoo5rest,
                exoo6name,0, exoo6serie,exoo6weight,exoo6rest,
                exoo7name,0, exoo7serie,exoo7weight,exoo7rest,
                exoo8name,0, exoo8serie,exoo8weight,exoo8rest,
                day, rest[0], rest[1], rest[2], rest[3], rest[4], rest[5]
                );
    }




    protected void attribution(Exercise e,TextView t, int i, LinearLayout l){
        if (e != null) {
            t = (TextView) findViewById(i);
            t.setText(e.getNom()+"\nSerie(s) : "+e.getNbseries()+"  Reps : "+e.getNbreps()+"  Weight : "+e.getPoids()+"  Rest : "+(int)e.getRepos());
        }else{
            l.setVisibility(View.GONE);
        }

    }

    protected void nextExercice(){
        if(compteur_serie > currentExo.getNbseries()){
            compteur_serie=1;
            compteur_exo+=1;
            next=true;
            db=new Workout_DbHelper(this);
            currentrep+=pickednumber;
            //Toast.makeText(this, "D :"+currentrep, Toast.LENGTH_SHORT).show();
            //updateDatabase(currentrep, db.getWritableDatabase());
            updateDatabase2(currentrep);
            currentrep=0;
            if (rest[compteur_exo-2] != 0) {
                current_rest = rest[compteur_exo - 2];
            }
        }else{
            next=false;
            //Toast.makeText(this, "COn a au total :"+(currentrep+pickednumber), Toast.LENGTH_SHORT).show();
            currentrep+=pickednumber;
        }


    }

    public void setViewSpecialRest(){
        Resources res =getResources();
        try {
            if (rest[0] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[0] );
                restbis1.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test=String.format(res.getString(R.string.resttest),(int) exoo1.getRepos() );
                restbis1.setText(test);

            }
        }catch (Exception e){
        }
        try{

            if (rest[1] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[1] );
                restbis2.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test=String.format(res.getString(R.string.resttest),(int) exoo2.getRepos() );
                restbis2.setText(test);
            }
        }catch (Exception e){

        }
        try{

            if (rest[2] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[2] );
                restbis3.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test = String.format(res.getString(R.string.resttest), (int) exoo3.getRepos());
                restbis3.setText(test);
            }
        }catch (Exception e){

        }

        try{

            if (rest[3] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[3] );
                restbis4.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test=String.format(res.getString(R.string.resttest),(int) exoo4.getRepos() );
                restbis4.setText(test);
            }
        }catch (Exception e){

        }
        try{

            if (rest[4] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[4] );
                restbis5.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test=String.format(res.getString(R.string.resttest),(int) exoo5.getRepos() );
                restbis5.setText(test);
            }
        }catch (Exception e){

        }
        try{
            if (rest[5] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[5] );
                restbis6.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test = String.format(res.getString(R.string.resttest), (int) exoo6.getRepos());
                restbis6.setText(test);
            }
        }catch (Exception e){

        }
        try{
            if (rest[6] != 0) {
                String test=String.format(res.getString(R.string.resttest),rest[6] );
                restbis7.setText(test);
            } else {
                //restbis1.setText(Integer.toString((int) exoo1.getRepos()));
                String test=String.format(res.getString(R.string.resttest),(int) exoo7.getRepos() );
                restbis7.setText(test);
            }
        }catch (Exception e){

        }

    }
    protected void whichExercise(){
        switch (compteur_exo){
            case 1:
                currentExo=exoo1;
                current_rest=(int)currentExo.getRepos();
                break;
            case 2:
                currentExo=exoo2;
                current_rest = (int) currentExo.getRepos();
                break;
            case 3:
                currentExo=exoo3;
                current_rest=(int)currentExo.getRepos();
                break;
            case 4:
                currentExo=exoo4;
                current_rest=(int)currentExo.getRepos();
                break;
            case 5:
                currentExo=exoo5;
                current_rest=(int)currentExo.getRepos();
                break;
            case 6:
                currentExo=exoo6;
                current_rest=(int)currentExo.getRepos();
                break;
            case 7:
                currentExo=exoo7;
                current_rest=(int)currentExo.getRepos();
                break;
            case 8:
                currentExo=exoo8;
                current_rest=(int)currentExo.getRepos();
                break;


        }

    }


}
