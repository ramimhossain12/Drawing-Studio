package com.example.drawingstudio;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class AboutFragment extends Fragment implements View.OnClickListener {


       View v;
    private TextView textView;

    public AboutFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_about, container, false);
        textView = v.findViewById(R.id.textID);
        textView.setOnClickListener(this);
        return v;



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textID:
                Intent intent  = new Intent(getActivity(),MainActivity2.class);
                startActivity(intent);
        }
    }
}