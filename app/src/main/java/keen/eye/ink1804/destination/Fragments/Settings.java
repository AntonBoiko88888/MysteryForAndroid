package keen.eye.ink1804.destination.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bruce.pickerview.popwindow.DatePickerPopWin;

import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 04.02.17.
 */

public class Settings extends Fragment implements View.OnClickListener{

    private View rootView;
    private DatePickerPopWin pickerPopWin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.settings_fragment,container,false);
        if (!((IsOnlaine) getActivity()).isOnline(getActivity())) {
            ((IsOnlaine) getActivity()).offlineMessageBox();
        }
        createDatePicker();
        initializeTView();
        return rootView;
    }

    private void initializeTView() {
        ((IToolBar)getActivity()).toolbarSetTitle("Настройки");
        SharedPreferences mSettings;
        mSettings = getActivity().getSharedPreferences(Constants.APP_PREF, Context.MODE_PRIVATE);
        ((TextView) rootView.findViewById(R.id.acc_date)).setText(setTextSettings("✯ Дата:"," "+ mSettings.getInt(Constants.APP_PREF_DAY, 1) + "." + mSettings.getInt(Constants.APP_PREF_MONTH, 1) + "." + mSettings.getInt(Constants.APP_PREF_YEAR, 2000), "✯"));
        rootView.findViewById(R.id.amend_pick_date).setOnClickListener(this);
        rootView.findViewById(R.id.no_advertising).setOnClickListener(this);
        rootView.findViewById(R.id.btn_share).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.amend_pick_date:
                pickerPopWin.showPopWin(getActivity());
                break;
            case R.id.no_advertising:
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=org.keen.mystery")));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=org.keen.mystery")));
                }
                break;
            case R.id.btn_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Бесплатный ежедневный гороскоп от ㋛ Mystery ㋛\n\n" +
                        "https://play.google.com/store/apps/details?id=keen.eye.ink1804.destination");
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, "Send Mystery"));
                break;
            default:break;
        }
    }

    public Spanned setTextSettings(String _text, String _value, String _text2){
        String value = _value;
        value = String.format("<b>%s</b>",value);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(_text+" "+value+" "+_text2, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(_text+" "+value+" "+_text2);
        }
    }

    private void createDatePicker(){
        pickerPopWin = new DatePickerPopWin.Builder(getActivity(), new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int yyyy, int mm, int dd, String dateDesc) {
                ((TextView) rootView.findViewById(R.id.acc_date)).setText(setTextSettings("✯ Дата:"," "+ dd + "." + mm + "." + yyyy, "✯"));
                SharedPreferences mSettings;
                mSettings = getActivity().getSharedPreferences("app_settings", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putBoolean(Constants.APP_PREF_ISREGISTER, true);
                editor.putInt(Constants.APP_PREF_DAY, dd);
                editor.putInt(Constants.APP_PREF_MONTH, mm);
                editor.putInt(Constants.APP_PREF_YEAR, yyyy);
                editor.apply();
            }
        }).minYear(1920) //min year in loop
                .maxYear(2018) // max year in loop
                .dateChose(2000+"-"+1+"-"+1) // date chose when init popwindow
                .build();
        pickerPopWin.confirmBtn.setText("Установить   ");
        pickerPopWin.cancelBtn.setText("Отмена");
        pickerPopWin.confirmBtn.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }
}
