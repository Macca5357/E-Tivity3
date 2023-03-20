/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
package com.broadcast.receiver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button time_trigger_button,notification_trigger_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews() {
        time_trigger_button=findViewById(R.id.time_trigger_button);
        notification_trigger_button=findViewById(R.id.notification_trigger_button);
        time_trigger_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                triggerTimeIntent();

            }
        });
     notification_trigger_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             triggerNotificationIntent();
         }
     });
    }

    public void triggerTimeIntent() {
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        intent.setAction("com.broadcastreceiver.app.ACTION_TIME_TRIGGER");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerTime = System.currentTimeMillis() + 5000; // 5 seconds from now
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, triggerTime, pendingIntent);

        Toast.makeText(this, "Time Intent Triggered", Toast.LENGTH_SHORT).show();
    }

    public void triggerNotificationIntent() {
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        intent.setAction("com.broadcastreceiver.app.ACTION_TRIGGER");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyBroadcastReceiverApp")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("MyBroadcastReceiverApp")
                .setContentText("Click here to trigger the notification-based Intent")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());

        Toast.makeText(this, "Notification Intent Triggered", Toast.LENGTH_SHORT).show();
    }


}