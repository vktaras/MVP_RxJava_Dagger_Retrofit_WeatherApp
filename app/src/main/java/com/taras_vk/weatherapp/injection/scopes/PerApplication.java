package com.taras_vk.weatherapp.injection.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by taras on 10/14/17.
 */

@Scope
@Retention(RUNTIME)
public @interface PerApplication {
}
