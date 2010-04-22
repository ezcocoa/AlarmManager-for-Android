package com.ezcocoa.alarmmanagertest;

import java.util.Calendar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmService_Service extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final Calendar c = Calendar.getInstance();
		int mHour = c.get(Calendar.HOUR_OF_DAY);
		int mMinute = c.get(Calendar.MINUTE);
		int mSecond = c.get(Calendar.SECOND);
		
		Toast.makeText(context, "���� �ð�" + mHour + ":" + mMinute + ":" + mSecond, Toast.LENGTH_LONG).show();
	}
}
