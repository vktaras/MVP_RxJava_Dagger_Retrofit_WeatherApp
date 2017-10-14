package com.taras_vk.weatherapp.mvp.favorite.injection;

import com.taras_vk.weatherapp.mvp.favorite.CityWeatherFavoriteContract;
import com.taras_vk.weatherapp.mvp.favorite.presenter.CityWeatherFavoritePresenter;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by taras on 10/14/17.
 */
@Module
public class CityWeatherFavoriteModule {

    @PerActivity
    @Provides
    CityWeatherFavoriteContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherFavoritePresenter(dataManager);
    }
}
