package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Descriptions;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 08.08.16.
 */
public class Description_fragment extends Fragment implements View.OnClickListener{

    View rootView;
    String key;
    List<Descriptions.virtual> virtuals = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.descriptions_layout_fragment,container,false);
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
