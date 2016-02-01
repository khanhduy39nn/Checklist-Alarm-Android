package com.ander39n.checklistalarm;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class SetAlarmActivity extends Activity implements View.OnClickListener {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private static SetAlarmActivity inst;
    private TextView alarmTextView;

    public static SetAlarmActivity instance() {
        return inst;
    }

    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alarmTimePicker = (TimePicker) findViewById(R.id.alarmTimePicker);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton alarmToggle = (ToggleButton) findViewById(R.id.alarmToggle);
        alarmToggle.setOnClickListener(this);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }


    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.alarmToggle:
                if (((ToggleButton) v).isChecked()) {
                    Log.d("MyActivity", "Alarm On");
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getCurrentHour());
                    calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());
                    Intent myIntent = new Intent(SetAlarmActivity.this, AlarmReceiver.class);
                    pendingIntent = PendingIntent.getBroadcast(SetAlarmActivity.this, 0, myIntent, 0);
                    alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
                } else {
                    alarmManager.cancel(pendingIntent);
                    setAlarmText("");
                    Log.d("MyActivity", "Alarm Off");
                }
                break;
        }
    }
}
