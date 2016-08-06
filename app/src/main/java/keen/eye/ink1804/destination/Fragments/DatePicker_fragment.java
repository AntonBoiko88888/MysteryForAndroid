package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Date;

import keen.eye.ink1804.destination.R;


/**
 * Created by Ink1804 on 06.08.16.
 */
public class DatePicker_fragment extends Fragment implements View.OnClickListener {

    private DatePicker datePicker;
    private Button btn_result;
    private int day,month,year,currentYear;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.datepicker_layout_fragment,container,false);
        btn_result = (Button)rootView.findViewById(R.id.btn_getResult);
        datePicker = (DatePicker)rootView.findViewById(R.id.datePicker);
        btn_result.setOnClickListener(this);
        currentYear = datePicker.getYear();
        datePicker.init(2000, 0, 1, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                day = datePicker.getDayOfMonth();
                month = datePicker.getMonth()+1;
                year = datePicker.getYear();
            }
        });
        return rootView;
    }

    public interface pushDateListener{
        void onDatePushed(int day, int month, int year,int currentYear);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_getResult:
                pushDateListener listener = (pushDateListener)getActivity();
                listener.onDatePushed(day,month,year,currentYear);
                Toast.makeText(getActivity(), day+"."+month+"."+year, Toast.LENGTH_SHORT).show();
        }
    }
}
