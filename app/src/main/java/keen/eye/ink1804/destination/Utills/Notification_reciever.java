package keen.eye.ink1804.destination.Utills;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ink1804 on 02.10.16.
 */

public class Notification_reciever extends BroadcastReceiver {
    HtmlParser parser = new HtmlParser();

    @Override
    public void onReceive(Context context, Intent intent) {
        parser.parseNotificHoroscope(context, 0);
//        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context
//                .NOTIFICATION_SERVICE);
//
//        Intent repeating_intent = new Intent(context,MainActivity.class);
//        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        HtmlParser parser = new HtmlParser();
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setContentIntent(pendingIntent)
//                .setSmallIcon(R.drawable.crop__ic_done)
//                .setContentTitle("Гороскоп на сегодня")
//                .setContentText(text)
//                .setSubText("hello")
//                .setAutoCancel(true);
//
//        notificationManager.notify(100,builder.build());
    }
}
