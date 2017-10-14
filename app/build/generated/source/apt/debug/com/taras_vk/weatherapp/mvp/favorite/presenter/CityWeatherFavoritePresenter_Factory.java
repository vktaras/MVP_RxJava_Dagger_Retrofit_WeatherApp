package com.taras_vk.weatherapp.mvp.favorite.presenter;

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
public final class CityWeatherFavoritePresenter_Factory
    implements Factory<CityWeatherFavoritePresenter> {
  private final MembersInjector<CityWeatherFavoritePresenter>
      cityWeatherFavoritePresenterMembersInjector;

  private final Provider<DataManager> dataManagerProvider;

  public CityWeatherFavoritePresenter_Factory(
      MembersInjector<CityWeatherFavoritePresenter> cityWeatherFavoritePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider) {
    assert cityWeatherFavoritePresenterMembersInjector != null;
    this.cityWeatherFavoritePresenterMembersInjector = cityWeatherFavoritePresenterMembersInjector;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public CityWeatherFavoritePresenter get() {
    return MembersInjectors.injectMembers(
        cityWeatherFavoritePresenterMembersInjector,
        new CityWeatherFavoritePresenter(dataManagerProvider.get()));
  }

  public static Factory<CityWeatherFavoritePresenter> create(
      MembersInjector<CityWeatherFavoritePresenter> cityWeatherFavoritePresenterMembersInjector,
      Provider<DataManager> dataManagerProvider) {
    return new CityWeatherFavoritePresenter_Factory(
        cityWeatherFavoritePresenterMembersInjector, dataManagerProvider);
  }
}
