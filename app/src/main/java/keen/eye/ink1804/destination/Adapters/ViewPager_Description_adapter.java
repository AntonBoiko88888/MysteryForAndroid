package keen.eye.ink1804.destination.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import keen.eye.ink1804.destination.Fragments.Relationship_description_fragment;
import keen.eye.ink1804.destination.Fragments.SphereDescription_fragment;
import keen.eye.ink1804.destination.Fragments_Advanced.Compatibility_birth_fragment;
import keen.eye.ink1804.destination.Fragments_Advanced.Compatibility_relations_fragment;
import keen.eye.ink1804.destination.Fragments_Advanced.Compatibility_virtual_fragment;
import keen.eye.ink1804.destination.Fragments_Advanced.Compatibility_zodiac_fragment;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class ViewPager_Description_adapter extends FragmentStatePagerAdapter {

    private String[] btnTextArray;
    private int type;

    public ViewPager_Description_adapter(FragmentManager fm, String[] _btnTextArray, int _type) {
        super(fm);
        btnTextArray = _btnTextArray;
        type = _type;
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
                fragment = new Relationship_description_fragment();
            else {
                fragment = new SphereDescription_fragment();
                args.putStringArray("btnTextArray", btnTextArray);
            }
        }
        else {
            switch (type) {
                case 0:
                    fragment = new Compatibility_zodiac_fragment();
                    break;
                case 1:
                    fragment = new Compatibility_birth_fragment();
                    break;
                case 2:
                    fragment = new Compatibility_virtual_fragment();
                    break;
                case 3:
                    fragment = new Compatibility_relations_fragment();
                    break;
            }
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
