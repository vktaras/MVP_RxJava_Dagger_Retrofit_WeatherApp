package com.taras_vk.weatherapp.mvp.favorite.view;

import com.taras_vk.weatherapp.mvp.favorite.presenter.CityWeatherFavoritePresenter;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherFavoriteFragment_MembersInjector
    implements MembersInjector<CityWeatherFavoriteFragment> {
  private final Provider<CityWeatherFavoritePresenter> presenterProvider;

  public CityWeatherFavoriteFragment_MembersInjector(
      Provider<CityWeatherFavoritePresenter> presenterProvider) {
    assert presenterProvider != null;
    this.presenterProvider = presenterProvider;
  }

  public static MembersInjector<CityWeatherFavoriteFragment> create(
      Provider<CityWeatherFavoritePresenter> presenterProvider) {
    return new CityWeatherFavoriteFragment_MembersInjector(presenterProvider);
  }

  @Override
  public void injectMembers(CityWeatherFavoriteFragment instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.presenter = presenterProvider.get();
  }
}
