package com.taras_vk.weatherapp.mvp.favorite.presenter;

import android.util.Log;

import com.taras_vk.weatherapp.mvp.favorite.CityWeatherFavoriteContract;
import com.taras_vk.weatherapp.common.MvpBasePresenter;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.models.CityWeather;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by taras on 10/14/17.
 */
public class CityWeatherFavoritePresenter extends MvpBasePresenter<CityWeatherFavoriteContract.View>
        implements CityWeatherFavoriteContract.Presenter {

    private final DataManager dataManager;

    @Inject
    public CityWeatherFavoritePresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }

    @Override
    public void getFavoriteData() {

        dataManager
                .getAllFavoriteCityWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cityWeathers -> {
                    if (getView() != null) {

                        getView().showData(cityWeathers);
                    }
                }, throwable -> {

                    Log.e("Error", throwable.toString());
                });
    }

    @Override
    public void onFavoriteSelected(CityWeather cityWeather) {

        // TODO: Implement favorite handling
    }
}
