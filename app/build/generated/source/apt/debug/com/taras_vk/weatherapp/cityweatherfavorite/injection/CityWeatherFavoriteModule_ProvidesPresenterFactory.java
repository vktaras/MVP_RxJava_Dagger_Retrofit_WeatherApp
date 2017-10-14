package com.taras_vk.weatherapp.cityweatherfavorite.injection;

import com.taras_vk.weatherapp.cityweatherfavorite.CityWeatherFavoriteContract;
import com.taras_vk.weatherapp.data.remote.DataManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherFavoriteModule_ProvidesPresenterFactory
    implements Factory<CityWeatherFavoriteContract.Presenter> {
  private final CityWeatherFavoriteModule module;

  private final Provider<DataManager> dataManagerProvider;

  public CityWeatherFavoriteModule_ProvidesPresenterFactory(
      CityWeatherFavoriteModule module, Provider<DataManager> dataManagerProvider) {
    assert module != null;
    this.module = module;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public CityWeatherFavoriteContract.Presenter get() {
    return Preconditions.checkNotNull(
        module.providesPresenter(dataManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CityWeatherFavoriteContract.Presenter> create(
      CityWeatherFavoriteModule module, Provider<DataManager> dataManagerProvider) {
    return new CityWeatherFavoriteModule_ProvidesPresenterFactory(module, dataManagerProvider);
  }
}
