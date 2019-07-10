package com.example.lunchapp;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

public class Main2Activity_Ayuda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2__ayuda);
        //llamada al método para que se active la flecha en el Actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Ayuda");

        //setupActionBar();
    }



    //activar la -> en el actionbar para regresar

    private void setupActionBar()
    {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar !=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Ayuda");
        }
    }
}
