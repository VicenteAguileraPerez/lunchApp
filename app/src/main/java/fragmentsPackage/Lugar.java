package fragmentsPackage;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lunchapp.MainActivity;
import com.example.lunchapp.R;
import com.example.lunchapp.direcciones;
import com.example.lunchapp.formas_pago;
import com.example.lunchapp.menu_comida;
import com.example.lunchapp.redes_sociales;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lugar extends Fragment {

    private TabLayout tabLayout;
    private int numero_fragment =-1;
    public Lugar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_negocio_especifico, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // se niega el retroceso de fragment
        if(getActivity() instanceof MainActivity)
        {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            String titulo = sharedPreferences.getString("tipo_selecciones", "Error");
            getActivity().setTitle(titulo);
            ((MainActivity)getActivity()).activadoRetonrno(false);
            ((MainActivity)getActivity()).activadoToolBar(false);
        }
        //
        Fragment fragment = new direcciones();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_secundario,fragment).commit();


        tabLayout = view.findViewById(R.id.tabs);
        tabLayout.setOnTabSelectedListener(listener);


    }
    TabLayout.OnTabSelectedListener listener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int id = tab.getPosition();
            String fragmento = tab.getContentDescription().toString();
            numero_fragment=id;

            getNumeroFragmento();
        }
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };
    private void getNumeroFragmento(){
        Fragment fragment = null;
        switch (numero_fragment) {
            case 0:
                // Crea el nuevo fragmento y la transacción.
                fragment = new direcciones();
                //Toast.makeText(getActivity(), fragmento, Toast.LENGTH_SHORT).show();

                break;
            case 1:
                fragment = new menu_comida();
                //Toast.makeText(getActivity(), fragmento, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                fragment = new formas_pago();
                //Toast.makeText(getActivity(), fragmento, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                //Toast.makeText(getActivity(), fragmento, Toast.LENGTH_SHORT).show();
                fragment = new redes_sociales();
                break;
            case 4:
                //Toast.makeText(getActivity(), fragmento, Toast.LENGTH_SHORT).show();
                break;
        }

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_secundario,fragment).commit();

        Toast.makeText(getActivity(), String.valueOf(numero_fragment), Toast.LENGTH_SHORT).show();
    }


}
