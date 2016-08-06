package keen.eye.ink1804.destination;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Date;

import keen.eye.ink1804.destination.Fragments.DatePicker_fragment;
import keen.eye.ink1804.destination.Fragments.StructureHor_fragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
,DatePicker_fragment.pushDateListener{

    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //adding a start fragment
        DatePicker_fragment fragment = new DatePicker_fragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.structure_fr,fragment,"infoFragment");
        transaction.commit();

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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    public void onDatePushed(int day, int month, int year,int currentYear) {
        int dd = day,mm=month,yy=year;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        StructureHor_fragment infoFragment = new StructureHor_fragment();

        Bundle args = new Bundle();
        args.putInt("day",day);
        args.putInt("month",month);
        args.putInt("year",year);
        args.putInt("currentYear",currentYear);
        infoFragment.setArguments(args);

        transaction.replace(R.id.structure_fr,infoFragment,"infoFragment");
        transaction.addToBackStack("infoFragment");
        transaction.setCustomAnimations(R.anim.abc_fade_in, R.anim.abc_fade_out);
        transaction.commit();
//        Toast.makeText(getApplicationContext(), dd+"."+mm+"."+yy, Toast.LENGTH_SHORT).show();
    }
}
