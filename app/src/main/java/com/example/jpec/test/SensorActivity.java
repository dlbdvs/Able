package com.example.jpec.test;

import android.content.Intent;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    private TextView xText, yText, zText, pucount, result;
    private Sensor mySensor;
    private SensorManager SM;
    private Button main;
    private float x=-1;
    private float y;
    private float z;
    private int pu=0;
    boolean init=false;
    private float ybis;
    boolean up=false;

/*
Il faut prendre en compte les degrés d'inclinaison du téléphone qui modifie également les valeurs de x, y et z !
 */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        main=(Button)findViewById(R.id.main);
        main.setOnClickListener(onClick);


        //Créer notre manager pour les capteurs
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);
        //On spécifie le type (accéléromètre) de notre capteur
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //Listener de notre capteur : il est mis dans le resume pour n'utiliser que les capteurs quand le téléphone n'est pas en veille
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);
        pucount=(TextView)findViewById(R.id.pucount);

        result=(TextView)findViewById(R.id.result);


        Resources res =getResources();
        String test=String.format(res.getString(R.string.pullup_count),pu);
        pucount.setText(test);



    }
    public void puCounter(){
        pu++;
        Resources res =getResources();
        String test=String.format(res.getString(R.string.pullup_count),(int)(pu/2));
        pucount.setText(test);
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.main:
                    Intent i = new Intent(v.getContext(), MainActivity.class);
                    startActivity(i);
                    break;
            }
        }
    };

    protected void onPause() {
        super.onPause();
        SM.unregisterListener(this); //Une pause sur l'appli permet d'arrêter la lecture de données et d'économiser de la batterie
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        if (!init){
            //Conditions initiales pour x, y et z
            x=event.values[0];
            y=event.values[1];
            ybis=event.values[1];
            z=event.values[2];
            init =true;

        }else{
            if (!up) {
                if (Math.abs(event.values[1]-y)>5){

                    if (event.values[1]>ybis) {
                        ybis = event.values[1];
                        up = true;
                        Resources res =getResources();
                        String test2=String.format(res.getString(R.string.result),y, up, (event.values[1]-y));
                        result.setText(test2);
                    }
                }
            }else {
                if (Math.abs(event.values[1] - y) < 1) {
                    up = false;
                    init = false;
                    puCounter();
                    Resources res =getResources();
                    String test2=String.format(res.getString(R.string.result),y, up, (event.values[1]-y));
                    result.setText(test2);
                }
            }
        }
    }
}