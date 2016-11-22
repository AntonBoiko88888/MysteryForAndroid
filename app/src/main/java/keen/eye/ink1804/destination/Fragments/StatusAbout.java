package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 22.11.16.
 */

public class StatusAbout extends Fragment {

    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.status_about_fragment,container,false);
        return rootView;
    }
}
