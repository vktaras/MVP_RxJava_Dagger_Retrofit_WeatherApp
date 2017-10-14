package com.taras_vk.weatherapp.mvp.details.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.taras_vk.weatherapp.R;
import com.taras_vk.weatherapp.WeatherApplication;
import com.taras_vk.weatherapp.mvp.details.CityWeatherDetailsContract;
import com.taras_vk.weatherapp.mvp.details.injection.DaggerCityWeatherDetailsComponent;
import com.taras_vk.weatherapp.common.BaseToolbarActivity;
import com.taras_vk.weatherapp.models.CityWeather;
import com.taras_vk.weatherapp.utilities.WeatherUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by taras on 10/14/17.
 */
public class CityWeatherDetailsActivity extends BaseToolbarActivity
        implements CityWeatherDetailsContract.View {

    public static String CITY_ID_EXTRA = "city_id_extra";
    public static String CITY_NAME_EXTRA = "city_name_extra";

    @BindView(R.id.city_weather_icon_imageview)
    ImageView cityWeatherIconImageView;

    @Inject
    CityWeatherDetailsContract.Presenter presenter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cityweatherdetails;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        long id = intent.getLongExtra(CITY_ID_EXTRA, Long.MIN_VALUE);
        String cityName = intent.getStringExtra(CITY_NAME_EXTRA);

        if (id == Long.MIN_VALUE || TextUtils.isEmpty(cityName)) {

            throw new IllegalArgumentException("id and cityName must be defined");
        }

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(cityName);
        }

        DaggerCityWeatherDetailsComponent
                .builder()
                .openWeatherMapComponent(((WeatherApplication) getApplication()).getOpenWeatherMapComponent())
                .build()
                .inject(this);

        presenter.attachView(this);
        presenter.loadCityWeatherData(id);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView(false);
        super.onDestroy();
    }

    @Override
    public void showCityWeatherData(CityWeather cityWeather) {

        cityWeatherIconImageView
                .setImageResource(WeatherUtils
                        .getArtResourceForWeatherCondition(cityWeather.getWeather().get(0).getId()));
    }
}
