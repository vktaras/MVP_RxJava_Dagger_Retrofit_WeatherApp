package com.taras_vk.weatherapp;

import android.app.Application;

import com.taras_vk.weatherapp.injection.components.AppComponent;
import com.taras_vk.weatherapp.injection.components.DaggerAppComponent;
import com.taras_vk.weatherapp.injection.components.DaggerOpenWeatherMapComponent;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import com.taras_vk.weatherapp.injection.modules.AppModule;
import com.taras_vk.weatherapp.injection.modules.NetworkModule;

/**
 * Created by taras on 10/14/17.
 */
public class WeatherApplication extends Application {

    private OpenWeatherMapComponent openWeatherMapComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(BuildConfig.OPENWEATHERMAP_URL))
                .build();

        openWeatherMapComponent = DaggerOpenWeatherMapComponent
                .builder()
                .appComponent(appComponent)
                .build();
    }

    public OpenWeatherMapComponent getOpenWeatherMapComponent() {
        return openWeatherMapComponent;
    }
}
