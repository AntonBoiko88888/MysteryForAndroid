package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.DatePickerPopWin;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 17.08.16.
 */
public class Registration_fragment extends Fragment implements View.OnClickListener {
    private TextView tv_date;
    private EditText et_name;
    private DatePickerPopWin pickerPopWin;
    private RadioButton rb_male;
    private int day = 1,month = 1,year = 2000;
    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.registration_layout_fragment,container,false);
        createDatePicker();
        initializeTView();
        return rootView;
    }


    private void initializeTView() {
        tv_date = (TextView)rootView.findViewById(R.id.reg_tv_date);
        et_name = (EditText)rootView.findViewById(R.id.reg_et_name);
        Button btn_registrate = (Button)rootView.findViewById(R.id.reg_btn_registrate);
        btn_registrate.setOnClickListener(this);
        Button btn_showDatePicker = (Button)rootView.findViewById(R.id.reg_pick_date);
        btn_showDatePicker.setOnClickListener(this);
        rb_male = (RadioButton)rootView.findViewById(R.id.reg_rb_male);
    }
    private void createDatePicker(){
        pickerPopWin = new DatePickerPopWin.Builder(getActivity(), new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int yyyy, int mm, int dd, String dateDesc) {
                tv_date.setText("Выбранная дата: "+dd+"."+mm+"."+yyyy);
                Toast.makeText(getActivity(), dd+"."+mm+"."+yyyy, Toast.LENGTH_SHORT).show();
                day = dd;
                month = mm;
                year = yyyy;
            }
        }).textConfirm("CANCEL11") //text of confirm button
                .textCancel("CONFIRM11") //text of cancel button
                .btnTextSize(16) // button text size
                .viewTextSize(25) // pick view text size
                .colorCancel(Color.parseColor("#0000FF")) //color of cancel button
                .colorConfirm(Color.parseColor("#FF00FF"))//color of confirm button
                .minYear(1920) //min year in loop
                .maxYear(2080) // max year in loop
                .dateChose(year+"-"+month+"-"+day) // date chose when init popwindow
                .build();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.reg_btn_registrate:
            pushDateListener listener = (pushDateListener) getActivity();
            boolean sex = rb_male.isChecked();
            if (!et_name.getText().toString().equals("")) {
                String name = et_name.getText().toString();
                listener.onRegistration(day, month, year, sex);
                SharedPreferences  mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putBoolean(Constants.APP_PREF_ISREGISTER, true);
                editor.putString(Constants.APP_PREF_NAME, name);
                editor.putInt(Constants.APP_PREF_DAY, day);
                editor.putInt(Constants.APP_PREF_MONTH, month);
                editor.putInt(Constants.APP_PREF_YEAR, year);
                editor.putBoolean(Constants.APP_PREF_SEX, sex);
                editor.putString(Constants.APP_PREF_STATUS, "Начинающий");
                editor.apply();
            } else
                Toast.makeText(getActivity(), "Недопустимое имя", Toast.LENGTH_SHORT).show();
                break;

            case R.id.reg_pick_date:
                pickerPopWin.showPopWin(getActivity());
                break;
            default:break;
        }
    }
    @Override
    public void onResume() {
        tv_date.setText("Выбранная дата: "+day+"."+month+"."+year);
        super.onResume();
    }
}
