package keen.eye.ink1804.destination.Fragments_Advanced;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 23.09.16.
 */

public class NoAccess extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.com_noaccess_fragment, container, false);
        return rootView;
    }
}