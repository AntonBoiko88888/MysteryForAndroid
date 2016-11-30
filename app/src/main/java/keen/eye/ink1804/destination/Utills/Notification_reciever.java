package keen.eye.ink1804.destination.Utills;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;

import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;

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
        zodiac = mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFOCATION,"Овен");
        int zodId = math.getZodiacId(zodiac);
        if(showNotific)
            parser.parseNotificHoroscope(context, zodId);


    }
}
