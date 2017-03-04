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

import keen.eye.ink1804.destination.Fragments.Sphere_container;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Math.Constants;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 28.02.17.
 */

public class SphereActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        , IToolBar, View.OnClickListener  {

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
        Bundle args = new Bundle();
        switch (key) {
            case "birth":
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.YEAR_NAMES);
                args.putString("toolbar", "Знаки рождения");
                args.putInt("type", 1);
                fragment.setArguments(args);
                break;
            case "virtual":
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.VIRTUAL_NAMES);
                args.putString("toolbar", "Виртуальные знаки");
                args.putInt("type", 2);
                fragment.setArguments(args);
                break;
            case "zodiac":
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.ZODIAK_NAMES);
                args.putString("toolbar", "Знаки зодиака");
                args.putInt("type", 0);
                fragment.setArguments(args);
                break;
            case "socionic":
                fragment = new Sphere_container();
                args.putString("toolbar", "Взаимоотношения");
                args.putInt("type", 3);
                fragment.setArguments(args);
                break;
        }
        if(fragment!=null) {
            transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
            transaction.commit();
        }

        initViews();
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
        Bundle args = new Bundle();
        switch (item.getItemId()) {
            case R.id.tab_hor_online://no
                startActivity(new Intent(this, HorOnlineActivity.class).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.tab_zodiaс_sign://done
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.ZODIAK_NAMES);
                args.putString("toolbar", "Знаки зодиака");
                args.putInt("type", 0);
                fragment.setArguments(args);
                break;
            case R.id.tab_birth_sign:
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.YEAR_NAMES);
                args.putString("toolbar", "Знаки рождения");
                args.putInt("type", 1);
                fragment.setArguments(args);
                break;
            case R.id.tab_virtual_sign:
                fragment = new Sphere_container();
                args.putStringArray("array", Constants.VIRTUAL_NAMES);
                args.putString("toolbar", "Виртуальные знаки");
                args.putInt("type", 2);
                fragment.setArguments(args);
                break;
            case R.id.tab_relations:
                fragment = new Sphere_container();
                args.putString("toolbar", "Взаимоотношения");
                args.putInt("type", 3);
                fragment.setArguments(args);
                break;
            case R.id.tab_interesting:
                Intent intent = new Intent(this, DescriptionActivity.class).addFlags(
                        Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                        Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("key", "interesting");
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
        if(fragment!=null) {
            transaction.replace(R.id.fragment_container, fragment, "drawer_fragment");
            transaction.commit();
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    void startRestActivity(String s) {
        Intent intent = new Intent(this, RestActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("key", s);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onClick(View view) {
        drawer.closeDrawer(GravityCompat.START);
        startActivity(new Intent(this, MainActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(this, MainActivity.class).addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK));
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
