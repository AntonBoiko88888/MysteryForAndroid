package keen.eye.ink1804.destination;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import keen.eye.ink1804.destination.Fragments.IntroFirstFragment;
import keen.eye.ink1804.destination.Fragments.IntroSecondFragment;
import keen.eye.ink1804.destination.Fragments.IntroThirdFragment;
import keen.eye.ink1804.destination.Math.Constants;

/**
 * Created by anton on 13.11.16.
 */

public class AppIntr extends AppIntro {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new IntroFirstFragment());
        addSlide(new IntroSecondFragment());
        addSlide(new IntroThirdFragment());

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
        else startActivity(new Intent(AppIntr.this,MainActivity.class));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        startActivity(new Intent(AppIntr.this,MainActivity.class));
    }
}
