package com.example.shengxiong.weather;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Parcelable;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shengxiong.weather.DayAdapter.DayAdapter;
import com.example.shengxiong.weather.weather.Day;

import java.util.Arrays;

import butterknife.BindView;

public class DailyForecastActivity extends ListActivity {
   private Day[] mMdays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mMdays = Arrays.copyOf(parcelables, parcelables.length,Day[].class);
        DayAdapter adapter = new DayAdapter(this, mMdays);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String dayOfTheWeek = mMdays[position].getDayOfTheWeek();
        String conditions = mMdays[position].getSummary();
        String highTemp = mMdays[position].getTemperatureMax()+"";
        String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek, highTemp,conditions);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

    }
}
