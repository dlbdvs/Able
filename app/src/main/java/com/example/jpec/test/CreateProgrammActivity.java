package com.example.jpec.test;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jpec on 26/12/16.
 */

public class CreateProgrammActivity extends Activity{

    private TextView name_workout;

    int[] rest = new int[6];
    int nbexo=1;
    int compteur_exo=1;
    int compteur_serie=1;
    public boolean isCreated= true;
    private Button add;
    private Button START;
    private Button saveworkout;
    private CheckBox rd1;
    private CheckBox rd2;
    private CheckBox rd3;
    private CheckBox rd4;
    private CheckBox rd5;
    private CheckBox rd6;
    private CheckBox rd7;
    private CheckBox rd8;
    private TextView exo1;
    private TextView exo2;
    private TextView exo3;
    private TextView exo4;
    private TextView exo5;
    private TextView exo6;
    private TextView exo7;
    private TextView exo8;
    private EditText poids1;
    private EditText poids2;
    private EditText poids3;
    private EditText poids4;
    private EditText poids5;
    private EditText poids6;
    private EditText poids7;
    private EditText poids8;
    private EditText restbis1;
    private EditText restbis2;
    private EditText restbis3;
    private EditText restbis4;
    private EditText restbis5;
    private EditText restbis6;
    private EditText restbis7;
    private TextView w1;
    private TextView w2;
    private TextView w3;
    private TextView w4;
    private TextView w5;
    private TextView w6;
    private TextView w7;
    private TextView w8;
    private LinearLayout LL1;
    private LinearLayout LL2;
    private LinearLayout LL3;
    private LinearLayout LL4;
    private LinearLayout LL5;
    private LinearLayout LL6;
    private LinearLayout LL7;
    private LinearLayout LL8;

    ArrayAdapter<CharSequence> adapter1;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Spinner spinner7;
    Spinner spinner8;

