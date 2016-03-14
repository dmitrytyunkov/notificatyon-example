package com.example.dmitry.notificationexample.ui.main;

import android.os.Bundle;

import com.example.dmitry.notificationexample.R;
import com.example.dmitry.notificationexample.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null)
            getFragmentManager().beginTransaction().add(R.id.container, new MainFragment()).commit();
    }
}
