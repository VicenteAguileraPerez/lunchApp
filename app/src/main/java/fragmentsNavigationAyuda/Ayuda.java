package fragmentsNavigationAyuda;

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

import com.example.lunchapp.R;

import informes.DialogLA;

public class Ayuda extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ayuda,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.ayuda);

        Button botonNoCargaElementos = view.findViewById(R.id.btn_no_carga_elementos);

        botonNoCargaElementos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Button botonAyuda = (Button) v;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        botonAyuda.setTextColor(getResources().getColor(R.color.colorblanco));
                        botonAyuda.setBackgroundColor(Color.parseColor("#FF6634"));

                        return false;
                    case MotionEvent.ACTION_UP:
                        botonAyuda.setTextColor(getResources().getColor(R.color.colorPrimary));
                        botonAyuda.setBackground(getResources().getDrawable(R.drawable.transparent_button_inactive));

                        return false;
                }
                return false;

            }
        });

        botonNoCargaElementos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogLA dialog = new DialogLA(getContext(),R.string.dialog_carga_elementos,R.string.dialog_carga_elementos_mensaje);
            }
        });


    }
}
