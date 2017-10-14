package com.taras_vk.weatherapp.data.remote;

import com.taras_vk.weatherapp.models.CityWeather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by taras on 10/14/17.
 */
public interface IOpenWeatherMapApi {

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityName(@Query("q") String cityName, @Query("appid") String appId);

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityId(@Query("id") long cityId, @Query("appid") String appId);
}
