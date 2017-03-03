package keen.eye.ink1804.destination.Activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.Toast;


import java.util.Calendar;
import java.util.Hashtable;

import com.tapjoy.TJConnectListener;
import com.tapjoy.Tapjoy;
import com.tapjoy.TapjoyConnectFlag;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Fragments.Account;
import keen.eye.ink1804.destination.Fragments.ApplicationAbout;
import keen.eye.ink1804.destination.Fragments.DatePicker;
import keen.eye.ink1804.destination.Fragments.Settings;
import keen.eye.ink1804.destination.Fragments.Sphere_container;
import keen.eye.ink1804.destination.Fragments.HoroscopeOnline;
import keen.eye.ink1804.destination.Fragments.Interesting;
import keen.eye.ink1804.destination.Fragments.ProfileDescription;
import keen.eye.ink1804.destination.Fragments.Details;
import keen.eye.ink1804.destination.Fragments.FirstRegistration;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.R;
import keen.eye.ink1804.destination.Utills.Notification_reciever;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        , pushDateListener, View.OnClickListener{

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private String zodiacNotific, timeNotific;
    private boolean isSelectedNotific = false;
    static boolean backID = false;
    //    0 - мы на главном фрагменте
    //    1 - один шаг от главного фрагмента
    //    2 - больше одного шага от главного фрагмента
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences mSettings;
        mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        initViews();
        isSelectedNotific = mSettings.getBoolean(Constants.APP_PREF_NOTIFICATIONS, false);

        if (!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {
            toggle.setDrawerIndicatorEnabled(false);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            createAlert_setName();
        } else {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, new Account(), "account_fragment");
            transaction.commit();
            Intent intent = getIntent();
            if (intent.getBooleanExtra("isHoroscope", false)) {
                FragmentTransaction horTransaction = getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                HoroscopeOnline horFragment = new HoroscopeOnline();//в дальнейшем
                args.putBoolean("fromNotification", true);
                horFragment.setArguments(args);
                horTransaction.replace(R.id.fragment_container, horFragment, "drawer_fragment");
                horTransaction.commit();
            }
        }
//        Tapjoy.setDebugEnabled(true);
//        Hashtable<String, Object> connectFlags = new Hashtable<String, Object>();
//        connectFlags.put(TapjoyConnectFlag.ENABLE_LOGGING, "true");      // remember to turn this off for your production builds!
//
//        Tapjoy.connect(getApplicationContext(), "I64pSOwpR-6kb9ygUGlggQEClSFZWsScnpX6Tj6rvef36ANK9YHvBVdcJ1BG"
//                , connectFlags, new TJConnectListener() {
//            @Override
//            public void onConnectSuccess() {
//                this.onConnectSuccess();
//            }
//
//            @Override
//            public void onConnectFailure() {
//                this.onConnectFailure();
//            }
//        });
//         placementListener = (TJPlacementListener) this;
//        p = Tapjoy.getPlacement("APP_LAUNCH", placementListener);
//
//        if(Tapjoy.isConnected())
//            p.requestContent();
//
//        if(p.isContentReady()) {
//            p.showContent();
//        }
//

    }
//    TJPlacementListener placementListener;
//    TJPlacement p;

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tab_hor_online://no
                startActivity(new Intent(MainActivity.this, HorOnlineActivity.class).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK));
                break;
            case R.id.tab_zodiaс_sign://done
                startSphereActivity("zodiac");
                break;
            case R.id.tab_birth_sign://done
                startSphereActivity("birth");
                break;
            case R.id.tab_virtual_sign://done
                startSphereActivity("virtual");
                break;
            case R.id.tab_relations://done
                startSphereActivity("socionic");
                break;
            case R.id.tab_interesting://done
                Intent intent = new Intent(this, DescriptionActivity.class).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("key", "interesting");
                startActivity(intent);
                break;
            case R.id.tab_settings:
                startRestActivity("settings");
                break;
            case R.id.tab_about:
                startRestActivity("about");
                break;
            default:
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    void startRestActivity(String s) {
        Intent intent = new Intent(this, RestActivity.class);
        intent.putExtra("key", s);
        startActivity(intent);
    }

    void startSphereActivity(String s) {
        Intent intent = new Intent(this, SphereActivity.class);
        intent.putExtra("key", s);
        startActivity(intent);
    }
