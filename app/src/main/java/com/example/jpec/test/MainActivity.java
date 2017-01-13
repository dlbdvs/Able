package com.example.jpec.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by jpec on 02/01/17.
 */

public class MainActivity extends Activity {

    private Button create_prog;
    private Button choose_prog;
    Login_DbHelper myDB;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_prog=(Button)findViewById(R.id.create_prog);
        choose_prog=(Button)findViewById(R.id.choose_prog);
        create_prog.setOnClickListener(onClick);
        choose_prog.setOnClickListener(onClick);

        //ADDIND LOGIN TEST









        //END OF ADDING

    }
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.create_prog:
                    Intent i = new Intent(v.getContext(), CreateProgrammActivity.class);
                    startActivity(i);

                    break;
                case R.id.choose_prog:
                    Intent intent =new Intent(v.getContext(), ChooseProg.class);
                    startActivity(intent);

                    break;
            }

        }
    };
}
