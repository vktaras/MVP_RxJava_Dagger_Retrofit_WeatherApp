package com.taras_vk.weatherapp.common;

/**
 * Created by taras on 10/14/17.
 */
public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView(boolean retainInstance);
}
