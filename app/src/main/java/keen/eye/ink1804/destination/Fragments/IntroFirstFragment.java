package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 13.11.16.
 */

public class IntroFirstFragment extends Fragment {
    public IntroFirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_intro_first,container,false);
        return root;
    }
}
