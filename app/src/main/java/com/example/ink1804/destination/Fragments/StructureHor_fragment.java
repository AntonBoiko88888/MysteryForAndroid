package com.example.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ink1804.destination.Math.Structure_databases;
import com.example.ink1804.destination.R;

import java.util.Date;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class StructureHor_fragment extends Fragment implements View.OnClickListener {

    Button btn_result;
    TextView tv_result;
    EditText et_date;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView  = inflater.inflate(R.layout.structurehor_layout_fragment,container,false);
        btn_result = (Button)rootView.findViewById(R.id.btn_transform_date);
        btn_result.setOnClickListener(this);
        tv_result = (TextView) rootView.findViewById(R.id.tv_result);
        et_date = (EditText) rootView.findViewById(R.id.et_date);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        Structure_databases struct_data = new Structure_databases();
        int i,j;
        String[] date = et_date.getText().toString().split("\\.");
        Log.d("LOG",date[0]+"\n");
        i = struct_data.getYearId(date[2]);
        j = struct_data.getDateId(Integer.parseInt(date[0]),Integer.parseInt(date[1]));
        tv_result.setText(struct_data.getStructureType(i,j));



    }
}
