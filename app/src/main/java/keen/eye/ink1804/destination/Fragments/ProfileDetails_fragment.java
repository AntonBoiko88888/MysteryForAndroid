package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 08.08.16.
 */
public class ProfileDetails_fragment extends Fragment implements View.OnClickListener{

    View rootView;
    String key;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.profile_details_layout_fragment,container,false);
        Bundle args = getArguments();
        key = args.getString("key");

        Button btn = (Button)rootView.findViewById(R.id.asd);
        btn.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
//        TextView tv = (TextView)rootView.findViewById(R.id.asd);
//        int id=0;
//        Constants C = new Constants();
//        Toast.makeText(getActivity(), ""+id, Toast.LENGTH_SHORT).show();
//        //tv.setText(key+"\n"+virtuals.get(id).DECCRIPTION);
    }
}
