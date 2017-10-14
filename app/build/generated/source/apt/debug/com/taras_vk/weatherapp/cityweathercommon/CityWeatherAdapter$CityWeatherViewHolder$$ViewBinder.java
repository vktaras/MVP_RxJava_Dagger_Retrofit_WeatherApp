// Generated code from Butter Knife. Do not modify!
package com.taras_vk.weatherapp.cityweathercommon;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class CityWeatherAdapter$CityWeatherViewHolder$$ViewBinder<T extends CityWeatherAdapter.CityWeatherViewHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(final Finder finder, final T target, Object source) {
    InnerUnbinder unbinder = createUnbinder(target);
    View view;
    view = finder.findRequiredView(source, 2131558540, "field 'cityNameTextView'");
    target.cityNameTextView = finder.castView(view, 2131558540, "field 'cityNameTextView'");
    view = finder.findRequiredView(source, 2131558541, "field 'cityWeatherDegreesTextView'");
    target.cityWeatherDegreesTextView = finder.castView(view, 2131558541, "field 'cityWeatherDegreesTextView'");
    view = finder.findRequiredView(source, 2131558542, "field 'cityWeatherDescriptionTextView'");
    target.cityWeatherDescriptionTextView = finder.castView(view, 2131558542, "field 'cityWeatherDescriptionTextView'");
    view = finder.findRequiredView(source, 2131558521, "field 'cityWeatherIconImageView'");
    target.cityWeatherIconImageView = finder.castView(view, 2131558521, "field 'cityWeatherIconImageView'");
    view = finder.findRequiredView(source, 2131558539, "field 'cityWeatherFavoriteImageView' and method 'onCityWeatherFavoriteSelected'");
    target.cityWeatherFavoriteImageView = finder.castView(view, 2131558539, "field 'cityWeatherFavoriteImageView'");
    unbinder.view2131558539 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCityWeatherFavoriteSelected();
      }
    });
    view = finder.findRequiredView(source, 2131558538, "method 'onCityWeatherItemClicked'");
    unbinder.view2131558538 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCityWeatherItemClicked();
      }
    });
    return unbinder;
  }

  protected InnerUnbinder<T> createUnbinder(T target) {
    return new InnerUnbinder(target);
  }

  protected static class InnerUnbinder<T extends CityWeatherAdapter.CityWeatherViewHolder> implements Unbinder {
    private T target;

    View view2131558539;

    View view2131558538;

    protected InnerUnbinder(T target) {
      this.target = target;
    }

    @Override
    public final void unbind() {
      if (target == null) throw new IllegalStateException("Bindings already cleared.");
      unbind(target);
      target = null;
    }

    protected void unbind(T target) {
      target.cityNameTextView = null;
      target.cityWeatherDegreesTextView = null;
      target.cityWeatherDescriptionTextView = null;
      target.cityWeatherIconImageView = null;
      view2131558539.setOnClickListener(null);
      target.cityWeatherFavoriteImageView = null;
      view2131558538.setOnClickListener(null);
    }
  }
}
