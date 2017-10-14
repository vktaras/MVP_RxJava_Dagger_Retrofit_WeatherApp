package com.taras_vk.weatherapp.mvp.details.injection;

import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.mvp.details.CityWeatherDetailsContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CityWeatherDetailsModule_ProvidesPresenterFactory
    implements Factory<CityWeatherDetailsContract.Presenter> {
  private final CityWeatherDetailsModule module;

  private final Provider<DataManager> dataManagerProvider;

  public CityWeatherDetailsModule_ProvidesPresenterFactory(
      CityWeatherDetailsModule module, Provider<DataManager> dataManagerProvider) {
    assert module != null;
    this.module = module;
    assert dataManagerProvider != null;
    this.dataManagerProvider = dataManagerProvider;
  }

  @Override
  public CityWeatherDetailsContract.Presenter get() {
    return Preconditions.checkNotNull(
        module.providesPresenter(dataManagerProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<CityWeatherDetailsContract.Presenter> create(
      CityWeatherDetailsModule module, Provider<DataManager> dataManagerProvider) {
    return new CityWeatherDetailsModule_ProvidesPresenterFactory(module, dataManagerProvider);
  }
}
