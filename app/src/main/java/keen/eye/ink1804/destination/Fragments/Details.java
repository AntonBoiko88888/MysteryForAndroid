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
 * Created by Ink1804 on 08.08.16.
 */
public class Details extends Fragment {

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.details_fragment,container,false);
        fillData();
        return rootView;
    }
    private void fillData(){
        ((pushDateListener)getActivity()).toolbarSetTitle("Интерпретация");
        Bundle args = getArguments();
        String key = args.getString("key");
        String tag = args.getString("tag");
        TextView tv_details = (TextView) rootView.findViewById(R.id.details_tv);

        int id = -1;
        if(tag!=null&&key!=null)
        switch (tag){
            case "profileDetails":
                String[] names = getResources().getStringArray(R.array.profDetails_names);
                String[] details = getResources().getStringArray(R.array.profDetails_db);
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    tv_details.setText(setTvTextWithHtml(details[id]));
                else
                    tv_details.setText("Данные не были успешно загружены(");
                break;
            case "interesting":
                String[] interesting_db = getResources().getStringArray(R.array.interesting_db);
                String[] interesting_names = getResources().getStringArray(R.array.interesting_names);
                for (int i = 0; i < interesting_names.length; i++) {
                    if (interesting_names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    tv_details.setText(setTvTextWithHtml(interesting_db[id]));
                else
                    tv_details.setText("Данные не были успешно загружены(");
                break;
            case "com_birth":
                String[] com_names = getResources().getStringArray(R.array.com_marriage_names);
                String[] com_db = getResources().getStringArray(R.array.com_marriage_db);
                for (int i = 0; i < com_names.length; i++) {
                    if (com_names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    tv_details.setText(setTvTextWithHtml(com_db[id]));
                else
                    tv_details.setText("Данные не были успешно загружены(");
                break;
            case "socionics":
                String[] socioNames = getResources().getStringArray(R.array.socionics_names);
                String[] socioDB = getResources().getStringArray(R.array.socionics_db);
                for (int i = 0; i < socioNames.length; i++) {
                    if (socioNames[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                if(id!=-1)
                    tv_details.setText(setTvTextWithHtml(socioDB[id]));
                else
                    tv_details.setText("Данные не были успешно загружены(");
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
