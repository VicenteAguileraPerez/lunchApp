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

import com.example.lunchapp.Main2Activity_Ayuda;
import com.example.lunchapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Ayuda extends Fragment {


    public Ayuda() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ayuda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // se niega el retroceso de fragment
        if(getActivity() instanceof Main2Activity_Ayuda)
        {
            //((MainActivity)getActivity()).activadoRetonrno(false);
            //((Main2Activity_Ayuda)getActivity()).activadoToolBar(false);
        }
        Button boton = view.findViewById(R.id.btnProblemasTecnicos);

        boton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Button botonA = (Button) v;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                      //  botonA.setBackgroundColor(Color.parseColor("#FF6634"));
                        //botonA.setHintTextColor(getResources().getColor(R.color.colorblanco));
                        botonA.setTextColor(getResources().getColor(R.color.colorblanco));
                        botonA.setBackgroundColor(Color.parseColor("#FF6634"));
                        return true;
                    case MotionEvent.ACTION_UP:
                        botonA.setTextColor(getResources().getColor(R.color.colorPrimary));
                        botonA.setBackground(getResources().getDrawable(R.drawable.transparent_button_inactive));
                        return true;
                }
                return false;
            }
        });
     /*   boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.parseColor("#FFFFFF"));
                ((Button)v).setHintTextColor(Color.parseColor("#FF6634"));
            }
        });*/
        //
    }
}
