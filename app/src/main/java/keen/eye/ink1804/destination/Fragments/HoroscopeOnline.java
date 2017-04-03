package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.Utills.FbUtills;
import keen.eye.ink1804.destination.Utills.HtmlParser;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tv_sign_name;
    private List<String> descriptions;
    int[] img_ids = new int[]{R.id.aries, R.id.taurus, R.id.twins, R.id.cancer, R.id.lion, R.id.virgo
            , R.id.libra, R.id.scorpio, R.id.sagittarius, R.id.capricorn, R.id.aquarius, R.id.fish};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.hor_online_fragment, container, false);
        initViews();
        if (((IsOnlaine)getActivity()).isOnline(getActivity()))
            onMySignClick();
        else {
            ((ProgressBar) rootView.findViewById(R.id.progressbar_horoscope)).setVisibility(View.INVISIBLE);
            tv_sign_name.setVisibility(View.GONE);
            ((TextView) rootView.findViewById(R.id.horOn_tvResult)).setText("Увы... Интернет соединение отсутствует :(");
        }
        return rootView;
    }

    private void initViews() {
        descriptions = new ArrayList<>();
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        new FbUtills().setStatistics(1);
        for (int i = 0; i < 12; i++) {
            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int m1dp = new Data_calculation().dpToPx(2, getActivity());
            int width = (size.x - 17 * m1dp) / 4;
            LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(width, width);
            GridLayout.LayoutParams imageViewParams = new GridLayout.LayoutParams(gridParams);
            imageViewParams.setMargins(m1dp, m1dp, m1dp, m1dp);
            ((ImageView) rootView.findViewById(img_ids[i])).setOnClickListener(this);
            ((ImageView) rootView.findViewById(img_ids[i])).setLayoutParams(imageViewParams);
        }
        ((ProgressBar) rootView.findViewById(R.id.progressbar_horoscope)).setVisibility(ProgressBar.VISIBLE);
        setBackgroundBlack();

        tv_sign_name = (TextView) rootView.findViewById(R.id.sphere_tv_sign_name);
        tv_sign_name.setTypeface(tf);
    }

    @Override
    public void onClick(View view) {
        int key = 0;
        switch (view.getId()) {
            case R.id.aries:
                key = 0;
                break;
            case R.id.taurus:
                key = 1;
                break;
            case R.id.twins:
                key = 2;
                break;
            case R.id.cancer:
                key = 3;
                break;
            case R.id.lion:
                key = 4;
                break;
            case R.id.virgo:
                key = 5;
                break;
            case R.id.libra:
                key = 6;
                break;
            case R.id.scorpio:
                key = 7;
                break;
            case R.id.sagittarius:
                key = 8;
                break;
            case R.id.capricorn:
                key = 9;
                break;
            case R.id.aquarius:
                key = 10;
                break;
            case R.id.fish:
                key = 11;
                break;
            default:
                break;
        }
        try {
            if (((IsOnlaine)getActivity()).isOnline(getActivity()))
                if (descriptions.size() == 0) {
                    tv_sign_name.setVisibility(View.VISIBLE);
                    ((TextView) rootView.findViewById(R.id.horOn_tvResult)).setText("");
                    ((ProgressBar) rootView.findViewById(R.id.progressbar_horoscope)).setVisibility(View.VISIBLE);
                    backgroundPressed(key);
                    setZodiacName(key);
                    new HtmlParser().parseHoroscope(getActivity(), descriptions, key);
                } else {
                    backgroundPressed(key);
                    setZodiacName(key);
                    ((TextView) rootView.findViewById(R.id.horOn_tvResult)).setText(descriptions.get(key));
                    tv_sign_name.setVisibility(View.VISIBLE);
                }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Данные еще не загрузились", Toast.LENGTH_SHORT).show();
        }
    }

    private void backgroundPressed(int i) {
        setBackgroundBlack();
        ((ImageView) rootView.findViewById(img_ids[i])).setImageDrawable(getResources().getDrawable(R.drawable.img_proz));
    }

    private void setBackgroundBlack() {
        for (int i = 0; i<12; i++) {
            ((ImageView) rootView.findViewById(img_ids[i])).setImageDrawable(getResources().getDrawable(R.drawable.img_t));
        }
    }

    private void setZodiacName(int zod) {
        tv_sign_name.setText(Constants.ZODIAK_NAMES_normal[zod]);
    }

    private void onMySignClick() {
        Bundle args = getArguments();

        SharedPreferences mSettings;
        mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        int day = mSettings.getInt(Constants.APP_PREF_DAY, 1);
        int month = mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int j;
        if (args != null)
            j = new Data_calculation().getZodiacId(mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFICATION, "Овен"));
        else
            j = (new Data_calculation().getDateId(day, month) + 9) % 12;
        backgroundPressed(j);
        setZodiacName(j);
        new HtmlParser().parseHoroscope(getActivity(), descriptions, j);
    }
}
