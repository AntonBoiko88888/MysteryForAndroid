package keen.eye.ink1804.destination.Fragments;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 14.08.16.
 */
public class SphereDescription_fragment extends Fragment implements View.OnClickListener {
    private View rootView;
    private String[] array;
    private TextView tv_details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sphere_fragment_viewpager, container, false);
        Bundle args = getArguments();

        array = args.getStringArray("btnTextArray");
        createButtonMassive(array);
        return rootView;
    }
    private void createButtonMassive(String[] array){
        GridLayout grid = (GridLayout)rootView.findViewById(R.id.sphere_grid);
        tv_details = (TextView)rootView.findViewById(R.id.horOn_tvResult);

        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x-20;
        int length = array.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width/4, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<length;i++){
            Button btn = new Button(getActivity());
            btn.setText(array[(i+3)%length]);
            btn.setTag(array[(i+3)%length]);
            btn.setTextSize(10);
            btn.setId(500+i);
            btn.setBackgroundResource(R.drawable.btn_border_thin);
            btn.setLayoutParams(layoutParams);
            btn.setOnClickListener(this);
            grid.addView(btn);
        }
    }

    @Override
    public void onClick(View view) {
        int btnID = view.getId();
        Button pressedButton = (Button)rootView.findViewById(btnID);
        int length = array.length;
        for(int i=0;i<length;i++)
            rootView.findViewById(500 + i).setBackgroundResource(R.drawable.btn_border_thin);
        pressedButton.setBackgroundResource(R.drawable.btn_pressed_thin);
        String key = view.getTag().toString();
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
