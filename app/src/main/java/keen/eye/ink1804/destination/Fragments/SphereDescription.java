package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.TypedValue;
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
public class SphereDescription extends Fragment implements View.OnClickListener {
    private View rootView;
    private String[] array;
    private TextView tv_details;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.spheres_fragment, container, false);
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
        int width = (size.x-2*dpToPx(6,getActivity()))/4;
        int length = array.length;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        for(int i=0;i<length;i++){
            Button btn = new Button(getActivity());
            btn.setText(array[(i+3)%length]);
            btn.setTag(array[(i+3)%length]);
            btn.setTextSize(10);
            btn.setId(500+i);
            btn.setBackgroundResource(R.drawable.btn_border_thin_circ);
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
            rootView.findViewById(500 + i).setBackgroundResource(R.drawable.btn_border_thin_circ);
        pressedButton.setBackgroundResource(R.drawable.btn_pressed_thin_circ);
        String key = view.getTag().toString();
        String[] names = getResources().getStringArray(R.array.profDetails_names);
        String[] details = getResources().getStringArray(R.array.profDetails_db);
        int id=-1;
        for(int i=0;i<names.length;i++){
            if(names[i].equals(key)){
                id=i;
                break;
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            tv_details.setText(Html.fromHtml(details[id], Html.FROM_HTML_MODE_LEGACY));
        } else {
            tv_details.setText(Html.fromHtml(details[id]));
        }
    }
    public int dpToPx(int dp, Context context) {
        /**
         * Converting dp to pixel
         */
        Resources r = context.getApplicationContext().getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
