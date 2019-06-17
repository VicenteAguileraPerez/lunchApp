package com.example.lunchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorEntidadTipoNegocio extends BaseAdapter
{
    private ArrayList<EntidadTipoNegocio> lista_tipo_de_negocios;
    private Context context;

    public AdaptadorEntidadTipoNegocio(ArrayList<EntidadTipoNegocio> lista_tipo_de_negocios, Context context) {
        this.lista_tipo_de_negocios = lista_tipo_de_negocios;
        this.context = context;
    }

    // va indicar al list view cuantos datos se van a cargar
    @Override
    public int getCount() {
        return lista_tipo_de_negocios.size();
    }
    //retornara del arryalist la entidad correspondiente
    @Override
    public Object getItem(int position) {
        return lista_tipo_de_negocios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //donde se va a crear cada item y donde se asignas los valores de cada elemento de cada item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        EntidadTipoNegocio Item = (EntidadTipoNegocio) getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
        ImageView img_foto = convertView.findViewById(R.id.negocio_img);
        TextView negocio_nombre = convertView.findViewById(R.id.negocio_nombre);
        TextView negocio_descripcion = convertView.findViewById(R.id.negocio_descripcion);

        //metodos de la entidad
        img_foto.setImageResource(Item.getImg_foto());
        negocio_nombre.setText(Item.getNegocio_nombre());
        negocio_descripcion.setText(Item.getNegocio_descripcion());

        return convertView;
    }
}
