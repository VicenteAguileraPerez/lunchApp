package com.example.lunchapp;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    private boolean activar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se referencia la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).hide();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //se crea el "botón" para abrir y cerrar el navigation menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.abrir_navigation_menu, R.string.cerrar_navigation_menu);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }
    // metodo que prohibe que se regrese a la pantalla anterior
    public void activado(boolean activar)
    {
        this.activar=activar;
    }

    @Override
    public void onBackPressed()
    {

        //utilizado para definir cuando si puedo regresar y cuando no


        if ( activar )//se asigna 1 en el fragment principal chofer y usuario
        {//the fragment on which you want to handle your back press
            finish();
        }
        else{// si es diferente a inicio, principal usuario o principa chofer
            super.onBackPressed();

        }
    }
}
