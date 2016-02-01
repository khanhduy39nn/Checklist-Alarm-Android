package com.ander39n.checklistalarm;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main2Activity extends AppCompatActivity{


    TextView tvHour;
    TextView tvMinute;
    Date noteTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ListView lvAlarm = (ListView)findViewById(R.id.listView);


        String[] vi_countries = new String[] { "Việt Nam", "Pháp",
                "Bỉ", "Ý", "Đức", "Tây Ban Nha" };
        Boolean[] alarm_enable = new Boolean[] { true, false, true, true, false, false};

        ArrayList<Alarm> alarms = new ArrayList<Alarm>();
        for (int i = 0; i < vi_countries.length; i++) {

            int colorID;
            switch (i){
                case 0: colorID= getResources().getColor(R.color.background_item_alarm_1); break;
                case 1: colorID= getResources().getColor(R.color.background_item_alarm_2); break;
                case 2: colorID= getResources().getColor(R.color.background_item_alarm_3); break;
                case 3: colorID= getResources().getColor(R.color.background_item_alarm_4); break;
                case 4: colorID= getResources().getColor(R.color.background_item_alarm_5); break;
                default: colorID= getResources().getColor(R.color.background_item_alarm_6); break;
            }
            Alarm c = new Alarm(vi_countries[i],"03:09","AM","no repeat",colorID,alarm_enable[i]);
            alarms.add(c);
        }

        ListAlarmApdater adapter = new ListAlarmApdater(getApplicationContext(), R.layout.item_layout, alarms);
        lvAlarm.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
