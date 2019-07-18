package fragmentsPackage;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
 import com.example.lunchapp.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class quejasysugenencias extends Fragment {

    private Button button_enviar_comentario;
    private EditText txt_correo;
    private EditText txt_queja;

    public quejasysugenencias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quejasysugenencias, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        configurarBotonEnviar(view,savedInstanceState);
        configurarEntradaEscritura(view,savedInstanceState);
    }


    /***
     * Configurar elemento(s)
     *
     * Por si necesita el uso de los elementos que recibe la funcíón padre
     * @param view
     * El view que entrega por defecto el onVIewCreated(...){}
     * @param savedInstanceState
     * Paquete de datos que entrega onViewCreated
     */
    private void configurarBotonEnviar(@NonNull View view, Bundle savedInstanceState){
        button_enviar_comentario= view.findViewById(R.id.button_enviarcomentario);
        button_enviar_comentario.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Button botonA = (Button) v;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        botonA.setTextColor(getResources().getColor(R.color.colorblanco));
                        botonA.setBackgroundColor(Color.parseColor("#FF6634"));
                        return false;
                    case MotionEvent.ACTION_UP:
                        botonA.setTextColor(getResources().getColor(R.color.colorPrimary));
                        botonA.setBackground(getResources().getDrawable(R.drawable.transparent_button_inactive));
                        return false;
                }
                return false;
            }
        });

        button_enviar_comentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Necesita la implementación de la acción click.
            }
        });
    }

    private void configurarEntradaEscritura(@NonNull View view, Bundle savedInstanceState) {

        txt_correo =  view.findViewById(R.id.editText_correodecontacto);
        txt_correo.requestFocus();
        //Enfocará el editText del correo y mostrará el teclado. Vic
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                InputMethodManager inputMethodManager =
                        (InputMethodManager) getActivity() .getSystemService( Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow( getActivity().getCurrentFocus().getWindowToken(), 0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
*/

}
