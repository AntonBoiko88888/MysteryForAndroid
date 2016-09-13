package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.Adapters.ViewPager_Description_adapter;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class Description_fragment extends Fragment {
    private View rootView;
    private ViewPager viewPager;
    private PagerTabStrip tabLayout;
    private String[] btnTextArray;
    private int layoutType;
    private ViewPager_Description_adapter mPagerAdapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.description_layout_fragment,container,false);
        initViews();

        return rootView;
    }
    @Override
    public void onResume() {
        mPagerAdapter = new ViewPager_Description_adapter(getActivity().getSupportFragmentManager(),
                btnTextArray, layoutType);//*
        viewPager.setAdapter(mPagerAdapter);
        super.onResume();
    }

    private void initViews(){

        tabLayout = (PagerTabStrip) rootView.findViewById(R.id.pagerTabStrip);
        viewPager = (ViewPager)rootView.findViewById(R.id.desc_viewPager);
        Bundle args = getArguments();
        String toolbarText = args.getString("toolbar");
        btnTextArray = args.getStringArray("array");
        layoutType = args.getInt("type");

        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle(toolbarText);

        mPagerAdapter = new ViewPager_Description_adapter(getActivity().getSupportFragmentManager(),
                btnTextArray,layoutType);//*
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        tabLayout.setTextColor(getResources().getColor(R.color.blue));
        tabLayout.setTabIndicatorColor(getResources().getColor(R.color.blue));
    }
}
