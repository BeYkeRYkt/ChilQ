package com.example.zz.chilq;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.zz.chilq.employment.create_emp;
import com.example.zz.chilq.employment.my_emp;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("");





        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout , R.string.openDrwm,R.string.closeDrwm);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        nvDrawer=(NavigationView)findViewById(R.id.nav_view);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setNavigationIcon((getResources().getDrawable(R.drawable.ic_menu)));
        setSupportActionBar(toolbar);


        setupDrawerContent(nvDrawer);
    }

    private void selectItemDrawer(MenuItem item){


        Class fragmentClass = null;

        switch (item.getItemId()) {
            case R.id.nav_my_emp:
                fragmentClass=my_emp.class;
                break;
            case R.id.nav_create_emp:
                fragmentClass=create_emp.class;
                break;
            case R.id.nav_list_child:
                fragmentClass=list_child.class;
                break;
            case R.id.nav_signout:
                Intent intent=new Intent(MainActivity.this ,Auth.class);
                startActivity(intent);
                break;
        }

        if(fragmentClass!=null) {
            try {
                Fragment myFragment = null;
                myFragment = (Fragment) fragmentClass.newInstance();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, myFragment).commit();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        mDrawerLayout.closeDrawers();
    }

    private void setupDrawerContent(NavigationView navigateionView){
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
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

