package com.taras_vk.weatherapp.injection.components;

import com.taras_vk.weatherapp.data.local.DatabaseHelper;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.data.remote.DataManager_Factory;
import com.taras_vk.weatherapp.data.remote.IOpenWeatherMapApi;
import com.taras_vk.weatherapp.injection.modules.OpenWeatherMapModule;
import com.taras_vk.weatherapp.injection.modules.OpenWeatherMapModule_ProvidesOpenWeatherMapApiFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerOpenWeatherMapComponent implements OpenWeatherMapComponent {
  private Provider<Retrofit> getRetrofitProvider;

  private Provider<IOpenWeatherMapApi> providesOpenWeatherMapApiProvider;

  private Provider<DatabaseHelper> getDatabaseHelperProvider;

  private Provider<DataManager> dataManagerProvider;

  private DaggerOpenWeatherMapComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getRetrofitProvider =
        new Factory<Retrofit>() {
          private final AppComponent appComponent = builder.appComponent;

          @Override
          public Retrofit get() {
            return Preconditions.checkNotNull(
                appComponent.getRetrofit(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providesOpenWeatherMapApiProvider =
        ScopedProvider.create(
            OpenWeatherMapModule_ProvidesOpenWeatherMapApiFactory.create(
                builder.openWeatherMapModule, getRetrofitProvider));

    this.getDatabaseHelperProvider =
        new Factory<DatabaseHelper>() {
          private final AppComponent appComponent = builder.appComponent;

          @Override
          public DatabaseHelper get() {
            return Preconditions.checkNotNull(
                appComponent.getDatabaseHelper(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.dataManagerProvider =
        ScopedProvider.create(
            DataManager_Factory.create(
                providesOpenWeatherMapApiProvider, getDatabaseHelperProvider));
  }

  @Override
  public DataManager getDataManager() {
    return dataManagerProvider.get();
  }

  public static final class Builder {
    private OpenWeatherMapModule openWeatherMapModule;

    private AppComponent appComponent;

    private Builder() {}

    public OpenWeatherMapComponent build() {
      if (openWeatherMapModule == null) {
        this.openWeatherMapModule = new OpenWeatherMapModule();
      }
      if (appComponent == null) {
        throw new IllegalStateException(AppComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerOpenWeatherMapComponent(this);
    }

    public Builder openWeatherMapModule(OpenWeatherMapModule openWeatherMapModule) {
      this.openWeatherMapModule = Preconditions.checkNotNull(openWeatherMapModule);
      return this;
    }

    public Builder appComponent(AppComponent appComponent) {
      this.appComponent = Preconditions.checkNotNull(appComponent);
      return this;
    }
  }
}
