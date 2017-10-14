package com.taras_vk.weatherapp.cityweathersearch;

import com.taras_vk.weatherapp.common.MvpModelListView;
import com.taras_vk.weatherapp.model.CityWeather;

import rx.Observable;

/**
 * Created by taras on 10/14/17.
 */
public interface CityWeatherSearchContract {

    interface View extends MvpModelListView<CityWeather> {

        void showSetToFavoritesSuccessful(CityWeather cityWeather);

        void showSetToFavoritesFailed(CityWeather cityWeather);

        void showRemovedFromFavoritesSuccessful(CityWeather cityWeather);

        void showRemovedFromFavoritesFailed(CityWeather cityWeather);
    }

    interface Presenter extends com.taras_vk.weatherapp.common.Presenter<View> {

        void onSearchTextChanged(Observable<CharSequence> searchObservable);

        void onFavoriteSelected(CityWeather cityWeather);
    }
}
