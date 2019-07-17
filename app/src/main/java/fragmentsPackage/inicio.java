package fragmentsPackage;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.navigation.Navigation;

import manipulacionDataLocalPackage.AdaptadorEntidadTipoNegocio;
import manipulacionDataLocalPackage.EntidadTipoNegocio;
import com.example.lunchapp.MainActivity;
import com.example.lunchapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class inicio extends Fragment{

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
        final View view = inflater.inflate(R.layout.fragment_categorias_comida, container, false);

        // se niega el retroceso de fragment
        if(getActivity() instanceof MainActivity)
        {
            ((MainActivity)getActivity()).activadoRetonrno(true);
            ((MainActivity)getActivity()).setTitle("Negocios Uruapan");
            ((MainActivity)getActivity()).activadoToolBar(false);
        }
        //

        lvListaTipoNegocios = view.findViewById(R.id.ListView_categorias_comida);
        adaptadorEntidadTipoNegocio = new AdaptadorEntidadTipoNegocio(getTiposNegocios(),getActivity());

        lvListaTipoNegocios.setAdapter(adaptadorEntidadTipoNegocio);

        lvListaTipoNegocios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {




                EntidadTipoNegocio entidadSeleccionada = listaTipoNegocios.get(position);
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                SharedPreferences.Editor miEditor = sharedPreferences.edit();
                miEditor.putString("tipo_seleccion",entidadSeleccionada.getTipo_negocio_nombre() );
                miEditor.apply();

                Navigation.findNavController(view).navigate(R.id.action_inicio_to_lugares);

            }
        });
        return view;
    }



    ///Aquí carga los tipos de negocios, cafeterias, pizzerias, etc, no?
    private ArrayList<EntidadTipoNegocio> getTiposNegocios()
    {
        listaTipoNegocios = new ArrayList<>();
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.background_inicio,"Tipo Negocio 1","Pizzas"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.semaforo,"Tipo Negocio 2","Cafés"));
        listaTipoNegocios.add( new EntidadTipoNegocio(R.drawable.fondo_noche,"Tipo Negocio 3 ","Tacos "));
        return  listaTipoNegocios;
    }




    /*public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                Toast.makeText(getActivity(),"abajo",Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                Toast.makeText(getActivity(),"arriba",Toast.LENGTH_SHORT).show();
                if(x1 > x2){
                    Intent i = new Intent(MainActivity.this, left.class);
                    startActivity(i);
                }
                else if(x1 < x2){

                    Intent i = new Intent(MainActivity.this, right.class);
                    startActivity(i);
                }
                break;
        }
        return true;
    }*/



    /*@Override
    public boolean onTouch(View view, MotionEvent touchEvent) {

            switch(touchEvent.getAction()){
                case MotionEvent.ACTION_DOWN:
                    x1 = touchEvent.getX();
                    y1 = touchEvent.getY();
                    System.out.println("\n\nx1="+x1+"  y1="+y1+"\n\n");
                    break;
                case MotionEvent.ACTION_UP:
                    x2 = touchEvent.getX();
                    y2 = touchEvent.getY();
                    if(x1 < x2){

                        //Intent i = new Intent(MainActivity.this, SwipeLeft.class);
                        //startActivity(i);
                        Navigation.findNavController(view).navigate(R.id.action_inicio_to_ayuda);
                    }
                    else if(x1 > x2){

                        //Intent i = new Intent(MainActivity.this, SwipeRight.class);
                        //startActivity(i);
                    }
                    System.out.println("\n\nx2="+x2+"  y2="+y2+"\n\n");
                    break;
            }

        return false;
    }*/


}


