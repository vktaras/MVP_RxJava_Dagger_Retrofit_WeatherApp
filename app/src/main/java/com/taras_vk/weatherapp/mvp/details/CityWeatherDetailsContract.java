package com.taras_vk.weatherapp.mvp.details;

import com.taras_vk.weatherapp.common.MvpView;
import com.taras_vk.weatherapp.models.CityWeather;

/**
 * Created by taras on 10/14/17.
 */
public interface CityWeatherDetailsContract {

    interface View extends MvpView {

        void showCityWeatherData(CityWeather cityWeather);
    }

    interface Presenter extends com.taras_vk.weatherapp.common.Presenter<View> {

        void loadCityWeatherData(long id);
    }
}