package com.example.zz.chilq.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zz.chilq.R;
import com.example.zz.chilq.fragments.CreateNewTaskFragment;
import com.example.zz.chilq.fragments.MyChildrensFragment;
import com.example.zz.chilq.fragments.MyTasksFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle mToggle;

    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("");

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.openDrwm, R.string.closeDrwm);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        nvDrawer = (NavigationView) findViewById(R.id.nav_view);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon((getResources().getDrawable(R.drawable.ic_menu)));
        setSupportActionBar(toolbar);

        setupDrawerContent(nvDrawer);
    }

    private void selectItemDrawer(MenuItem item) {
        Class fragmentClass = null;

        switch (item.getItemId()) {
            case R.id.nav_my_tasks:
                fragmentClass = MyTasksFragment.class;
                break;
            case R.id.nav_create_new_task:
                fragmentClass = CreateNewTaskFragment.class;
                break;
            case R.id.nav_my_childrens:
                fragmentClass = MyChildrensFragment.class;
                break;
            case R.id.nav_signout:
                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                startActivity(intent);
                break;
        }

        if (fragmentClass != null) {
            try {
                Fragment myFragment = null;
                myFragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, myFragment).commit();

                if(prevMenuItem != null){
                    prevMenuItem.setChecked(false);
                }
                prevMenuItem = item;
                prevMenuItem.setChecked(true);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        mDrawerLayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigateionView) {
        navigateionView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

