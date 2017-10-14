package com.taras_vk.weatherapp.mvp.details.presenter;

import com.taras_vk.weatherapp.mvp.details.CityWeatherDetailsContract;
import com.taras_vk.weatherapp.common.MvpBasePresenter;
import com.taras_vk.weatherapp.data.remote.DataManager;

import static com.taras_vk.weatherapp.data.remote.DataManager.applySchedulers;

/**
 * Created by taras on 10/14/17.
 */
public class CityWeatherDetailsPresenter extends MvpBasePresenter<CityWeatherDetailsContract.View>
        implements CityWeatherDetailsContract.Presenter {

    private DataManager dataManager;

    public CityWeatherDetailsPresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }

    @Override
    public void loadCityWeatherData(long id) {

        dataManager
                .getWeatherByCityId(id)
                .compose(applySchedulers())
                .subscribe(cityWeather -> {

                    if (getView() != null) {

                        getView().showCityWeatherData(cityWeather);
                    }
                });
    }
}
