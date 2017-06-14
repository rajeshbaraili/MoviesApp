package com.example.rajesh.moviesapp.ActivityClasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.rajesh.moviesapp.R;


public class Fragmentone extends Fragment {
Button bt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.a_main, container, false);
bt=(Button)view.findViewById(R.id.btnLogin);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                activity.signIn();
            }
        });
        return view;


    }


}

