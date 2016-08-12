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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.DatePickerPopWin;

import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;


/**
 * Created by Ink1804 on 06.08.16.
 */
public class DatePicker_fragment extends Fragment implements View.OnClickListener {

    private Button btn_result;
    private View rootView;
    private TextView tv_date;
    private DatePickerPopWin pickerPopWin;
    private RadioButton rb_male;
    private String action = "default";
    SharedPreferences mSettings;
    private boolean sex;

    private int day = 1,month = 1,year = 2000,currentYear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(R.layout.datepicker_layout_fragment,container,false);

        initializeTView();
        createDatePicker();
        return rootView;
    }

    @Override
    public void onClick(View view) {//кнопка "Далее"
        switch (view.getId()){
            case R.id.btn_getResult:
                pushDateListener listener = (pushDateListener)getActivity();
                sex = rb_male.isChecked();
                if(action.equals("default")){
                    listener.onDatePushed(day,month,year,currentYear,sex);}
                else{
                    listener.onRegistrating(day,month,year,sex);
                    mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = mSettings.edit();
                    editor.putBoolean(Constants.APP_PREF_ISREGISTER,true);
                    editor.putInt(Constants.APP_PREF_DAY,day);
                    editor.putInt(Constants.APP_PREF_MONTH,month);
                    editor.putInt(Constants.APP_PREF_YEAR,year);
                    editor.putBoolean(Constants.APP_PREF_SEX,sex);
                    editor.putString(Constants.APP_PREF_STATUS,"Начинающий");
                    editor.apply();
                }
        }
    }
    private void initializeTView() {
        tv_date = (TextView)rootView.findViewById(R.id.tv_date);
        btn_result = (Button)rootView.findViewById(R.id.btn_getResult);
        btn_result.setOnClickListener(this);
        rb_male = (RadioButton)rootView.findViewById(R.id.rb_male);
        if(getArguments()!=null) {
            Bundle args = getArguments();
            action = args.getString("action");
        }
    }
    private void createDatePicker(){
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
        pickerPopWin = new DatePickerPopWin.Builder(getActivity(), new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int yyyy, int mm, int dd, String dateDesc) {
                tv_date.setText(dd+"."+mm+"."+yyyy);
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
        rootView.findViewById(R.id.pick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickerPopWin.showPopWin(getActivity());
            }
        });



//        datePicker = (DatePicker)rootView.findViewById(R.id.datePicker);
//        datePicker.init(2000, 0, 1, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
//                day = datePicker.getDayOfMonth();
//                month = datePicker.getMonth()+1;
//                year = datePicker.getYear();
//            }
//        });
    }

    @Override
    public void onResume() {
        tv_date.setText(day+"."+month+"."+year);
        super.onResume();
    }
}
