package keen.eye.ink1804.destination.Fragments_Advanced;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 23.09.16.
 */

public class NoAccess extends Fragment {

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.com_noaccess_fragment, container, false);
        context = getActivity();
        rootView.findViewById(R.id.na_btn_getAccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pushDateListener listener = (pushDateListener) getActivity();
                if (MainActivity.mSettings.contains(Constants.APP_PREF_EMAIL)) {
                    MainActivity mainActivity = new MainActivity();
                    if (mainActivity.isOnline(context))
                        listener.onPurchaseClick();
                    else
                        Toast.makeText(context, "Увы... Интернет соединение отсутствует :(", Toast.LENGTH_SHORT).show();
                } else {
                    listener.onRegEnter();
                }
            }
        });
        return rootView;
    }
}
