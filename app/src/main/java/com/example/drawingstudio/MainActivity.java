package com.example.drawingstudio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {


    ChipNavigationBar bottomNav;

    FragmentManager fragmentManager;
    private static final String Tag = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = findViewById(R.id.bottom_nav);

        if (savedInstanceState ==null){
            bottomNav.setItemSelected(R.id.home,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragmen = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_constainer,homeFragmen)
                    .commit();
        }


        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                Fragment  fragment = null;
                switch (i){
                    case  R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case  R.id.drawing:
                        fragment = new DrawingFragment();
                        break;

                    case R.id.about:
                        fragment = new AboutFragment();
                        break;
                }

                if (fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_constainer,fragment)
                            .commit();

                }
                else {
                    Log.e(Tag,"Error in createing fragment");
                }
            }
        });
    }
}