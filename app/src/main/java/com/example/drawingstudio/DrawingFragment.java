package com.example.drawingstudio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class DrawingFragment extends Fragment implements  View.OnClickListener  {


     private Button button;
View v;
    public DrawingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_drawing, container, false);


         button = v.findViewById(R.id.btnclickid);


        button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnclickid:
                Intent intent  = new Intent(getActivity(),MainActivity2.class);
                startActivity(intent);
        }
    }
}


