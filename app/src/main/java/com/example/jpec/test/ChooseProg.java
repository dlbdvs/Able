package com.example.jpec.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jpec on 02/01/17.
 */

public class ChooseProg extends Activity {
    private Button w1;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseprog);
        w1=(Button)findViewById(R.id.workout1);
        w1.setOnClickListener(onClick);
    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){

                case R.id.workout1:
                    exoo1=new CloseGripPullUps(5,10,90.0);
                    Intent i1 = new Intent(v.getContext(), ProgrammActivity.class);
                    i1.putExtra("name_workout", "Armstrong -Pull ups- DAY 1");
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
                    startActivity(i1);
                    break;

                case R.id.workout2:
                    exoo1=new RegularPullUps(3,10,60.0);
                    exoo2=new CloseGripPullUps(3,10,60.0);
                    exoo3=new WidePullUps(3,10,60.0);
                    Intent i2 = new Intent(v.getContext(), ProgrammActivity.class);
                    i2.putExtra("name_workout", "Armstrong -Pull ups- DAY 3");
                    i2.putExtra("exoo1", exoo1);
                    i2.putExtra("exoo2", exoo2);
                    i2.putExtra("exoo3", exoo3);
                    i2.putExtra("exoo4", exoo4);
                    i2.putExtra("exoo5", exoo5);
                    i2.putExtra("exoo6", exoo6);
                    i2.putExtra("exoo7", exoo7);
                    i2.putExtra("exoo8", exoo8);
                    i2.putExtra("compteur_exo", compteur_exo);
                    i2.putExtra("compteur_serie", compteur_serie);
                    i2.putExtra("isCreated", isCreated);
                    startActivity(i2);
                    break;

                case R.id.workout3:
                    exoo1=new RegularPullUps(3,10,60.0);
                    exoo2=new CloseGripPullUps(3,10,60.0);
                    exoo3=new WidePullUps(3,10,60.0);
                    Intent i3 = new Intent(v.getContext(), ProgrammActivity.class);
                    i3.putExtra("name_workout", "Armstrong -Pull ups- DAY 3");
                    i3.putExtra("exoo1", exoo1);
                    i3.putExtra("exoo2", exoo2);
                    i3.putExtra("exoo3", exoo3);
                    i3.putExtra("exoo4", exoo4);
                    i3.putExtra("exoo5", exoo5);
                    i3.putExtra("exoo6", exoo6);
                    i3.putExtra("exoo7", exoo7);
                    i3.putExtra("exoo8", exoo8);
                    i3.putExtra("compteur_exo", compteur_exo);
                    i3.putExtra("compteur_serie", compteur_serie);
                    i3.putExtra("isCreated", isCreated);
                    startActivity(i3);
                    break;
                case R.id.workout4:
                    exoo1=new CloseGripPullUps(20,10,60.0);
                    Intent i4 = new Intent(v.getContext(), ProgrammActivity.class);
                    i4.putExtra("name_workout", "Armstrong -Pull ups- DAY 1");
                    i4.putExtra("exoo1", exoo1);
                    i4.putExtra("exoo2", exoo2);
                    i4.putExtra("exoo3", exoo3);
                    i4.putExtra("exoo4", exoo4);
                    i4.putExtra("exoo5", exoo5);
                    i4.putExtra("exoo6", exoo6);
                    i4.putExtra("exoo7", exoo7);
                    i4.putExtra("exoo8", exoo8);
                    i4.putExtra("compteur_exo", compteur_exo);
                    i4.putExtra("compteur_serie", compteur_serie);
                    i4.putExtra("isCreated", isCreated);
                    startActivity(i4);
                    break;


            }

        }};
}
