package com.example.dmitry.notificationexample.ui.main;


import android.app.Fragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dmitry.notificationexample.R;
import com.example.dmitry.notificationexample.ui.base.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment {

    private static final int NOTIFY_ID = 101;


    @Bind(R.id.notification_text)
    EditText notificationText;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick(R.id.notification_button)
    public void onNotificationButtonClick() {
        Context context = getActivity().getApplicationContext();

        if (notificationText.getText().length() != 0) {
            Intent notificationIntent = new Intent();
            PendingIntent contentIntent = PendingIntent.getActivity(context,
                    0, notificationIntent,
                    PendingIntent.FLAG_CANCEL_CURRENT);
            Notification.Builder builder = new Notification.Builder(context);
            builder.setContentIntent(contentIntent)
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setDefaults(Notification.DEFAULT_VIBRATE)
                    .setContentTitle(getString(R.string.title_notification))
                    .setContentText(notificationText.getText());
            Notification notification = builder.getNotification();
            // Notification notification = builder.getNotification(); // min API 16
            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFY_ID, notification);
        }
        else
            Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show();
    }
}
