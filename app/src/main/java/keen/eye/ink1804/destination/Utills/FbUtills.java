package keen.eye.ink1804.destination.Utills;

import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;

/**
 * Created by Ink1804 on 05.12.16.
 */

public class FbUtills {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    final private DatabaseReference mRef = mDatabase.getRef();

    public void setName(String _name) {
        int day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, 0);
        int month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        boolean sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, true);
        String socionics = MainActivity.mSettings.getString(Constants.APP_PREF_SOCIONICS, "");
        if(id!=0) {
            UsersModel user = new UsersModel(id, _name, day, month, year, sex, socionics);
            mRef.child("users").child(id + "").setValue(user);
        }
    }

    public void setSocionics(String _socionics) {
        long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, 0);
        String name = MainActivity.mSettings.getString(Constants.APP_PREF_NAME, "");
        int day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        int month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        boolean sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, true);
        if(id!=0) {
            UsersModel user = new UsersModel(id, name, day, month, year, sex, _socionics);
            mRef.child("users").child(id + "").setValue(user);
        }
    }

    public void getDataFromDB(final TextView tv_version, final String text_version) {
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (!dataSnapshot.child("app_version").getValue().toString().equals(text_version)) {
                        tv_version.setText(dataSnapshot.child("app_upgrade_text").getValue().toString());
                    }
                    MainActivity.isFirstLaunch = true;
                } catch (Exception e) {
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
