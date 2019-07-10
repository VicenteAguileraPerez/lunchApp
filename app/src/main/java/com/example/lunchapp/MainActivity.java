package com.example.lunchapp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.Objects;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private boolean activarRetorno;
    public MenuItem items;

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
        navigationView.setNavigationItemSelectedListener(this);

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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            // Handle the camera action
            item.setCheckable(true);

        }
        else if (id == R.id.nav_help) {

            item.setCheckable(true);
            if(item.isCheckable())
            {

                Toast.makeText(this,"checados",Toast.LENGTH_SHORT).show();
                //item.setCheckable(false);

            }
            Intent intent = new Intent(this, Main2Activity_Ayuda.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_quejas) {
            item.setCheckable(true);
        }

        /*else if (id == R.id.nav_tools) {

        }
        else if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_send) {

        }*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    /*public void clic (MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            // Handle the camera action

        }
        else if (id == R.id.nav_help) {

            Intent intent = new Intent(this, Main2Activity_Ayuda.class);
            startActivity(intent);


        }
        else if (id == R.id.nav_quejas) {

        }
    }*/


}
