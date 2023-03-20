/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
package com.broadcastreceiver.app;

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
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Create a notification channel
        String channelId = "MyBroadcastReceiverApp";
        CharSequence channelName = "MyBroadcastReceiverApp";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(channelId, channelName, importance);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(channel);
        }

        // Create the notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        // Show the notification
        notificationManager.notify(0, builder.build());
    }
}
