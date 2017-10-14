package com.taras_vk.weatherapp.injection.components;

import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.modules.OpenWeatherMapModule;
import com.taras_vk.weatherapp.injection.scopes.PerApplication;

import dagger.Component;

/**
 * Created by taras on 10/14/17.
 */
@PerApplication
@Component(
        modules = OpenWeatherMapModule.class,
        dependencies = AppComponent.class
)
public interface OpenWeatherMapComponent {

    DataManager getDataManager();
}
