package manipulacionDataLocalPackage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragmentsTabs.direcciones;
import fragmentsTabs.menu_comida;
import fragmentsTabs.formas_pago;
import fragmentsTabs.redes_sociales;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numeroTabs;

    public PagerAdapter(FragmentManager fm, int numeroTabs) {
        super(fm);
        this.numeroTabs = numeroTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new direcciones();
            case 1:
                return  new menu_comida();
            case 2:
                return new formas_pago();
            case 3:
                return new redes_sociales();
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
