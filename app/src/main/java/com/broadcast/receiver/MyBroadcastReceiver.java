/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
package com.broadcast.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the intent
        if (intent.getAction().equals("com.broadcastreceiver.app.ACTION_TRIGGER")) {
            // This is the notification trigger
            showNotification(context, "MyBroadcastReceiverApp", "Notification Triggered!");
        } else if (intent.getAction().equals("com.broadcastreceiver.app.ACTION_TIME_TRIGGER")) {
            // This is the time-based trigger
            showNotification(context, "MyBroadcastReceiverApp", "Time Triggered!");
        }
    }

    private void showNotification(Context context, String title, String message) {
      
    }
}
