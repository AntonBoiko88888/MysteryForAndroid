package keen.eye.ink1804.destination.Interfaces;

import android.content.Context;

/**
 * Created by anton on 04.03.17.
 */

public interface IsOnlaine {
    boolean isOnline(Context context);
    void offlineMessageBox();
}
