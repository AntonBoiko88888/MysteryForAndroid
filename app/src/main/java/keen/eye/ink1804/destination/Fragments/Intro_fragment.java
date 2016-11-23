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
    public Intro_fragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.intro_fragment,container,false);
        String[] appintr_description = getResources().getStringArray(R.array.appintr_description);
        String[] appintr_description_db = getResources().getStringArray(R.array.appintr_description_db);
        TextView tv_title = (TextView) root.findViewById(R.id.appintr_title);
        TextView tv_details = (TextView) root.findViewById(R.id.appintr_first);
        ImageView img = (ImageView) root.findViewById(R.id.appintr_img);
        Bundle bundle = this.getArguments();
        int i=bundle.getInt("number");
        switch (i) {
            case 0: img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.icon_eye_512)); break;
            case 1: img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.com_zod_rak)); break;
            case 2: img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.com_birth_snake)); break;
            case 3: img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.appintr_virtual_persona)); break;
            case 4: img.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.appintr_description)); break;
        }
        Typeface tf_title = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        tv_title.setTypeface(tf_title);
        tv_title.setText(Html.fromHtml(appintr_description[i]));
        tv_details.setText(Html.fromHtml(appintr_description_db[i]));


        return root;
    }
}
