package com.example.lunchapp;

public class EntidadTipoNegocio
{
    private int img_foto;
    private String negocio_nombre;
    private String negocio_descripcion;

    public EntidadTipoNegocio(int img_foto, String negocio_nombre, String negocio_descripcion) {
        this.img_foto = img_foto;
        this.negocio_nombre = negocio_nombre;
        this.negocio_descripcion = negocio_descripcion;
    }

    public int getImg_foto() {
        return img_foto;
    }

    public void setImg_foto(int img_foto) {
        this.img_foto = img_foto;
    }

    public String getNegocio_nombre() {
        return negocio_nombre;
    }

    public void setNegocio_nombre(String negocio_nombre) {
        this.negocio_nombre = negocio_nombre;
    }

    public String getNegocio_descripcion() {
        return negocio_descripcion;
    }

    public void setNegocio_descripcion(String negocio_descripcion) {
        this.negocio_descripcion = negocio_descripcion;
    }
}
