package com.example.lunchapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;

public class Main2Activity_quejassugerencias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_quejassugerencias);
        setTitle(R.string.quejassugerencias);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                //ocultar teclado cuando entra directo por el menu drawer
                InputMethodManager inputMethodManager =
                (InputMethodManager) getSystemService( Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow( getCurrentFocus().getWindowToken(), 0);

                break;
        }
        //retonna a la actividad pricipal pero la inicia de nuevo
        //return super.onOptionsItemSelected(item);
        return true;
    }
}
