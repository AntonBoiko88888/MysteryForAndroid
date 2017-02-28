package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.DatePickerPopWin;

import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;


/**
 * Created by Ink1804 on 06.08.16.
 */
public class DatePicker extends Fragment implements View.OnClickListener {

    private View rootView;
    private DatePickerPopWin pickerPopWin;
    private RadioButton rb_male;

    private int day = 1, month = 1, year = 2000, currentYear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.datepicker_fragment, container, false);
        initializeTView();
        createDatePicker();
        return rootView;
    }


    private void initializeTView() {
        pushDateListener listener = (pushDateListener) getActivity();
        listener.toolbarSetTitle("Новый профиль");
        rootView.findViewById(R.id.picker_btn_next).setOnClickListener(this);
        rootView.findViewById(R.id.picker_btn_pick_date).setOnClickListener(this);
        rb_male = (RadioButton) rootView.findViewById(R.id.picker_rb_male);

    }

    private void createDatePicker() {
        currentYear = Calendar.getInstance().get(Calendar.YEAR);

        pickerPopWin = new DatePickerPopWin.Builder(getActivity(), new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int yyyy, int mm, int dd, String dateDesc) {
                ((TextView) rootView.findViewById(R.id.picker_tv_date)).setText("Выбранная дата: " + dd + "." + mm + "." + yyyy);
                Toast.makeText(getActivity(), dd + "." + mm + "." + yyyy, Toast.LENGTH_SHORT).show();
                day = dd;
                month = mm;
                year = yyyy;
            }
        }).minYear(1920) //min year in loop
                .maxYear(2018) // max year in loop
                .dateChose(year + "-" + month + "-" + day) // date chose when init popwindow
                .build();
        pickerPopWin.confirmBtn.setText("Установить   ");
        pickerPopWin.cancelBtn.setText("Отмена");
        pickerPopWin.confirmBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }

    @Override
    public void onClick(View view) {//кнопка "Далее"
        switch (view.getId()) {
            case R.id.picker_btn_next:
                boolean sex = rb_male.isChecked();
                rb_male.setChecked(sex);
                ((pushDateListener) getActivity()).onDatePushed(day, month, year, currentYear, sex, 2, false);
                new FbUtills().setStatistics(3);
                ((pushDateListener)getActivity()).AdShow();
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
        ((TextView) rootView.findViewById(R.id.picker_tv_date)).setText("Выбранная дата: " + day + "." + month + "." + year);
        super.onResume();
    }
}
