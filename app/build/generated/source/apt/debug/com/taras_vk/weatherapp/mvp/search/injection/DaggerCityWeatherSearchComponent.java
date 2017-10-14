package com.taras_vk.weatherapp.mvp.search.injection;

import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import com.taras_vk.weatherapp.mvp.search.CityWeatherSearchContract;
import com.taras_vk.weatherapp.mvp.search.view.CityWeatherSearchFragment;
import com.taras_vk.weatherapp.mvp.search.view.CityWeatherSearchFragment_MembersInjector;
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
public final class DaggerCityWeatherSearchComponent implements CityWeatherSearchComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<CityWeatherSearchContract.Presenter> providesPresenterProvider;

  private MembersInjector<CityWeatherSearchFragment> cityWeatherSearchFragmentMembersInjector;

  private DaggerCityWeatherSearchComponent(Builder builder) {
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
            CityWeatherSearchModule_ProvidesPresenterFactory.create(
                builder.cityWeatherSearchModule, getDataManagerProvider));

    this.cityWeatherSearchFragmentMembersInjector =
        CityWeatherSearchFragment_MembersInjector.create(providesPresenterProvider);
  }

  @Override
  public CityWeatherSearchFragment inject(CityWeatherSearchFragment fragment) {
    cityWeatherSearchFragmentMembersInjector.injectMembers(fragment);
    return fragment;
  }

  public static final class Builder {
    private CityWeatherSearchModule cityWeatherSearchModule;

    private OpenWeatherMapComponent openWeatherMapComponent;

    private Builder() {}

    public CityWeatherSearchComponent build() {
      if (cityWeatherSearchModule == null) {
        this.cityWeatherSearchModule = new CityWeatherSearchModule();
      }
      if (openWeatherMapComponent == null) {
        throw new IllegalStateException(
            OpenWeatherMapComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerCityWeatherSearchComponent(this);
    }

    public Builder cityWeatherSearchModule(CityWeatherSearchModule cityWeatherSearchModule) {
      this.cityWeatherSearchModule = Preconditions.checkNotNull(cityWeatherSearchModule);
      return this;
    }

    public Builder openWeatherMapComponent(OpenWeatherMapComponent openWeatherMapComponent) {
      this.openWeatherMapComponent = Preconditions.checkNotNull(openWeatherMapComponent);
      return this;
    }
  }
}
