package com.taras_vk.weatherapp.mvp.details.view;

import com.taras_vk.weatherapp.mvp.details.CityWeatherDetailsContract;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherDetailsActivity_MembersInjector
    implements MembersInjector<CityWeatherDetailsActivity> {
  private final Provider<CityWeatherDetailsContract.Presenter> presenterProvider;

  public CityWeatherDetailsActivity_MembersInjector(
      Provider<CityWeatherDetailsContract.Presenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<CityWeatherDetailsActivity> create(
      Provider<CityWeatherDetailsContract.Presenter> presenterProvider) {
    return new CityWeatherDetailsActivity_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(CityWeatherDetailsActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      CityWeatherDetailsActivity instance,
      Provider<CityWeatherDetailsContract.Presenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
