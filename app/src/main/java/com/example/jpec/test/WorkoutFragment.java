package com.example.jpec.test;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class WorkoutFragment extends Fragment {
    Button pec;
    Button leg;
    Button abs;
    Button back;
    Button done;
    Spinner spin1;
    ArrayAdapter<CharSequence> adap;






    public WorkoutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pec=(Button)getActivity().findViewById(R.id.pec);
        pec.setOnClickListener(onClickListener);
        back=(Button)getActivity().findViewById(R.id.back);
        back.setOnClickListener(onClickListener);
        leg=(Button)getActivity().findViewById(R.id.leg);
        leg.setOnClickListener(onClickListener);
        abs=(Button)getActivity().findViewById(R.id.abs);
        abs.setOnClickListener(onClickListener);
        done=(Button)getActivity().findViewById(R.id.done);
        done.setOnClickListener(onClickListener);





        spin1=(Spinner)getActivity().findViewById(R.id.spin1);
        adap =ArrayAdapter.createFromResource(getActivity(), R.array.listofexos, android.R.layout.simple_spinner_item);
        adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(adap);
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getBaseContext(),parent.getItemAtPosition(position)+ " selected", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.pec:
                    Toast.makeText(v.getContext(), "Vous avez choisi les pecs", Toast.LENGTH_LONG).show();
                    adap =ArrayAdapter.createFromResource(getActivity(), R.array.exolist_pec, android.R.layout.simple_spinner_item);
                    adap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spin1.setAdapter(adap);
                    spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                    break;
                case R.id.back:
                    Toast.makeText(v.getContext(), "Vous avez choisi le dos", Toast.LENGTH_LONG).show();
                    //TODO Plus tard, pas ici
                    //getActivity().getFragmentManager().popBackStack();
                    break;
                case R.id.abs:
                    Toast.makeText(v.getContext(), "Vous avez choisi les abdos", Toast.LENGTH_LONG).show();
                    getActivity().getFragmentManager().popBackStack();
                    break;
                case R.id.leg:
                    Toast.makeText(v.getContext(), "Vous avez choisi les jambes", Toast.LENGTH_LONG).show();
                    //getActivity().getFragmentManager().popBackStack();
                    break;
                case R.id.done:

                    SharedPreferences sharedPreferences=getActivity().getSharedPreferences("userWorkout", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("chosen_exo", spin1.getSelectedItem().toString());
                    editor.apply();

                    getActivity().getFragmentManager().popBackStack();
                    break;
            }
        }
    };


}
