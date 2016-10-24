package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by Ink1804 on 12.08.16.
 */
public class Account_fragment extends Fragment implements View.OnClickListener {

    private View rootView;
    private TextView tv_name;
    private boolean sex;
    private ImageView imageView;
    private String status, name, icon;
    private int day, month, year;
    private SharedPreferences mSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_layout_fragment, container, false);
        initializeViews();
        return rootView;
    }

    private void initializeViews() {
        pushDateListener listener = (pushDateListener) getActivity();
        listener.toolbarSetTitle("Аккаунт");
        imageView = (ImageView) rootView.findViewById(R.id.acc_image_icon);
        getPreferences();

        rootView.findViewById(R.id.acc_btn_rename).setOnClickListener(this);
        rootView.findViewById(R.id.acc_select_img).setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_pushSettings).setOnClickListener(this);
        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
        Button desc = (Button)rootView.findViewById(R.id.acc_btn_description);
        desc.setTypeface(tf);
        desc.setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_new_profile).setOnClickListener(this);
        status = mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий");
        tv_name = (TextView) rootView.findViewById(R.id.acc_tv_name);
        TextView tv_date = (TextView) rootView.findViewById(R.id.acc_tv_date);
        TextView tv_sex = (TextView) rootView.findViewById(R.id.acc_tv_sex);
        TextView tv_status = (TextView) rootView.findViewById(R.id.acc_tv_status);
        tv_date.setText(setTextSettingsBirth("Дата рождения:<br>",  day + "."+  month + "."+  year+""));
        tv_name.setText(setTextSettings("Имя:"," "+name));
        if (sex) tv_sex.setText(setTextSettings("Пол:", " муж."));
        else tv_sex.setText(setTextSettings("Пол:", " жен."));
        tv_status.setText(setTextSettings("Статус:<br>", status));


    }

    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener) getActivity();
        switch (view.getId()) {
            case R.id.acc_select_img:
                listener.pictureDownload(imageView);
                break;
            case R.id.acc_btn_description:
                listener.onDatePushed(day, month, year, Calendar.getInstance().get(Calendar.YEAR), sex, 2);
                break;
            case R.id.acc_btn_rename:
                setName();
                break;
            case R.id.acc_btn_new_profile:
                listener.onNewProfile();
                break;
            case R.id.acc_btn_pushSettings:
                listener.setNotification();
                break;
            default: break;
        }
    }

    private void setName(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Редактирование имени")
                .setMessage("Введите новое имя")
                .setCancelable(false)
                .setIcon(R.drawable.icon_eye)
                .setView(R.layout.alert_setname)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                EditText et = (EditText)((AlertDialog) dialog).findViewById(R.id.alert_edit_name);
                                String name = et.getText().toString();
                                if (!name.trim().equals("")&&name.length()<=10) {
                                    tv_name.setText("Имя: " + name);
                                    SharedPreferences mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = mSettings.edit();
                                    editor.putString(Constants.APP_PREF_NAME, name);
                                    editor.apply();
                                    dialog.cancel();
                                }else{
                                    Toast.makeText(getActivity(), "Недопустимое имя", Toast.LENGTH_SHORT).show();
                                    setName();
                                }
                            }
                        })
        .setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void getPreferences() {
        mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        name = mSettings.getString(Constants.APP_PREF_NAME, "noName");
        day = mSettings.getInt(Constants.APP_PREF_DAY, 1);
        month = mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        year = mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        sex = mSettings.getBoolean(Constants.APP_PREF_SEX, false);
        icon = mSettings.getString(Constants.APP_PREF_IMAGE, "");
        Bitmap bitmap;
        InputStream is;
        BufferedInputStream bis;
        try {
            //FIXME to do in Picasso
            //TODO example Picasso.with(context).load(url).into(imageView);
            URLConnection conn = new URL(icon).openConnection();
            conn.connect();
            is = conn.getInputStream();
            bis = new BufferedInputStream(is, 8192);
            bitmap = BitmapFactory.decodeStream(bis);
            imageView.setImageBitmap(bitmap);

        } catch (Exception e) {
            imageView.setImageResource(R.drawable.account_img);
        }

    }

    public Spanned setTextSettings(String text, String value){
        return Html.fromHtml(String.format("<u><i>%s</i></u>",text+" "+String.format("<b>%s</b>",value)));
    }

    public Spanned setTextSettingsBirth(String text, String value){
        return Html.fromHtml(String.format("<u><i>%s</i></u>",text)+" "+String.format("<b>%s</b>",value));
    }


}
