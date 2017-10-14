package com.taras_vk.weatherapp.injection.modules;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class NetworkModule_ProvidesRestAdapterFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<Gson> gsonProvider;

  public NetworkModule_ProvidesRestAdapterFactory(
      NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<Gson> gsonProvider) {
    assert module != null;
    this.module = module;
    assert okHttpClientProvider != null;
    this.okHttpClientProvider = okHttpClientProvider;
    assert gsonProvider != null;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public Retrofit get() {
    return Preconditions.checkNotNull(
        module.providesRestAdapter(okHttpClientProvider.get(), gsonProvider.get()),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Retrofit> create(
      NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider,
      Provider<Gson> gsonProvider) {
    return new NetworkModule_ProvidesRestAdapterFactory(module, okHttpClientProvider, gsonProvider);
  }
}
