package com.taras_vk.weatherapp.cityweatherfavorite.injection;

import com.taras_vk.weatherapp.cityweatherfavorite.view.CityWeatherFavoriteFragment;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Component;

/**
 * Created by taras on 10/14/17.
 */
@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherFavoriteModule.class)
public interface CityWeatherFavoriteComponent {

    CityWeatherFavoriteFragment inject(CityWeatherFavoriteFragment fragment);
}