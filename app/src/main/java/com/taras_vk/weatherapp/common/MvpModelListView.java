package com.taras_vk.weatherapp.common;

import java.util.List;

/**
 * Created by taras on 10/14/17.
 */
public interface MvpModelListView<M> extends MvpView {

    void addData(M data);

    void showData(List<M> data);

    void showLoading();

    void hideLoading();

    void showEmpty();

    void showError(Throwable e);
}
