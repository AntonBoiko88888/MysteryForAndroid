package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class ViewPager_fragment extends Fragment {
    private View rootView;
    private String some1;//*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_description_viewpager, container, false);
        TextView tv = (TextView)rootView.findViewById(R.id.tv_pager);
        Bundle args = getArguments();//*
        some1 = args.getString("someString1");//*
        tv.setText(some1);
        return rootView;
    }
}
