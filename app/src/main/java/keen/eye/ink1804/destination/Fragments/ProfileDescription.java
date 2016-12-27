package keen.eye.ink1804.destination.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 29.07.16.
 */
public class ProfileDescription extends Fragment implements View.OnClickListener{

    private TextView tv_year, tv_zodiac, tv_virtual_type, tv_year_number, tv_year_number_next , tv_year_period, tv_fate_symbol
            , tv_energy, tv_communicate, tv_psychology, tv_type_of_thinking, tv_vector_host
            , tv_vector_servant, tv_element_structure,tv_date,tv_socionics;
    private View rootView;

    private boolean sex,socioAccess;//true - male, false - female
    private int yearNow, year, month, day;
    private String D_virtualType;
    private String D_year;
    private String D_zodiac;
    private String D_year_number;
    private String D_year_number_next;
    private String D_yearPeriod;
    private String D_fateSymbol;
    private String D_energy;
    private String D_communicate;
    private String D_psychology;
    private String D_typeOfThinking;
    private String D_elementStructure;
    private String D_socionics;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(R.layout.profile_description_fragment,container,false);
        initializeTView();
        fillInfo();
        return rootView;
    }

    private void initializeTView() {
//        pushDateListener listener = (pushDateListener)getActivity();
        ((pushDateListener)getActivity()).toolbarSetTitle("Характеристика профиля");
        Bundle args = getArguments();
        socioAccess = args.getBoolean("isMyDescription",false);
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
        rootView.findViewById(R.id.prof_tv_zodiak).setOnClickListener(this);
        tv_year_number = (TextView) rootView.findViewById(R.id.prof_tv_year_number);
        tv_year_number.setOnClickListener(this);
        tv_year_number_next = (TextView) rootView.findViewById(R.id.prof_tv_year_number_next);
        tv_year_number_next.setOnClickListener(this);
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
        tv_socionics = (TextView) rootView.findViewById(R.id.prof_tv_socionics);
        tv_socionics.setOnClickListener(this);
        tv_socionics.setEnabled(false);
        tv_socionics.setVisibility(View.GONE);
    }
    private void fillInfo() {
        Data_calculation struct_data = new Data_calculation();
        int i,j;
        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        D_virtualType = struct_data.getStructureType(i, j);
        D_year = struct_data.getYearName(year);
        D_zodiac = struct_data.getZodiakName(day, month);
        D_year_number = struct_data.getNumberYear(yearNow, month, day);
        D_year_number_next = struct_data.getNumberYear(yearNow+1, month, day);
        D_yearPeriod = struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i));
        D_fateSymbol = struct_data.getSymbolFate(i);
        D_energy = struct_data.getEnergyName(i);
        D_communicate = struct_data.getMeansCommunicateName(i);
        D_psychology = struct_data.getPsychologyName(i);
        D_typeOfThinking = struct_data.getTypeThinkingNames(sex, i);
        String d_vectorHost = struct_data.getHostName(i);
        String d_vectorServant = struct_data.getServantName(i);
        D_elementStructure = struct_data.getElementName(day, month);
        tv_date.setText(                "Дата: "+day+"."+month+"."+year);
        tv_virtual_type.setText(        setTextSettings("Тип:", D_virtualType));
        tv_year.setText(                setTextSettings("Год:", D_year));
        tv_zodiac.setText(              setTextSettings("Знак зодиака:", D_zodiac));
        tv_year_number.setText(      Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+yearNow+" год!</b></u>&#9824;"));
        tv_year_number_next.setText(      Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+(yearNow+1)+" год!</b></u>&#9824;"));
        tv_year_period.setText(         setTextSettings("Годовой цикл:", D_yearPeriod));
        tv_fate_symbol.setText(         setTextSettings("По судьбе:", D_fateSymbol));
        tv_energy.setText(              setTextSettings("Энергетика:", D_energy));
        tv_communicate.setText(         setTextSettings("Способы общения:", D_communicate));
        tv_psychology.setText(          setTextSettings("Психология человека:", D_psychology));
        tv_type_of_thinking.setText(    setTextSettings("Тип мышления:", D_typeOfThinking));
        tv_vector_host.setText(         setTextSettings("Векторный хозяин:", d_vectorHost));
        tv_vector_servant.setText(      setTextSettings("Векторный слуга:", d_vectorServant));
        tv_element_structure.setText(   setTextSettings("Структура стихии:", D_elementStructure));
        if(socioAccess&& MainActivity.mSettings.contains(Constants.APP_PREF_SOCIONICS)) {
            D_socionics = MainActivity.mSettings.getString(Constants.APP_PREF_SOCIONICS, "");
            tv_socionics.setText(setTextSettings("Социотип:", D_socionics));
            tv_socionics.setVisibility(View.VISIBLE);
            tv_socionics.setEnabled(true);
        }
    }
    public Spanned setTextSettings(String _text, String _value){
        String text = _text;
        String value = _value;
        text = String.format("&#149;<u><i>%s</i></u>",text);
        value = String.format("<b>%s</b>",value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text+" "+value, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text+" "+value);
        }
//        return Html.fromHtml(text+" "+value);
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
            case R.id.prof_tv_year_number_next:
                key = D_year_number_next;
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
            case R.id.prof_tv_socionics:
                tag = "socionics";
                key = D_socionics;
                break;
            default:break;
        }
        listener.onDescriptionClicked(key,tag);//key is going to new bundle
    }
}
