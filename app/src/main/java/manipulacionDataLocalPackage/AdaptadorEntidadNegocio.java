package manipulacionDataLocalPackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lunchapp.R;

import java.util.ArrayList;

public class AdaptadorEntidadNegocio extends BaseAdapter {

    private ArrayList<EntidadNegocio> lista_de_negocios;
    private Context context;

    public AdaptadorEntidadNegocio(ArrayList<EntidadNegocio> lista_de_negocios, Context context) {
        this.lista_de_negocios = lista_de_negocios;
        this.context = context;
    }


    @Override
    public int getCount() {
        return lista_de_negocios.size();
    }

    @Override
    public Object getItem(int position) {
        return lista_de_negocios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntidadNegocio Item = (EntidadNegocio) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_negocio,null);

        ImageView img_foto = convertView.findViewById(R.id.negocio_img);
        TextView negocio_nombre = convertView.findViewById(R.id.negocio_nombre);
        TextView negocio_descripcion = convertView.findViewById(R.id.negocio_descripcion);

        //metodos de la entidadNegocio
        img_foto.setImageResource(Item.getImg_foto());
        negocio_nombre.setText(Item.getNegocio_nombre());
        negocio_descripcion.setText(Item.getNegocio_descripcion());

        return convertView;
    }


}
