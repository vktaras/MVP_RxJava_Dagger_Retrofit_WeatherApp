package com.taras_vk.weatherapp.data.remote;

import com.taras_vk.weatherapp.data.local.DatabaseHelper;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DataManager_Factory implements Factory<DataManager> {
  private final Provider<IOpenWeatherMapApi> openWeatherMapServiceProvider;

  private final Provider<DatabaseHelper> databaseHelperProvider;

  public DataManager_Factory(
      Provider<IOpenWeatherMapApi> openWeatherMapServiceProvider,
      Provider<DatabaseHelper> databaseHelperProvider) {
    assert openWeatherMapServiceProvider != null;
    this.openWeatherMapServiceProvider = openWeatherMapServiceProvider;
    assert databaseHelperProvider != null;
    this.databaseHelperProvider = databaseHelperProvider;
  }

  @Override
  public DataManager get() {
    return new DataManager(openWeatherMapServiceProvider.get(), databaseHelperProvider.get());
  }

  public static Factory<DataManager> create(
      Provider<IOpenWeatherMapApi> openWeatherMapServiceProvider,
      Provider<DatabaseHelper> databaseHelperProvider) {
    return new DataManager_Factory(openWeatherMapServiceProvider, databaseHelperProvider);
  }
}
