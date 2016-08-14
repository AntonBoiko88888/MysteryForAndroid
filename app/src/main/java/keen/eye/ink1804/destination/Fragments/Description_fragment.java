package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.Adapters.ViewPager_Description_adapter;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class Description_fragment extends Fragment {
    private View rootView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private String page1,page2;//*
    private ViewPager_Description_adapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.description_layout_fragment,container,false);
        tabLayout = (TabLayout)rootView.findViewById(R.id.tablayout);
        viewPager = (ViewPager)rootView.findViewById(R.id.desc_viewPager);
        Bundle args = getArguments();
        page1 = args.getString("page1");//*
        page2 = args.getString("page2");//*
        mPagerAdapter = new ViewPager_Description_adapter(getActivity().getSupportFragmentManager(),
                "Description is here","Lets go and purchase this page");//*
        viewPager.setAdapter(mPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText(page1);
        tabLayout.getTabAt(1).setText(page2);
        return rootView;
    }
}
