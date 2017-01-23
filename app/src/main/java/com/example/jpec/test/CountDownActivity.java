package com.example.jpec.test;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
Objectifs :
-rajouter un commentaire qui apparraît aux cinq dernières secondes
-lancer le chrono immédiatement
-ajouter un moyen de mettre en pause le timer (optionnel)
 */
public class CountDownActivity extends Activity {

    //Ajout d'un son
    MediaPlayer mySound;
    private boolean started=true;

    //Pour les intent
    public String name_workout;
    int compteur_exo;
    int compteur_serie;
    int current_rest;
    Exercise currentExo;
    public boolean isCreated;
    public boolean next;
    int[] rest =new int[6];
    int currentrep;
    int pickednumber;
    Workout_DbHelper db;




    //Initialisation des variables
    private Button start;
    private Button cancel;
    private Button quit;
    private CountDownTimer countDownTimer;
    private TextView time;
    private Exercise exoo1;
    private Exercise exoo2;
    private Exercise exoo3;
    private Exercise exoo4;
    private Exercise exoo5;
    private Exercise exoo6;
    private Exercise exoo7;
    private Exercise exoo8;
    //private TextView commentaire;


    //Fonction pour réagir au clic
    private View.OnClickListener onClick = new View.OnClickListener(){
        @Override
        //Le view définit quel bouton a été cliqué
        public void onClick(View v){
            switch(v.getId()) {
                case R.id.b_start:
                    start();
                    break;
                case R.id.quit:
                    cancel();
                    //Mise à jour de la bdd avant de quitter
                    db=new Workout_DbHelper(v.getContext());
                    updateDatabase2(currentrep);
                    Intent intent2=new Intent(v.getContext(), EndOfWorkout.class);
                    startActivity(intent2);
                    break;
                case R.id.b_cancel:
                    cancel();
                    Intent intent = new Intent(v.getContext(), ProgrammActivity.class);
                    if (exoo1 != null){
                        intent.putExtra("exoo1", exoo1);
                    }
                    if (exoo2 != null){
                        intent.putExtra("exoo2", exoo2);
                    }
                    if (exoo3 != null){
                        intent.putExtra("exoo3", exoo3);
                    }
                    if (exoo4 != null){
                        intent.putExtra("exoo4", exoo4);
                    }
                    if (exoo5 != null){
                        intent.putExtra("exoo5", exoo5);
                    }
                    if (exoo6 != null){
                        intent.putExtra("exoo6", exoo6);
                    }
                    if (exoo7 != null){
                        intent.putExtra("exoo7", exoo7);
                    }
                    if (exoo8 != null){
                        intent.putExtra("exoo8", exoo8);
                    }


                    intent.putExtra("compteur_exo", compteur_exo);
                    intent.putExtra("compteur_serie", compteur_serie);
                    intent.putExtra("currentExo", currentExo);
                    intent.putExtra("isCreated", isCreated);
                    intent.putExtra("name_workout", name_workout);
                    intent.putExtra("started", started);
                    intent.putExtra("restspecial", rest);
                    intent.putExtra("pickednumber", pickednumber);
                    intent.putExtra("currentrep", currentrep);//TODO


                    startActivity(intent);
                    break;
            }
        }


    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)
        {
            pickednumber=(int)b.get("pickednumber");
            currentrep=(int) b.get("currentrep");//TODO
            compteur_exo=(int) b.get("compteur_exo");
            compteur_serie=(int) b.get("compteur_serie");
            current_rest=(int) b.get("current_rest");
            isCreated=(boolean)b.get("isCreated");
            currentExo=intent.getParcelableExtra("currentExo");
            next=(boolean)b.get("next");
            if (b.get("restspecial") !=null){
                rest = (int[])b.get("restspecial");
            }

            if (isCreated) {
                name_workout = (String) b.get("name_workout");
            }
            exoo1 = intent.getParcelableExtra("exoo1");
            exoo2 = intent.getParcelableExtra("exoo2");
            exoo3 = intent.getParcelableExtra("exoo3");
            exoo4 = intent.getParcelableExtra("exoo4");
            exoo5= intent.getParcelableExtra("exoo5");
            exoo6= intent.getParcelableExtra("exoo6");
            exoo7= intent.getParcelableExtra("exoo7");
            exoo8= intent.getParcelableExtra("exoo8");


        }