    protected Exercise exoo1;
    protected Exercise exoo2;
    protected Exercise exoo3;
    protected Exercise exoo4;
    protected Exercise exoo5;
    protected Exercise exoo6;
    protected Exercise exoo7;
    protected Exercise exoo8;
/*
Pour utiliser "Parcelable", il faut :
-Faire implémenter Parcelable dans la classe contenant l'objet à transmettre
(ATTENTION : il faut respecter l'ordre de déclarations de variables !!!)
-Récupérer les données avec : getParcelableExtra       -->     exoo1=intent.getParcelableExtra("exoo1");


 */




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addworkout);

        restbis1=(EditText)findViewById(R.id.rest1bis);
        restbis2=(EditText)findViewById(R.id.rest2bis);
        restbis3=(EditText)findViewById(R.id.rest3bis);
        restbis4=(EditText)findViewById(R.id.rest4bis);
        restbis5=(EditText)findViewById(R.id.rest5bis);
        restbis6=(EditText)findViewById(R.id.rest6bis);
        restbis7=(EditText)findViewById(R.id.rest7bis);
        //TODO REVOIR OCR
        /*
        Resources res = getResources();
// Anaïs ira en %1 et 22 ira en %2
        String chaine = res.getString(R.string.resttest, (int)exoo1.getRepos());

        restbis1.setText(chaine);
        restbis2.setText(Integer.toString((int)exoo1.getRepos()));
        */




        //Initialisation des boutons

        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(onClick);
        START=(Button)findViewById(R.id.START);
        START.setOnClickListener(onClick);
        rd1=(CheckBox) findViewById(R.id.rd1);
        rd1.setOnClickListener(onClick);
        rd2=(CheckBox)findViewById(R.id.rd2);
        rd2.setOnClickListener(onClick);
        rd3=(CheckBox)findViewById(R.id.rd3);
        rd3.setOnClickListener(onClick);
        rd4=(CheckBox)findViewById(R.id.rd4);
        rd4.setOnClickListener(onClick);
        rd5=(CheckBox)findViewById(R.id.rd5);
        rd5.setOnClickListener(onClick);
        rd6=(CheckBox)findViewById(R.id.rd6);
        rd6.setOnClickListener(onClick);
        rd7=(CheckBox)findViewById(R.id.rd7);
        rd7.setOnClickListener(onClick);
        rd8=(CheckBox)findViewById(R.id.rd8);
        rd8.setOnClickListener(onClick);


        //Initialisation des TextView et EditView
        exo1 =(TextView)findViewById(R.id.exo1);
        exo2 =(TextView)findViewById(R.id.exo2);
        exo3 =(TextView)findViewById(R.id.exo3);
        exo4 =(TextView)findViewById(R.id.exo4);
        exo5 =(TextView)findViewById(R.id.exo5);
        exo6 =(TextView)findViewById(R.id.exo6);
        exo7 =(TextView)findViewById(R.id.exo7);
        exo8 =(TextView)findViewById(R.id.exo8);
        poids1=(EditText)findViewById(R.id.poids1);
        poids2=(EditText)findViewById(R.id.poids2);
        poids3=(EditText)findViewById(R.id.poids3);
        poids4=(EditText)findViewById(R.id.poids4);
        poids5=(EditText)findViewById(R.id.poids5);
        poids6=(EditText)findViewById(R.id.poids6);
        poids7=(EditText)findViewById(R.id.poids7);
        poids8=(EditText)findViewById(R.id.poids8);
        w1=(TextView) findViewById(R.id.w1);
        w2=(TextView) findViewById(R.id.w2);
        w3=(TextView) findViewById(R.id.w3);
        w4=(TextView) findViewById(R.id.w4);
        w5=(TextView) findViewById(R.id.w5);
        w6=(TextView) findViewById(R.id.w6);
        w7=(TextView) findViewById(R.id.w7);
        w8=(TextView) findViewById(R.id.w8);


        //Création de la liste déroulante

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        adapter1 =ArrayAdapter.createFromResource(this, R.array.listofexos, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Fin de la création de la liste déroulante

        //----------------------------------------------------------------------------------------------

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter1);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner3.setAdapter(adapter1);

        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner4.setAdapter(adapter1);

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner5.setAdapter(adapter1);

        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner6.setAdapter(adapter1);

        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner7.setAdapter(adapter1);

        spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner8 = (Spinner) findViewById(R.id.spinner8);
        spinner8.setAdapter(adapter1);

        spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        saveworkout=(Button)findViewById(R.id.saveworkout);
        saveworkout.setOnClickListener(onClick);

        LL1=(LinearLayout)findViewById(R.id.LL1);
        LL2=(LinearLayout)findViewById(R.id.LL2);
        LL3=(LinearLayout)findViewById(R.id.LL3);
        LL4=(LinearLayout)findViewById(R.id.LL4);
        LL5=(LinearLayout)findViewById(R.id.LL5);
        LL6=(LinearLayout)findViewById(R.id.LL6);
        LL7=(LinearLayout)findViewById(R.id.LL7);
        LL8=(LinearLayout)findViewById(R.id.LL8);
        whichLayout();




    }

    private View.OnClickListener onClick = new View.OnClickListener(){
        @Override
        //Le view définit quel bouton a été cliqué
        public void onClick(View v){                            //throws IncompleteException
            switch(v.getId()) {
                case R.id.rd8:
                    if (rd8.isChecked()){
                        poids8.setVisibility(View.VISIBLE);
                        w8.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids8.setVisibility(View.GONE);
                        w8.setVisibility(View.GONE);

                    }
                case R.id.rd7:
                    if (rd7.isChecked()){
                        poids7.setVisibility(View.VISIBLE);
                        w7.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids7.setVisibility(View.GONE);
                        w7.setVisibility(View.GONE);

                    }
                case R.id.rd6:
                    if (rd6.isChecked()){
                        poids6.setVisibility(View.VISIBLE);
                        w6.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids6.setVisibility(View.GONE);
                        w6.setVisibility(View.GONE);

                    }
                case R.id.rd5:
                    if (rd5.isChecked()){
                        poids5.setVisibility(View.VISIBLE);
                        w5.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids5.setVisibility(View.GONE);
                        w5.setVisibility(View.GONE);

                    }
                case R.id.rd4:
                    if (rd4.isChecked()){
                        poids4.setVisibility(View.VISIBLE);
                        w4.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids4.setVisibility(View.GONE);
                        w4.setVisibility(View.GONE);

                    }
                case R.id.rd3:
                    if (rd3.isChecked()){
                        poids3.setVisibility(View.VISIBLE);
                        w3.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids3.setVisibility(View.GONE);
                        w3.setVisibility(View.GONE);

                    }
                case R.id.rd2:
                    if (rd2.isChecked()){
                        poids2.setVisibility(View.VISIBLE);
                        w2.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids2.setVisibility(View.GONE);
                        w2.setVisibility(View.GONE);

                    }
                case R.id.rd1:
                    if (rd1.isChecked()){
                        poids1.setVisibility(View.VISIBLE);
                        w1.setVisibility(View.VISIBLE);
                        break;

                    }else {
                        poids1.setVisibility(View.GONE);
                        w1.setVisibility(View.GONE);

                    }

                    break;
                case R.id.add:
                    nbexo++;
                    whichLayout();
                    break;
                case R.id.START:

                    Intent i = new Intent(v.getContext(), ProgrammActivity.class);
                    name_workout=(TextView)findViewById(R.id.programme_name);
                    if (name_workout.getText().toString().equals("")){
                        name_workout.setText("Created Programme");
                    }
                    exoo1= getExercise(spinner1);
                    try{
                    exoo1=setExercise(exoo1, R.id.nbs1, R.id.nbr1, rd1, R.id.poids1, R.id.rest1);}catch(Exception e){}
                    if (getExercise(spinner2) == new Exercise()){
                        exoo2=null;
                    }
                    else{
                        try {
                            exoo2=getExercise(spinner2);
                            exoo2=setExercise(exoo2, R.id.nbs2, R.id.nbr2, rd2, R.id.poids2, R.id.rest2);
                        }catch (Exception e){
                            exoo2=null;
                        }

                    }


                    if (getExercise(spinner3) == new Exercise()){
                        exoo3=null;
                    }
                    else{
                        try {
                            exoo3=getExercise(spinner3);
                            exoo3=setExercise(exoo3, R.id.nbs3, R.id.nbr3, rd3, R.id.poids3, R.id.rest3);
                        }catch (Exception e){
                            exoo3=null;
                        }

                    }

                    if (getExercise(spinner4) == new Exercise()){
                        exoo4=null;
                    }
                    else{
                        try {
                            exoo4=getExercise(spinner4);
                            exoo4=setExercise(exoo4, R.id.nbs4, R.id.nbr4, rd4, R.id.poids4, R.id.rest4);
                        }catch (Exception e){
                            exoo4=null;
                        }

                    }

                    if (getExercise(spinner5) == new Exercise()){
                        exoo5=null;
                    }
                    else{
                        try {
                            exoo5=getExercise(spinner2);
                            exoo5=setExercise(exoo5, R.id.nbs5, R.id.nbr5, rd5, R.id.poids5, R.id.rest5);
                        }catch (Exception e){
                            exoo5=null;
                        }

                    }
                    if (getExercise(spinner6) == new Exercise()){
                        exoo6=null;
                    }
                    else{
                        try {
                            exoo6=getExercise(spinner2);
                            exoo6=setExercise(exoo2, R.id.nbs6, R.id.nbr6, rd6, R.id.poids6, R.id.rest6);
                        }catch (Exception e){
                            exoo6=null;
                        }

                    }

                    if (getExercise(spinner7) == new Exercise()){
                        exoo7=null;
                    }
                    else{
                        try {
                            exoo7=getExercise(spinner7);
                            exoo7=setExercise(exoo7, R.id.nbs7, R.id.nbr7, rd7, R.id.poids7, R.id.rest7);
                        }catch (Exception e){
                            exoo7=null;
                        }

                    }

                    if (getExercise(spinner8) == new Exercise()){
                        exoo8=null;
                    }
                    else{
                        try {
                            exoo8=getExercise(spinner8);
                            exoo8=setExercise(exoo8, R.id.nbs8, R.id.nbr8, rd8, R.id.poids8, R.id.rest8);
                        }catch (Exception e){
                            exoo8=null;
                        }

                    }
                    specialrest();


                    i.putExtra("restspecial", rest);
                    i.putExtra("exoo1", exoo1);
                    i.putExtra("exoo2", exoo2);
                    i.putExtra("exoo3", exoo3);
                    i.putExtra("exoo4", exoo4);
                    i.putExtra("exoo5", exoo5);
                    i.putExtra("exoo6", exoo6);
                    i.putExtra("exoo7", exoo7);
                    i.putExtra("exoo8", exoo8);
                    i.putExtra("isCreated", isCreated);
                    i.putExtra("name_workout", name_workout.getText().toString());

                    i.putExtra("compteur_exo", compteur_exo);
                    i.putExtra("compteur_serie", compteur_serie);
                    startActivity(i);

                    break;
                case R.id.saveworkout:
                    SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    name_workout=(TextView)findViewById(R.id.programme_name);
                    if (name_workout.getText().toString().equals("")){
                        name_workout.setText("Created Programme");

                    }
                    editor.putString("nameworkout1", name_workout.getText().toString());
                    editor.apply();
                    break;
            }
        }


    };


    public Exercise setExercise(Exercise e, int v, int w, CheckBox r, int y, int z) {
         try{
        e.nbseries=Integer.parseInt(((EditText)findViewById(v)).getText().toString());
        e.nbreps=Integer.parseInt(((EditText)findViewById(w)).getText().toString());}catch (Exception excep){
           //Toast.makeText(this, "Default repetitions/series applied on exercise(s) ! ", Toast.LENGTH_LONG).show();
        }
        //TODO Gérer d'une autre manière cette exception afin d'empêcher à l'utilisateur d'aller sur la prochaine page
        //Faire un test sur getExercise pour ne pas tomber dans le panneau pour les autres exo non remplis
        if (r.isChecked()){
            e.isPdc=false;
            e.setPoids(Integer.parseInt(((EditText)findViewById(y)).getText().toString()));
        }
        else{
            e.setPdc(true);
            e.setPoids(0);
        }

        e.repos=(int)Double.parseDouble(((EditText)findViewById(z)).getText().toString());



        return e;
    }

    public Exercise getExercise(Spinner s){
        //exoo1
        if (s.getSelectedItem().toString().equals("Bulgarian Split")){
            return new BulgarianSplit();
        }else if (s.getSelectedItem().toString().equals("Lunge")){
            return new Lunges();
        }else if (s.getSelectedItem().toString().equals("Squat")){
            return new Squat();
        }else if (s.getSelectedItem().toString().equals("Squat Hold")){
            return new Squat();                         //EN ATTENDANT !

        }else if (s.getSelectedItem().toString().equals("Narrow Push Up")){
            return new NarrowPushUp();
        }else if (s.getSelectedItem().toString().equals("Pike Push Up")){
            return new PikePushUp();
        }else {
            return new Exercise();  //PAR DEFAUT
        }
    }
    public void specialrest(){
        //TODO btwexo à ajuster pour textview
        try{rest[0]=Integer.parseInt(((EditText)findViewById(R.id.rest1bis)).getText().toString());}catch (Exception e1){};
        try{rest[1]=Integer.parseInt(((EditText)findViewById(R.id.rest2bis)).getText().toString());}catch (Exception e2){};
        try{rest[2]=Integer.parseInt(((EditText)findViewById(R.id.rest3bis)).getText().toString());}catch (Exception e3){};
        try{rest[3]=Integer.parseInt(((EditText)findViewById(R.id.rest4bis)).getText().toString());}catch (Exception e4){};
        try{rest[4]=Integer.parseInt(((EditText)findViewById(R.id.rest5bis)).getText().toString());}catch (Exception e5){};
        try{rest[5]=Integer.parseInt(((EditText)findViewById(R.id.rest6bis)).getText().toString());}catch (Exception e6){};
        try{rest[6]=Integer.parseInt(((EditText)findViewById(R.id.rest7bis)).getText().toString());}catch (Exception e7){};

    }

    public void whichLayout(){
        switch (nbexo){
            case 1:
                //Changer visibility
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.GONE);
                exo3.setVisibility(View.GONE);
                exo4.setVisibility(View.GONE);
                exo5.setVisibility(View.GONE);
                exo6.setVisibility(View.GONE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.GONE);
                spinner3.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.GONE);
                LL3.setVisibility(View.GONE);
                LL4.setVisibility(View.GONE);
                LL5.setVisibility(View.GONE);
                LL6.setVisibility(View.GONE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 2:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.GONE);
                exo4.setVisibility(View.GONE);
                exo5.setVisibility(View.GONE);
                exo6.setVisibility(View.GONE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.GONE);
                LL4.setVisibility(View.GONE);
                LL5.setVisibility(View.GONE);
                LL6.setVisibility(View.GONE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 3:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.GONE);
                exo5.setVisibility(View.GONE);
                exo6.setVisibility(View.GONE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.GONE);
                LL5.setVisibility(View.GONE);
                LL6.setVisibility(View.GONE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 4:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.VISIBLE);
                exo5.setVisibility(View.GONE);
                exo6.setVisibility(View.GONE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.GONE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.VISIBLE);
                LL5.setVisibility(View.GONE);
                LL6.setVisibility(View.GONE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 5:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.VISIBLE);
                exo5.setVisibility(View.VISIBLE);
                exo6.setVisibility(View.GONE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.GONE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.VISIBLE);
                LL5.setVisibility(View.VISIBLE);
                LL6.setVisibility(View.GONE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 6 :
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.VISIBLE);
                exo5.setVisibility(View.VISIBLE);
                exo6.setVisibility(View.VISIBLE);
                exo7.setVisibility(View.GONE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.VISIBLE);
                spinner7.setVisibility(View.GONE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.VISIBLE);
                LL5.setVisibility(View.VISIBLE);
                LL6.setVisibility(View.VISIBLE);
                LL7.setVisibility(View.GONE);
                LL8.setVisibility(View.GONE);
                break;
            case 7:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.VISIBLE);
                exo5.setVisibility(View.VISIBLE);
                exo6.setVisibility(View.VISIBLE);
                exo7.setVisibility(View.VISIBLE);
                exo8.setVisibility(View.GONE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.VISIBLE);
                spinner7.setVisibility(View.VISIBLE);
                spinner8.setVisibility(View.GONE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.VISIBLE);
                LL5.setVisibility(View.VISIBLE);
                LL6.setVisibility(View.VISIBLE);
                LL7.setVisibility(View.VISIBLE);
                LL8.setVisibility(View.GONE);
                break;
            case 8:
                exo1.setVisibility(View.VISIBLE);
                exo2.setVisibility(View.VISIBLE);
                exo3.setVisibility(View.VISIBLE);
                exo4.setVisibility(View.VISIBLE);
                exo5.setVisibility(View.VISIBLE);
                exo6.setVisibility(View.VISIBLE);
                exo7.setVisibility(View.VISIBLE);
                exo8.setVisibility(View.VISIBLE);
                spinner1.setVisibility(View.VISIBLE);
                spinner2.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);
                spinner6.setVisibility(View.VISIBLE);
                spinner7.setVisibility(View.VISIBLE);
                spinner8.setVisibility(View.VISIBLE);
                LL1.setVisibility(View.VISIBLE);
                LL2.setVisibility(View.VISIBLE);
                LL3.setVisibility(View.VISIBLE);
                LL4.setVisibility(View.VISIBLE);
                LL5.setVisibility(View.VISIBLE);
                LL6.setVisibility(View.VISIBLE);
                LL7.setVisibility(View.VISIBLE);
                LL8.setVisibility(View.VISIBLE);
                break;

        }

    }



}
