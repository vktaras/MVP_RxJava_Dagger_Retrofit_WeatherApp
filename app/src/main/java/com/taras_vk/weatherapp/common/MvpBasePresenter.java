package com.taras_vk.weatherapp.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by taras on 10/14/17.
 */
public class MvpBasePresenter<V extends MvpView> implements Presenter<V> {

    private WeakReference<V> viewRef;

    @Override
    public void attachView(@NonNull V view) {

        viewRef = new WeakReference<>(view);
    }

    @Override
    public void detachView(boolean retainInstance) {

        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    @Nullable
    public V getView() {
        return viewRef == null ? null : viewRef.get();
    }

    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }
}
