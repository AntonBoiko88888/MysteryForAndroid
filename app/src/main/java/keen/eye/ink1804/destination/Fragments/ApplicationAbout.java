package keen.eye.ink1804.destination.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 05.12.16.
 */

public class ApplicationAbout extends Fragment{

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.application_about_fragment, container, false);
        initializeViews();
        return rootView;
    }

    private void initializeViews() {
        ((pushDateListener) getActivity()).toolbarSetTitle("О приложении");

        final TextView application_about_text = (TextView) rootView.findViewById(R.id.application_about_text);
        application_about_text.setText(setTvTextWithHtml(getResources().getStringArray(R.array.appintr_description_db)[5]));
    }

    private Spanned setTvTextWithHtml(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }

    }
}
