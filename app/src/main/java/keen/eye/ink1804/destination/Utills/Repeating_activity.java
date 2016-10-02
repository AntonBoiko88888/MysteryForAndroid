package keen.eye.ink1804.destination.Utills;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 02.10.16.
 */
public class Repeating_activity extends AppCompatActivity{

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.repeating_layout_activity);
    }
}
