package com.ander39n.checklistalarm;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by duynguyen on 1/28/2016.
 */
public class ListAlarmApdater extends  ArrayAdapter<Alarm>
{


        Context context;
        int resId;
        ArrayList<Alarm> countries;

    public ListAlarmApdater(Context context, int resId,
            ArrayList<Alarm> countries) {
            super(context, resId, countries);
            this.context = context;
            this.resId = resId;
            this.countries = countries;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        Alarm alarm = countries.get(position);

        view = inflater.inflate(resId, null);

        TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
        TextView txtTime = (TextView) view.findViewById(R.id.txtTime);
        TextView txtGrub = (TextView) view.findViewById(R.id.txtGrub);
        RelativeLayout layout = (RelativeLayout)view.findViewById(R.id.itemLayout);
        Button btnEnableThisAlarm = (Button)view.findViewById(R.id.btnEnableThisAlarm);


        layout.setBackgroundColor(alarm.getColorID());
        txtTitle.setText(alarm.getTitle());
        txtTime.setText(alarm.getTime());
        txtGrub.setText(alarm.getGrub());
       if(alarm.isEnable()) {

        btnEnableThisAlarm.setBackgroundResource(R.color.background_enable_alarm);
       }else{
          // btnEnableThisAlarm.setBackgroundColor(convertView.getResources().getColor(R.color.background_disable_alarm));
           btnEnableThisAlarm.setBackgroundResource(R.color.background_disable_alarm);
       }

        return view;
    }

}