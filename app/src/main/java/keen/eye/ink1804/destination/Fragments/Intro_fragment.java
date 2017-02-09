package keen.eye.ink1804.destination.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 13.11.16.
 */

public class Intro_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.intro_fragment,container,false);
        int i = this.getArguments().getInt("number");
        switch (i) {
            case 0: ((ImageView) root.findViewById(R.id.appintr_img)).setImageDrawable(getActivity().getResources().getDrawable(R.drawable.icon_eye_512)); break;
            case 1: ((ImageView) root.findViewById(R.id.appintr_img)).setImageDrawable(getActivity().getResources().getDrawable(R.drawable.com_zod_rak)); break;
            case 2: ((ImageView) root.findViewById(R.id.appintr_img)).setImageDrawable(getActivity().getResources().getDrawable(R.drawable.com_birth_snake)); break;
            case 3: ((ImageView) root.findViewById(R.id.appintr_img)).setImageDrawable(getActivity().getResources().getDrawable(R.drawable.appintr_virtual_persona)); break;
            case 4: ((ImageView) root.findViewById(R.id.appintr_img)).setImageDrawable(getActivity().getResources().getDrawable(R.drawable.appintr_description)); break;
        }
        Typeface tf_title = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        ((TextView) root.findViewById(R.id.appintr_title)).setTypeface(tf_title);
        ((TextView) root.findViewById(R.id.appintr_title)).setText(Html.fromHtml(getResources().getStringArray(R.array.appintr_description)[i]));
        ((TextView) root.findViewById(R.id.appintr_first)).setText(Html.fromHtml(getResources().getStringArray(R.array.appintr_description_db)[i]));


        return root;
    }
    public Intro_fragment() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

}
