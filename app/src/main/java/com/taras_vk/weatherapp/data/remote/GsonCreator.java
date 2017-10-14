package com.taras_vk.weatherapp.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by taras on 10/14/17.
 */
public class GsonCreator {

    public static Gson createGson() {

        // register possible type adapters here
        return new GsonBuilder().create();
    }
}
