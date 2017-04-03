package keen.eye.ink1804.destination.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import keen.eye.ink1804.destination.Fragments.Account;
import keen.eye.ink1804.destination.Fragments.DatePicker;
import keen.eye.ink1804.destination.Fragments.Interesting;
import keen.eye.ink1804.destination.Fragments.ProfileDescription;
import keen.eye.ink1804.destination.Interfaces.IDatePushed;
import keen.eye.ink1804.destination.Interfaces.IOnDesClick;
import keen.eye.ink1804.destination.Interfaces.IToolBar;
import keen.eye.ink1804.destination.Interfaces.IsOnlaine;
import keen.eye.ink1804.destination.R;

/**
 * Created by anton on 26.03.17.
 */

public class New_ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
        ,IDatePushed, IsOnlaine, View.OnClickListener  {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, new DatePicker(), "account_fragment");
        transaction.commit();

        initViews();
    }

    private void initViews() {
        toolbarSetTitle("Новый профиль");
        ((NavigationView) findViewById(R.id.nav_view)).setNavigationItemSelectedListener(this);
        ((NavigationView) findViewById(R.id.nav_view)).getHeaderView(0).setOnClickListener(this);

    }

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
        switch (item.getItemId()) {
            case R.id.tab_hor_online://no
                Intent i = new Intent(this, HorOnlineActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("key", s);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    void startSphereActivity(String s) {
        Intent intent = new Intent(this, SphereActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtra("key", s);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this, MainActivity.class).addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK));
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public boolean isOnline(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
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
                        if (!New_ProfileActivity.this.isOnline(New_ProfileActivity.this)) {
                            Toast.makeText(New_ProfileActivity.this, "Нет подключения к сети", Toast.LENGTH_SHORT).show();
                            offlineMessageBox();
                        }
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

