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
