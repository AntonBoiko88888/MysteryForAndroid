package keen.eye.ink1804.destination;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import keen.eye.ink1804.destination.Fragments.Intro_fragment;
import keen.eye.ink1804.destination.Math.Constants;

/**
 * Created by anton on 13.11.16.
 */

public class AppIntr extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = new Bundle();
        bundle.putInt("int", 1);
        Fragment fragment = new Intro_fragment();
        fragment.setArguments(bundle);
        Fragment fragment1 = new Intro_fragment();
        fragment1.setArguments(bundle);
        Fragment fragment2 = new Intro_fragment();
        fragment2.setArguments(bundle);
        Fragment fragment3 = new Intro_fragment();
        fragment3.setArguments(bundle);
        Fragment fragment4 = new Intro_fragment();
        fragment4.setArguments(bundle);
        addSlide(fragment);
        addSlide(fragment1);
        addSlide(fragment2);
        addSlide(fragment3);
        addSlide(fragment4);

       final SharedPreferences mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        if (!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {


            showStatusBar(false);
            showSkipButton(false);

            setFlowAnimation();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(AppIntr.this, MainActivity.class);
                    startActivity(i);
                }
            });

        }
        else {
            finish();
            startActivity(new Intent(AppIntr.this, MainActivity.class));
        }
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        startActivity(new Intent(AppIntr.this,MainActivity.class));
    }
}
