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

    private View rootView;

    private boolean sex;
    private int yearNow, year, month, day;
    private String D_socionics;
    int i,j;
    Data_calculation struct_data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView  = inflater.inflate(R.layout.profile_description_fragment,container,false);
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
        ((pushDateListener)getActivity()).toolbarSetTitle("Характеристика профиля");
        Bundle args = getArguments();
        boolean socioAccess = args.getBoolean("isMyDescription", false);
        yearNow = args.getInt("currentYear");
        year = args.getInt("year");
        month = args.getInt("month");
        day = args.getInt("day");
        sex = args.getBoolean("sex");
        TextView tv_date = (TextView) rootView.findViewById(R.id.picker_tv_date);
        TextView tv_year = (TextView) rootView.findViewById(R.id.prof_tv_year);
        tv_year.setOnClickListener(this);
        TextView tv_virtual_type = (TextView) rootView.findViewById(R.id.prof_tv_virtual_type);
        tv_virtual_type.setOnClickListener(this);
        TextView tv_zodiac = (TextView) rootView.findViewById(R.id.prof_tv_zodiak);
        tv_zodiac.setOnClickListener(this);
        TextView tv_year_number = (TextView) rootView.findViewById(R.id.prof_tv_year_number);
        tv_year_number.setOnClickListener(this);
        TextView tv_year_number_next = (TextView) rootView.findViewById(R.id.prof_tv_year_number_next);
        tv_year_number_next.setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_year_number_next).setOnClickListener(this);
        TextView tv_year_period = (TextView) rootView.findViewById(R.id.prof_tv_year_period);
        tv_year_period.setOnClickListener(this);
        TextView tv_fate_symbol = (TextView) rootView.findViewById(R.id.prof_tv_fate_symbol);
        tv_fate_symbol.setOnClickListener(this);
        TextView tv_energy = (TextView) rootView.findViewById(R.id.prof_tv_energy);
        tv_energy.setOnClickListener(this);
        TextView tv_communicate = (TextView) rootView.findViewById(R.id.prof_tv_communicate);
        tv_communicate.setOnClickListener(this);
        TextView tv_psychology = (TextView) rootView.findViewById(R.id.prof_tv_psychology);
        tv_psychology.setOnClickListener(this);
        TextView tv_type_of_thinking = (TextView) rootView.findViewById(R.id.prof_tv_type_of_thinking);
        tv_type_of_thinking.setOnClickListener(this);
        TextView tv_vector_host = (TextView) rootView.findViewById(R.id.prof_tv_vector_host);
        tv_vector_host.setOnClickListener(this);
        TextView tv_vector_servant = (TextView) rootView.findViewById(R.id.prof_tv_vector_servant);
        tv_vector_servant.setOnClickListener(this);
        TextView tv_element_structure = (TextView) rootView.findViewById(R.id.prof_tv_element_structure);
        tv_element_structure.setOnClickListener(this);
        TextView tv_socionics = (TextView) rootView.findViewById(R.id.prof_tv_socionics);
        tv_socionics.setOnClickListener(this);
        tv_socionics.setEnabled(false);
        tv_socionics.setVisibility(View.GONE);

        struct_data = new Data_calculation();
        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        tv_date.setText(                "Дата: "+day+"."+month+"."+year);
        tv_virtual_type.setText(        setTextSettings("Тип:", struct_data.getStructureType(i, j)));
        tv_year.setText(                setTextSettings("Год:", struct_data.getYearName(year)));
        tv_zodiac.setText(              setTextSettings("Знак зодиака:", struct_data.getZodiakName(day, month)));
        tv_year_number.setText(      Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+yearNow+" год!</b></u>&#9824;"));
        tv_year_number_next.setText(      Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+(yearNow+1)+" год!</b></u>&#9824;"));
        tv_year_period.setText(         setTextSettings("Годовой цикл:", struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i))));
        tv_fate_symbol.setText(         setTextSettings("По судьбе:", struct_data.getSymbolFate(i)));
        tv_energy.setText(              setTextSettings("Энергетика:", struct_data.getEnergyName(i)));
        tv_communicate.setText(         setTextSettings("Способы общения:", struct_data.getMeansCommunicateName(i)));
        tv_psychology.setText(          setTextSettings("Психология человека:", struct_data.getPsychologyName(i)));
        tv_type_of_thinking.setText(    setTextSettings("Тип мышления:", struct_data.getTypeThinkingNames(sex, i)));
        tv_vector_host.setText(         setTextSettings("Векторный хозяин:", struct_data.getHostName(i)));
        tv_vector_servant.setText(      setTextSettings("Векторный слуга:", struct_data.getServantName(i)));
        tv_element_structure.setText(   setTextSettings("Структура стихии:", struct_data.getElementName(day, month)));
        if(socioAccess && MainActivity.mSettings.contains(Constants.APP_PREF_SOCIONICS)) {
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
    }
    @Override
    public void onClick(View view) {
        String key="default";
        String tag = "profileDetails";
        pushDateListener listener = (pushDateListener)getActivity();
        switch (view.getId()){
            case R.id.prof_tv_virtual_type:
                key = struct_data.getStructureType(i, j);
                break;
            case R.id.prof_tv_year:
                key = struct_data.getYearName(year);
                break;
            case R.id.prof_tv_zodiak:
                key = struct_data.getZodiakName(day, month);
                break;
            case R.id.prof_tv_year_number:
                key = struct_data.getNumberYear(yearNow, month, day);
                break;
            case R.id.prof_tv_year_number_next:
                key = struct_data.getNumberYear(yearNow+1, month, day);
                break;
            case R.id.prof_tv_year_period:
                key = struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i));
                break;
            case R.id.prof_tv_fate_symbol:
                key = struct_data.getSymbolFate(i);
                break;
            case R.id.prof_tv_energy:
                key = struct_data.getEnergyName(i);
                break;
            case R.id.prof_tv_communicate:
                key = struct_data.getMeansCommunicateName(i);
                break;
            case R.id.prof_tv_psychology:
                key = struct_data.getPsychologyName(i);
                break;
            case R.id.prof_tv_type_of_thinking:
                key = struct_data.getTypeThinkingNames(sex, i);
                break;
            case R.id.prof_tv_vector_host:
                key = "Векторные отношения";
                break;
            case R.id.prof_tv_vector_servant:
                key = "Векторные отношения";
                break;
            case R.id.prof_tv_element_structure:
                key = struct_data.getElementName(day, month);
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
