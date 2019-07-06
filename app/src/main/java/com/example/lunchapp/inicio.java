package com.example.lunchapp;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class inicio extends Fragment {

    private ListView lvListaTipoNegocios;
    private AdaptadorEntidadTipoNegocio adaptadorEntidadTipoNegocio;
    ArrayList<EntidadTipoNegocio> listaTipoNegocios = new ArrayList<>();
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
        // se niega el retroceso de fragment
        if(getActivity() instanceof MainActivity)
        {
            ((MainActivity)getActivity()).activado(true);
        }
        //

        lvListaTipoNegocios = view.findViewById(R.id.ListView_categorias_comida);
        adaptadorEntidadTipoNegocio = new AdaptadorEntidadTipoNegocio(getTiposNegocios(),getActivity());

        lvListaTipoNegocios.setAdapter(adaptadorEntidadTipoNegocio);
        lvListaTipoNegocios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              //  Bundle miSeleccion = new Bundle();

                EntidadTipoNegocio entidadSeleccionada = listaTipoNegocios.get(position);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor miEditor = sharedPreferences.edit();
                //miSeleccion.putString("tip_seleccion",entidadSeleccionada.getTipo_negocio_nombre());
                miEditor.putString("tipo_seleccion",entidadSeleccionada.getTipo_negocio_nombre() );
                miEditor.apply();

                Navigation.findNavController(view).navigate(R.id.action_inicio_to_lugares/*,miSeleccion*/ );
                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    ///Aquí carga los tipos de negocios, cafeterias, pizzerias, etc, no?
    private ArrayList<EntidadTipoNegocio> getTiposNegocios()
    {
        listaTipoNegocios = new ArrayList<>();
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        return  listaTipoNegocios;
    }

}
