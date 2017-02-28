package keen.eye.ink1804.destination.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import keen.eye.ink1804.destination.Fragments.ApplicationAbout;
import keen.eye.ink1804.destination.Fragments.Interesting;
import keen.eye.ink1804.destination.Fragments.Settings;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 28.02.17.
 */

public class RestActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
       ,IToolBar, View.OnClickListener  {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        String key;
        key = intent.getStringExtra("key");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        switch (key) {
            case "interesting":
                fragment = new Interesting();
                break;
            case "settings":
                fragment = new Settings();
                break;
            case "about":
                fragment = new ApplicationAbout();
                break;
        }
        transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
        transaction.commit();

        initViews();
    }

    void startSphereActivity(String s) {
        Intent intent = new Intent(this, SphereActivity.class);
        intent.putExtra("key", s);
        startActivity(intent);
        finish();
    }

    private void initViews() {
        toolbarSetTitle("Постижение тайны");
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0).setOnClickListener(this);

    }

    @Override
    public void toolbarSetTitle(String title) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(title);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.com_signMan_text);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment fragment = null;
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        switch (item.getItemId()) {
            case R.id.tab_hor_online://no
                startActivity(new Intent(this, HorOnlineActivity.class));
                finish();
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
                fragment = new Interesting();
                break;
            case R.id.tab_settings:
                fragment = new Settings();
                break;
            case R.id.tab_about:
                fragment = new ApplicationAbout();
                break;
            default:
                break;
        }
        if(fragment!=null) {
            transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
            transaction.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class));
        finish();
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            overridePendingTransition(R.anim.activity_down_up_close_enter, R.anim.activity_down_up_close_exit);
        }
    }
}
