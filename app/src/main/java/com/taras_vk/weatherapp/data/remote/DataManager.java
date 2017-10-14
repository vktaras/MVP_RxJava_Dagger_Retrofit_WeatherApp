package com.taras_vk.weatherapp.data.remote;

import com.taras_vk.weatherapp.BuildConfig;
import com.taras_vk.weatherapp.data.local.DatabaseHelper;
import com.taras_vk.weatherapp.data.memory.MemoryCache;
import com.taras_vk.weatherapp.injection.scopes.PerApplication;
import com.taras_vk.weatherapp.models.CityWeather;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by taras on 10/14/17.
 */
@PerApplication
public class DataManager {

    private MemoryCache memoryCache;
    private IOpenWeatherMapApi openWeatherMapService;
    private DatabaseHelper databaseHelper;
    private final String apiKey = BuildConfig.OPENWEATHERMAP_API_KEY;

    @Inject
    public DataManager(IOpenWeatherMapApi openWeatherMapService, DatabaseHelper databaseHelper) {

        this.openWeatherMapService = openWeatherMapService;
        this.databaseHelper = databaseHelper;
        memoryCache = new MemoryCache();
    }

    //TODO: Implement caching
    public Observable<CityWeather> getWeatherByCityName(String name) {

        return openWeatherMapService
                .getWeatherByCityName(name, apiKey);
    }

    public Observable<CityWeather> getWeatherByCityId(long id) {

        return openWeatherMapService
                .getWeatherByCityId(id, apiKey);
    }

    public Observable<Void> addCityWeatherToFavorites(CityWeather cityWeather) {

        return databaseHelper
                .addCityWeatherToDb(cityWeather);
    }

    public Observable<Boolean> isCityWeatherFavorite(long id) {
        return databaseHelper
                .findFavoriteCityWeatherById(id)
                .map(cityWeather -> {

                    if (cityWeather != null) {

                        return cityWeather.isFavorite();
                    } else {

                        return false;
                    }
                });
    }

    public Observable<List<CityWeather>> getAllFavoriteCityWeather() {

        return databaseHelper
                .getAllFavoriteCityWeather()
                .flatMap(Observable::from)
                .flatMap(cityWeather -> getWeatherByCityId(cityWeather.getId()))
                .map(cityWeather -> {

                    cityWeather.setFavorite(true);
                    return cityWeather;
                })
                .toList();
    }

    public Observable<Void> removeCityWeatherFromFavorites(CityWeather cityWeather) {

        return databaseHelper
                .deleteFavoriteCityWeatherById(cityWeather.getId());
    }

    //Schedulers Transformer

    public static <T> Observable.Transformer<T, T> applySchedulers() {

        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
