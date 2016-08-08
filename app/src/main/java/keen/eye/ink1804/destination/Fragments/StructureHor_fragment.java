package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Structure_databases;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class StructureHor_fragment extends Fragment implements View.OnClickListener{

    private TextView tv_year,tv_zodiak,tv_struct, tv_number_year, tv_year_period, tv_symbol_fate
            , tv_energetics, tv_communicate, tv_psychology, tv_type_thinking, tv_vector_host
            , tv_vector_servant, tv_equal_marriage, tv_romantic_marriage, tv_spiritual_marriage
            , tv_patriarchal_marriage, tv_struct_element,tv_date;
    private View rootView;

    private boolean sex;//true - male, false - female
    private int yearNow, year, month, day;
    private String D_virtualStruct, D_yearName, D_zodiakName, D_numberYears, D_yearPeriod, D_symbolFate
            , D_energetics, D_communicate, D_psychology, D_typeThinking, D_vectorHost, D_vectorServant
            , D_equalMarriage, D_romanticMarriage, D_spiritualMarriage, D_patriarchalMarriage, D_structElement;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(keen.eye.ink1804.destination.R.layout.structurehor_layout_fragment,container,false);

        initializeTView();

        Structure_databases struct_data = new Structure_databases();
        int i,j;

        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        D_virtualStruct = struct_data.getStructureType(i, j);
        D_yearName = struct_data.getYearName(year);
        D_zodiakName = struct_data.getZodiakName(day, month);
        D_numberYears = struct_data.getNumberYear(yearNow, month, day);
        D_energetics = struct_data.getTemperamentName(i);
        D_symbolFate = struct_data.getSymbolFate(i);
        D_typeThinking = struct_data.getTypeThinkingNames(sex, i);
        D_vectorHost = struct_data.getHostName(i);
        D_vectorServant = struct_data.getServantName(i);
        D_equalMarriage = struct_data.getEqualMarriageName(i);
        D_romanticMarriage = struct_data.getRomanticMarriageName(i);
        D_spiritualMarriage = struct_data.getSpiritualMarriageName(i);
        D_patriarchalMarriage = struct_data.getPatriarchalMarriageName(i);
        tv_date.setText(day+"."+month+"."+year);
        tv_struct.setText("Тип: "+ D_virtualStruct);
        tv_year.setText("Год: " + D_yearName);
        tv_zodiak.setText("Знак зодиака: " + D_zodiakName);
        tv_number_year.setText("Число года: " + D_numberYears);
        tv_energetics.setText("Энергетика: " + D_energetics);
        tv_symbol_fate.setText("По судьбе: "+ D_symbolFate);
        tv_type_thinking.setText("Тип мышления: " + D_typeThinking);
        tv_vector_host.setText("Векторный хозяин: " + D_vectorHost);
        tv_vector_host.setText("Векторный слуга: " + D_vectorServant);
        tv_equal_marriage.setText("Равный брак: " + D_equalMarriage);
        tv_romantic_marriage.setText("Романтический брак: " + D_romanticMarriage);
        tv_spiritual_marriage.setText("Духовный брак: " + D_spiritualMarriage);
        tv_patriarchal_marriage.setText("Патриархальный брак: " + D_patriarchalMarriage);

//        try {
//        }catch (Exception e){
//            Toast.makeText(getActivity(), "Неверно введена дата", Toast.LENGTH_SHORT).show();
//            Snackbar.make(getView(),"Неверно введена дата",Snackbar.LENGTH_SHORT).show();
//            tv_struct.setText(""); tv_year.setText(""); tv_zodiak.setText("");//clearing the textViews
//        }
//
        return rootView;
    }

    private void initializeTView() {
        Bundle args = getArguments();
        yearNow = args.getInt("currentYear");
        year = args.getInt("year");
        month = args.getInt("month");
        day = args.getInt("day");
        sex = args.getBoolean("sex");
        tv_date = (TextView) rootView.findViewById(R.id.tv_date);
        tv_date.setOnClickListener(this);
        tv_year = (TextView) rootView.findViewById(R.id.tv_year_result);
        tv_struct = (TextView) rootView.findViewById(R.id.tv_struct_result);
        tv_zodiak = (TextView) rootView.findViewById(R.id.tv_zodiak_result);
        tv_number_year = (TextView) rootView.findViewById(R.id.tv_number_year);
        tv_energetics = (TextView) rootView.findViewById(R.id.tv_temperament);
        tv_year_period = (TextView) rootView.findViewById(R.id.tv_year_period);
        tv_symbol_fate = (TextView) rootView.findViewById(R.id.tv_symbol_fate);
        tv_communicate = (TextView) rootView.findViewById(R.id.tv_communicate);
        tv_psychology = (TextView) rootView.findViewById(R.id.tv_psychology);
        tv_type_thinking = (TextView) rootView.findViewById(R.id.tv_type_thinking);
        tv_vector_host = (TextView) rootView.findViewById(R.id.tv_vector_host);
        tv_vector_servant = (TextView) rootView.findViewById(R.id.tv_vector_servant);
        tv_equal_marriage = (TextView) rootView.findViewById(R.id.tv_equal_marriage);
        tv_romantic_marriage = (TextView) rootView.findViewById(R.id.tv_romantic_marriage);
        tv_spiritual_marriage = (TextView) rootView.findViewById(R.id.tv_spiritual_marriage);
        tv_patriarchal_marriage = (TextView) rootView.findViewById(R.id.tv_patriarchal_marriage);
        tv_struct_element = (TextView) rootView.findViewById(R.id.tv_struct_element);
    }

    @Override
    public void onClick(View view) {
        String key;
        switch (view.getId()){
            case R.id.tv_date:
                key = D_virtualStruct;
                pushDateListener listener = (pushDateListener)getActivity();
                listener.onDescriptionClicked(key);
        }

    }
}
