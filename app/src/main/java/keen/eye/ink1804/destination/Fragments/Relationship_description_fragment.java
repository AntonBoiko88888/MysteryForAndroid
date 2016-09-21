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
import android.widget.Toast;

import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Relationship_description_fragment extends Fragment implements View.OnClickListener{

    private View rootView;
    private TextView tv_info;
    Button saveProfaile;

    String[] tmp = {"-1","-1","-1","-1"};

    private String[] names = {"Рационал","Иррационал","Логик","Этик","Интуитив","Сенсорик","Экстраверт","Интроверт"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.relationship_desc_fragment_viewpager,container,false);
        initViews();
        return rootView;
    }
    private void initViews(){
        GridLayout grid = (GridLayout)rootView.findViewById(R.id.relD_grid);
        createGridButtons(grid);
        tv_info = (TextView)rootView.findViewById(R.id.relD_tv_info);
        Button btnShowInfo = (Button)rootView.findViewById(R.id.relD_btn_showInfo);
        btnShowInfo.setOnClickListener(this);
        saveProfaile = (Button)rootView.findViewById(R.id.save_in_profile);
        saveProfaile.setVisibility(Button.GONE);
    }


    private void createGridButtons(GridLayout grid){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x-20;
        int height = size.y/20;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width/2, height);
        for(int i=0;i<8;i++){
            Button btn = new Button(getActivity());
            btn.setText(names[i]);
            btn.setTag(""+i%2);
            btn.setTextSize(14);
            btn.setId(2000+i);
            btn.setBackgroundResource(R.drawable.btn_border_thin);

            btn.setLayoutParams(layoutParams);
            btn.setOnClickListener(this);
            grid.addView(btn);
        }

    }
    private String getSocialType(String n1,String n2, String n3,String n4){
        int i,j,k,l;
        i = Integer.parseInt(n1);
        j = Integer.parseInt(n2);
        k = Integer.parseInt(n3);
        l = Integer.parseInt(n4);
        return Constants.SOCIONICS[i][j][k][l];
    }
    private void setTvInfoText(String key_Name){
        String[] names = getResources().getStringArray(R.array.relation_description_name);
        String[] details = getResources().getStringArray(R.array.relation_description_db);
        int id = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(key_Name)) {
                id = i;
                break;
            }
        }
        tv_info.setText(Html.fromHtml(details[id]));
    }
    @Override
    public void onClick(View view) {
            if(view.getId() == R.id.relD_btn_showInfo) {
 //А здесь работает       saveProfaile.setVisibility(Button.VISIBLE);
                if (tmp[0].equals("-1") || tmp[1].equals("-1") || tmp[2].equals("-1") || tmp[3].equals("-1"))
                    Toast.makeText(getActivity(), "Выберите все пункты", Toast.LENGTH_SHORT).show();
                else {
                    String socioType = getSocialType(tmp[0], tmp[1], tmp[2], tmp[3]);
                    setTvInfoText(socioType);
// Почему-то здесь не работает это:  saveProfaile.setVisibility(Button.VISIBLE);
                }
            }
            else {
                saveProfaile.setVisibility(Button.GONE);
                int btnID = view.getId();
                Button pressedButton = (Button)rootView.findViewById(btnID);
                setTvInfoText(pressedButton.getText().toString());
                pressedButton.setBackgroundResource(R.drawable.btn_pressed_thin);
                tmp[btnID % 2000 / 2] = pressedButton.getTag().toString();

                if (btnID % 2 == 1)
                    rootView.findViewById(btnID - 1).setBackgroundResource(R.drawable.btn_border_thin);
                else
                    rootView.findViewById(btnID + 1).setBackgroundResource(R.drawable.btn_border_thin);

            }
    }
}
