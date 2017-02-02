package keen.eye.ink1804.destination.Interfaces;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Ink1804 on 08.08.16.
 */
public interface pushDateListener {
    void onDatePushed(int day, int month, int year,int currentYear,boolean sex, int bsID,boolean isMyDesr);
    void onRegistration(int day, int month, int year, boolean sex);
    void onDescriptionClicked(String key, String layoutTag);
    void toolbarSetTitle(String title);
    void onNewProfile();
    void mainFragmentCreate();
    void setNotification(Context context);
}
