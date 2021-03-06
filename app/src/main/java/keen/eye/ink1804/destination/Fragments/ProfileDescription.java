package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.IOnDesClick;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
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
        if (!((IsOnlaine) getActivity()).isOnline(getActivity())) {
            ((IsOnlaine) getActivity()).offlineMessageBox();
        }
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
        ((IToolBar)getActivity()).toolbarSetTitle("Характеристика профиля");
        Intent intent = getActivity().getIntent();

        boolean socioAccess = intent.getBooleanExtra("isMyDescription", false);
        yearNow = intent.getIntExtra("currentYear", 2017);
        year = intent.getIntExtra("year", 2000);
        month = intent.getIntExtra("month", 1);
        day = intent.getIntExtra("day", 1);
        sex = intent.getBooleanExtra("sex", true);
        rootView.findViewById(R.id.prof_tv_year).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_virtual_type).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_zodiak).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_year_number).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_year_number_next).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_year_number_next).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_year_period).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_fate_symbol).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_energy).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_communicate).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_psychology).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_type_of_thinking).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_vector_host).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_vector_servant).setOnClickListener(this);
        rootView.findViewById(R.id.prof_tv_element_structure).setOnClickListener(this);
        TextView tv_socionics = (TextView) rootView.findViewById(R.id.prof_tv_socionics);
        tv_socionics.setOnClickListener(this);
        tv_socionics.setEnabled(false);
        tv_socionics.setVisibility(View.GONE);

        struct_data = new Data_calculation();
        i = struct_data.getYearId(year);
        j = struct_data.getDateId(day, month);
        ((TextView) rootView.findViewById(R.id.picker_tv_date)).setText(              "Дата: "+day+"."+month+"."+year);
        ((TextView) rootView.findViewById(R.id.prof_tv_virtual_type)).setText(        setTextSettings("Тип:", struct_data.getStructureType(i, j)));
        ((TextView) rootView.findViewById(R.id.prof_tv_year)).setText(                setTextSettings("Год:", struct_data.getYearName(year)));
        ((TextView) rootView.findViewById(R.id.prof_tv_zodiak)).setText(              setTextSettings("Знак зодиака:", struct_data.getZodiakName(day, month)));
        ((TextView) rootView.findViewById(R.id.prof_tv_year_number)).setText(         Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+yearNow+" год!</b></u>&#9824;"));
        ((TextView) rootView.findViewById(R.id.prof_tv_year_number_next)).setText(    Html.fromHtml("&#9824;<u><b>Ваш гороскоп на "+(yearNow+1)+" год!</b></u>&#9824;"));
        ((TextView) rootView.findViewById(R.id.prof_tv_year_period)).setText(         setTextSettings("Годовой цикл:", struct_data.getYearPeriod(struct_data.getYearIdTable(yearNow),struct_data.getTypeThinkingId(sex,i))));
        ((TextView) rootView.findViewById(R.id.prof_tv_fate_symbol)).setText(         setTextSettings("По судьбе:", struct_data.getSymbolFate(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_energy)).setText(              setTextSettings("Энергетика:", struct_data.getEnergyName(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_communicate)).setText(         setTextSettings("Способы общения:", struct_data.getMeansCommunicateName(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_psychology)).setText(          setTextSettings("Психология человека:", struct_data.getPsychologyName(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_type_of_thinking)).setText(    setTextSettings("Тип мышления:", struct_data.getTypeThinkingNames(sex, i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_vector_host)).setText(         setTextSettings("Векторный хозяин:", struct_data.getHostName(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_vector_servant)).setText(      setTextSettings("Векторный слуга:", struct_data.getServantName(i)));
        ((TextView) rootView.findViewById(R.id.prof_tv_element_structure)).setText(   setTextSettings("Структура стихии:", struct_data.getElementName(day, month)));
        SharedPreferences mSettings;
        mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        if(socioAccess && mSettings.contains(Constants.APP_PREF_SOCIONICS)) {
            D_socionics = mSettings.getString(Constants.APP_PREF_SOCIONICS, "");
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
        IOnDesClick listener = (IOnDesClick)getActivity();
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
