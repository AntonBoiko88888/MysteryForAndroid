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

import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.Utills.FbUtills;
import keen.eye.ink1804.destination.Utills.HtmlParser;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline extends Fragment implements View.OnClickListener {

    private ProgressBar progressBar;
    private View rootView;
    private ImageView[] images;
    private TextView tv_result, tv_sign_name;
    private List<String> descriptions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.hor_online_fragment, container, false);
        initViews();
        if (((IsOnlaine)getActivity()).isOnline(getActivity()))
            onMySignClick();
        else {
            progressBar.setVisibility(View.INVISIBLE);
            tv_sign_name.setVisibility(View.GONE);
            tv_result.setText("Увы... Интернет соединение отсутствует :(");
        }
        return rootView;
    }

    private void initViews() {
        descriptions = new ArrayList<>();
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
//        ((IToolBar)getActivity()).toolbarSetTitle("Гороскоп онлайн");
        int[] img_ids = new int[]{R.id.aries, R.id.taurus, R.id.twins, R.id.cancer, R.id.lion, R.id.virgo
                , R.id.libra, R.id.scorpio, R.id.sagittarius, R.id.capricorn, R.id.aquarius, R.id.fish};
        images = new ImageView[12];
        new FbUtills().setStatistics(1);
        for (int i = 0; i < 12; i++) {
            Display display = getActivity().getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            Data_calculation dc = new Data_calculation();
            int m1dp = dc.dpToPx(2, getActivity());
            int width = (size.x - 17 * m1dp) / 4;
            LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(width, width);
            GridLayout.LayoutParams imageViewParams = new GridLayout.LayoutParams(gridParams);
            imageViewParams.setMargins(m1dp, m1dp, m1dp, m1dp);
            images[i] = (ImageView) rootView.findViewById(img_ids[i]);
            images[i].setOnClickListener(this);
            images[i].setLayoutParams(imageViewParams);
        }
        progressBar = (ProgressBar) rootView.findViewById(R.id.progressbar_horoscope);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        setBackgroundBlack();

        tv_result = (TextView) rootView.findViewById(R.id.horOn_tvResult);
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
                    tv_result.setText("");
                    progressBar.setVisibility(View.VISIBLE);
                    backgroundPressed(key, images);
                    setZodiacName(key);
                    new HtmlParser().parseHoroscope(getActivity(), descriptions, tv_result, key, progressBar);
                    HtmlParser.TTL = 0;
                } else {
                    backgroundPressed(key, images);
                    setZodiacName(key);
                    tv_result.setText(descriptions.get(key));
                    tv_sign_name.setVisibility(View.VISIBLE);
                }
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Данные еще не загрузились", Toast.LENGTH_SHORT).show();
        }
    }

    private void backgroundPressed(int i, ImageView[] img_m) {
        setBackgroundBlack();
        img_m[i].setImageDrawable(getResources().getDrawable(R.drawable.img_proz));
    }

    private void setBackgroundBlack() {
        for (ImageView image : images)
            image.setImageDrawable(getResources().getDrawable(R.drawable.img_t));
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
        Data_calculation struct_data = new Data_calculation();
        int j;
        if (args != null)
            j = struct_data.getZodiacId(mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFICATION, "Овен"));
        else
            j = (struct_data.getDateId(day, month) + 9) % 12;
        backgroundPressed(j, images);
        setZodiacName(j);
        new HtmlParser().parseHoroscope(getActivity(), descriptions, tv_result, j, progressBar);
    }
}
