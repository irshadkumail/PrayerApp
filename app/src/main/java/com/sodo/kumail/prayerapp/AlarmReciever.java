package com.sodo.kumail.prayerapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by kumail on 6/5/2016.
 */

public class AlarmReciever extends BroadcastReceiver {

    Uri alarm_uri;
    Ringtone ringtone;
    Context context;

    public static boolean isON=false;

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"Enable Alrm-------",Toast.LENGTH_LONG).show();


        if(isON) {
            ringtone.stop();
        }
        else {
            this.context = context;
            alarm_uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

            ringtone = RingtoneManager.getRingtone(context, alarm_uri);
            ringtone.play();
            startNotification();
        }

    }

    public void startNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Heading");
        builder.setContentText("Subtext it is");

        builder.notify();

    }
}
