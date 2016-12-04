package keen.eye.ink1804.destination.Utills;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;

/**
 * Created by Ink1804 on 02.10.16.
 */

public class Notification_reciever extends BroadcastReceiver {
    private HtmlParser parser = new HtmlParser();
    private Data_calculation math = new Data_calculation();
    private String zodiac;
    private boolean showNotific;

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.getExtras();
        SharedPreferences mSettings = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        showNotific = mSettings.getBoolean(Constants.APP_PREF_NOTIFICATIONS,false);
        zodiac = mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFICATION,"Овен");
        int zodId = math.getZodiacId(zodiac);
        if(showNotific)
            parser.parseNotificHoroscope(context, zodId);


    }
}
