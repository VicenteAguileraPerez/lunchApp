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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.navigation.Navigation;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lugares extends Fragment {

    EditText lblName;

    ListView lvListaNesgocios;
    private ArrayList<EntidadNegocio> listaNegocios = new ArrayList<>();
    private AdaptadorEntidadNegocio adaptadorEntidadNegocio;
    public Lugares() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lugares_mismo_tipo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // se niega el retroceso de fragment
        if(getActivity() instanceof MainActivity)
        {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            String titulo = sharedPreferences.getString("tipo_seleccion", "Error");
            ((MainActivity)getActivity()).activadoRetonrno(false);
            ((MainActivity)getActivity()).setTitle(titulo);
            ((MainActivity)getActivity()).activadoToolBar(false);
        }
        //
        lblName = view.findViewById(R.id.edit_text_buscar_lugar_mismo_tipo);


        lvListaNesgocios = view.findViewById(R.id.ListView_Lugares);
        adaptadorEntidadNegocio = new AdaptadorEntidadNegocio(getNegocios(), getActivity());
        lvListaNesgocios.setAdapter(adaptadorEntidadNegocio);

        lvListaNesgocios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();

                Navigation.findNavController(view).navigate(R.id.action_lugares_to_lugar );

            }
        });

    }

    private ArrayList<EntidadNegocio> getNegocios()
    {
        //se instancia de nuevo, para que no duplique datos, igualmente, aquí deberia hacer la consulta a la DB.
        listaNegocios = new ArrayList<>();
        listaNegocios.add( new EntidadNegocio(R.drawable.restaurante1,"Lugar 1"));
        listaNegocios.add( new EntidadNegocio(R.drawable.restaurante2,"Lugar 2"));
        return  listaNegocios;
    }


}
