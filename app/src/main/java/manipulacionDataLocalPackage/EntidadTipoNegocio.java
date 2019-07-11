package manipulacionDataLocalPackage;

public class EntidadTipoNegocio
{
    /*Esta entidad unicamente seteará miembros por medio del constructor
    *
    * */
    private int img_foto;
    private String tipo_negocio_nombre;
    private String tipo_negocio_descripcion;

    public EntidadTipoNegocio(int img_foto, String tipo_negocio_nombre, String tipo_negocio_descripcion) {
        this.img_foto = img_foto;
        this.tipo_negocio_nombre = tipo_negocio_nombre;
        this.tipo_negocio_descripcion = tipo_negocio_descripcion;
    }

    public int getImg_foto() {
        return img_foto;
    }

    public String getTipo_negocio_nombre() {
        return tipo_negocio_nombre;
    }

    public String getTipo_negocio_descripcion() {
        return tipo_negocio_descripcion;
    }

}
