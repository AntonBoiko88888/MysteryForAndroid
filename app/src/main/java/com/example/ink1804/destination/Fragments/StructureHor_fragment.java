package com.example.ink1804.destination.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ink1804.destination.Math.Structure_databases;
import com.example.ink1804.destination.R;

import java.util.Date;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class StructureHor_fragment extends Fragment implements View.OnClickListener {

    private Button btn_result;
    private TextView tv_year,tv_zodiak,tv_struct;
    private EditText et_date;
    private View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(R.layout.structurehor_layout_fragment,container,false);
        btn_result = (Button)rootView.findViewById(R.id.btn_transform_date);
        btn_result.setOnClickListener(this);
        tv_year = (TextView) rootView.findViewById(R.id.tv_year_result);
        tv_struct = (TextView) rootView.findViewById(R.id.tv_struct_result);
        tv_zodiak = (TextView) rootView.findViewById(R.id.tv_zodiak_result);
        et_date = (EditText) rootView.findViewById(R.id.et_date);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Structure_databases struct_data = new Structure_databases();
        int i,j;
        try {
            String[] date = et_date.getText().toString().split("\\.");
            i = struct_data.getYearId(date[2]);
            j = struct_data.getDateId(Integer.parseInt(date[0]), Integer.parseInt(date[1]));
            tv_struct.setText("Тип: "+struct_data.getStructureType(i, j));
            tv_year.setText("Год: " + struct_data.getYearName(date[2]));
            tv_zodiak.setText("Знак зодиака: " + struct_data.getZodiakName(Integer.parseInt(date[0]), Integer.parseInt(date[1])));
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
