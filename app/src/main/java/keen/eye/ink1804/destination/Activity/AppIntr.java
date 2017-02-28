package keen.eye.ink1804.destination.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;

import keen.eye.ink1804.destination.Fragments.Intro_fragment;

/**
 * Created by anton on 13.11.16.
 */

public class AppIntr extends AppIntro {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < 5; i++) {
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

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
        startActivity(new Intent(AppIntr.this,MainActivity.class));
    }
}