        //Permet aux boutons de réagir en attribuant les fonctions "de réaction" adéquates
        start=(Button)findViewById(R.id.b_start);
        start.setOnClickListener(onClick);
        cancel=(Button)findViewById(R.id.b_cancel);
        cancel.setOnClickListener(onClick);
        time=(TextView)findViewById(R.id.time);
        quit=(Button)findViewById(R.id.quit);
        quit.setOnClickListener(onClick);
        //commentaire=(TextView)findViewById(R.id.commentaire);


        //Lancement automatique du chrono
        start();


        //Rajout du son dans la méthode
        mySound = MediaPlayer.create(this, R.raw.bip);

    }

    public void updateDatabase2(int value){
        String col="";
        if (compteur_exo==1){
            col=Workout_DbHelper.COL41;
        }else
        if (compteur_exo==2){
            col=Workout_DbHelper.COL42;
        }else
        if (compteur_exo==3){
            col=Workout_DbHelper.COL43;
        }else
        if (compteur_exo==4){
            col=Workout_DbHelper.COL44;
        }else
        if (compteur_exo==5){
            col=Workout_DbHelper.COL45;
        }else
        if (compteur_exo==6){
            col=Workout_DbHelper.COL46;
        }else
        if (compteur_exo==7){
            col=Workout_DbHelper.COL47;
        }else
        if (compteur_exo==8){
            col=Workout_DbHelper.COL48;
        }
        db.getWritableDatabase().execSQL("UPDATE "+Workout_DbHelper.TABLE_NAME+" SET "+col+" ='"+value+"' WHERE ID = (SELECT MAX(ID) FROM "+Workout_DbHelper.TABLE_NAME+" ) ");
    }


    public void start(){

        time.setText("10");
        //commentaire.setText("");
        //start.setText("Pause");

        //CountDownTimer(long millisInFuture, long countDownInterval)
        countDownTimer = new CountDownTimer(current_rest*1000,1000) {


            //Dans le setText il faut qu'il y ait du texte d'où les "" (vide)
            @Override
            public void onTick(long millisUntilFinished) {
                //remainingtime=millisUntilFinished;
                 if (millisUntilFinished/1000 <= 5){
                     time.setText(""+millisUntilFinished / 1000 +"\n Get ready...");
                     //commentaire.setText("Oh merde...");
                 }
                 else {
                     time.setText("" + millisUntilFinished / 1000);
                 }
            }

            @Override
            public void onFinish() {
                mySound.start(); //Joue simplement le son déjà initialisé
                //time.setText("Done !");
                //cancel.setText("Next Exercise !");

                cancel();
                Intent intent = new Intent(getApplicationContext(), ProgrammActivity.class);
                if (exoo1 != null){
                    intent.putExtra("exoo1", exoo1);
                }
                if (exoo2 != null){
                    intent.putExtra("exoo2", exoo2);
                }
                if (exoo3 != null){
                    intent.putExtra("exoo3", exoo3);
                }
                if (exoo4 != null){
                    intent.putExtra("exoo4", exoo4);
                }
                if (exoo5 != null){
                    intent.putExtra("exoo5", exoo5);
                }
                if (exoo6 != null){
                    intent.putExtra("exoo6", exoo6);
                }
                if (exoo7 != null){
                    intent.putExtra("exoo7", exoo7);
                }
                if (exoo8 != null){
                    intent.putExtra("exoo8", exoo8);
                }


                intent.putExtra("compteur_exo", compteur_exo);
                intent.putExtra("compteur_serie", compteur_serie);
                intent.putExtra("currentExo", currentExo);
                intent.putExtra("isCreated", isCreated);
                intent.putExtra("name_workout", name_workout);
                intent.putExtra("started", started);
                intent.putExtra("restspecial", rest);
                intent.putExtra("currentrep", currentrep);//TODO
                intent.putExtra("pickednumber", pickednumber);



                startActivity(intent);



            }


        };
        countDownTimer.start();

    }

/*
    public void onPause() {
        countDownTimer.cancel();
        start.setText("Resume");
    }

*/

    public void cancel(){
        if (countDownTimer != null){
            countDownTimer.cancel();
            countDownTimer=null;
        }

    }


}