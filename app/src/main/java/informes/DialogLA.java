package informes;


import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lunchapp.R;

public class DialogLA  {

    public DialogLA(final Context context, int idTituloError, int idMensajeError) {
        final Dialog dialog = new Dialog(context);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_design);
        dialog.show();
        View btnAceptar = dialog.findViewById(R.id.btn_aceptar_error);
        TextView txtTitulo = dialog.findViewById(R.id.textView_tituloEror);

        TextView txtMensaje = dialog.findViewById(R.id.textView_mensajeError);

        txtTitulo.setText(idTituloError);
        txtMensaje.setText(idMensajeError);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnAceptar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Button botonAyuda = (Button) v;
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        botonAyuda.setTextColor(context.getResources().getColor(R.color.colorblanco));
                        botonAyuda.setBackgroundColor(Color.parseColor("#FF6634"));

                        return false;
                    case MotionEvent.ACTION_UP:
                        botonAyuda.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                        botonAyuda.setBackground(context.getResources().getDrawable(R.drawable.transparent_button_inactive));

                        return false;
                }
                return false;

            }
        });


    }



}
