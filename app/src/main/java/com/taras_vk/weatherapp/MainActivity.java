package com.taras_vk.weatherapp;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;

import com.taras_vk.weatherapp.R;
import com.taras_vk.weatherapp.mvp.favorite.view.CityWeatherFavoriteFragment;
import com.taras_vk.weatherapp.mvp.search.view.CityWeatherSearchFragment;
import com.taras_vk.weatherapp.common.BaseToolbarActivity;

import butterknife.BindView;

/**
 * Created by taras on 10/14/17.
 */
public class MainActivity extends BaseToolbarActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final String BOTTOM_BAR_TAG = "bottom_bar_tag";

    @BindView(R.id.rootCoordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_citiyweathermain;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // Set default selected item
        selectFragmentForMenuItemId(R.id.action_search);
    }

    @Override
    protected void onDestroy() {
        bottomNavigationView.setOnNavigationItemSelectedListener(null);
        super.onDestroy();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        selectFragmentForMenuItemId(item.getItemId());
        return true;
    }

    public void selectFragmentForMenuItemId(@IdRes int itemId) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;

        switch (itemId) {

            case R.id.action_search:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
            case R.id.action_favorites:
                fragment = CityWeatherFavoriteFragment.newInstance();
                break;
            default:
                fragment = CityWeatherSearchFragment.newInstance();
                break;
        }

        fragmentManager.beginTransaction().replace(R.id.bottom_bar_fragment_container,
                fragment, BOTTOM_BAR_TAG).commit();
    }
}