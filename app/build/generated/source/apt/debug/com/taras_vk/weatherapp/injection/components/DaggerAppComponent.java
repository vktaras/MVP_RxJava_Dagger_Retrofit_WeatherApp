package com.taras_vk.weatherapp.injection.components;

import android.app.Application;
import android.content.Context;
import com.google.gson.Gson;
import com.taras_vk.weatherapp.WeatherApplication;
import com.taras_vk.weatherapp.data.local.DatabaseHelper;
import com.taras_vk.weatherapp.data.local.DatabaseHelper_Factory;
import com.taras_vk.weatherapp.data.local.DbOpenHelper;
import com.taras_vk.weatherapp.data.local.DbOpenHelper_Factory;
import com.taras_vk.weatherapp.injection.modules.AppModule;
import com.taras_vk.weatherapp.injection.modules.AppModule_ProvidesApplicationContextFactory;
import com.taras_vk.weatherapp.injection.modules.AppModule_ProvidesApplicationFactory;
import com.taras_vk.weatherapp.injection.modules.NetworkModule;
import com.taras_vk.weatherapp.injection.modules.NetworkModule_ProvidesGsonFactory;
import com.taras_vk.weatherapp.injection.modules.NetworkModule_ProvidesOkHttpClientFactory;
import com.taras_vk.weatherapp.injection.modules.NetworkModule_ProvidesRestAdapterFactory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
  private Provider<Application> providesApplicationProvider;

  private Provider<Context> providesApplicationContextProvider;

  private Provider<OkHttpClient> providesOkHttpClientProvider;

  private Provider<Gson> providesGsonProvider;

  private Provider<Retrofit> providesRestAdapterProvider;

  private Provider<DbOpenHelper> dbOpenHelperProvider;

  private Provider<DatabaseHelper> databaseHelperProvider;

  private DaggerAppComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.providesApplicationProvider =
        ScopedProvider.create(AppModule_ProvidesApplicationFactory.create(builder.appModule));

    this.providesApplicationContextProvider =
        ScopedProvider.create(
            AppModule_ProvidesApplicationContextFactory.create(builder.appModule));

    this.providesOkHttpClientProvider =
        ScopedProvider.create(
            NetworkModule_ProvidesOkHttpClientFactory.create(builder.networkModule));

    this.providesGsonProvider =
        ScopedProvider.create(NetworkModule_ProvidesGsonFactory.create(builder.networkModule));

    this.providesRestAdapterProvider =
        ScopedProvider.create(
            NetworkModule_ProvidesRestAdapterFactory.create(
                builder.networkModule, providesOkHttpClientProvider, providesGsonProvider));

    this.dbOpenHelperProvider =
        DbOpenHelper_Factory.create(
            MembersInjectors.<DbOpenHelper>noOp(), providesApplicationContextProvider);

    this.databaseHelperProvider =
        ScopedProvider.create(DatabaseHelper_Factory.create(dbOpenHelperProvider));
  }

  @Override
  public void inject(WeatherApplication weatherApplication) {
    MembersInjectors.<WeatherApplication>noOp().injectMembers(weatherApplication);
  }

  @Override
  public Application getApplication() {
    return providesApplicationProvider.get();
  }

  @Override
  public Context getApplicationContext() {
    return providesApplicationContextProvider.get();
  }

  @Override
  public Retrofit getRetrofit() {
    return providesRestAdapterProvider.get();
  }

  @Override
  public DatabaseHelper getDatabaseHelper() {
    return databaseHelperProvider.get();
  }

  public static final class Builder {
    private AppModule appModule;

    private NetworkModule networkModule;

    private Builder() {}

    public AppComponent build() {
      if (appModule == null) {
        throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
      }
      if (networkModule == null) {
        throw new IllegalStateException(NetworkModule.class.getCanonicalName() + " must be set");
      }
      return new DaggerAppComponent(this);
    }

    public Builder appModule(AppModule appModule) {
      this.appModule = Preconditions.checkNotNull(appModule);
      return this;
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }
  }
}
