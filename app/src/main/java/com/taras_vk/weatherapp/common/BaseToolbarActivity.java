package com.taras_vk.weatherapp.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.taras_vk.weatherapp.R;

import butterknife.ButterKnife;

/**
 * Created by taras on 10/14/17.
 */
public abstract class BaseToolbarActivity extends AppCompatActivity {

    protected Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResourceId());

        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

    }

    protected abstract int getLayoutResourceId();
}
