package com.taras_vk.weatherapp.mvp.search.injection;

import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.mvp.search.CityWeatherSearchContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherSearchModule_ProvidesPresenterFactory
    implements Factory<CityWeatherSearchContract.Presenter> {
  private final CityWeatherSearchModule module;

  private final Provider<DataManager> dataManagerProvider;

  public CityWeatherSearchModule_ProvidesPresenterFactory(
      CityWeatherSearchModule module, Provider<DataManager> dataManagerProvider) {
    assert module != null;
    this.module = module;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public CityWeatherSearchContract.Presenter get() {
    return Preconditions.checkNotNull(
        module.providesPresenter(dataManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CityWeatherSearchContract.Presenter> create(
      CityWeatherSearchModule module, Provider<DataManager> dataManagerProvider) {
    return new CityWeatherSearchModule_ProvidesPresenterFactory(module, dataManagerProvider);
  }
}
