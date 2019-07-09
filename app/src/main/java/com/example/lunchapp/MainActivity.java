package com.example.lunchapp;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.Navigation;

import java.util.Objects;


public class MainActivity extends AppCompatActivity
        //implements /*NavigationView.OnNavigationItemSelectedListener*/ View.OnTouchListener
{

    private boolean activarRetorno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hola mundo");
        //se referencia la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        //navigationView.setNavigationItemSelectedListener(this);

        //se crea el "botón" para abrir y cerrar el navigation menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.abrir_navigation_menu, R.string.cerrar_navigation_menu);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }
    // metodo que prohibe que se regrese a la pantalla anterior
    public void activadoRetonrno(boolean activarRetorno)
    {
        this.activarRetorno=activarRetorno;
    }
    public void activadoToolBar(boolean  activarToolBar)
    {
        if (activarToolBar)
        {
             Objects.requireNonNull(getSupportActionBar()).hide();
        }
        else
        {
            Objects.requireNonNull(getSupportActionBar()).show();
        }

    }

    @Override
    public void onBackPressed()
    {

        //utilizado para definir cuando si puedo regresar y cuando no


        if (activarRetorno)//se asigna 1 en el fragment principal chofer y usuario
        {//the fragment on which you want to handle your back press
            finish();
        }
        else{// si es diferente a inicio, principal usuario o principa chofer
            super.onBackPressed();

        }
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }
}
