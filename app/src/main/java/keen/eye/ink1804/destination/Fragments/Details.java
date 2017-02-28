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
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 08.08.16.
 */
public class Details extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.details_fragment,container,false);
//        if (!((pushDateListener) getActivity()).isOnline(getActivity())) {
//            ((pushDateListener) getActivity()).offlineMessageBox();
//        }
//        new FbUtills().setStatistics(5);
        fillData();
        return rootView;
    }
    private void fillData(){
        ((pushDateListener)getActivity()).AdShow();
        ((pushDateListener)getActivity()).toolbarSetTitle("Интерпретация");
        Bundle args = getArguments();
        String key = args.getString("key");
        String tag = args.getString("tag");

        int id = -1;
        if(tag!=null&&key!=null)
        switch (tag){
            case "profileDetails":
                String[] names = getResources().getStringArray(R.array.profDetails_names);
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText(setTvTextWithHtml(getResources().getStringArray(R.array.profDetails_db)[id]));
                else
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText("Данные не были успешно загружены(");
                break;
            case "interesting":
                String[] interesting_names = getResources().getStringArray(R.array.interesting_names);
                for (int i = 0; i < interesting_names.length; i++) {
                    if (interesting_names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText(setTvTextWithHtml(getResources().getStringArray(R.array.interesting_db)[id]));
                else
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText("Данные не были успешно загружены(");
                break;
            case "socionics":
                String[] socioNames = getResources().getStringArray(R.array.socionics_names);
                for (int i = 0; i < socioNames.length; i++) {
                    if (socioNames[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText(setTvTextWithHtml(getResources().getStringArray(R.array.socionics_db)[id]));
                else
                    ((TextView) rootView.findViewById(R.id.details_tv)).setText("Данные не были успешно загружены(");
                break;
            default:break;
        }
    }
    private Spanned setTvTextWithHtml(String text){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }

    }
}
