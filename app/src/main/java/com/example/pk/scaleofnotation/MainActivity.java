package com.example.pk.scaleofnotation;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PutInformationFragment pif = PutInformationFragment.newInstance();

        ScaleOfNotationFragment sonf = ScaleOfNotationFragment.newInstance();
        pif.setScaleOfNotationListener(sonf);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.add(R.id.pif_container, pif
                , PutInformationFragment.class.getSimpleName());
        ft.add(R.id.sonf_container, sonf
                , ScaleOfNotationFragment.class.getSimpleName());

        ft.commit();

    }
}
