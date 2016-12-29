package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
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
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.MainActivity;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 12.08.16.
 */
public class Account extends Fragment implements View.OnClickListener {

    private View rootView;
//    private TextView tv_name;
    private boolean sex;
//    private ImageView imageView;
    private String name;
    private int day, month, year;
    public static String status;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_fragment, container, false);
        initializeViews();
        return rootView;
    }
    @Override
    public void onDetach() {
//        tv_name = null;
        ((ImageView) rootView.findViewById(R.id.acc_image_icon)).setImageDrawable(null);
//        imageView = null;
        rootView = null;
        super.onDetach();
    }

    private void initializeViews() {
//        pushDateListener listener = (pushDateListener) getActivity();
        ((pushDateListener) getActivity()).toolbarSetTitle("Профиль");
//        imageView = (ImageView) rootView.findViewById(R.id.acc_image_icon);
        getPreferences();

        rootView.findViewById(R.id.acc_btn_rename).setOnClickListener(this);
        rootView.findViewById(R.id.acc_select_img).setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_question).setOnClickListener(this);
//        Button btn_push = (Button) rootView.findViewById(R.id.acc_btn_pushSettings);
//        Button btn_new_profile = (Button) rootView.findViewById(R.id.acc_btn_new_profile);
        rootView.findViewById(R.id.acc_btn_pushSettings).setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_new_profile).setOnClickListener(this);
//        Typeface tf = Typeface.createFromAsset(getResources().getAssets(), "space.otf");
//        Button desc = (Button) rootView.findViewById(R.id.acc_btn_description);
        ((Button) rootView.findViewById(R.id.acc_btn_description)).setTypeface(Typeface.createFromAsset(getResources().getAssets(), "space.otf"));
        rootView.findViewById(R.id.acc_btn_description).setOnClickListener(this);
//        TextView tv_email = (TextView) rootView.findViewById(R.id.acc_tv_email);
        rootView.findViewById(R.id.acc_tv_email).setVisibility(View.GONE);
//        Button userUpgrage = (Button) rootView.findViewById(R.id.btn_users_upgrade);
        rootView.findViewById(R.id.btn_users_upgrade).setOnClickListener(this);
        if(!MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL,"").equals("")){
            rootView.findViewById(R.id.acc_tv_email).setVisibility(View.VISIBLE);
            ((TextView) rootView.findViewById(R.id.acc_tv_email)).setText(MainActivity.mSettings.getString(Constants.APP_PREF_EMAIL,""));
            ((Button)rootView.findViewById(R.id.btn_users_upgrade)).setText("Сменить");
        }
        status = MainActivity.mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий");
