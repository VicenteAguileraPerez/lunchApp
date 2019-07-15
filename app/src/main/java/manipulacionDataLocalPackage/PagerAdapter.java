package manipulacionDataLocalPackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragmentsTabs.direcciones;
import fragmentsTabs.menu_comida;
import fragmentsTabs.formas_pago;
import fragmentsTabs.redes_sociales;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numeroTabs;

    public PagerAdapter(FragmentManager fm, int numeroTabs) {
        super(fm);
        this.numeroTabs = numeroTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                direcciones direcciones = new direcciones();
                return direcciones;
            case 1:
                menu_comida menu_comida = new menu_comida();
                return  menu_comida;
            case 2:
                formas_pago formas_pago = new formas_pago();
                return formas_pago;
            case 3:
                redes_sociales redes_sociales = new redes_sociales();
                return redes_sociales;
            case 4:
                return null;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return numeroTabs;
    }
}
