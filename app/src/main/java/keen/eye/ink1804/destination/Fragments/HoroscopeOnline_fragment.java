package keen.eye.ink1804.destination.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 20.08.16.
 */
public class HoroscopeOnline_fragment extends Fragment implements View.OnClickListener{

    private View rootView;
    ImageView oven, telec, blizneci, rak, lev, deva, vesi, skorpion, strelec, kozerog, vodoley, ribi;
    ImageView[] img_m;
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
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.oven: backgroundPressed(1, img_m); break;
            case R.id.telec: backgroundPressed(2, img_m); break;
            case R.id.blizneci: backgroundPressed(3, img_m); break;
            case R.id.rak: backgroundPressed(4, img_m); break;
            case R.id.lev: backgroundPressed(5, img_m); break;
            case R.id.deva: backgroundPressed(6, img_m); break;
            case R.id.vesi: backgroundPressed(7, img_m); break;
            case R.id.skorpion: backgroundPressed(8, img_m); break;
            case R.id.strelec: backgroundPressed(9, img_m); break;
            case R.id.kozerog: backgroundPressed(10, img_m); break;
            case R.id.vodoley: backgroundPressed(11, img_m); break;
            case R.id.ribi: backgroundPressed(12, img_m); break;
        }
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
