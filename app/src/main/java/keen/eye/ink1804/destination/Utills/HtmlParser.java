package keen.eye.ink1804.destination.Utills;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import keen.eye.ink1804.destination.Fragments.HoroscopeOnline;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 24.09.16.
 */

public class HtmlParser {
    private Document doc;
    public static int TTL=0;

    public void parseHoroscope(final Context context, final TextView tvResult,final int horCode, final ProgressBar progressbar) {
        try {
            Ion.with(context)
                    .load("https://utro.europaplus.ru/programs/horoscope")
                    .asString()
                    .setCallback(new FutureCallback<String>() {
                        @Override
                        public void onCompleted(Exception e, String result) {
                            progressbar.setVisibility(ProgressBar.INVISIBLE);
                            String text = "";
                            if(result!=null) {
                                doc = Jsoup.parse(result);
                                for (int i = 0; i < 12; i++) {
                                    text = doc.select("ul.horoscope-list").select("li").get(i).select("div.text").text();
                                    HoroscopeOnline.descriptions.add(text);
                                }
                                tvResult.setText(HoroscopeOnline.descriptions.get(horCode));
                                TTL = 0;
                            }
                            else {
                                TTL++;
                                if(TTL!=5) {
                                    parseHoroscope(context, tvResult, horCode, progressbar);
                                    HoroscopeOnline.descriptions.clear();
                                }
                                else
                                    tvResult.setText("Не удалось загрузить данные, проверьте интернет соединение.");
                            }

                        }
                    });

        } catch (Exception e) {
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
                            createNotification(context, text,horCode);
                            TTL = 0;
                        }
                    });

        } catch (Exception e) {
            Toast.makeText(context, "Не удалось загрузить данные, проверьте интернет соединение.", Toast.LENGTH_SHORT).show();
        }

    }

    void createNotification(Context context, String text, int horCode){
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context
                .NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,MainActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        repeating_intent.putExtra("isHoroscope",true);

        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
//                .setContentIntent(pendingIntent)
//                .setSmallIcon(R.drawable.crop__ic_done)
//                .setContentTitle("Гороскоп на сегодня")
//                .setContentText(text)
//                .setSubText("hello")
//                .setAutoCancel(true);
        int[] img_ids = new int[]{R.drawable.push_aries,R.drawable.push_taurus,R.drawable.push_twins,R.drawable.push_cancer
                ,R.drawable.push_lion,R.drawable.push_virgo,R.drawable.push_libra,R.drawable.push_scorpio
                ,R.drawable.push_sagittarius,R.drawable.push_capricorn,R.drawable.push_aquarius,R.drawable.push_fish};
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.icon_eye_512);
        Notification.Builder builder = new Notification.Builder(context)
                .setContentIntent(pendingIntent)
                .setContentTitle("Ваш гороскоп на сегодня")
                .setContentText(Constants.ZODIAK_NAMES_normal[horCode])
                .setContentText(text)
                .setSmallIcon(img_ids[horCode])
                .setLargeIcon(icon)
                .setAutoCancel(true);

        Notification notification = new Notification.BigTextStyle(builder)
                .bigText(text).build();

        notificationManager.notify(100,notification);
    }
}
