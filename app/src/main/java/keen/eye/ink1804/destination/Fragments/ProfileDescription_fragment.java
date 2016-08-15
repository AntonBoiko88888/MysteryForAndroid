package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Structure_databases;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class ProfileDescription_fragment extends Fragment implements View.OnClickListener{

    private TextView tv_year,tv_zodiak,tv_struct, tv_number_year, tv_year_period, tv_symbol_fate
            , tv_energetics, tv_communicate, tv_psychology, tv_type_thinking, tv_vector_host
            , tv_vector_servant, tv_struct_element,tv_date;
    private View rootView;

    private boolean sex;//true - male, false - female
    private int yearNow, year, month, day;
    private String D_virtualStruct, D_yearName, D_zodiakName, D_numberYears, D_yearPeriod, D_symbolFate
            , D_energetics, D_communicate, D_psychology, D_typeThinking, D_vectorHost, D_vectorServant
            , D_equalMarriage, D_romanticMarriage, D_spiritualMarriage, D_patriarchalMarriage, D_structElement;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(keen.eye.ink1804.destination.R.layout.profile_description_layout_fragment,container,false);
        initializeTView();
        fillInfo();
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
        tv_struct.setOnClickListener(this);
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
        tv_struct_element = (TextView) rootView.findViewById(R.id.tv_struct_element);
    }
    private void fillInfo() {
        Structure_databases struct_data = new Structure_databases();
        int i,j;

        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        D_virtualStruct = struct_data.getStructureType(i, j);
        D_yearName = struct_data.getYearName(year);
        D_zodiakName = struct_data.getZodiakName(day, month);
        D_numberYears = struct_data.getNumberYear(yearNow, month, day);
        D_yearPeriod = struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i));
        D_symbolFate = struct_data.getSymbolFate(i);
        D_energetics = struct_data.getEnergyName(i);
        D_communicate = struct_data.getMeansCommunicateName(i);
        D_psychology = struct_data.getPsychologyName(i);
        D_typeThinking = struct_data.getTypeThinkingNames(sex, i);
        D_vectorHost = struct_data.getHostName(i);
        D_vectorServant = struct_data.getServantName(i);
        D_equalMarriage = struct_data.getEqualMarriageName(i);
        D_romanticMarriage = struct_data.getRomanticMarriageName(i);
        D_spiritualMarriage = struct_data.getSpiritualMarriageName(i);
        D_patriarchalMarriage = struct_data.getPatriarchalMarriageName(i);
        D_structElement = struct_data.getElementName(day, month);
        tv_date.setText(                "Дата: "+day+"."+month+"."+year);
        tv_struct.setText(              setTextSettings("Тип:", D_virtualStruct));
        tv_year.setText(                setTextSettings("Год:", D_yearName));
        tv_zodiak.setText(              setTextSettings("Знак зодиака:", D_zodiakName));
        tv_number_year.setText(         setTextSettings("Число года:", D_numberYears));
        tv_year_period.setText(         setTextSettings("Годовой цикл:", D_yearPeriod));
        tv_symbol_fate.setText(         setTextSettings("По судьбе:", D_symbolFate));
        tv_energetics.setText(          setTextSettings("Энергетика:", D_energetics));
        tv_communicate.setText(         setTextSettings("Способы общения:", D_communicate));
        tv_psychology.setText(          setTextSettings("Психология человека:", D_psychology));
        tv_type_thinking.setText(       setTextSettings("Тип мышления:", D_typeThinking));
        tv_vector_host.setText(         setTextSettings("Векторный хозяин:", D_vectorHost));
        tv_vector_servant.setText(      setTextSettings("Векторный слуга:", D_vectorServant));
        tv_struct_element.setText(      setTextSettings("Структура стихии:",D_structElement));
    }
    public Spanned setTextSettings(String _text, String _value){
        String text = _text;
        String value = _value;
//        Typeface font = Typeface.createFromAsset(getAssets(),"fonts/minion_bold_cond_disp.otf");
//        textView.setTypeface(font);//шрифт
//        textView.setText(Html.fromHtml(text).toString());//парс из html в текст
        text = String.format("<u><i>%s</i></u>",text);
        value = String.format("<b>%s</b>",value);
        return Html.fromHtml(text+" "+value);
    }
    @Override
    public void onClick(View view) {
        String key;
        pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()){
            case R.id.tv_date:
                key = D_virtualStruct;
                listener.onDescriptionClicked(key);//key is going to new bundle
                break;
            case R.id.tv_struct_result:
                key = D_virtualStruct;
                listener.onDescriptionClicked(key);//key is going to new bundle
        }

    }
}
