package com.taras_vk.weatherapp.mvp.search.view;

import com.taras_vk.weatherapp.mvp.search.CityWeatherSearchContract;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherSearchFragment_MembersInjector
    implements MembersInjector<CityWeatherSearchFragment> {
  private final Provider<CityWeatherSearchContract.Presenter> presenterProvider;

  public CityWeatherSearchFragment_MembersInjector(
      Provider<CityWeatherSearchContract.Presenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<CityWeatherSearchFragment> create(
      Provider<CityWeatherSearchContract.Presenter> presenterProvider) {
    return new CityWeatherSearchFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(CityWeatherSearchFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }

  public static void injectPresenter(
      CityWeatherSearchFragment instance,
      Provider<CityWeatherSearchContract.Presenter> presenterProvider) {
    instance.presenter = presenterProvider.get();
  }
}
