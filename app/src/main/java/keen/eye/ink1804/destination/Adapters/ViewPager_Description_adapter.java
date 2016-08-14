package keen.eye.ink1804.destination.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import keen.eye.ink1804.destination.Fragments.ViewPager_fragment;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class ViewPager_Description_adapter extends FragmentStatePagerAdapter {

    private String someString1;//*
    private String someString2;//*

    public ViewPager_Description_adapter(FragmentManager fm,String info1, String info2) {
        super(fm);
        this.someString1 = info1;//*
        this.someString2 = info2;//*
    }

    @Override
    public Fragment getItem(int position) {//*
        ViewPager_fragment fragment = new ViewPager_fragment();
        Bundle args = new Bundle();
        if(position==0)
            args.putString("someString1",someString1);
        else
            args.putString("someString1",someString2);
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
