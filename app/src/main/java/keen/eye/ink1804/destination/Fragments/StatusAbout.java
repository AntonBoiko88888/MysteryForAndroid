package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 22.11.16.
 */

public class StatusAbout extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.status_about_fragment, container, false);
        TextView beginning = (TextView) rootView.findViewById(R.id.beginning_text);
        TextView advanced = (TextView) rootView.findViewById(R.id.advanced_text);
        String[] status_about_db = getResources().getStringArray(R.array.status_about_db);
        beginning.setText(Html.fromHtml(status_about_db[0]));
        advanced.setText(Html.fromHtml(status_about_db[1]));
        rootView.findViewById(R.id.statAbout_purchase).setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener) getActivity();
        switch (view.getId()){
            case R.id.statAbout_purchase:
                if(MainActivity.mSettings.contains(Constants.APP_PREF_EMAIL)) {
                    listener.onPurchaseClick();
                }
                else{
                    listener.onRegEnter();
                }
                break;
        }

//        switch (view.getId()){
//            case R.id.statAbout_purchase:
//                break;
//        default: break;
//        }
    }
}
