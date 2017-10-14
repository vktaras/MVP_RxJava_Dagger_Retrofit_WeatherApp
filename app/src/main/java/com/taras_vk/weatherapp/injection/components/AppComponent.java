package com.taras_vk.weatherapp.injection.components;

import android.app.Application;
import android.content.Context;

import com.taras_vk.weatherapp.WeatherApplication;
import com.taras_vk.weatherapp.data.local.DatabaseHelper;
import com.taras_vk.weatherapp.injection.modules.AppModule;
import com.taras_vk.weatherapp.injection.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by taras on 10/14/17.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {

    void inject(WeatherApplication weatherApplication);

    Application getApplication();

    Context getApplicationContext();

    Retrofit getRetrofit();

    DatabaseHelper getDatabaseHelper();
}