//        tv_name = (TextView) rootView.findViewById(R.id.acc_tv_name);
//        TextView tv_date = (TextView) rootView.findViewById(R.id.acc_tv_date);
//        TextView tv_sex = (TextView) rootView.findViewById(R.id.acc_tv_sex);
//        TextView tv_status = (TextView) rootView.findViewById(R.id.acc_tv_status);
//        TextView tv_version = (TextView) rootView.findViewById(R.id.tv_version);
        ((TextView) rootView.findViewById(R.id.acc_tv_date)).setText(setTextSettings("Дата рождения:<br>", day + "." + month + "." + year + ""));
        ((TextView) rootView.findViewById(R.id.acc_tv_date)).setText(setTextSettings("Дата рождения:<br>", day + "." + month + "." + year + ""));
        ((TextView) rootView.findViewById(R.id.acc_tv_name)).setText(setTextSettings("Имя:", " " + name));
        if (sex)
            ((TextView) rootView.findViewById(R.id.acc_tv_sex)).setText(setTextSettings("Пол:", " муж."));
        else
            ((TextView) rootView.findViewById(R.id.acc_tv_sex)).setText(setTextSettings("Пол:", " жен."));
        ((TextView) rootView.findViewById(R.id.acc_tv_status)).setText(setTextSettings("Статус:<br>", status));
        if(MainActivity.mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий").equals("Начинающий"))
            ((TextView) rootView.findViewById(R.id.acc_tv_status)).setTextColor(ContextCompat.getColor(getContext(), R.color.pro_zra_beginning_status));
        else
            ((TextView) rootView.findViewById(R.id.acc_tv_status)).setTextColor(ContextCompat.getColor(getContext(),R.color.pro_zra_advanced_status));
        if (status.equals("Начинающий")) {
            rootView.findViewById(R.id.acc_btn_pushSettings).setBackgroundResource(R.drawable.acc_push_pressed);
        }
        if(!MainActivity.isFirstLaunch) {
//            FbUtills fbUtills = new FbUtills();
            new FbUtills().getDataFromDB(getActivity(),
                    (TextView) rootView.findViewById(R.id.acc_tv_status),
                    (TextView) rootView.findViewById(R.id.tv_version),
                    (Button) rootView.findViewById(R.id.acc_btn_pushSettings), getResources().getString(R.string.app_version));
        }
    }

    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener) getActivity();
        switch (view.getId()) {
            case R.id.acc_select_img:
                listener.pictureDownload((ImageView) rootView.findViewById(R.id.acc_image_icon)/*imageView*/);
                break;
            case R.id.acc_btn_description:
                listener.onDatePushed(day, month, year, Calendar.getInstance().get(Calendar.YEAR), sex, 1, true);
                //поменял на 1, если что то будет тупить, надо исправить на 2, но не должно
                break;
            case R.id.acc_btn_rename:
                setName();
                break;
            case R.id.acc_btn_new_profile:
                listener.onNewProfile();
                break;
            case R.id.acc_btn_pushSettings:
                if (status.equals("Начинающий")) {
                    Toast.makeText(getActivity(), "Начинающим пользователям уведомления гороскопа недоступны!", Toast.LENGTH_SHORT).show();
                }
                else
                    listener.setNotification(getActivity());
                break;
            case R.id.btn_users_upgrade:
                listener.onRegEnter();
                break;
            case R.id.acc_btn_question:
                listener.onStatusAbout();
                break;
            default:
                break;
        }
    }

    private void setName() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(getActivity(), R.style.AlertDialogCustom));
        builder.setTitle("Редактирование имени")
                .setMessage("Введите новое имя")
                .setCancelable(false)
                .setIcon(R.drawable.icon_eye_512)
                .setView(R.layout.alert_setname)
                .setPositiveButton("Ок",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                EditText et = (EditText) ((AlertDialog) dialog).findViewById(R.id.alert_edit_name);
                                String name = et.getText().toString();
                                if (!name.trim().equals("") && name.length() <= 10) {
                                    ((TextView) rootView.findViewById(R.id.acc_tv_name)).setText(setTextSettings("Имя:", " " + name));
                                    SharedPreferences.Editor editor = MainActivity.mSettings.edit();
                                    editor.putString(Constants.APP_PREF_NAME, name);
                                    editor.apply();
//                                    FbUtills firebaseUtills = new FbUtills();
//                                    firebaseUtills.setName(name);
                                    new FbUtills().setName(name);
                                    dialog.cancel();
                                } else {
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
        MainActivity.mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        name = MainActivity.mSettings.getString(Constants.APP_PREF_NAME, "noName");
        day = MainActivity.mSettings.getInt(Constants.APP_PREF_DAY, 1);
        month = MainActivity.mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        year = MainActivity.mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        sex = MainActivity.mSettings.getBoolean(Constants.APP_PREF_SEX, false);
//        String icon = MainActivity.mSettings.getString(Constants.APP_PREF_IMAGE, "");
        Bitmap bitmap;
//        InputStream is;
//        BufferedInputStream bis;
        try {
            URLConnection conn = new URL(MainActivity.mSettings.getString(Constants.APP_PREF_IMAGE, "")).openConnection();
            conn.connect();
//            is = conn.getInputStream();
//            bis = new BufferedInputStream(conn.getInputStream());
            bitmap = BitmapFactory.decodeStream(new BufferedInputStream(conn.getInputStream()));

            ((ImageView) rootView.findViewById(R.id.acc_image_icon)).setImageBitmap(bitmap);

        } catch (Exception e) {
            ((ImageView) rootView.findViewById(R.id.acc_image_icon)).setImageResource(R.drawable.account_img);
        }

    }

    public Spanned setTextSettings(String _text, String _value) {
        String text = _text;
        String value = _value;
        text = String.format("<u><i>%s</i></u>", text);
        value = String.format("<b>%s</b>", value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text+" "+value, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text+" "+value);
        }
//        return Html.fromHtml(text + " " + value);
    }

}
