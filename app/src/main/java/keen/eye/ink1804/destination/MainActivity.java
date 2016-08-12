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
import keen.eye.ink1804.destination.Fragments.StructureHor_fragment;
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
            DatePicker_fragment fragment = new DatePicker_fragment();
//            Account_fragment fragment = new Account_fragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.structure_fr,fragment,"infoFragment");
            transaction.commit();
        }
            createActivityViews();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tab_account:
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                Account_fragment accFragment = new Account_fragment();

                transaction.replace(R.id.structure_fr,accFragment,"accFragment");
                transaction.addToBackStack("accFragment");
                transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
                transaction.commit();
            default:break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void createActivityViews(){
        //adding a start fragment


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setTitle("Destination");

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
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                                DatePicker_fragment infoFragment = new DatePicker_fragment();
                                Bundle args = new Bundle();
                                args.putString("action","registration");
                                infoFragment.setArguments(args);
                                transaction.replace(R.id.structure_fr,infoFragment,"infoFragment");
                                transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
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
        StructureHor_fragment infoFragment = new StructureHor_fragment();

        Bundle args = new Bundle();
        args.putInt("day",day);
        args.putInt("month",month);
        args.putInt("year",year);
        args.putInt("currentYear",currentYear);
        args.putBoolean("sex",sex);
        infoFragment.setArguments(args);

        transaction.replace(R.id.structure_fr,infoFragment,"infoFragment");
        transaction.addToBackStack("infoFragment");
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.commit();
    }
    @Override
    public void onDescriptionClicked(String key) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Description_fragment descrFragment = new Description_fragment();

        Bundle args = new Bundle();
        args.putString("key",key);
        descrFragment.setArguments(args);

        transaction.replace(R.id.structure_fr,descrFragment,"descFragment");
        transaction.addToBackStack("descFragment");
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.commit();
    }
    @Override
    public void onRegistrating(int day, int month, int year, boolean sex) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Account_fragment accFragment = new Account_fragment();

        transaction.replace(R.id.structure_fr,accFragment,"accFragment");
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.commit();
    }

}
