package keen.eye.ink1804.destination.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import keen.eye.ink1804.destination.Fragments.Socionics;
import keen.eye.ink1804.destination.Fragments.SphereDescription;
import keen.eye.ink1804.destination.Fragments_Advanced.Com_birthSign;
import keen.eye.ink1804.destination.Fragments_Advanced.Com_socionics;
import keen.eye.ink1804.destination.Fragments_Advanced.Com_virtualSign;
import keen.eye.ink1804.destination.Fragments_Advanced.Com_zodiacSign;
import keen.eye.ink1804.destination.Fragments_Advanced.NoAccess;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class Sphere_vp_adapter extends FragmentStatePagerAdapter {

    private String[] btnTextArray;
    private int type;
    private boolean access;

    public Sphere_vp_adapter(FragmentManager fm, String[] _btnTextArray, int _type, boolean _access) {
        super(fm);
        btnTextArray = _btnTextArray;
        type = _type;
        access = _access;
    }


    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public Fragment getItem(int position) {//*
        Fragment fragment = null;
        Bundle args = new Bundle();
        if(position==0) {
            if(type == 3)
                fragment = new Socionics();
            else {
                fragment = new SphereDescription();
                args.putStringArray("btnTextArray", btnTextArray);
            }
        }
        else {
            if(access)
            switch (type) {
                case 0:
                    fragment = new Com_zodiacSign();
                    break;
                case 1:
                    fragment = new Com_birthSign();
                    break;
                case 2:
                    fragment = new Com_virtualSign();
                    break;
                case 3:
                    fragment = new Com_socionics();
                    break;
                default:break;
            }
            else
                fragment = new NoAccess();
        }
            fragment.setArguments(args);
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Описание";
        else
            return "Совместимость";
    }

    @Override
    public int getCount() {
        return 2;
    }
}
