package com.example.lunchapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.navigation.Navigation;

import java.util.ArrayList;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class inicio extends Fragment {

    private ListView listaNegocios;
    private AdaptadorEntidadTipoNegocio adaptadorEntidadTipoNegocio;
    public inicio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categorias_comida, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listaNegocios = view.findViewById(R.id.ListView_categorias_comida);
        adaptadorEntidadTipoNegocio = new AdaptadorEntidadTipoNegocio(getNegocios(),getActivity());
        listaNegocios.setAdapter(adaptadorEntidadTipoNegocio);
        listaNegocios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                findNavController(view).navigate(R.id.action_inicio_to_lugares);
                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private ArrayList<EntidadTipoNegocio> getNegocios()
    {
        ArrayList<EntidadTipoNegocio> listaNegocios = new ArrayList<>();
        listaNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Negocio 1","Fonda Doña Cuca"));
        listaNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Negocio 2","Fonda Doña Cuca 2"));
        listaNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Negocio 3 ","Fonda Doña Cuca 3"));
        return  listaNegocios;
    }

}
