package fragmentsPackage;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lunchapp.MainActivity;
import com.example.lunchapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Lugar extends Fragment {


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
    }
}
