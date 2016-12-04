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

        Intent intent = new Intent(this, AppIntr.class);
        startActivity(intent);
        finish();
    }
}