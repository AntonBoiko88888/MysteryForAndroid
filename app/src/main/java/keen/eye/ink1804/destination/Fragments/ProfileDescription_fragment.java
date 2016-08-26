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

    private TextView tv_year, tv_zodiac, tv_virtual_type, tv_year_number, tv_year_period, tv_fate_symbol
            , tv_energy, tv_communicate, tv_psychology, tv_type_of_thinking, tv_vector_host
            , tv_vector_servant, tv_element_structure,tv_date;
    private View rootView;

    private boolean sex;//true - male, false - female
    private int yearNow, year, month, day;
    private String D_virtualType, D_year, D_zodiac, D_year_number, D_yearPeriod, D_fateSymbol
            , D_energy, D_communicate, D_psychology, D_typeOfThinking, D_vectorHost, D_vectorServant
            , D_equalMarriage, D_romanticMarriage, D_spiritualMarriage, D_patriarchalMarriage, D_elementStructure;


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
        tv_date = (TextView) rootView.findViewById(R.id.picker_tv_date);
        tv_year = (TextView) rootView.findViewById(R.id.prof_tv_year);
        tv_year.setOnClickListener(this);
        tv_virtual_type = (TextView) rootView.findViewById(R.id.prof_tv_virtual_type);
        tv_virtual_type.setOnClickListener(this);
        tv_zodiac = (TextView) rootView.findViewById(R.id.prof_tv_zodiak);
        tv_zodiac.setOnClickListener(this);
        tv_year_number = (TextView) rootView.findViewById(R.id.prof_tv_year_number);
        tv_year_number.setOnClickListener(this);
        tv_year_period = (TextView) rootView.findViewById(R.id.prof_tv_year_period);
        tv_year_period.setOnClickListener(this);
        tv_fate_symbol = (TextView) rootView.findViewById(R.id.prof_tv_fate_symbol);
        tv_fate_symbol.setOnClickListener(this);
        tv_energy = (TextView) rootView.findViewById(R.id.prof_tv_energy);
        tv_energy.setOnClickListener(this);
        tv_communicate = (TextView) rootView.findViewById(R.id.prof_tv_communicate);
        tv_communicate.setOnClickListener(this);
        tv_psychology = (TextView) rootView.findViewById(R.id.prof_tv_psychology);
        tv_psychology.setOnClickListener(this);
        tv_type_of_thinking = (TextView) rootView.findViewById(R.id.prof_tv_type_of_thinking);
        tv_type_of_thinking.setOnClickListener(this);
        tv_vector_host = (TextView) rootView.findViewById(R.id.prof_tv_vector_host);
        tv_vector_host.setOnClickListener(this);
        tv_vector_servant = (TextView) rootView.findViewById(R.id.prof_tv_vector_servant);
        tv_vector_servant.setOnClickListener(this);
        tv_element_structure = (TextView) rootView.findViewById(R.id.prof_tv_element_structure);
        tv_element_structure.setOnClickListener(this);
    }
    private void fillInfo() {
        Structure_databases struct_data = new Structure_databases();
        int i,j;

        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        D_virtualType = struct_data.getStructureType(i, j);
        D_year = struct_data.getYearName(year);
        D_zodiac = struct_data.getZodiakName(day, month);
        D_year_number = struct_data.getNumberYear(yearNow, month, day);
        D_yearPeriod = struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i));
        D_fateSymbol = struct_data.getSymbolFate(i);
        D_energy = struct_data.getEnergyName(i);
        D_communicate = struct_data.getMeansCommunicateName(i);
        D_psychology = struct_data.getPsychologyName(i);
        D_typeOfThinking = struct_data.getTypeThinkingNames(sex, i);
        D_vectorHost = struct_data.getHostName(i);
        D_vectorServant = struct_data.getServantName(i);
        D_equalMarriage = struct_data.getEqualMarriageName(i);//
        D_romanticMarriage = struct_data.getRomanticMarriageName(i);//
        D_spiritualMarriage = struct_data.getSpiritualMarriageName(i);//
        D_patriarchalMarriage = struct_data.getPatriarchalMarriageName(i);//
        D_elementStructure = struct_data.getElementName(day, month);
        tv_date.setText(                "Дата: "+day+"."+month+"."+year);
        tv_virtual_type.setText(              setTextSettings("Тип:", D_virtualType));
        tv_year.setText(                setTextSettings("Год:", D_year));
        tv_zodiac.setText(              setTextSettings("Знак зодиака:", D_zodiac));
        tv_year_number.setText(         setTextSettings("Число года:", D_year_number));
        tv_year_period.setText(         setTextSettings("Годовой цикл:", D_yearPeriod));
        tv_fate_symbol.setText(         setTextSettings("По судьбе:", D_fateSymbol));
        tv_energy.setText(          setTextSettings("Энергетика:", D_energy));
        tv_communicate.setText(         setTextSettings("Способы общения:", D_communicate));
        tv_psychology.setText(          setTextSettings("Психология человека:", D_psychology));
        tv_type_of_thinking.setText(       setTextSettings("Тип мышления:", D_typeOfThinking));
        tv_vector_host.setText(         setTextSettings("Векторный хозяин:", D_vectorHost));
        tv_vector_servant.setText(      setTextSettings("Векторный слуга:", D_vectorServant));
        tv_element_structure.setText(      setTextSettings("Структура стихии:", D_elementStructure));
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
        String key="default";
        String tag = "profileDetails";
        pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()){
            case R.id.prof_tv_virtual_type:
                key = D_virtualType;
                break;
            case R.id.prof_tv_year:
                key = D_year;
                break;
            case R.id.prof_tv_zodiak:
                key = D_zodiac;
                break;
            case R.id.prof_tv_year_number:
                key = D_year_number;
                break;
            case R.id.prof_tv_year_period:
                key = D_yearPeriod;
                break;
            case R.id.prof_tv_fate_symbol:
                key = D_fateSymbol;
                break;
            case R.id.prof_tv_energy:
                key = D_energy;
                break;
            case R.id.prof_tv_communicate:
                key = D_communicate;
                break;
            case R.id.prof_tv_psychology:
                key = D_psychology;
                break;
            case R.id.prof_tv_type_of_thinking:
                key = D_typeOfThinking;
                break;
            case R.id.prof_tv_vector_host:
                key = "Векторные отношения";
                break;
            case R.id.prof_tv_vector_servant:
                key = "Векторные отношения";
                break;
            case R.id.prof_tv_element_structure:
                key = D_elementStructure;
                break;
            default:break;
        }
        listener.onDescriptionClicked(key,tag);//key is going to new bundle
    }
}
