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
    private String key;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile_details_layout_fragment,container,false);
        fillData();
        return rootView;
    }
    private void fillData(){
        Bundle args = getArguments();
        key = args.getString("key");
        tv_details = (TextView)rootView.findViewById(R.id.details_tv);
        String[] names = getResources().getStringArray(R.array.db_names);
        String[] details = getResources().getStringArray(R.array.db_details);
        int id=-1;
        for(int i=0;i<names.length;i++){
            if(names[i].equals(key)){
                id=i;
                break;
            }
        }
        tv_details.setText(Html.fromHtml(details[id]));
    }
}