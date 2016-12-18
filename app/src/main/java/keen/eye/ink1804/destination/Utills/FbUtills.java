package keen.eye.ink1804.destination.Utills;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import keen.eye.ink1804.destination.Fragments.Account;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 05.12.16.
 */

public class FbUtills {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    final private DatabaseReference mRef = mDatabase.getRef();
    private List<UsersModel> users = new ArrayList<>();

    public void onLogin(final Context context, final String email, final String password) {
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UsersModel user;
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    user = postSnapshot.getValue(UsersModel.class);
                    users.add(user);
                }
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).Email.equals(email)) {
                        user = users.get(i);
                        i = users.size() + 1;
                        SharedPreferences.Editor editor = MainActivity.mSettings.edit();
                        editor.putString(Constants.APP_PREF_NAME, user.Name);
                        editor.putInt(Constants.APP_PREF_DAY, user.Day);
                        editor.putInt(Constants.APP_PREF_MONTH, user.Month);
                        editor.putInt(Constants.APP_PREF_YEAR, user.Year);
                        editor.putBoolean(Constants.APP_PREF_SEX, user.Sex);
                        editor.putString(Constants.APP_PREF_SOCIONICS, user.Socionics);
                        editor.putString(Constants.APP_PREF_STATUS, user.Status);
                        editor.putString(Constants.APP_PREF_EMAIL, email);
                        editor.putString(Constants.APP_PREF_PASSWORD, password);
                        editor.putLong(Constants.APP_PREF_USER_ID, user.Id);
                        editor.apply();
                        UsersModel setUser = new UsersModel(user.Id, user.Name, user.Day, user.Month, user.Year
                                , user.Sex, user.Socionics, user.Email, password, user.Status);
                        mRef.child(user.Id + "").setValue(setUser);
                    }
                }
                pushDateListener listener = (pushDateListener) context;
                listener.mainFragmentCreate();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }


    public void setAccessToAdvanced() {
        String status = "Продвинутый";
        SharedPreferences.Editor editor = MainActivity.mSettings.edit();
        editor.putString(Constants.APP_PREF_STATUS, status);
        editor.apply();
        int day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, 0);
        int month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        String name = MainActivity.mSettings.getString(Constants.APP_PREF_NAME, "");
        boolean sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, true);
        String email = MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL, "");
        String password = MainActivity.mSettings.getString(Constants.APP_PREF_PASSWORD, "");
        String socionics = MainActivity.mSettings.getString(Constants.APP_PREF_SOCIONICS, "");
        UsersModel user = new UsersModel(id, name, day, month, year, sex, socionics, email, password, status);
        mRef.child(id + "").setValue(user);
    }
    public void setName(String _name) {
        int day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, 0);
        int month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        boolean sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, true);
        String email = MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL, "");
        String password = MainActivity.mSettings.getString(Constants.APP_PREF_PASSWORD, "");
        String socionics = MainActivity.mSettings.getString(Constants.APP_PREF_SOCIONICS, "");
        String status = MainActivity.mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий");
        UsersModel user = new UsersModel(id, _name, day, month, year, sex, socionics, email, password, status);
        mRef.child(id + "").setValue(user);
    }
    public void setSocionics(String _socionics) {
        long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, 0);
        String name = MainActivity.mSettings.getString(Constants.APP_PREF_NAME, "");
        int day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        int month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        int year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        boolean sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, true);
        String email = MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL, "");
        String password = MainActivity.mSettings.getString(Constants.APP_PREF_PASSWORD, "");
        String status = MainActivity.mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий");
        UsersModel user = new UsersModel(id, name, day, month, year, sex, _socionics, email, password, status);
        mRef.child(id + "").setValue(user);
    }
    public void getDataFromDB(final Context context, final TextView tv_status,final Button push, final Button new_profile){
        final long id = MainActivity.mSettings.getLong(Constants.APP_PREF_USER_ID, -1);
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    UsersModel user;
                    user = dataSnapshot.child(id + "").getValue(UsersModel.class);
                    SharedPreferences.Editor editor = MainActivity.mSettings.edit();
                    editor.putString(Constants.APP_PREF_NAME, user.Name);
                    editor.putInt(Constants.APP_PREF_DAY, user.Day);
                    editor.putInt(Constants.APP_PREF_MONTH, user.Month);
                    editor.putInt(Constants.APP_PREF_YEAR, user.Year);
                    editor.putBoolean(Constants.APP_PREF_SEX, user.Sex);
                    editor.putString(Constants.APP_PREF_SOCIONICS, user.Socionics);
                    editor.putString(Constants.APP_PREF_STATUS, user.Status);
                    editor.putString(Constants.APP_PREF_EMAIL, user.Email);
                    editor.putString(Constants.APP_PREF_PASSWORD, user.Password);
                    editor.putLong(Constants.APP_PREF_USER_ID, user.Id);
                    editor.apply();
                    tv_status.setText(setTextSettings("Статус:<br>", user.Status));
                    MainActivity.nav_headerStatus.setText(user.Status);
                    Account.status = user.Status;
                    if(user.Status.equals("Начинающий")) {
                        push.setBackgroundResource(R.drawable.acc_push_pressed);
                        new_profile.setBackgroundResource(R.drawable.acc_new_profile_pressed);
                        MainActivity.nav_headerStatus.setTextColor(ContextCompat.getColor(context, R.color.pro_zra_beginning_status));
                    }
                    else{
                        push.setBackgroundResource(R.drawable.acc_push_states);
                        new_profile.setBackgroundResource(R.drawable.acc_new_profile_states);
                        MainActivity.nav_headerStatus.setTextColor(ContextCompat.getColor(context,R.color.pro_zra_advanced_status));
                    }
                    MainActivity.isFirstLaunch = true;
                }catch (Exception e){}
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public Spanned setTextSettings(String _text, String _value) {
        String text = _text;
        String value = _value;
        text = String.format("<u><i>%s</i></u>", text);
        value = String.format("<b>%s</b>", value);
        return Html.fromHtml(text + " " + value);
    }

}
