package com.taras_vk.weatherapp.data.local;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DbOpenHelper_Factory implements Factory<DbOpenHelper> {
  private final MembersInjector<DbOpenHelper> dbOpenHelperMembersInjector;

  private final Provider<Context> contextProvider;

  public DbOpenHelper_Factory(
      MembersInjector<DbOpenHelper> dbOpenHelperMembersInjector,
      Provider<Context> contextProvider) {
    assert dbOpenHelperMembersInjector != null;
    this.dbOpenHelperMembersInjector = dbOpenHelperMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
  }

  @Override
  public DbOpenHelper get() {
    return MembersInjectors.injectMembers(
        dbOpenHelperMembersInjector, new DbOpenHelper(contextProvider.get()));
  }

  public static Factory<DbOpenHelper> create(
      MembersInjector<DbOpenHelper> dbOpenHelperMembersInjector,
      Provider<Context> contextProvider) {
    return new DbOpenHelper_Factory(dbOpenHelperMembersInjector, contextProvider);
  }
}
