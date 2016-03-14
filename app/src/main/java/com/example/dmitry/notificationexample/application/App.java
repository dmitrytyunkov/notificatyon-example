package com.example.dmitry.notificationexample.application;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by dmitry on 14.03.16.
 */
public class App extends Application {


    private Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        bus = new Bus();
    }


    public Bus getBus() {
        return bus;
    }
}
