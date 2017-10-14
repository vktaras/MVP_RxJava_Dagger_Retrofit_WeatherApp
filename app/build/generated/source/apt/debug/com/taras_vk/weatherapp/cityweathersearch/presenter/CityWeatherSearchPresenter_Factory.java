package com.taras_vk.weatherapp.cityweathersearch.presenter;

import com.taras_vk.weatherapp.data.remote.DataManager;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherSearchPresenter_Factory
    implements Factory<CityWeatherSearchPresenter> {
  private final MembersInjector<CityWeatherSearchPresenter>
      cityWeatherSearchPresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  public CityWeatherSearchPresenter_Factory(
      MembersInjector<CityWeatherSearchPresenter> cityWeatherSearchPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider) {
    assert cityWeatherSearchPresenterMembersInjector != null;
    this.cityWeatherSearchPresenterMembersInjector = cityWeatherSearchPresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public CityWeatherSearchPresenter get() {
    return MembersInjectors.injectMembers(
        cityWeatherSearchPresenterMembersInjector,
        new CityWeatherSearchPresenter(dataManagerProvider.get()));
  }

  public static Factory<CityWeatherSearchPresenter> create(
      MembersInjector<CityWeatherSearchPresenter> cityWeatherSearchPresenterMembersInjector,
      Provider<DataManager> dataManagerProvider) {
    return new CityWeatherSearchPresenter_Factory(
        cityWeatherSearchPresenterMembersInjector, dataManagerProvider);
  }
}
