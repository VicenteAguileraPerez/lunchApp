package fragmentsPackage;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;

import com.example.lunchapp.R;

public class Ayuda extends Fragment {

    int botonesAyudaColeccion[];

    public Ayuda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_ayuda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // se niega el retroceso de fragment
        /*if(getActivity() instanceof Main2Activity_Ayuda)
        {
            //((MainActivity)getActivity()).activadoRetonrno(false);
            //((Main2Activity_Ayuda)getActivity()).activadoToolBar(false);
        }
*/
        botonesAyudaColeccion = new int[]{
          R.id.btnProblemasTecnicos,
          R.id.btnAyuda
        };

      //  for ( int actual:botonesAyudaColeccion) {
            Button boton = view.findViewById(R.id.btnProblemasTecnicos);


            boton.setClickable(true);

            boton.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    Button botonA = (Button) v;
                    switch(event.getAction()) {
                        case MotionEvent.ACTION_DOWN:

                            botonA.setTextColor(getResources().getColor(R.color.colorblanco));
                            botonA.setBackgroundColor(Color.parseColor("#FF6634"));
                            botonA.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wrech_white, 0, 0, 0);

                            //retorna falso para que se puedan recibir clicks, y para que si el boton se desliza y se suelta
                            // , se active el clickListener

                            return false;
                        case MotionEvent.ACTION_UP:
                            botonA.setTextColor(getResources().getColor(R.color.colorPrimary));
                            botonA.setBackground(getResources().getDrawable(R.drawable.transparent_button_inactive));
                            botonA.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_wrench_orange, 0, 0, 0);
                            //Navigation.findNavController(v).navigate(R.id.action_ayuda_to_problemasTecnicos);
                            return false;
                    }
                    return false;
                }
            });
/*
* The TouchListener is executed before the view can respond to the event. The ClickListener will receive its event only after the view has handled it.
* Vic
* */
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ayuda_to_problemasTecnicos);
            }
        });


        //}
        boton = view.findViewById(R.id.btnAyuda);

        boton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Button botonA = (Button) v;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        botonA.setTextColor(getResources().getColor(R.color.colorblanco));
                        botonA.setBackgroundColor(Color.parseColor("#FF6634"));
                        botonA.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_help_white, 0, 0, 0);
                        return false;
                    case MotionEvent.ACTION_UP:
                        botonA.setTextColor(getResources().getColor(R.color.colorPrimary));
                        botonA.setBackground(getResources().getDrawable(R.drawable.transparent_button_inactive));
                        botonA.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_help_orange, 0, 0, 0);
                        //Navigation.findNavController(v).navigate(R.id.action_ayuda_to_ayuda2);
                        return false;
                }
                return false;
            }
        });
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_ayuda_to_ayuda2);
            }
        });



    }

    //cuando regrese de otro fragment, reestablezca el titulo
    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.ayuda);
    }
}
