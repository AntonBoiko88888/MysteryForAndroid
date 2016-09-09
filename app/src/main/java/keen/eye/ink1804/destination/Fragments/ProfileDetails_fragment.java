package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 08.08.16.
 */
public class ProfileDetails_fragment extends Fragment {

    private TextView tv_details;
    private View rootView;
    private String key,tag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile_details_layout_fragment,container,false);
        fillData();
        return rootView;
    }
    private void fillData(){
        Bundle args = getArguments();
        //null may be
        key = args.getString("key");
        tag = args.getString("tag");
        tv_details = (TextView)rootView.findViewById(R.id.details_tv);
        String[] names = getResources().getStringArray(R.array.db_names);
        String[] details = getResources().getStringArray(R.array.db_details);
        String[] interesting_names = getResources().getStringArray(R.array.interesting_names);
        String[] interesting_db = getResources().getStringArray(R.array.interesting_db);
        String[] com_names = getResources().getStringArray(R.array.com_names2);
        String[] com_db = getResources().getStringArray(R.array.com_db2);
        int id = -1;
        switch (tag){
            case "profileDetails":
                for (int i = 0; i < names.length; i++) {
                    if (names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                tv_details.setText(Html.fromHtml(details[id]));
                break;

            case "interesting":
                for (int i = 0; i < interesting_names.length; i++) {
                    if (interesting_names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                tv_details.setText(Html.fromHtml(interesting_db[id]));
                break;

            case "com_birth":
                for (int i = 0; i < com_names.length; i++) {
                    if (com_names[i].equals(key)) {
                        id = i;
                        break;
                    }
                }
                tv_details.setText(Html.fromHtml(com_db[id]));
                break;

            default:break;
        }
    }
}
