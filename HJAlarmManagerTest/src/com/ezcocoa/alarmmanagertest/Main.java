package com.ezcocoa.alarmmanagertest;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class Main extends Activity {
    /** Called when the activity is first created. */
    Toast mToast;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent intent = new Intent(Main.this, AlarmService_Service.class);
        PendingIntent sender = PendingIntent.getBroadcast(Main.this, 0 , intent, 0);
        
        long firstTime = SystemClock.elapsedRealtime();
        firstTime += 10*1000;
        
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime, 10 *1000, sender);
        
        final Calendar c = Calendar.getInstance();
        int mHour = c.get(Calendar.HOUR_OF_DAY);
        int mMinute = c.get(Calendar.MINUTE);
        int mSecond = c.get(Calendar.SECOND);
        
        Toast mToast = null;
        if (mToast != null) {
        	mToast.cancel();
        }
        
        mToast = Toast.makeText(this, "현재 시간" + mHour + ":" + mMinute + ":" + mSecond, Toast.LENGTH_LONG);
        mToast.show();
        Log.d("Tag","Toast....");
    }
}