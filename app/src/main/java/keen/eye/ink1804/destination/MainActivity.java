package keen.eye.ink1804.destination;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import keen.eye.ink1804.destination.Fragments.Account_fragment;
import keen.eye.ink1804.destination.Fragments.DatePicker_fragment;
import keen.eye.ink1804.destination.Fragments.Description_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDetails_fragment;
import keen.eye.ink1804.destination.Fragments.ProfileDescription_fragment;
import keen.eye.ink1804.destination.Interfaces.pushDateListener;
import keen.eye.ink1804.destination.Math.Constants;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
,pushDateListener {

    private DrawerLayout drawer;
    private SharedPreferences mSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSettings = getSharedPreferences("app_settings", Context.MODE_PRIVATE);

        if(!mSettings.contains(Constants.APP_PREF_ISREGISTER)) {
            createAlert();
        }
        else{
            DatePicker_fragment datePicker_fragment= new DatePicker_fragment();
//            Account_fragment fragment = new Account_fragment();//в дальнейшем
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container,datePicker_fragment,"datePicker_fragment");
            transaction.commit();
        }
            createActivityViews();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()){
            case R.id.tab_account:
                Account_fragment accFragment = new Account_fragment();
                transaction.replace(R.id.fragment_container,accFragment,"accFragment");
                transaction.addToBackStack("accFragment");
                transaction.commit();
                break;
            case R.id.tab_hor_online:
                break;
            case R.id.tab_zodiaс_sign:
                Description_fragment zodiacFragment = new Description_fragment();
                Bundle argszodiac = new Bundle();
                argszodiac.putString("page1","page1");
                argszodiac.putString("page2","page2");
                zodiacFragment.setArguments(argszodiac);
                transaction.replace(R.id.fragment_container,zodiacFragment,"zodiacFragment");
                transaction.addToBackStack("zodiacFragment");
                transaction.commit();
                break;
            case R.id.tab_birth_sign:
                Description_fragment birthFragment = new Description_fragment();
                Bundle argsbirth = new Bundle();
                argsbirth.putString("page1","page1");
                argsbirth.putString("page2","page2");
                birthFragment.setArguments(argsbirth);
                transaction.replace(R.id.fragment_container,birthFragment,"birthFragment");
                transaction.addToBackStack("birthFragment");
                transaction.commit();
                break;
            case R.id.tab_virtual_sign:
                Description_fragment virtualFragment = new Description_fragment();
                Bundle argsvirtual = new Bundle();
                argsvirtual.putString("page1","page1");
                argsvirtual.putString("page2","page2");
                virtualFragment.setArguments(argsvirtual);
                transaction.replace(R.id.fragment_container,virtualFragment,"virtualFragment");
                transaction.addToBackStack("virtualFragment");
                transaction.commit();
                break;
            case R.id.tab_relations:
                Description_fragment relatFragment = new Description_fragment();
                Bundle argsrelat = new Bundle();
                argsrelat.putString("page1","page1");
                argsrelat.putString("page2","page2");
                relatFragment.setArguments(argsrelat);
                transaction.replace(R.id.fragment_container,relatFragment,"relatFragment");
                transaction.addToBackStack("relatFragment");
                transaction.commit();
                break;
            case R.id.tab_interesting:

                break;
            case R.id.tab_settings:

            default:break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createActivityViews(){
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Постижение тайны");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.clown_about);

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
                                DatePicker_fragment infoFragment = new DatePicker_fragment();
                                Bundle args = new Bundle();
                                args.putString("action","registration");
                                infoFragment.setArguments(args);
                                transaction.replace(R.id.fragment_container,infoFragment,"infoFragment");
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
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Account_fragment accFragment = new Account_fragment();

        transaction.replace(R.id.fragment_container,accFragment,"accFragment");
        transaction.commit();
    }

}
