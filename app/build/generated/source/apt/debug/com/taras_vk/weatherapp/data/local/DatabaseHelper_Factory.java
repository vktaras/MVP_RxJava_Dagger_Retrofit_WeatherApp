package com.taras_vk.weatherapp.data.local;

import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DatabaseHelper_Factory implements Factory<DatabaseHelper> {
  private final Provider<DbOpenHelper> dbOpenHelperProvider;

  public DatabaseHelper_Factory(Provider<DbOpenHelper> dbOpenHelperProvider) {
    assert dbOpenHelperProvider != null;
    this.dbOpenHelperProvider = dbOpenHelperProvider;
  }

  @Override
  public DatabaseHelper get() {
    return new DatabaseHelper(dbOpenHelperProvider.get());
  }

  public static Factory<DatabaseHelper> create(Provider<DbOpenHelper> dbOpenHelperProvider) {
    return new DatabaseHelper_Factory(dbOpenHelperProvider);
  }
}
