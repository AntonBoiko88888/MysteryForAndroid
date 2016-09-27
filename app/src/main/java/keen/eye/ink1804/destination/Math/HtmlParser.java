package keen.eye.ink1804.destination.Math;

import android.content.Context;
import android.widget.TextView;
import android.widget.Toast;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by Ink1804 on 24.09.16.
 */

public class HtmlParser {
    Document doc;
    int TTL=0;

    public void parseHoroscope(final Context context, final TextView tvResult, final int horCode){
        try{
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

        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, "Не удалось загрузить данные, проверьте интернет соединение.", Toast.LENGTH_SHORT).show();
        }
    }
}
