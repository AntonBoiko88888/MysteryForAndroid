package keen.eye.ink1804.destination;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.ByteArrayOutputStream;
import java.io.File;

import keen.eye.ink1804.destination.Fragments.Account_fragment;
import keen.eye.ink1804.destination.Fragments.DatePicker_fragment;
import keen.eye.ink1804.destination.Fragments.Description_fragment;
import keen.eye.ink1804.destination.Fragments.HoroscopeOnline_fragment;
import keen.eye.ink1804.destination.Fragments.Interesting_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDetails_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDescription_fragment;
import keen.eye.ink1804.destination.Fragments.Registration_fragment;
import keen.eye.ink1804.destination.Fragments.Settings_fragment;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
,pushDateListener, View.OnClickListener {

    private Toolbar toolbar;
    private ImageView iconImage;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    public static int backStackID;
//    0 - мы на главном фрагменте
//    1 - один шаг от главного фрагмента
//    2 - больше одного шага от главного фрагмента
    private static long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createActivityViews();
        SharedPreferences mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);

        backStackID = 0;
        if(!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {
            toggle.setDrawerIndicatorEnabled(false);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            createAlert();
        }
        else{
            DatePicker_fragment fragment = new DatePicker_fragment();
//            Account_fragment fragment = new Account_fragment();//в дальнейшем
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container,fragment,"datePicker_fragment");
            transaction.commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        String tag = "default";
        Bundle args = new Bundle();
        switch (item.getItemId()){
            case R.id.tab_hor_online://no
                fragment = new HoroscopeOnline_fragment();
                break;
            case R.id.tab_zodiaс_sign://done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.ZODIAK_NAMES);
                args.putString("toolbar","Знаки зодиака");
                args.putInt("type",0);
                fragment.setArguments(args);
                break;
            case R.id.tab_birth_sign://done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.YEAR_NAMES);
                args.putString("toolbar","Знаки рождения");
                args.putInt("type",1);
                fragment.setArguments(args);
                tag = "birth_sign_vp";
                if (fragmentManager.findFragmentByTag(tag) == null) {
                    transaction.addToBackStack(tag);
                }
                break;
            case R.id.tab_virtual_sign://done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.VIRTUAL_NAMES);
                args.putString("toolbar","Виртуальные знаки");
                args.putInt("type",2);
                fragment.setArguments(args);
                break;
            case R.id.tab_relations://done
                fragment = new Description_fragment();
                args.putString("toolbar","Взаимоотношения");
                args.putInt("type",3);
                fragment.setArguments(args);
                break;
            case R.id.tab_interesting://done
                fragment = new Interesting_fragment();
                tag = "interesting";
                if (fragmentManager.findFragmentByTag(tag) == null) {
                    transaction.addToBackStack(tag);
                }
                break;
            case R.id.tab_settings://have to delete
                fragment = new Settings_fragment();
                break;
            default:break;
        }
        clearBackStack();
        transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
        transaction.commit();
        backStackID = 1;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void createActivityViews(){
        toolbarSetTitle("Постижение тайны");

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        header.setOnClickListener(this);
    }
    private void clearBackStack(){
        FragmentManager fm = getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); i++) {
            fm.popBackStack();
        }
    }
    private void createAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Аккаунт")
                .setMessage("У вас еще не создан аккаунт, перейдите к заполнению формы.")
                .setCancelable(false)
                .setIcon(R.drawable.icon_eye)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                Registration_fragment fragment = new Registration_fragment();
                                Bundle args = new Bundle();
                                fragment.setArguments(args);
                                transaction.replace(R.id.fragment_container,fragment,"registrationFragment");
                                transaction.commit();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void mainFragmentCreate() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        DatePicker_fragment accFragment = new DatePicker_fragment();
        backStackID = 0;
        transaction.replace(R.id.fragment_container,accFragment,"mainFragment");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            switch (backStackID){
                case 0:
                    if (back_pressed + 2000 > System.currentTimeMillis()) {
                        super.onBackPressed();
                    } else {
                        Toast.makeText(getBaseContext(), "Нажмите еще раз для выхода", Toast.LENGTH_SHORT).show();
                    }
                    back_pressed = System.currentTimeMillis();// не удаляй
                    break;
                case 1:
                    clearBackStack();
                    mainFragmentCreate();
                    break;
                case 2:
                    if(getSupportFragmentManager().getBackStackEntryCount()<=1) {
                        clearBackStack();
                        mainFragmentCreate();
                    }
                    else
                    super.onBackPressed();
                    break;
            }
        }
    }
    @Override
    public void onDatePushed(int day, int month, int year, int currentYear, boolean sex, int _backStackID) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        ProfileDescription_fragment profDescFragment = new ProfileDescription_fragment();
        String tag = "profDescFragment";

        Bundle args = new Bundle();
        args.putInt("day",day);
        args.putInt("month",month);
        args.putInt("year",year);
        args.putInt("currentYear",currentYear);
        args.putBoolean("sex",sex);
        profDescFragment.setArguments(args);

        transaction.replace(R.id.fragment_container,profDescFragment,tag);
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
        ProfileDetails_fragment profDetFragment = new ProfileDetails_fragment();
        String tag = "profDetFragment";

        Bundle args = new Bundle();
        args.putString("key",key);
        args.putString("tag",layoutTag);
        profDetFragment.setArguments(args);

        transaction.replace(R.id.fragment_container,profDetFragment,tag);
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
        Account_fragment accFragment = new Account_fragment();

        transaction.replace(R.id.fragment_container,accFragment,"accFragment");
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.nav_header:
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Account_fragment fragment = new Account_fragment();
                String tag = "accFragment";
                transaction.replace(R.id.fragment_container, fragment, tag);
                clearBackStack();
                if (fm.findFragmentByTag(tag) == null) {
                    transaction.addToBackStack(tag);
                }
                backStackID = 1;
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

//        SharedPreferences  mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = mSettings.edit();
//        editor.putString(Constants.APP_PREF_IMAGE, temp);
//        editor.apply();
    }

    @Override
    public void toolbarSetTitle(String title) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
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

            SharedPreferences mSettings = getSharedPreferences(Constants.APP_PREF,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString(Constants.APP_PREF_IMAGE,destination.toString());
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
    }
}
