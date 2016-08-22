package keen.eye.ink1804.destination.Fragments;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline_fragment extends Fragment {

    private View rootView;
    private String[] array;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.horoscope_online_layout_fragment,container,false);
        Bundle args = getArguments();
        array = args.getStringArray("array");
        createButtonMassive(array);
        return rootView;
    }
    private void createButtonMassive(String[] array){
        GridLayout grid = (GridLayout)rootView.findViewById(R.id.sphere_grid);
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x-10;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width/4, ViewGroup.LayoutParams.WRAP_CONTENT);

        for(int i=0;i<array.length;i++){
            Button btn = new Button(getActivity());
            btn.setText(array[(i+3)%12]);
            btn.setId(2000+array.length);
            btn.setTextSize(12);
            btn.setLayoutParams(layoutParams);
            grid.addView(btn);
        }
    }
}
