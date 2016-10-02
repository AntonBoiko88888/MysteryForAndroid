package keen.eye.ink1804.destination.Utills;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 24.09.16.
 */

public class HtmlParser {
    Document doc;
    int TTL=0;

    public void parseHoroscope(final Context context, final TextView tvResult, final int horCode) {
        try {
            Ion.with(context)
                    .load("https://utro.europaplus.ru/programs/horoscope")
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {

                            String text;
                            doc = Jsoup.parse(result);
                            text = doc.select("ul.horoscope-list").select("li").get(horCode).select("div.text").text();
                            tvResult.setText(text);
                            TTL = 0;
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Не удалось загрузить данные, проверьте интернет соединение.", Toast.LENGTH_SHORT).show();
        }
    }
    public void parseNotificHoroscope(final Context context, final int horCode) {
        try {
            Ion.with(context)
                    .load("https://utro.europaplus.ru/programs/horoscope")
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {

                            String text;
                            doc = Jsoup.parse(result);
                            text = doc.select("ul.horoscope-list").select("li").get(horCode).select("div.text").text();
                            createNotification(context, text);
                            TTL = 0;
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "Не удалось загрузить данные, проверьте интернет соединение.", Toast.LENGTH_SHORT).show();
        }

    }

    void createNotification(Context context, String text){
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context
                .NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,MainActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setContentIntent(pendingIntent)
//                .setSmallIcon(R.drawable.crop__ic_done)
//                .setContentTitle("Гороскоп на сегодня")
//                .setContentText(text)
//                .setSubText("hello")
//                .setAutoCancel(true);
        Notification.Builder builder = new Notification.Builder(context)
                .setContentIntent(pendingIntent)
                .setContentTitle("Ваш гороскоп на сегодня")
                .setContentText("Овен")
                .setSmallIcon(R.drawable.icon_eye)
                .setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(text).build();

        notificationManager.notify(100,notification);
    }
}
