package keen.eye.ink1804.destination;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
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
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.vending.billing.IInAppBillingService;
import com.soundcloud.android.crop.Crop;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import fr.ganfra.materialspinner.MaterialSpinner;
import keen.eye.ink1804.destination.Fragments.Account;
import keen.eye.ink1804.destination.Fragments.DatePicker;
import keen.eye.ink1804.destination.Fragments.Sphere_container;
import keen.eye.ink1804.destination.Fragments.HoroscopeOnline;
import keen.eye.ink1804.destination.Fragments.Interesting;
import keen.eye.ink1804.destination.Fragments.LoginFragment;
import keen.eye.ink1804.destination.Fragments.ProfileDescription;
import keen.eye.ink1804.destination.Fragments.Details;
import keen.eye.ink1804.destination.Fragments.FirstRegistration;
import keen.eye.ink1804.destination.Fragments.ResetFragment;
import keen.eye.ink1804.destination.Fragments.SignUpFragment;
import keen.eye.ink1804.destination.Fragments.StatusAbout;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.Math.Data_calculation;
import keen.eye.ink1804.destination.Utills.Notification_reciever;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
,pushDateListener, View.OnClickListener {

//    public static String ACCESS = "Начинающий";
    private ImageView iconImage;
    private DrawerLayout drawer;
    private static View header;
    private ActionBarDrawerToggle toggle;
    private String zodiacNotific, timeNotific;
    private boolean isSelectedNotific = false;
    public static int backStackID;
    public static SharedPreferences mSettings;
    //    0 - мы на главном фрагменте
    //    1 - один шаг от главного фрагмента
    //    2 - больше одного шага от главного фрагмента
    private static long back_pressed;


    private IInAppBillingService mService;
    private ServiceConnection connection;
    private String inAppId = "android.test.purchased";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
        createActivityViews();
        isSelectedNotific = mSettings.getBoolean(Constants.APP_PREF_NOTIFICATIONS, false);

        backStackID = 0;
        if (!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {
            toggle.setDrawerIndicatorEnabled(false);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            createAlert_setName();
        } else {
            Account fragment = new Account();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, fragment, "account_fragment");
            transaction.commit();
            Intent intent = getIntent();
            if(intent.getBooleanExtra("isHoroscope",false)) {
                FragmentTransaction horTransaction = getSupportFragmentManager().beginTransaction();
                HoroscopeOnline horFragment = new HoroscopeOnline();//в дальнейшем
                horTransaction.replace(R.id.fragment_container, horFragment, "drawer_fragment");
                horTransaction.commit();
                backStackID = 1;
            }

        }
            setBillingConnection();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        String tag = "default";
        Bundle args = new Bundle();
        switch (item.getItemId()) {
            case R.id.tab_hor_online://no
                fragment = new HoroscopeOnline();
                break;
            case R.id.tab_zodiaс_sign://done
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.ZODIAK_NAMES);
                args.putString("toolbar", "Знаки зодиака");
                args.putInt("type", 0);
                fragment.setArguments(args);
                break;
            case R.id.tab_birth_sign://done
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.YEAR_NAMES);
                args.putString("toolbar", "Знаки рождения");
                args.putInt("type", 1);
                fragment.setArguments(args);
                tag = "birth_sign_vp";
                if (fragmentManager.findFragmentByTag(tag) == null) {
                    transaction.addToBackStack(tag);
                }
                break;
            case R.id.tab_virtual_sign://done
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.VIRTUAL_NAMES);
                args.putString("toolbar", "Виртуальные знаки");
                args.putInt("type", 2);
                fragment.setArguments(args);
                break;
            case R.id.tab_relations://done
                fragment = new Sphere_container();
                args.putString("toolbar", "Взаимоотношения");
                args.putInt("type", 3);
                fragment.setArguments(args);
                break;

            case R.id.tab_interesting://done
                fragment = new Interesting();
                tag = "interesting";
                if (fragmentManager.findFragmentByTag(tag) == null) {
                    transaction.addToBackStack(tag);
                }
                break;
            case R.id.tab_about:
                fragment = new HoroscopeOnline();
                break;
            default:
                break;
        }
        clearBackStack();
        transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
        transaction.commit();
        backStackID = 1;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createActivityViews() {
        toolbarSetTitle("Постижение тайны");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);
        TextView nav_headerStatus = (TextView)header.findViewById(R.id.nav_header_textStatus);
        nav_headerStatus.setText(MainActivity.mSettings.getString(Constants.APP_PREF_STATUS, "Начинающий"));
        header.setOnClickListener(this);
    }
    private void clearBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
    }
    private void createAlert_setName() {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(MainActivity.this, R.style.AlertDialogCustom));
        builder.setTitle("Профиль")
                .setMessage("У вас еще не создан ваш профиль, перейдите к заполнению формы.")
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
    public void mainFragmentCreate() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Account fragment = new Account();
        backStackID = 0;
        transaction.replace(R.id.fragment_container, fragment, "mainFragment");
        transaction.commit();

    }
    public boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
    private void setBillingConnection(){
        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                mService = IInAppBillingService.Stub.asInterface(iBinder);
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                mService = null;
            }
        };
