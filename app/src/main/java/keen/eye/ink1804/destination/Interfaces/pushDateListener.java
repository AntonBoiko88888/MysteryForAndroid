package keen.eye.ink1804.destination.Interfaces;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Ink1804 on 08.08.16.
 */
public interface pushDateListener {
    void onDatePushed(String s, int day, int month, int year, int currentYear, boolean sex, boolean isMyDescr);
    void onRegistration(int day, int month, int year, boolean sex);
    void toolbarSetTitle(String title);
    void onNewProfile();
    void setNotification(Context context);
    void offlineMessageBox();
    boolean isOnline(Context context);
}
