package com.taras_vk.weatherapp.injection.modules;

import com.taras_vk.weatherapp.data.remote.IOpenWeatherMapApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class OpenWeatherMapModule_ProvidesOpenWeatherMapApiFactory
    implements Factory<IOpenWeatherMapApi> {
  private final OpenWeatherMapModule module;

  private final Provider<Retrofit> retrofitProvider;

  public OpenWeatherMapModule_ProvidesOpenWeatherMapApiFactory(
      OpenWeatherMapModule module, Provider<Retrofit> retrofitProvider) {
    assert module != null;
    this.module = module;
    assert retrofitProvider != null;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public IOpenWeatherMapApi get() {
    return Preconditions.checkNotNull(
        module.providesOpenWeatherMapApi(retrofitProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<IOpenWeatherMapApi> create(
      OpenWeatherMapModule module, Provider<Retrofit> retrofitProvider) {
    return new OpenWeatherMapModule_ProvidesOpenWeatherMapApiFactory(module, retrofitProvider);
  }
}
