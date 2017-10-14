package com.taras_vk.weatherapp.cityweathersearch.injection;

import com.taras_vk.weatherapp.cityweathersearch.view.CityWeatherSearchFragment;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Component;

/**
 * Created by taras on 10/14/17.
 */
@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherSearchModule.class
)
public interface CityWeatherSearchComponent {

    CityWeatherSearchFragment inject(CityWeatherSearchFragment fragment);
}