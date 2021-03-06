package com.taras_vk.weatherapp.mvp.details.injection;

import com.taras_vk.weatherapp.mvp.details.view.CityWeatherDetailsActivity;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Component;

/**
 * Created by taras on 10/14/17.
 */
@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherDetailsModule.class
)
public interface CityWeatherDetailsComponent {

    CityWeatherDetailsActivity inject(CityWeatherDetailsActivity cityWeatherDetailsActivity);
}
