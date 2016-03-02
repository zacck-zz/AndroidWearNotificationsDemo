package com.zacck.androidwearnotificationsdemo;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intentr
        Intent notifyIntent = new Intent(this, MainActivity.class);
        final PendingIntent mPendingIntent = PendingIntent.getActivity(this,0,notifyIntent,0);

        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
               // mTextView = (TextView) stub.findViewById(R.id.text);
                NotificationCompat.Builder mWearNotificationBuilder = new NotificationCompat.Builder(MainActivity.this)
                        .setSmallIcon(android.R.drawable.arrow_down_float)
                        .setContentTitle("Notifification")
                        .setContentText("I am notifying you")
                        .setContentIntent(mPendingIntent);

                NotificationManagerCompat mNotificationMan = NotificationManagerCompat.from(MainActivity.this);
                mNotificationMan.notify(0,mWearNotificationBuilder.build());
            }
        });
    }
}
