package manipulacionDataLocalPackage;


///será cada negocio, la pizzeria Ramones, BurgerMan, etc, un establecimiento en especifico.
public class EntidadNegocio {

    private int img_foto;
    private String negocio_nombre;
    private String negocio_descripcion;

    public EntidadNegocio(int img_foto, String negocio_nombre, String negocio_descripcion ) {
        this.img_foto = img_foto;
        this.negocio_nombre = negocio_nombre;
        this.negocio_descripcion = negocio_descripcion;
    }

    public int getImg_foto() {
        return img_foto;
    }

    public String getNegocio_nombre() {
        return negocio_nombre;
    }

    public String getNegocio_descripcion() {
        return negocio_descripcion;
    }
}
