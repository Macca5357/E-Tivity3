/* Student name: Gavin McCarthy
 * Student id: 19237766
 */
        package com.broadcast.receiver;

import androidx.appcompat.app.AppCompatActivity;

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
                Toast.makeText(MainActivity.this, "Time trigger button clicked", Toast.LENGTH_SHORT).show();

            }
        });
     notification_trigger_button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Toast.makeText(MainActivity.this, "Notification trigger button clicked", Toast.LENGTH_SHORT).show();
         }
     });
    }
}