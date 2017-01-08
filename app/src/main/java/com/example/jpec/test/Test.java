package com.example.jpec.test;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by jpec on 29/12/16.
 */

public class Test extends Activity {
    TextView exo1;
    Exercise exoo1;
    TextView data;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        exo1 = (TextView)findViewById(R.id.Test);
        data=(TextView)findViewById(R.id.TesT) ;
        exo1.setText("Hello !");
        Intent intent = getIntent();            //Récupère les données de CreateProgramm
        Bundle b = intent.getExtras();
        if(b!=null) {
            exoo1=intent.getParcelableExtra("exoo1");
            exo1.setText(exoo1.getNom()+" yeah !");
            data.setText("N° series: "+exoo1.getNbseries()+"\n N° rep : "
            +exoo1.getNbreps()+" Repos : "+exoo1.getRepos()+" Nom :"+exoo1.getNom()+ " "+exoo1.isPdc());
        }

    }
}

