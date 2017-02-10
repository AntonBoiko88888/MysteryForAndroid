package keen.eye.ink1804.destination.Utills;

import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Ink1804 on 05.12.16.
 */

public class FbUtills {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    final private DatabaseReference mRef = mDatabase.getRef();

    public void getDataFromDB(final TextView tv_version, final TextView admin_text, final String text_version) {
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (!dataSnapshot.child("app_version").getValue().toString().equals(text_version)) {
                        tv_version.setText(dataSnapshot.child("app_upgrade_text").getValue().toString());
                    }
                    if (!dataSnapshot.child("app_notification").getValue().toString().equals("")) {
                        admin_text.setVisibility(View.VISIBLE);
                        admin_text.setText(dataSnapshot.child("app_notification").getValue().toString());
                    }
                } catch (Exception e) {}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    public void setStatistics(final int c) {
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    long count = 0;
                    switch (c) {
                        case 1:
                            count = (long) dataSnapshot.child("statistics").child("hor_clicks").getValue();
                            if (count==0)
                            count = (long) dataSnapshot.child("statistics").child("hor_clicks").getValue();
                            if (count != 0) {
                                mRef.child("statistics").child("hor_clicks").setValue((count + 1));
                            }
                            break;
                        case 2:
                            count = (long) dataSnapshot.child("statistics").child("interesting_clicks").getValue();
                            if (count==0)
                            count = (long) dataSnapshot.child("statistics").child("interesting_clicks").getValue();
                            if (count != 0) {
                                mRef.child("statistics").child("interesting_clicks").setValue((count + 1));
                            }
                            break;
                        case 3:
                            count = (long) dataSnapshot.child("statistics").child("new_profile").getValue();
                            if (count==0)
                            count = (long) dataSnapshot.child("statistics").child("new_profile").getValue();
                            if (count != 0) {
                                mRef.child("statistics").child("new_profile").setValue((count + 1));
                            }
                            break;
                        case 4:
                            count = (long) dataSnapshot.child("statistics").child("sphere_clicks").getValue();
                            if (count==0)
                            count = (long) dataSnapshot.child("statistics").child("sphere_clicks").getValue();
                            if (count != 0) {
                                mRef.child("statistics").child("sphere_clicks").setValue((count + 1));
                            }
                            break;
                        case 5:
                            count = (long) dataSnapshot.child("statistics").child("details").getValue();
                            if (count==0)
                                count = (long) dataSnapshot.child("statistics").child("details").getValue();
                            if (count != 0) {
                                mRef.child("statistics").child("details").setValue((count + 1));
                            }
                            break;
                    }
                } catch (Exception e) {}
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
