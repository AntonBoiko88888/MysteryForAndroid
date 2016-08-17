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
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import keen.eye.ink1804.destination.Fragments.Account_fragment;
import keen.eye.ink1804.destination.Fragments.DatePicker_fragment;
import keen.eye.ink1804.destination.Fragments.Description_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDetails_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDescription_fragment;
import keen.eye.ink1804.destination.Fragments.Registration_fragment;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
,pushDateListener {

    private DrawerLayout drawer;
    private SharedPreferences mSettings;
    private ActionBarDrawerToggle toggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createActivityViews();
        mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);

        if(!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {
            toggle.setDrawerIndicatorEnabled(false);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            createAlert();
        }
        else{
            DatePicker_fragment datePicker_fragment= new DatePicker_fragment();
//            Account_fragment fragment = new Account_fragment();//в дальнейшем
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container,datePicker_fragment,"datePicker_fragment");
            transaction.commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String FRAGMENT_TAG = "";
        Fragment fragment = null;
        Bundle args = new Bundle();
        switch (item.getItemId()){
            case R.id.tab_account:
                fragment = new Account_fragment();
                FRAGMENT_TAG = "accFragment";
                break;
            case R.id.tab_hor_online:
                fragment = new Account_fragment();//*
                FRAGMENT_TAG = "f3";//*
                break;
            case R.id.tab_zodiaс_sign:
                fragment = new Description_fragment();
                FRAGMENT_TAG = "zodiacFragment";
                args.putString("page1","page1");
                args.putString("page2","page2");
                fragment.setArguments(args);
                break;
            case R.id.tab_birth_sign:
                fragment = new Description_fragment();
                FRAGMENT_TAG = "birthFragment";
                args.putString("page1","page1");
                args.putString("page2","page2");
                fragment.setArguments(args);
                break;
            case R.id.tab_virtual_sign:
                fragment = new Description_fragment();
                FRAGMENT_TAG = "virtualFragment";
                args.putString("page1","page1");
                args.putString("page2","page2");
                fragment.setArguments(args);
                break;
            case R.id.tab_relations:
                fragment = new Description_fragment();
                FRAGMENT_TAG = "relationsFragment";
                args.putString("page1","page1");
                args.putString("page2","page2");
                fragment.setArguments(args);
                break;
            case R.id.tab_interesting:
                fragment = new Account_fragment();//*
                FRAGMENT_TAG = "f1";//*
                break;
            case R.id.tab_settings:
                fragment = new Account_fragment();//*
                FRAGMENT_TAG = "f2";//*
                break;
            default:break;
        }
        transaction.replace(R.id.fragment_container, fragment, FRAGMENT_TAG);
        if (fragmentManager.findFragmentByTag(FRAGMENT_TAG) == null) {
            transaction.addToBackStack(FRAGMENT_TAG);
        }
        transaction.commit();
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

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

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
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onDatePushed(int day, int month, int year, int currentYear, boolean sex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ProfileDescription_fragment profDescFragment = new ProfileDescription_fragment();

        Bundle args = new Bundle();
        args.putInt("day",day);
        args.putInt("month",month);
        args.putInt("year",year);
        args.putInt("currentYear",currentYear);
        args.putBoolean("sex",sex);
        profDescFragment.setArguments(args);

        transaction.replace(R.id.fragment_container,profDescFragment,"profDescFragment");
        transaction.addToBackStack("profDescFragment");
        transaction.commit();
    }
    @Override
    public void onDescriptionClicked(String key) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ProfileDetails_fragment profDetFragment = new ProfileDetails_fragment();

        Bundle args = new Bundle();
        args.putString("key",key);
        profDetFragment.setArguments(args);

        transaction.replace(R.id.fragment_container,profDetFragment,"profDetFragment");
        transaction.addToBackStack("profDetFragment");
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

}
