package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.HtmlParser;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline_fragment extends Fragment implements View.OnClickListener{

    private View rootView;
    private ImageView oven, telec, blizneci, rak, lev, deva, vesi, skorpion, strelec, kozerog, vodoley, ribi;
    private ImageView[] img_m;
    private TextView tv_result;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.horoscope_online_layout_fragment,container,false);
        initViews();
        return rootView;
    }

    private void initViews(){
        pushDateListener listener = (pushDateListener)getActivity();
        listener.toolbarSetTitle("Гороскоп онлайн");
        oven = (ImageView) rootView.findViewById(R.id.oven);
        oven.setOnClickListener(this);
        telec = (ImageView) rootView.findViewById(R.id.telec);
        telec.setOnClickListener(this);
        blizneci = (ImageView) rootView.findViewById(R.id.blizneci);
        blizneci.setOnClickListener(this);
        rak = (ImageView) rootView.findViewById(R.id.rak);
        rak.setOnClickListener(this);
        lev = (ImageView) rootView.findViewById(R.id.lev);
        lev.setOnClickListener(this);
        deva = (ImageView) rootView.findViewById(R.id.deva);
        deva.setOnClickListener(this);
        vesi = (ImageView) rootView.findViewById(R.id.vesi);
        vesi.setOnClickListener(this);
        skorpion = (ImageView) rootView.findViewById(R.id.skorpion);
        skorpion.setOnClickListener(this);
        strelec = (ImageView) rootView.findViewById(R.id.strelec);
        strelec.setOnClickListener(this);
        kozerog = (ImageView) rootView.findViewById(R.id.kozerog);
        kozerog.setOnClickListener(this);
        vodoley = (ImageView) rootView.findViewById(R.id.vodoley);
        vodoley.setOnClickListener(this);
        ribi = (ImageView) rootView.findViewById(R.id.ribi);
        ribi.setOnClickListener(this);
        img_m = new ImageView[] {oven, telec, blizneci, rak, lev, deva, vesi, skorpion, strelec, kozerog, vodoley,ribi};
        backgroundBlack();
        img_m[0].setImageDrawable(getResources().getDrawable(R.drawable.img_proz));
        tv_result = (TextView)rootView.findViewById(R.id.horOn_tvResult);
    }

    @Override
    public void onClick(View view) {
        int key = 1;
        switch (view.getId()) {
            case R.id.oven: key = 1; break;
            case R.id.telec: key = 2; break;
            case R.id.blizneci: key = 3; break;
            case R.id.rak: key = 4; break;
            case R.id.lev: key = 5; break;
            case R.id.deva: key = 6; break;
            case R.id.vesi: key = 7; break;
            case R.id.skorpion: key = 8; break;
            case R.id.strelec: key = 9; break;
            case R.id.kozerog: key = 10; break;
            case R.id.vodoley: key = 11; break;
            case R.id.ribi: key = 12; break;
        }
        backgroundPressed(key, img_m);
        HtmlParser parser = new HtmlParser();
        parser.parseHoroscope(getActivity(),tv_result, key-1);
    }

    private void backgroundPressed(int i, ImageView[] img_m) {
        backgroundBlack();
        img_m[i-1].setImageDrawable(getResources().getDrawable(R.drawable.img_proz));
    }

    private void backgroundBlack() {
        for (int i = 0; i<img_m.length; i++) {
            img_m[i].setImageDrawable(getResources().getDrawable(R.drawable.img_t));
        }
    }
}
