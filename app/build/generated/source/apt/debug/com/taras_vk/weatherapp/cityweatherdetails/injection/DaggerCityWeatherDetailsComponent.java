package com.taras_vk.weatherapp.cityweatherdetails.injection;

import com.taras_vk.weatherapp.cityweatherdetails.CityWeatherDetailsContract;
import com.taras_vk.weatherapp.cityweatherdetails.view.CityWeatherDetailsActivity;
import com.taras_vk.weatherapp.cityweatherdetails.view.CityWeatherDetailsActivity_MembersInjector;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCityWeatherDetailsComponent implements CityWeatherDetailsComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<CityWeatherDetailsContract.Presenter> providesPresenterProvider;

  private MembersInjector<CityWeatherDetailsActivity> cityWeatherDetailsActivityMembersInjector;

  private DaggerCityWeatherDetailsComponent(Builder builder) {
    assert builder != null;
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {

    this.getDataManagerProvider =
        new Factory<DataManager>() {
          private final OpenWeatherMapComponent openWeatherMapComponent =
              builder.openWeatherMapComponent;

          @Override
          public DataManager get() {
            return Preconditions.checkNotNull(
                openWeatherMapComponent.getDataManager(),
                "Cannot return null from a non-@Nullable component method");
          }
        };

    this.providesPresenterProvider =
        ScopedProvider.create(
            CityWeatherDetailsModule_ProvidesPresenterFactory.create(
                builder.cityWeatherDetailsModule, getDataManagerProvider));

    this.cityWeatherDetailsActivityMembersInjector =
        CityWeatherDetailsActivity_MembersInjector.create(providesPresenterProvider);
  }

  @Override
  public CityWeatherDetailsActivity inject(CityWeatherDetailsActivity cityWeatherDetailsActivity) {
    cityWeatherDetailsActivityMembersInjector.injectMembers(cityWeatherDetailsActivity);
    return cityWeatherDetailsActivity;
  }

  public static final class Builder {
    private CityWeatherDetailsModule cityWeatherDetailsModule;

    private OpenWeatherMapComponent openWeatherMapComponent;

    private Builder() {}

    public CityWeatherDetailsComponent build() {
      if (cityWeatherDetailsModule == null) {
        this.cityWeatherDetailsModule = new CityWeatherDetailsModule();
      }
      if (openWeatherMapComponent == null) {
        throw new IllegalStateException(
            OpenWeatherMapComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerCityWeatherDetailsComponent(this);
    }

    public Builder cityWeatherDetailsModule(CityWeatherDetailsModule cityWeatherDetailsModule) {
      this.cityWeatherDetailsModule = Preconditions.checkNotNull(cityWeatherDetailsModule);
      return this;
    }

    public Builder openWeatherMapComponent(OpenWeatherMapComponent openWeatherMapComponent) {
      this.openWeatherMapComponent = Preconditions.checkNotNull(openWeatherMapComponent);
      return this;
    }
  }
}
