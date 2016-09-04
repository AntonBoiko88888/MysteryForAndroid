package keen.eye.ink1804.destination.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;

import keen.eye.ink1804.destination.Fragments.Relationship_description_fragment;
import keen.eye.ink1804.destination.Fragments.Settings_fragment;
import keen.eye.ink1804.destination.Fragments.SphereDescription_fragment;
import keen.eye.ink1804.destination.Fragments_Advenced.Compatibility_zodiac_fragment;

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
    public Fragment getItem(int position) {//*
        Fragment fragment = null;
        Bundle args = new Bundle();

        if(position==0) {
            switch (type){
                case 0:
                    fragment = new SphereDescription_fragment();
                    args.putStringArray("btnTextArray", btnTextArray);
                    break;
                case 2:
                    fragment = new Relationship_description_fragment();
                    break;
            }

        }
        else {
            fragment = new Compatibility_zodiac_fragment();//*
            args.putString("someString1", "This page is available for advanced users");
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
