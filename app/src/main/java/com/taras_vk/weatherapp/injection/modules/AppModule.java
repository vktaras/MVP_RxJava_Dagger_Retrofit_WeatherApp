package com.taras_vk.weatherapp.injection.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by taras on 10/14/17.
 */

@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {

        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {

        return application;
    }

    @Provides
    @Singleton
    Context providesApplicationContext() {

        return application.getApplicationContext();
    }
}
