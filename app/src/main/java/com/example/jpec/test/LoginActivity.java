package com.example.jpec.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by jpec on 12/01/17.
 */

public class LoginActivity extends AppCompatActivity {

    Login_DbHelper myDB;
    Button register;
    Button login;
    EditText username;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.uname);
        pass = (EditText) findViewById(R.id.pass);

        register = (Button) findViewById(R.id.register);
        login =(Button)findViewById(R.id.login);
        myDB = new Login_DbHelper(this);
        register.setOnClickListener(onClick);
        login.setOnClickListener(onClick);





    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.register:
                    Intent i = new Intent(v.getContext(), Register.class);
                    startActivity(i);

                    break;
                case R.id.login:
                    String uname = username.getText().toString();
                    String mdp = pass.getText().toString();
                    if ((uname.length() != 0) && (mdp.length() != 0)) {

                        boolean[] answer= isMember(uname, mdp);
                        if (!answer[0]){
                            Toast.makeText(v.getContext(), "Pseudo doesn't exist !", Toast.LENGTH_LONG).show();
                            return;
                        }else{
                            if(!answer[1]){
                                Toast.makeText(v.getContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }
                        Intent i2 = new Intent(v.getContext(), MainActivity.class);
                        saveInfo();
                        startActivity(i2);
                    }

                    break;
            }

        }
    };

    private boolean [] isMember(String uname, String mdp){
        boolean [] answer = new boolean[] {false, false};
        Cursor data = myDB.getListContents();
        while (data.moveToNext()) {
            if (data.getString(0).equals(uname)) {
                answer[0]=true;
                if (data.getString(1).equals(mdp)) {
                    answer[1]=true;
                }
                return answer;

            }
        }
        return answer;
    }

    private void saveInfo(){
        SharedPreferences sharedPreferences=getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username.getText().toString() );
        editor.putInt("xp", 0);
        editor.apply();
    }
}







