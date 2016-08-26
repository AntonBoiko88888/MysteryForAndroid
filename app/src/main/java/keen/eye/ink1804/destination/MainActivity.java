package keen.eye.ink1804.destination;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

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

    private DrawerLayout drawer;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    public static int backStackID = 0;
//    0 - мы на главном фрагменте
//    1 - backstack.count! = 0
//    2 - backstack.count = 0 но мы не на главном фрагменте
    private static long back_pressed;//не удаляй

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createActivityViews();
        SharedPreferences mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);


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
        Bundle args = new Bundle();
        switch (item.getItemId()){
//            case R.id.tab_account:
//                fragment = new Account_fragment();
//                break;
            case R.id.tab_hor_online://half_done
                fragment = new HoroscopeOnline_fragment();
                args.putStringArray("array",Constants.ZODIAK_NAMES);
                fragment.setArguments(args);

                break;
            case R.id.tab_zodiaс_sign://half_done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.ZODIAK_NAMES);
                fragment.setArguments(args);
                break;
            case R.id.tab_birth_sign://half_done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.YEAR_NAMES);
                fragment.setArguments(args);
                break;
            case R.id.tab_virtual_sign://half_done
                fragment = new Description_fragment();
                args.putStringArray("array",Constants.VIRTUAL_NAMES);
                fragment.setArguments(args);
                break;
            case R.id.tab_relations://*
                fragment = new Description_fragment();
                args.putStringArray("array",new String[]{"Взаимоотношения не готовы еще"});
                fragment.setArguments(args);
                break;
            case R.id.tab_interesting://*
                fragment = new Interesting_fragment();//*
                break;
            case R.id.tab_settings://*
                fragment = new Settings_fragment();//*
                break;
            default:break;
        }
        transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
        transaction.commit();
        backStackID = 2;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void createActivityViews(){
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Постижение тайны");

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.clown_about);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        header.setOnClickListener(this);
    }
    private void drawerTabInit(){
//        new NaDrawer()
//                .withActivity(this)
//                .withToolbar(toolbar)
//                .withActionBarDrawerToggle(true)
//                .withHeader(R.layout.drawer_header)
//                .addDrawerItems(
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_home).withBadge("99").withIdentifier(1),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_gamepad),
//                        new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_eye).withBadge("6").withIdentifier(2),
//                        new SectionDrawerItem().withName(R.string.drawer_item_settings),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_cog),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
//                        new DividerDrawerItem(),
//                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_github).withBadge("12+").withIdentifier(1)
//                )
//                .build();
    }
    private void createAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Аккаунт")
                .setMessage("У вас еще не создан аккаунт, перейдите к заполнению формы.")
                .setCancelable(false)
                .setIcon(R.drawable.icon2)
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
        transaction.replace(R.id.fragment_container,accFragment,"mainFragment");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
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
                    if(getSupportFragmentManager().getBackStackEntryCount()==0) {
                        mainFragmentCreate();
                    } else
                        super.onBackPressed();
                    break;
                case 2:
                    mainFragmentCreate();
                    break;
            }
        }

    }
    @Override
    public void onDatePushed(int day, int month, int year, int currentYear, boolean sex) {
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
            backStackID = 1;
        }
        transaction.commit();
    }
    @Override
    public void onDescriptionClicked(String key, String layoutTag ) {
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
            backStackID = 1;
        }
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
                if (fm.findFragmentByTag(tag) == null) {
                    backStackID = 1;
                }
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
