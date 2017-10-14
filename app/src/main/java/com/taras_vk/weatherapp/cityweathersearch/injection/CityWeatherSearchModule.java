package com.taras_vk.weatherapp.cityweathersearch.injection;

import com.taras_vk.weatherapp.cityweathersearch.CityWeatherSearchContract;
import com.taras_vk.weatherapp.cityweathersearch.presenter.CityWeatherSearchPresenter;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by taras on 10/14/17.
 */
@Module
public class CityWeatherSearchModule {

    @PerActivity
    @Provides
    CityWeatherSearchContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherSearchPresenter(dataManager);
    }
}