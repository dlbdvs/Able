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

    protected Exercise exoo1=new RegularPullUps(3,10,60.0);
    protected Exercise exoo2=new CloseGripPullUps(3,10,60.0);
    protected Exercise exoo3=new WidePullUps(3,10,60.0);
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
                    Intent i = new Intent(v.getContext(), ProgrammActivity.class);
                    i.putExtra("exoo1", exoo1);
                    i.putExtra("exoo2", exoo2);
                    i.putExtra("exoo3", exoo3);
                    i.putExtra("exoo4", exoo4);
                    i.putExtra("exoo5", exoo5);
                    i.putExtra("exoo6", exoo6);
                    i.putExtra("exoo7", exoo7);
                    i.putExtra("exoo8", exoo8);
                    i.putExtra("compteur_exo", compteur_exo);
                    i.putExtra("compteur_serie", compteur_serie);
                    i.putExtra("isCreated", isCreated);
                    startActivity(i);
                    break;
            }

        }};
}
