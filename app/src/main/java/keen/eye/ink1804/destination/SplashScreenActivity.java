package keen.eye.ink1804.destination;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import keen.eye.ink1804.destination.Math.Constants;

/**
 * Created by anton on 26.11.16.
 */

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        TextView loading = (TextView)findViewById(R.id.loading);
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        loading.setTypeface(tf);


        final SharedPreferences mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        if (!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(8000);
                        startActivity(new Intent(SplashScreenActivity.this, AppIntr.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                        startActivity(new Intent(SplashScreenActivity.this, AppIntr.class));
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