//        bindService(new Intent("com.android.vending.billing.InAppBillingService.BIND"),
//                connection, Context.BIND_AUTO_CREATE);
        Intent purchaseIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
// This is the key line that fixed everything for me
        purchaseIntent.setPackage("com.android.vending");
        bindService(purchaseIntent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            switch (backStackID) {
                case 0:
                    if (back_pressed + 2000 > System.currentTimeMillis()) {
                        super.onBackPressed();
                    } else {
                        Toast.makeText(getBaseContext(), "Нажмите еще раз для выхода", Toast.LENGTH_SHORT).show();
                    }
                    back_pressed = System.currentTimeMillis();
                    break;
                case 1:
                    clearBackStack();
                    mainFragmentCreate();
                    break;
                case 2:
                    if (getSupportFragmentManager().getBackStackEntryCount() <= 1) {
                        clearBackStack();
                        mainFragmentCreate();
                    } else
                        super.onBackPressed();
                    break;
                default: break;
            }
        }
    }
    @Override
    public void onDatePushed(int day, int month, int year, int currentYear, boolean sex, int _backStackID, boolean isMyDescr) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        ProfileDescription profDescFragment = new ProfileDescription();
        String tag = "profDescFragment";

        Bundle args = new Bundle();
        args.putBoolean("isMyDescription", isMyDescr);
        args.putInt("day", day);
        args.putInt("month", month);
        args.putInt("year", year);
        args.putInt("currentYear", currentYear);
        args.putBoolean("sex", sex);
        profDescFragment.setArguments(args);

        transaction.replace(R.id.fragment_container, profDescFragment, tag);
        if (fm.findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = _backStackID;
        transaction.commit();
    }
    @Override
    public void onDescriptionClicked(String key, String layoutTag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        Details profDetFragment = new Details();
        String tag = "profDetailsFragment";

        Bundle args = new Bundle();
        args.putString("key", key);
        args.putString("tag", layoutTag);
        profDetFragment.setArguments(args);

        transaction.replace(R.id.fragment_container, profDetFragment, tag);
        if (fm.findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 2;
        transaction.commit();
    }
    @Override
    public void onRegistration(int day, int month, int year, boolean sex) {
        toggle.setDrawerIndicatorEnabled(true);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Account accFragment = new Account();

        transaction.replace(R.id.fragment_container, accFragment, "accFragment");
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nav_header:
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
                Account fragment = new Account();
                String tag = "accFragment";
                transaction.replace(R.id.fragment_container, fragment, tag);
                clearBackStack();
                backStackID = 0;
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
    @Override
    public void pictureDownload(ImageView imageView) {
        iconImage = imageView;
        Crop.pickImage(this);
        iconImage.buildDrawingCache();
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Crop.REQUEST_PICK && resultCode == RESULT_OK) {
            Uri destination = Uri.fromFile(new File(getCacheDir(), "cropped"));
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(Constants.APP_PREF_IMAGE, destination.toString());
            editor.apply();
            Crop.of(data.getData(), destination).asSquare().start(this);
        } else if (requestCode == Crop.REQUEST_CROP) {
            if (resultCode == RESULT_OK) {
                iconImage.setImageBitmap(null);
                iconImage.setImageURI(Crop.getOutput(data));
            } else if (resultCode == Crop.RESULT_ERROR) {
                Toast.makeText(this, Crop.getError(data).getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == 1001) {
            String purchaseData = data.getStringExtra("INAPP_PURCHASE_DATA");
            if (resultCode == RESULT_OK) {
                try {
                    JSONObject jo = new JSONObject(purchaseData);
                    String sku = jo.getString(inAppId);
                    Toast.makeText(MainActivity.this, "Вы приобрели " + sku + ". Приятного пользования!", Toast.LENGTH_LONG).show();
//                    ACCESS = "Продвинутый";
                    //TODO Изменять статус пользователя после приобретения доступа Продвинутого
                } catch (Exception e) {
                    System.out.println("Failed to parse purchase data.");
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"FLJKSDHLJS",Toast.LENGTH_LONG).show();
                }
            }
        }
    }
    @Override
    public void onNewProfile() {
        String tag = "datePicker_fragment";
        DatePicker fragment = new DatePicker();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 1;
        transaction.replace(R.id.fragment_container, fragment, "datePicker_fragment");
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
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        Data_calculation dc = new Data_calculation();
        int day = mSettings.getInt(Constants.APP_PREF_DAY,1);
        int month = mSettings.getInt(Constants.APP_PREF_MONTH,1);
        String zod = dc.getZodiakName(day, month);
        if(mSettings.contains(Constants.APP_PREF_ZODIAC_NOTIFOCATION))
            zod = mSettings.getString(Constants.APP_PREF_ZODIAC_NOTIFOCATION,"Овен");
        int id = dc.getZodiacId(zod);
        zodSpinner.setSelection(id);
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                timeNotific = i + "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        String time = mSettings.getString(Constants.APP_PREF_TIME_NOTIFOCATION,0+"");
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
                                editor.putString(Constants.APP_PREF_TIME_NOTIFOCATION, timeNotific);
                                editor.putString(Constants.APP_PREF_ZODIAC_NOTIFOCATION, zodiacNotific);
                                editor.apply();
                                Calendar calendar = Calendar.getInstance();

                                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeNotific));//это получить из спинера
                                calendar.set(Calendar.MINUTE, 00);
                                calendar.set(Calendar.SECOND, 00);

                                Intent intent = new Intent(getApplicationContext(), Notification_reciever.class);
//                                intent.putExtra("zodiac", zodiacNotific);
//                                intent.putExtra("time", timeNotific);
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
    public void onRegEnter() {
        String tag = "reg";
        LoginFragment fragment = new LoginFragment();//в дальнейшем
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 1;
        transaction.replace(R.id.fragment_container, fragment, "login_fragment");
        transaction.commit();
    }
    @Override
    public void onStatusAbout() {
        String tag = "status";
        StatusAbout fragment = new StatusAbout();//в дальнейшем
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 1;
        transaction.replace(R.id.fragment_container, fragment, "status_about_fragment");
        transaction.commit();
    }
    @Override
    public void onLoginClick(String email, String password) {
        String tag = "login_fragment";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        LoginFragment fragment = new LoginFragment();
        transaction.replace(R.id.fragment_container, fragment, "loginFragment");
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("password", password);
        fragment.setArguments(args);
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 2;
        transaction.commit();
    }
    @Override
    public void onStartResetPassword() {
        String tag = "reset_password_fragment";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ResetFragment fragment = new ResetFragment();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 2;
        transaction.replace(R.id.fragment_container, fragment, "resetFragment");
        transaction.commit();
    }
    @Override
    public void onStartRegistration() {
        String tag = "start_reg_fragment";
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SignUpFragment fragment = new SignUpFragment();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
        if (getSupportFragmentManager().findFragmentByTag(tag) == null) {
            transaction.addToBackStack(tag);
        }
        backStackID = 2;
        transaction.replace(R.id.fragment_container, fragment, "signUpFragment");
        transaction.commit();
    }
    @Override
    public void onPurchaseClick() {
        ArrayList skuList = new ArrayList();
        skuList.add(inAppId);
        Bundle querySkus = new Bundle();
        querySkus.putStringArrayList("ITEM_ID_LIST", skuList);
        Bundle skuDetails;
        try {
            skuDetails = mService.getSkuDetails(3, getPackageName(),
                    "inapp", querySkus);

            int response = skuDetails.getInt("RESPONSE_CODE");
            if (response == 0) {

                ArrayList<String> responseList = skuDetails
                        .getStringArrayList("DETAILS_LIST");

                for (String thisResponse : responseList) {
                    JSONObject object = new JSONObject(thisResponse);
                    String sku = object.getString("productId");
                    String price = object.getString("price");
                    if (sku.equals(inAppId)) {
                        System.out.println("price " + price);
                        Bundle buyIntentBundle = mService
                                .getBuyIntent(3, getPackageName(), sku,
                                        "inapp",
                                        "bGoa+V7g/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ");
                        PendingIntent pendingIntent = buyIntentBundle
                                .getParcelable("BUY_INTENT");
                        if (pendingIntent != null) {
                            startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), 0, 0, 0);
                        }
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connection != null) {
            unbindService(connection);
        }
    }
}