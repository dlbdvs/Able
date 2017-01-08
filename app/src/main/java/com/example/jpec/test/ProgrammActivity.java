package com.example.jpec.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View;

import java.io.Serializable;

/**
 * Created by jpec on 23/12/16.
 */

public class ProgrammActivity extends Activity implements Serializable{

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

    private TextView currentexo;
    private TextView currentserie;


    protected Exercise exoo1=new Lunges(1, 20);
    protected Exercise exoo2;
    //protected Exercise exoo2=new CloseGripPullUps(70, 4, 18);
    protected Exercise exoo3;
    protected Exercise exoo4;
    protected Exercise exoo5;
    protected Exercise exoo6;
    protected Exercise exoo7;
    //protected Exercise exoo8;
    protected Exercise exoo8;
    protected Exercise currentExo=exoo1;

    private Button start_workout;
    private Button done;


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
                    setContentView(R.layout.activity_exercise);
                    whichExercise();
                    currentexo=(TextView)findViewById(R.id.current_exo);
                    currentserie=(TextView)findViewById(R.id.current_repserie);
                    if (currentExo != null) { //Test inutile
                        currentexo.setText(currentExo.getNom());
                        //currentserie.setText("Serie n° : "+compteur_serie+" / "+currentExo.getNbseries()+"\nReps : "+currentExo.getNbreps());
                        currentserie.setText("Serie n° : " + compteur_serie + " / " + currentExo.getNbseries() + "\nReps : " + currentExo.getNbreps() + "\n " + (int) currentExo.getRepos());

                    }
                    compteur_serie++;
                        //nextExercice();

                    done=(Button)findViewById(R.id.done);
                    done.setOnClickListener(onClick);}catch (Exception e){
                        Intent intent = new Intent(v.getContext(), EndOfWorkout.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.done:    //Envoyer sur l'exo d'après grace à un bouton approprié
                    nextExercice(); //new here
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
                    startActivity(intent);
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        whichExercise();
        Intent intent = getIntent();            //Récupère les données de CountDownActivity
        Bundle b = intent.getExtras();
        if(b!=null)
        {

            compteur_exo = (int) b.get("compteur_exo");
            compteur_serie = (int) b.get("compteur_serie");
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
            }





            }



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
                setContentView(R.layout.activity_exercise);
                whichExercise();
                currentexo = (TextView) findViewById(R.id.current_exo);
                currentserie = (TextView) findViewById(R.id.current_repserie);
                if (currentExo != null) { //Test inutile
                    currentexo.setText(currentExo.getNom());
                    //currentserie.setText("Serie n° : "+compteur_serie+" / "+currentExo.getNbseries()+"\nReps : "+currentExo.getNbreps());
                    currentserie.setText("Serie n° : " + compteur_serie + " / " + currentExo.getNbseries() + "\nReps : " + currentExo.getNbreps() + "\n " + (int) currentExo.getRepos());

                }
                compteur_serie++;
                //nextExercice();

                done = (Button) findViewById(R.id.done);
                done.setOnClickListener(onClick);
            } catch (Exception e) {
                Intent intent2 = new Intent(this, EndOfWorkout.class);
                startActivity(intent2);
            }
        }







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
        }else{
            next=false;
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
