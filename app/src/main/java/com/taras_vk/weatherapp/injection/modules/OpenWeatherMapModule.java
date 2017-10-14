package com.taras_vk.weatherapp.injection.modules;

import com.taras_vk.weatherapp.data.remote.IOpenWeatherMapApi;
import com.taras_vk.weatherapp.injection.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by taras on 10/14/17.
 */

@Module
public class OpenWeatherMapModule {

    @Provides
    @PerApplication
    IOpenWeatherMapApi providesOpenWeatherMapApi(Retrofit retrofit) {

        return retrofit.create(IOpenWeatherMapApi.class);
    }
}