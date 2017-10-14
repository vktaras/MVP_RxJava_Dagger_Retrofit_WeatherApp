package com.taras_vk.weatherapp.mvp.details.injection;

import com.taras_vk.weatherapp.mvp.details.CityWeatherDetailsContract;
import com.taras_vk.weatherapp.mvp.details.presenter.CityWeatherDetailsPresenter;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by taras on 10/14/17.
 */
@Module
public class CityWeatherDetailsModule {

    @PerActivity
    @Provides
    CityWeatherDetailsContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherDetailsPresenter(dataManager);
    }
}
