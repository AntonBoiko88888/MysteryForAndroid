package keen.eye.ink1804.destination.Utills;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;

/**
 * Created by Ink1804 on 30.11.16.
 */

public class firebaseUtill {
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("users");
    final private DatabaseReference mRef = mDatabase.getRef();

    public void onLogin(final Context context, final String email, final String password){
        final List<UsersModel> users = new ArrayList<>();

        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UsersModel user = null;
                for(DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    user = postSnapshot.getValue(UsersModel.class);
//                    if (user != null)
                        users.add(user);
                }
                for(int i=0;i<users.size();i++){
                    if(users.get(i).Email.equals(email)){
                        user = users.get(i);
                        i = users.size() + 1;
                    }
                }
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
                pushDateListener listener = (pushDateListener)context;

                listener.mainFragmentCreate();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
