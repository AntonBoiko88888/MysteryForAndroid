package keen.eye.ink1804.destination.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.IOnDesClick;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class Interesting extends Fragment implements View.OnClickListener{

    private View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.interesting_fragment,container,false);
//        if (!((pushDateListener) getActivity()).isOnline(getActivity())) {
//            ((pushDateListener) getActivity()).offlineMessageBox();
//        }
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
//        ((IToolBar)getActivity()).toolbarSetTitle("Интересное");
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        ((TextView)rootView.findViewById(R.id.year_woman)).setTypeface(tf);
        rootView.findViewById(R.id.year_woman).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.year_man)).setTypeface(tf);
        rootView.findViewById(R.id.year_man).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.tactics_forgive)).setTypeface(tf);
        rootView.findViewById(R.id.tactics_forgive).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.pros_cons_signs)).setTypeface(tf);
        rootView.findViewById(R.id.pros_cons_signs).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.time_birth_numerology)).setTypeface(tf);
        rootView.findViewById(R.id.time_birth_numerology).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.zodiac_poems)).setTypeface(tf);
        rootView.findViewById(R.id.zodiac_poems).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.distribution_tolerance_signs)).setTypeface(tf);
        rootView.findViewById(R.id.distribution_tolerance_signs).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.sleep_by_day)).setTypeface(tf);
        rootView.findViewById(R.id.sleep_by_day).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.types_of_gifts)).setTypeface(tf);
        rootView.findViewById(R.id.types_of_gifts).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.painful_function)).setTypeface(tf);
        rootView.findViewById(R.id.painful_function).setOnClickListener(this);
        ((TextView)rootView.findViewById(R.id.extroverts_and_introverts)).setTypeface(tf);
        rootView.findViewById(R.id.extroverts_and_introverts).setOnClickListener(this);

//        new FbUtills().setStatistics(2);
    }

    @Override
    public void onClick(View view) {
        String key = "default";
        switch (view.getId()){
            case R.id.year_woman:
                key = "Характер женщины по месяцу рождения";
                break;
            case R.id.year_man:
                key = "Характер мужчины по месяцу рождения";
                break;
            case R.id.tactics_forgive:
                key = "Тактика прощения";
                break;
            case R.id.pros_cons_signs:
                key = "Плюсы и минусы знаков";
                break;
            case R.id.time_birth_numerology:
                key = "Время рождения - Нумерология";
                break;
            case R.id.zodiac_poems:
                key = "Знаки зодиака в стихах";
                break;
            case R.id.distribution_tolerance_signs:
                key = "Раздача толерантности знакам";
                break;
            case R.id.sleep_by_day:
                key = "Сонник по числам месяца";
                break;
            case R.id.types_of_gifts:
                key = "Какие подарки дарить 16 типам?";
                break;
            case R.id.painful_function:
                key = "Болевая функция 16-ти типов личности";
                break;
            case R.id.extroverts_and_introverts:
                key = "Почему в мире существуют экстраверты и интроверты";
                break;
            default:break;
        }
        ((IOnDesClick)getActivity()).onDescriptionClicked(key,"interesting");//key is going to new bundle
    }
}
