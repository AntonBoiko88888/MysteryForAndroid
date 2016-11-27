package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 22.11.16.
 */

public class StatusAbout extends Fragment implements View.OnClickListener {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.status_about_fragment,container,false);
        TextView beginning = (TextView)rootView.findViewById(R.id.beginning_text);
        TextView advanced = (TextView)rootView.findViewById(R.id.advanced_text);
        TextView advanced_money = (TextView)rootView.findViewById(R.id.advanced_money);
        String[] status_about_db = getResources().getStringArray(R.array.status_about_db);
        beginning.setText(Html.fromHtml(status_about_db[0]));
        advanced.setText(Html.fromHtml(status_about_db[1]));
        advanced_money.setText(Html.fromHtml(""));


        rootView.findViewById(R.id.statAbout_purchase).setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener) getActivity();
        listener.onPurchaseClick();
//        switch (view.getId()){
//            case R.id.statAbout_purchase:
//                break;
//        default: break;
//        }
    }
}
