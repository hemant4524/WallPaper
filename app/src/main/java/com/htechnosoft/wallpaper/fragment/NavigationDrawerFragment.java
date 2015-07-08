package com.htechnosoft.wallpaper.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htechnosoft.wallpaper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends Fragment {

    public static final String PEFERED_FILE_NAME = "hpref";
    public static final String KEY_USER_LEARNED_DRAWER = "user_learned_drawer";
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private boolean mUserDrawerLearn;
    private boolean mFromSaveInstanceState;
    private DrawerLayout mDrawerLayout;
    private View mContainerView;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mUserDrawerLearn = Boolean.getBoolean(readToSharedPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,"false"));
        if(savedInstanceState!=null)
        {
            mFromSaveInstanceState = true;
            saveToSharedPreferences(getActivity(),KEY_USER_LEARNED_DRAWER,""+mFromSaveInstanceState);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.navigation_drawer_fragment, container, false);
    }

    public void setUp(int fragmentId,DrawerLayout drawerLayout, final Toolbar toolbar) {
        mContainerView = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        mActionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("HVTech", "onDrawerOpened");

                getActivity().supportInvalidateOptionsMenu();
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d("HVTech", "onDrawerClosed");
                getActivity().invalidateOptionsMenu();
            }


            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                Log.d("HVTech", "offset:" + slideOffset);
                if(slideOffset<0.2)
                {
                    toolbar.setAlpha(1-slideOffset);
                }

            }
        };
        if(!mUserDrawerLearn && !mFromSaveInstanceState)
        {
            mDrawerLayout.openDrawer(mContainerView);
        }
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mActionBarDrawerToggle.syncState();
            }
        });
    }

    public static void saveToSharedPreferences(Context pContext, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = pContext.getSharedPreferences(PEFERED_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(preferenceName, preferenceValue);
        edit.apply();
    }

    public static String readToSharedPreferences(Context pContext, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = pContext.getSharedPreferences(PEFERED_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultValue);
    }
}
