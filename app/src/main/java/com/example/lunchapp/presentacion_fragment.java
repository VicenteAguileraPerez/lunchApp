package com.example.lunchapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.Navigation;

import static androidx.navigation.Navigation.findNavController;
import static com.example.lunchapp.R.id.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class presentacion_fragment extends Fragment {


    public presentacion_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_presentacion_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Navigation.findNavController(getView()).navigate(action_presentacion_fragment_to_inicio);

            }
        },1000);
    }
}
