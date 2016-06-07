package com.sodo.kumail.prayerapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.widget.Toast;

import java.util.Calendar;

public class SettingsActivity extends PreferenceActivity {


    SwitchPreference asar_switchPreference, fajr_sharedPreference, zuhr_sharedPreference, maghrib_sharedPreference, isha_sharedPreference, noti_sharedPreference;

    Preference salah_reminders;
    public static boolean asar_switchPreference_boolean, fajr_sharedPreference_boolean, zuhr_sharedPreference_boolean, maghrib_sharedPreference_boolean, isha_sharedPreference_boolean, noti_sharedPreference_boolean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);


        salah_reminders = findPreference("pref_salah_reminder");
        salah_reminders.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                //getFragmentManager().beginTransaction().replace(android.R.id.content, new SubPrefFrag()).addToBackStack("").commit();
                enableAlarms();

                return false;
            }
        });

    }

    public void enableAlarms() {
        if (true) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 44);

            Intent intent = new Intent(SettingsActivity.this, AlarmReciever.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            Toast.makeText(this,"Enable Alrm",Toast.LENGTH_LONG).show();


        }

    }

    public static class SubPrefFrag extends PreferenceFragment {

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            addPreferencesFromResource(R.xml.setiings_reminders);


        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);

            getView().setBackgroundColor(getActivity().getResources().getColor(android.R.color.white));
            getView().setClickable(true);


        }

    }

}


