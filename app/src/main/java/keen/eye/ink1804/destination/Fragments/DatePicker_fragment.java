package keen.eye.ink1804.destination.Fragments;

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
import keen.eye.ink1804.destination.R;


/**
 * Created by Ink1804 on 06.08.16.
 */
public class DatePicker_fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tv_date;
    private DatePickerPopWin pickerPopWin;
    private RadioButton rb_male,rb_female;

    private int day = 1,month = 1,year = 2000,currentYear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(R.layout.datepicker_layout_fragment,container,false);
        initializeTView();
        createDatePicker();
        return rootView;
    }


    private void initializeTView() {
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Новый профиль");
        tv_date = (TextView)rootView.findViewById(R.id.picker_tv_date);
        Button btn_next = (Button) rootView.findViewById(R.id.picker_btn_next);
        btn_next.setOnClickListener(this);
        Button btn_showDatePicker = (Button) rootView.findViewById(R.id.picker_btn_pick_date);
        btn_showDatePicker.setOnClickListener(this);
        rb_male = (RadioButton)rootView.findViewById(R.id.picker_rb_male);
        rb_female = (RadioButton)rootView.findViewById(R.id.picker_rb_female);

    }
    private void createDatePicker(){
        Calendar calendar = Calendar.getInstance();
        currentYear = calendar.get(Calendar.YEAR);
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
    public void onClick(View view) {//кнопка "Далее"
        switch (view.getId()) {
            case R.id.picker_btn_next:
                pushDateListener listener = (pushDateListener) getActivity();
                boolean sex = rb_male.isChecked();
                rb_male.setChecked(sex);
                listener.onDatePushed(day, month, year, currentYear, sex, 1);
                break;
            case R.id.picker_btn_pick_date:
                pickerPopWin.showPopWin(getActivity());
                break;
            default:
                break;
        }
    }
    @Override
    public void onResume() {
        tv_date.setText("Выбранная дата: "+day+"."+month+"."+year);
        super.onResume();
    }
}
