package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.FbUtills;

/**
 * Created by Ink1804 on 12.08.16.
 */
public class Account extends Fragment implements View.OnClickListener {


    private View rootView;
    private boolean sex;
    private String name;
    private int day, month, year;
    private AnimationDrawable mAnimationDrawable;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_fragment, container, false);
        initializeViews();
        return rootView;
    }

    private void initializeViews() {
//        ((pushDateListener) getActivity()).toolbarSetTitle("Профиль");
        getPreferences();
//        if (!((pushDateListener) getActivity()).isOnline(getActivity())) {
//            ((pushDateListener) getActivity()).offlineMessageBox();
//        }

        rootView.findViewById(R.id.acc_btn_rename).setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_pushSettings).setOnClickListener(this);
        rootView.findViewById(R.id.acc_btn_new_profile).setOnClickListener(this);
        imageView = (ImageView) rootView.findViewById(R.id.acc_image_icon);
        imageView.setOnClickListener(this);
        imageView.setBackgroundResource(R.drawable.acc_animation);

        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.start();

        ((TextView) rootView.findViewById(R.id.acc_tv_name)).setText(setTextSettings("Имя:", " " + name));
        ((TextView) rootView.findViewById(R.id.acc_tv_date)).setText(setTextSettings("Дата рождения:", " " + day + "." + month + "." + year + ""));
        if (sex)
            ((TextView) rootView.findViewById(R.id.acc_tv_sex)).setText(setTextSettings("Пол:", " муж."));
        else
            ((TextView) rootView.findViewById(R.id.acc_tv_sex)).setText(setTextSettings("Пол:", " жен."));
        new FbUtills().getDataFromDB(
                (TextView) rootView.findViewById(R.id.tv_version),
                (TextView) rootView.findViewById(R.id.acc_tv_admin_text), getResources().getString(R.string.app_version));
    }

    @Override
    public void onClick(View view) {
        pushDateListener listener = (pushDateListener) getActivity();
        switch (view.getId()) {
            case R.id.acc_image_icon:
                mAnimationDrawable.stop();
                imageView.setBackgroundResource(R.drawable.account_img_pressed);
                listener.onDatePushed("account", day, month, year, Calendar.getInstance().get(Calendar.YEAR), sex, true);
                break;
            case R.id.acc_btn_rename:
                setName();
                break;
            case R.id.acc_btn_new_profile:
                listener.onNewProfile();
                break;
            case R.id.acc_btn_pushSettings:
                listener.setNotification(getActivity());
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
                                    SharedPreferences mSettings;
                                    mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = mSettings.edit();
                                    editor.putString(Constants.APP_PREF_NAME, name);
                                    editor.apply();
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
        SharedPreferences mSettings;
        mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        name = mSettings.getString(Constants.APP_PREF_NAME, "noName");
        day = mSettings.getInt(Constants.APP_PREF_DAY, 1);
        month = mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        year = mSettings.getInt(Constants.APP_PREF_YEAR, 2000);
        sex = mSettings.getBoolean(Constants.APP_PREF_SEX, false);
    }

    public Spanned setTextSettings(String _text, String _value) {
        String text = _text;
        String value = _value;
        text = String.format("<u><i>%s</i></u>", text);
        value = String.format("<b>%s</b>", value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text + " " + value, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text + " " + value);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mAnimationDrawable.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        imageView.setBackgroundResource(R.drawable.acc_animation);
        mAnimationDrawable = (AnimationDrawable) imageView.getBackground();
        mAnimationDrawable.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        imageView.destroyDrawingCache();
        mAnimationDrawable.stop();

    }
}
