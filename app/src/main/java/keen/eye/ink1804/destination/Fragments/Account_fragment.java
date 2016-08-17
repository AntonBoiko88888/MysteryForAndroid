package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 12.08.16.
 */
public class Account_fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tv_name,tv_date,tv_sex,tv_status;
    private Button btn_desc;
    private boolean sex;
    private String status,name;
    private int day,month,year;
    private SharedPreferences mSettings;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_layout_fragment,container,false);
        initializeViews();
        return rootView;
    }
    private void initializeViews(){
        mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        name = mSettings.getString(Constants.APP_PREF_NAME,"noName");
        day = mSettings.getInt(Constants.APP_PREF_DAY,1);
        month = mSettings.getInt(Constants.APP_PREF_MONTH,1);
        year = mSettings.getInt(Constants.APP_PREF_YEAR,2000);
        sex = mSettings.getBoolean(Constants.APP_PREF_SEX,false);
        status = mSettings.getString(Constants.APP_PREF_STATUS,"Начинающий");
        btn_desc = (Button)rootView.findViewById(R.id.acc_btn_description);
        btn_desc.setOnClickListener(this);
        tv_name = (TextView)rootView.findViewById(R.id.acc_tv_name);
        tv_date = (TextView)rootView.findViewById(R.id.acc_tv_date);
        tv_sex = (TextView)rootView.findViewById(R.id.acc_tv_sex);
        tv_status = (TextView)rootView.findViewById(R.id.acc_tv_status);
        tv_date.setText("Дата рождения:\n"+day+"."+month+"."+year);
        tv_name.setText("Имя: "+name);
        if(sex) tv_sex.setText("Пол: муж.");
        else tv_sex.setText("Пол: жен.");
        tv_status.setText(status);
    }

    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener)getActivity();
        listener.onDatePushed(day,month,year,Calendar.getInstance().get(Calendar.YEAR),sex);
    }
}
