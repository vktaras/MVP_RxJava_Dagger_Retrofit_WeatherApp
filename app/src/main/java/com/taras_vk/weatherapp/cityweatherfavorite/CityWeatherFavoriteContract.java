package com.taras_vk.weatherapp.cityweatherfavorite;

import com.taras_vk.weatherapp.common.MvpModelListView;
import com.taras_vk.weatherapp.model.CityWeather;

/**
 * Created by taras on 10/14/17.
 */
public interface CityWeatherFavoriteContract {

    interface View extends MvpModelListView<CityWeather> {

    }

    interface Presenter extends com.taras_vk.weatherapp.common.Presenter<View> {

        void onFavoriteSelected(CityWeather cityWeather);

        void getFavoriteData();
    }
}
