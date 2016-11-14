package keen.eye.ink1804.destination.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
        View root = inflater.inflate(R.layout.fragment_intro,container,false);
        String[] appintr_description = getResources().getStringArray(R.array.appintr_description);
        String[] appintr_description_db = getResources().getStringArray(R.array.appintr_description_db);
        TextView tv_title = (TextView) root.findViewById(R.id.appintr_title);
        TextView tv_details = (TextView) root.findViewById(R.id.appintr_first);
        Bundle bundle = this.getArguments();
        int i=bundle.getInt("int");
        Typeface tf_title = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        tv_title.setTypeface(tf_title);
//        tv_details.setTypeface(tf);
        tv_title.setText(Html.fromHtml(appintr_description[i]));
        tv_details.setText(Html.fromHtml(appintr_description_db[i]));


        return root;
    }
}
