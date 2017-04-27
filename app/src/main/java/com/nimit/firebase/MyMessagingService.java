package com.nimit.firebase;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Nimit Agg on 27-04-2017.
 */

public class MyMessagingService extends FirebaseMessagingService {
    String TAG = "Here";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getMessageId());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getData());
        Log.d(TAG, "onMessageReceived: " + remoteMessage.getNotification());

        Notification.Builder ser = new Notification.Builder(this);
        ser.setContentTitle(remoteMessage.getNotification().getTitle());
        ser.setContentText(remoteMessage.getNotification().getBody());
        ser.setSmallIcon(R.mipmap.ic_launcher);
        ser.setPriority(Notification.PRIORITY_MAX).setDefaults(Notification.DEFAULT_ALL);
        NotificationManager not = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        not.notify(111, ser.build());
    }
}
