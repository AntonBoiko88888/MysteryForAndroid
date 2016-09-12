package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class Settings_fragment extends Fragment {
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_layout_fragment,container,false);
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Настройки");
    }
}