//        if(p.isContentReady()) {
//            p.showContent();
//        }

    private void initViews() {
        toolbarSetTitle("Постижение тайны");
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0).setOnClickListener(this);
    }
    private void createAlert_setName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
        builder.setTitle("Профиль")
                .setView(R.layout.alert_create_acc)
                .setCancelable(false)
                .setIcon(R.drawable.icon_eye_512)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                FirstRegistration fragment = new FirstRegistration();
                                Bundle args = new Bundle();
                                fragment.setArguments(args);
                                transaction.replace(R.id.fragment_container, fragment, "registrationFragment");
                                transaction.commit();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean isOnline(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        if(backID)
        {
            backID = false;
            super.onBackPressed();
        }
        else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), "Нажмите еще раз для выхода", Toast.LENGTH_SHORT).show();
            }
            back_pressed = System.currentTimeMillis();
        }
    }

    @Override
    public void onDatePushed(String s, int day, int month, int year, int currentYear, boolean sex, boolean isMyDescr) {
        Intent intent = new Intent(this, DescriptionActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("key", s);
        intent.putExtra("isMyDescription", isMyDescr);
        intent.putExtra("day", day);
        intent.putExtra("month", month);
        intent.putExtra("year", year);
        intent.putExtra("currentYear", currentYear);
        intent.putExtra("sex", sex);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_enter,
                R.anim.animation_leave);
    }

    @Override
    public void AdShow() {
    }

    @Override
    public void onRegistration(int day, int month, int year, boolean sex) {
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new Account(), "accFragment");
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_header:
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
    @Override
    public void toolbarSetTitle(String title) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.com_signMan_text);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public void onNewProfile() {
        String tag = "datePicker_fragment";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backID = true;
        transaction.replace(R.id.fragment_container, new DatePicker(), "datePicker_fragment");
        transaction.commit();
    }
    @Override
    public void setNotification(Context context) {
        String[] times = new String[]{"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00"
                , "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
        View v = View.inflate(context, R.layout.alert_setnotification, null);
        final MaterialSpinner zodSpinner = (MaterialSpinner) v.findViewById(R.id.alert_zodiac);
        final MaterialSpinner timeSpinner = (MaterialSpinner) v.findViewById(R.id.alert_time);
        final Switch sw = (Switch) v.findViewById(R.id.alert_switch);
        sw.setChecked(isSelectedNotific);

        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, times);
        final ArrayAdapter<String> zodAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item,
                Constants.ZODIAK_NAMES_normal);

        zodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        zodSpinner.setAdapter(zodAdapter);
        timeSpinner.setAdapter(timeAdapter);

        zodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                zodiacNotific = Constants.ZODIAK_NAMES_normal[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        final SharedPreferences mSettings;
        mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        Data_calculation dc = new Data_calculation();
        int day = mSettings.getInt(Constants.APP_PREF_DAY, 1);
        int month = mSettings.getInt(Constants.APP_PREF_MONTH, 1);
        String zod = dc.getZodiakName(day, month);
        if (mSettings.contains(Constants.APP_PREF_ZODIAC_NOTIFICATION))
            zod = mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFICATION, "Овен");
        int id = dc.getZodiacId(zod);
        zodSpinner.setSelection(id);
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeNotific = i + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        String time = mSettings.getString(Constants.APP_PREF_TIME_NOTIFICATION, 0 + "");
        timeSpinner.setSelection(Integer.parseInt(time));

        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
        builder.setTitle("Уведомления")
                .setCancelable(true)
                .setView(v)
                .setIcon(R.drawable.icon_eye_512)
                .setPositiveButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                isSelectedNotific = sw.isChecked();
                                SharedPreferences.Editor editor = mSettings.edit();
                                editor.putBoolean(Constants.APP_PREF_NOTIFICATIONS, isSelectedNotific);
                                editor.putString(Constants.APP_PREF_TIME_NOTIFICATION, timeNotific);
                                editor.putString(Constants.APP_PREF_ZODIAC_NOTIFICATION, zodiacNotific);
                                editor.apply();
                                Calendar calendar = Calendar.getInstance();

                                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeNotific));//это получить из спинера
                                calendar.set(Calendar.MINUTE, 00);
                                calendar.set(Calendar.SECOND, 00);

                                Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
                                intent.putExtra("notify", isSelectedNotific);

                                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), alarmManager.INTERVAL_DAY, pendingIntent);
                                if (isSelectedNotific)
                                    Toast.makeText(getApplicationContext(), "Напоминание установлено на " + timeNotific + ":00", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Напоминание не установлено", Toast.LENGTH_SHORT).show();
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

    @Override
    public void offlineMessageBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
        builder.setTitle("Ошибка сети")
                .setMessage("Проверьте подключение к интернету и повторите попытку снова")
                .setCancelable(false)
                .setIcon(R.drawable.icon_eye_512)
                .setNegativeButton("Закрыть приложение",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                finish();
                            }
                        })
                .setPositiveButton("Повторить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (!MainActivity.this.isOnline(MainActivity.this)) {
                            Toast.makeText(MainActivity.this, "Нет подключения к сети", Toast.LENGTH_SHORT).show();
                            offlineMessageBox();
                        }
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    @Override
    protected void onStart() {
        super.onStart();
//        Tapjoy.onActivityStart(this);
    }
    @Override
    protected void onStop() {
//        Tapjoy.onActivityStop(this);
        super.onStop();
    }

}