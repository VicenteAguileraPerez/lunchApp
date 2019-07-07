package com.example.lunchapp;


///será cada negocio, la pizzeria Ramones, BurgerMan, etc, un establecimiento en especifico.
public class EntidadNegocio {

    private int img_foto;
    private String negocio_nombre;

    //puede tener una pequeña descripcion, pero la omitiré por ahora
    //private String negocio_pequena_descripcion;


    public EntidadNegocio(int img_foto, String negocio_nombre) {
        this.img_foto = img_foto;
        this.negocio_nombre = negocio_nombre;
    }

    public int getImg_foto() {
        return img_foto;
    }

    /*public void setImg_foto(int img_foto) {
        this.img_foto = img_foto;
    }*/

    public String getNegocio_nombre() {
        return negocio_nombre;
    }

    /*public void setNegocio_nombre(String negocio_nombre) {
        this.negocio_nombre = negocio_nombre;
    }*/
}
