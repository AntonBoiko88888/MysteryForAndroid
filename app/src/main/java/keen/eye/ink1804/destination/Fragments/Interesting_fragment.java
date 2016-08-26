package keen.eye.ink1804.destination.Fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class Interesting_fragment extends Fragment implements View.OnClickListener{
    private View rootView;
    private TextView year_woman, year_man, tactics_forgive, pros_cons_signs, time_birth_numerology, zodiac_poems, distribution_tolerance_signs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.interesting_layout_fragment,container,false);
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "brendtext.otf");
        year_woman = (TextView) rootView.findViewById(R.id.year_woman);
        year_woman.setTypeface(tf);
        year_woman.setOnClickListener(this);
        year_man = (TextView) rootView.findViewById(R.id.year_man);
        year_man.setTypeface(tf);
        year_man.setOnClickListener(this);
        tactics_forgive = (TextView) rootView.findViewById(R.id.tactics_forgive);
        tactics_forgive.setTypeface(tf);
        tactics_forgive.setOnClickListener(this);
        pros_cons_signs = (TextView) rootView.findViewById(R.id.pros_cons_signs);
        pros_cons_signs.setTypeface(tf);
        pros_cons_signs.setOnClickListener(this);
        time_birth_numerology = (TextView) rootView.findViewById(R.id.time_birth_numerology);
        time_birth_numerology.setTypeface(tf);
        time_birth_numerology.setOnClickListener(this);
        zodiac_poems = (TextView) rootView.findViewById(R.id.zodiac_poems);
        zodiac_poems.setTypeface(tf);
        zodiac_poems.setOnClickListener(this);
        distribution_tolerance_signs = (TextView) rootView.findViewById(R.id.distribution_tolerance_signs);
        distribution_tolerance_signs.setTypeface(tf);
        distribution_tolerance_signs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String key = "default";
        String tag = "interesting";
        pushDateListener listener = (pushDateListener)getActivity();
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
            default:break;
        }
        listener.onDescriptionClicked(key,tag);//key is going to new bundle
    }
}
