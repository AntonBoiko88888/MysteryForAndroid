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
   //     setContentView(R.layout.activity_splash_screen);


       final SharedPreferences mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        if (!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {

//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });


            for(int i=0;i<5;i++){
                Bundle bundle = new Bundle();
                bundle.putInt("number", i);
                Fragment fragment = new Intro_fragment();
                fragment.setArguments(bundle);
                addSlide(fragment);
            }


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
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
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
