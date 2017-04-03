package keen.eye.ink1804.destination.Utills;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 05.12.16.
 */

public class FbUtills {
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
    final private DatabaseReference mRef = mDatabase.getRef();

    public void getDataFromDB(final Context context, final TextView tv_version, final String text_version) {
        mRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    if (!dataSnapshot.child("app_version").getValue().toString().equals(text_version)) {
                        app_version(context, dataSnapshot.child("app_upgrade_text").getValue().toString());
                    }
                    if (!dataSnapshot.child("app_notification").getValue().toString().equals("")) {
                        tv_version.setVisibility(View.VISIBLE);
                        tv_version.setText(dataSnapshot.child("app_notification").getValue().toString());
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

    public void app_version(final Context context, String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(context, R.style.AlertDialogCustom));
        builder.setTitle("Информация")
                .setMessage(s)
                .setIcon(R.drawable.icon_eye_512)
                .setPositiveButton("Понятно", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Обновить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final String appPackageName = context.getPackageName();
                        try {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
