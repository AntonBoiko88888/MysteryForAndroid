package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.Adapters.Sphere_vp_adapter;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class Sphere_container extends Fragment {
    private View rootView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.vp_sphere_container,container,false);
        initViews();
        return rootView;
    }


    private void initViews(){
        PagerTabStrip tabLayout = (PagerTabStrip) rootView.findViewById(R.id.pagerTabStrip);
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.desc_viewPager);
        Bundle args = getArguments();
        String toolbarText = args.getString("toolbar");
        String[] btnTextArray = args.getStringArray("array");
        int layoutType = args.getInt("type");

        ((pushDateListener) getActivity()).toolbarSetTitle(toolbarText);

        Sphere_vp_adapter mPagerAdapter = new Sphere_vp_adapter(getChildFragmentManager(),
                btnTextArray, layoutType/*, MainActivity.ACCESS*/);
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        tabLayout.setTextColor(ContextCompat.getColor(getContext(), R.color.blue));
        tabLayout.setTabIndicatorColor(ContextCompat.getColor(getContext(), R.color.blue));
    }
}
