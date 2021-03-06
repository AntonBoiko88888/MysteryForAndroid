package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
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

import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 28.08.16.
 */
public class Socionics extends Fragment implements View.OnClickListener{

    private View rootView;
    private String socioType;

    String[] tmp = {"-1","-1","-1","-1"};

    private String[] names = {"Рационал","Иррационал","Логик","Этик","Интуитив","Сенсорик","Экстраверт","Интроверт"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.socionics_fragment,container,false);
        if (!((IsOnlaine) getActivity()).isOnline(getActivity())) {
            ((IsOnlaine) getActivity()).offlineMessageBox();
        }
        initViews();
        return rootView;
    }
    private void initViews(){
        GridLayout grid = (GridLayout)rootView.findViewById(R.id.relD_grid);
        createGridButtons(grid);
        (rootView.findViewById(R.id.relD_btn_showInfo)).setOnClickListener(this);
        (rootView.findViewById(R.id.relD_btn_save_prof)).setVisibility(View.INVISIBLE);
        (rootView.findViewById(R.id.relD_btn_save_prof)).setOnClickListener(this);
        (rootView.findViewById(R.id.relD_btn_save_prof)).setEnabled(false);
    }


    private void createGridButtons(GridLayout grid){
        Data_calculation dc = new Data_calculation();
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int dp = (int) (getResources().getDimension(R.dimen.defaultMargin) / getResources().getDisplayMetrics().density);
        int defMargin = dc.dpToPx(dp,getActivity());
        int width = (size.x-2*defMargin)/2;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, width/5);
        for(int i=0;i<8;i++){
            Button btn = new Button(getActivity());
            btn.setText(names[i]);
            btn.setTag(""+i%2);
            btn.setTextSize(getResources().getDimension(R.dimen.sphere_btn_text_size));
            btn.setId(2000+i);
            btn.setBackgroundResource(R.drawable.btn_border_thin_circ);
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
        String[] names = getResources().getStringArray(R.array.socionics_names);
        String[] details = getResources().getStringArray(R.array.socionics_db);
        int id = -1;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(key_Name)) {
                id = i;
                break;
            }
        }
        if(id!=-1)
            ((TextView)rootView.findViewById(R.id.relD_tv_info)).setText(Html.fromHtml(details[id]));
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.relD_btn_showInfo:
                if (tmp[0].equals("-1") || tmp[1].equals("-1") || tmp[2].equals("-1") || tmp[3].equals("-1"))
                    Toast.makeText(getActivity(), "Выберите все пункты", Toast.LENGTH_SHORT).show();
                else {
                    socioType = getSocialType(tmp[0], tmp[1], tmp[2], tmp[3]);
                    setTvInfoText(socioType);
                    (rootView.findViewById(R.id.relD_btn_save_prof)).setVisibility(View.VISIBLE);
                    (rootView.findViewById(R.id.relD_btn_save_prof)).setEnabled(true);
                }
                break;
            case R.id.relD_btn_save_prof:
                SharedPreferences mSettings;
                mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(Constants.APP_PREF_SOCIONICS, socioType);
                Toast.makeText(getActivity(), socioType+" - сохранено в профиль", Toast.LENGTH_SHORT).show();
                editor.apply();
                break;
            default:
                int btnID = view.getId();
                Button pressedButton = (Button)rootView.findViewById(btnID);
                setTvInfoText(pressedButton.getText().toString());
                pressedButton.setBackgroundResource(R.drawable.btn_pressed_thin_circ);
                tmp[btnID % 2000 / 2] = pressedButton.getTag().toString();
                (rootView.findViewById(R.id.relD_btn_save_prof)).setVisibility(View.GONE);
                if (btnID % 2 == 1)
                    rootView.findViewById(btnID - 1).setBackgroundResource(R.drawable.btn_border_thin_circ);
                else
                    rootView.findViewById(btnID + 1).setBackgroundResource(R.drawable.btn_border_thin_circ);
                break;
        }
    }
}
