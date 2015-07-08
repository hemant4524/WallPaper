package com.htechnosoft.wallpaper.activity;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.htechnosoft.wallpaper.R;
import com.htechnosoft.wallpaper.fragment.NavigationDrawerFragment;

public class HomeScreen extends AppCompatActivity {
    private Toolbar mToolBar;
    private NavigationDrawerFragment mDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_appbar_styletwo_activity);
        mToolBar = (Toolbar) findViewById(R.id.homescreen_toolbar);
       if(mToolBar!=null)
       {
          setSupportActionBar(mToolBar);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       }
        mDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        mDrawerFragment.setUp(R.id.fragment_navigation_drawer,(DrawerLayout) findViewById(R.id.homescreen_navDrawer),mToolBar);
    }

}
