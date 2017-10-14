package com.taras_vk.weatherapp.cityweatherfavorite.injection;

import com.taras_vk.weatherapp.cityweatherfavorite.presenter.CityWeatherFavoritePresenter;
import com.taras_vk.weatherapp.cityweatherfavorite.presenter.CityWeatherFavoritePresenter_Factory;
import com.taras_vk.weatherapp.cityweatherfavorite.view.CityWeatherFavoriteFragment;
import com.taras_vk.weatherapp.cityweatherfavorite.view.CityWeatherFavoriteFragment_MembersInjector;
import com.taras_vk.weatherapp.data.remote.DataManager;
import com.taras_vk.weatherapp.injection.components.OpenWeatherMapComponent;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerCityWeatherFavoriteComponent implements CityWeatherFavoriteComponent {
  private Provider<DataManager> getDataManagerProvider;

  private Provider<CityWeatherFavoritePresenter> cityWeatherFavoritePresenterProvider;

  private MembersInjector<CityWeatherFavoriteFragment> cityWeatherFavoriteFragmentMembersInjector;

  private DaggerCityWeatherFavoriteComponent(Builder builder) {
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

    this.cityWeatherFavoritePresenterProvider =
        CityWeatherFavoritePresenter_Factory.create(
            MembersInjectors.<CityWeatherFavoritePresenter>noOp(), getDataManagerProvider);

    this.cityWeatherFavoriteFragmentMembersInjector =
        CityWeatherFavoriteFragment_MembersInjector.create(cityWeatherFavoritePresenterProvider);
  }

  @Override
  public CityWeatherFavoriteFragment inject(CityWeatherFavoriteFragment fragment) {
    cityWeatherFavoriteFragmentMembersInjector.injectMembers(fragment);
    return fragment;
  }

  public static final class Builder {
    private OpenWeatherMapComponent openWeatherMapComponent;

    private Builder() {}

    public CityWeatherFavoriteComponent build() {
      if (openWeatherMapComponent == null) {
        throw new IllegalStateException(
            OpenWeatherMapComponent.class.getCanonicalName() + " must be set");
      }
      return new DaggerCityWeatherFavoriteComponent(this);
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Deprecated
    public Builder cityWeatherFavoriteModule(CityWeatherFavoriteModule cityWeatherFavoriteModule) {
      Preconditions.checkNotNull(cityWeatherFavoriteModule);
      return this;
    }

    public Builder openWeatherMapComponent(OpenWeatherMapComponent openWeatherMapComponent) {
      this.openWeatherMapComponent = Preconditions.checkNotNull(openWeatherMapComponent);
      return this;
    }
  }
}
