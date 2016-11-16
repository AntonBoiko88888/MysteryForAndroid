package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.Utills.HtmlParser;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline_fragment extends Fragment implements View.OnClickListener{

    private ProgressBar progressBar;
    private View rootView;
    private ImageView[] img_m;
    private TextView tv_result, tv_sign_name;
    private HtmlParser parser = new HtmlParser();
    private MainActivity mainActivity = new MainActivity();
    public static List<String> descriptions = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.horoscope_online_layout_fragment,container,false);
        initViews();
        if(mainActivity.isOnline(getActivity()))
            onMySignClick();
        else{
            progressBar.setVisibility(View.INVISIBLE);
            tv_sign_name.setVisibility(View.GONE);
            tv_result.setText("Увы... Интернет соединение отсутствует :(");
        }
        return rootView;
    }

    private void initViews() {
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Гороскоп онлайн");
        ImageView aries = (ImageView) rootView.findViewById(R.id.aries);
        aries.setOnClickListener(this);
        ImageView taurus = (ImageView) rootView.findViewById(R.id.taurus);
        taurus.setOnClickListener(this);
        ImageView twins = (ImageView) rootView.findViewById(R.id.twins);
        twins.setOnClickListener(this);
        ImageView cancer = (ImageView) rootView.findViewById(R.id.cancer);
        cancer.setOnClickListener(this);
        ImageView lion = (ImageView) rootView.findViewById(R.id.lion);
        lion.setOnClickListener(this);
        ImageView virgo = (ImageView) rootView.findViewById(R.id.virgo);
        virgo.setOnClickListener(this);
        ImageView libra = (ImageView) rootView.findViewById(R.id.libra);
        libra.setOnClickListener(this);
        ImageView scorpio = (ImageView) rootView.findViewById(R.id.scorpio);
        scorpio.setOnClickListener(this);
        ImageView sagittarius = (ImageView) rootView.findViewById(R.id.sagittarius);
        sagittarius.setOnClickListener(this);
        ImageView capricorn = (ImageView) rootView.findViewById(R.id.capricorn);
        capricorn.setOnClickListener(this);
        ImageView aquarius = (ImageView) rootView.findViewById(R.id.aquarius);
        aquarius.setOnClickListener(this);
        ImageView fish = (ImageView) rootView.findViewById(R.id.fish);
        fish.setOnClickListener(this);
        progressBar = (ProgressBar)rootView.findViewById(R.id.progressbar_horoscope);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        img_m = new ImageView[] {aries, taurus, twins, cancer, lion, virgo, libra, scorpio, sagittarius, capricorn, aquarius, fish};
        setBackgroundBlack();
        tv_result = (TextView)rootView.findViewById(R.id.horOn_tvResult);
        tv_sign_name = (TextView)rootView.findViewById(R.id.sphere_tv_sign_name);
        tv_sign_name.setTypeface(tf);
    }

    @Override
    public void onClick(View view) {
        int key = 1;
        switch (view.getId()) {
            case R.id.aries: key = 1; break;
            case R.id.taurus: key = 2; break;
            case R.id.twins: key = 3; break;
            case R.id.cancer: key = 4; break;
            case R.id.lion: key = 5; break;
            case R.id.virgo: key = 6; break;
            case R.id.libra: key = 7; break;
            case R.id.scorpio: key = 8; break;
            case R.id.sagittarius: key = 9; break;
            case R.id.capricorn: key = 10; break;
            case R.id.aquarius: key = 11; break;
            case R.id.fish: key = 12; break;
            default: break;
        }
        try{
        if (mainActivity.isOnline(getActivity()))
            if (descriptions.size() == 0) {
                tv_sign_name.setVisibility(View.VISIBLE);
                tv_result.setText("");
                progressBar.setVisibility(View.VISIBLE);
                backgroundPressed(key, img_m);
                setZodiacName(key+2);
                parser.parseHoroscope(getActivity(), tv_result, key - 1, progressBar);
            }
            else {
                backgroundPressed(key, img_m);
                setZodiacName(key + 2);
                tv_result.setText(descriptions.get(key - 1));
                tv_sign_name.setVisibility(View.VISIBLE);

            }
        }catch (Exception e){
            Toast.makeText(getActivity(), "Данные еще не загрузились", Toast.LENGTH_SHORT).show();
        }
    }

    private void backgroundPressed(int i, ImageView[] img_m) {
        setBackgroundBlack();
        img_m[i-1].setImageDrawable(getResources().getDrawable(R.drawable.img_proz));
    }
    private void setBackgroundBlack() {
        for (int i = 0; i<img_m.length; i++) {
            img_m[i].setImageDrawable(getResources().getDrawable(R.drawable.img_t));
        }
    }
    private void setZodiacName(int zod) {
        if(zod>11) zod=zod-12;
        Constants C = new Constants();
        tv_sign_name.setText(C.ZODIAK_NAMES[zod]);
    }

    private void onMySignClick() {
        SharedPreferences mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        int day = mSettings.getInt(Constants.APP_PREF_DAY, 1);
        int month = mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        Data_calculation struct_data = new Data_calculation();
        int j = (struct_data.getDateId(day, month) - 2) % 12;
        backgroundPressed(j, img_m);
        setZodiacName(j +2);
        parser.parseHoroscope(getActivity(),tv_result, j -1, progressBar);
    }
}
