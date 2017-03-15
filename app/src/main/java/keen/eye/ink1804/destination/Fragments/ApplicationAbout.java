package keen.eye.ink1804.destination.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 05.12.16.
 */

public class ApplicationAbout extends Fragment implements View.OnClickListener{

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.application_about_fragment, container, false);
        if (!((IsOnlaine) getActivity()).isOnline(getActivity())) {
            ((IsOnlaine) getActivity()).offlineMessageBox();
        }
        initializeViews();
        return rootView;
    }

    private void initializeViews() {
        ((IToolBar) getActivity()).toolbarSetTitle("О приложении");
        ((TextView) rootView.findViewById(R.id.application_about_text)).setText(setTvTextWithHtml(getResources().getStringArray(R.array.appintr_description_db)[5]));
        (rootView.findViewById(R.id.app_estimate)).setOnClickListener(this);

    }

    private Spanned setTvTextWithHtml(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }

    }

    @Override
    public void onClick(View view) {
        final String appPackageName = getActivity().getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}
