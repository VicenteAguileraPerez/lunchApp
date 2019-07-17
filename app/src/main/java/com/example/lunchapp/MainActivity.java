package com.example.lunchapp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Objects;



public class MainActivity extends AppCompatActivity
{

    private boolean activarRetorno;
    private ListView listaItems;
    private String[] items = {"Ayuda", "Quejas y sugerencias"};


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_main_));
       // Objects.requireNonNull(getSupportActionBar()).show();//oculta el toolbar
        mDrawerLayout = findViewById(R.id.navigation_drawer);
        listaItems = findViewById(R.id.navigation_items);
        listaItems.addHeaderView(cargarHeader());
        seleccionaItem(listaItems,items);
        setupDrawer();
      //  mDrawerLayout.setScrimColor(getResources().getColor(R.color.colorThird) );
        //mDrawerLayout.setStatusBarBackgroundColor(getResources().getColor(R.color.colorblanco));
        //cambia el color de las 3 barritas del toggle
        mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorblanco));

        mDrawerToggle.syncState();//sincroniza el boton del toolbar con el navigation Drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);




    }

    /*******************************************
     * METODOS PRIVATE
     ******************************************/
        //retorna el header para cargarlo a la listView
        private View cargarHeader ()
        {
            return getLayoutInflater().inflate(R.layout.nav_header_main,null,false);
        }
        //metodo que permite seleccionar los items
        private void seleccionaItem(ListView lista,String[] items)
        {
            final ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
            lista.setAdapter(adaptador);
            //para items del navigation Drawer
            lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                    // TODO Auto-generated method stub
                    try {
                        //getSupportActionBar().setTitle(adaptador.getItem(position-1));
                        //Toast.makeText(getApplicationContext(), "Ha pulsado e;l item " + adaptador.getItem(position-1), Toast.LENGTH_SHORT).show();

                        accion(adaptador.getItem(position-1));

                    }
                    catch (Exception E)
                    {

                    }
                    mDrawerLayout.closeDrawer(GravityCompat.START);

                }
            });
        }
        // metodo para ver que opción del menu fue selccionada y abrir la actividad
        private void accion(String opcion)
        {
            Intent intent = null;
            switch (opcion)
            {
                case "Ayuda":
                    intent = new Intent(this, Main2Activity_Ayuda.class);

                    break;
                case "Quejas y sugerencias":
                    intent = new Intent(this,Main2Activity_quejassugerencias.class);
            }
            startActivity(intent);

        }
        //metodo para aplicar el efecto que se cambien las rallitas del toolbar por la flecha
        private void setupDrawer()
        {
            mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close){

                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    invalidateOptionsMenu();
                }

                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                    //getSupportActionBar().setTitle(mActivityTitle);
                    invalidateOptionsMenu();
                }
            };

            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerLayout.setDrawerListener(mDrawerToggle);
        }
     /********************************************/

    /*******************************************
     * METODOS PUBLIC
     ******************************************/
        // metodo que prohibe que se regrese a la pantalla anterior
        public void activadoRetonrno(boolean activarRetorno)
        {
            this.activarRetorno=activarRetorno;
        }

        // metodo que permite que sea visible el toolbar o no sea
        public void activadoToolBar(boolean  activarToolBar)
        {
            if (activarToolBar)
            {
                 Objects.requireNonNull(getSupportActionBar()).hide();//oculta el toolbar
            }
            else
            {
                Objects.requireNonNull(getSupportActionBar()).show();//muestra el toolbar
            }

    }
    /********************************************/
    /*******************************************
     * METODOS OVERRIDE
     ******************************************/
    @Override
    public void onBackPressed()
    {

        //utilizado para definir cuando si puedo regresar y cuando no
        if (activarRetorno)
        {
            if(listaItems.getVisibility() == View.VISIBLE)
            {
                mDrawerLayout.closeDrawer(Gravity.START);
            }
            else{
                finish();
            }

        }
        else{
            if(listaItems.getVisibility() == View.VISIBLE)
            {
                mDrawerLayout.closeDrawer(Gravity.START);
            }
            else{
                super.onBackPressed();
            }


        }
    }
    //para items del toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(mDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    /********************************************/



}
