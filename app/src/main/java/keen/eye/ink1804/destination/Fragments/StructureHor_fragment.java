package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import keen.eye.ink1804.destination.Math.Structure_databases;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class StructureHor_fragment extends Fragment implements View.OnClickListener {

    private Button btn_result;
    private TextView tv_year,tv_zodiak,tv_struct, tv_number_year, tv_year_period, tv_symbol_fate
            ,tv_temperament, tv_communicate, tv_psychology, tv_type_thinking, tv_vector_host, tv_vector_servant
            ,tv_type_marriage, tv_struct_element;
    private EditText et_date;
    private View rootView;

    private int mYear;

    private String D_virtualStruct, D_yearName, D_zodiakName, D_numberYears, D_yearPeriod, D_symbolFate, D_temperament, D_communicate, D_psychology, D_typeThinking, D_vectorHost, D_vectorServant, D_typeMarriage, D_structElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(keen.eye.ink1804.destination.R.layout.structurehor_layout_fragment,container,false);
        btn_result = (Button)rootView.findViewById(keen.eye.ink1804.destination.R.id.btn_transform_date);
        btn_result.setOnClickListener(this);
        tv_year = (TextView) rootView.findViewById(R.id.tv_year_result);
        tv_struct = (TextView) rootView.findViewById(R.id.tv_struct_result);
        tv_zodiak = (TextView) rootView.findViewById(R.id.tv_zodiak_result);
        tv_number_year = (TextView) rootView.findViewById(R.id.tv_number_year);
        tv_temperament = (TextView) rootView.findViewById(R.id.tv_temperament);
        tv_year_period = (TextView) rootView.findViewById(R.id.tv_year_period);
        tv_symbol_fate = (TextView) rootView.findViewById(R.id.tv_symbol_fate);
        tv_communicate = (TextView) rootView.findViewById(R.id.tv_communicate);
        tv_psychology = (TextView) rootView.findViewById(R.id.tv_psychology);
        tv_type_thinking = (TextView) rootView.findViewById(R.id.tv_type_thinking);
        tv_vector_host = (TextView) rootView.findViewById(R.id.tv_vector_host);
        tv_vector_servant = (TextView) rootView.findViewById(R.id.tv_vector_servant);
        tv_type_marriage = (TextView) rootView.findViewById(R.id.tv_type_marriage);
        tv_struct_element = (TextView) rootView.findViewById(R.id.tv_struct_element);
        et_date = (EditText) rootView.findViewById(R.id.et_date);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Structure_databases struct_data = new Structure_databases();
        int i,j;
        try {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);

            String[] date = et_date.getText().toString().split("\\.");
            i = struct_data.getYearId(date[2]);
            j = struct_data.getDateId(Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            D_virtualStruct = struct_data.getStructureType(i, j);
            D_yearName = struct_data.getYearName(date[2]);
            D_zodiakName = struct_data.getZodiakName(Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            D_numberYears = struct_data.getNumberYear(""+mYear, Integer.parseInt(date[1]), Integer.parseInt(date[0]));
            D_temperament = struct_data.getTemperamentName(i);
            D_symbolFate = struct_data.getSymbolFate(i);
            tv_struct.setText("Тип: "+ D_virtualStruct);
            tv_year.setText("Год: " + D_yearName);
            tv_zodiak.setText("Знак зодиака: " + D_zodiakName);
            tv_number_year.setText("Число года: " + D_numberYears);
            tv_temperament.setText("Темперамент: " + D_temperament);
            tv_symbol_fate.setText("По судьбе: " + D_symbolFate);

        }catch (Exception e){
            Toast.makeText(getActivity(), "Неверно введена дата", Toast.LENGTH_SHORT).show();
//            Snackbar.make(getView(),"Неверно введена дата",Snackbar.LENGTH_SHORT).show();
            tv_struct.setText(""); tv_year.setText(""); tv_zodiak.setText("");//clearing the textViews
        }
        InputMethodManager inputManager = (InputMethodManager)
                getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);//hide keyboard
    }
}
