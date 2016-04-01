package com.yatra.yatrahackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.yatra.yatrahackathon.notification.NotificationUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        RelativeLayout rlFLights = (RelativeLayout)findViewById(R.id.rl_flights);
        RelativeLayout rlHotels = (RelativeLayout)findViewById(R.id.rl_hotels);
        RelativeLayout rlHolidays = (RelativeLayout)findViewById(R.id.rl_holidays);
        RelativeLayout rlTaxi = (RelativeLayout)findViewById(R.id.rl_taxi);

        rlFLights.setOnClickListener(this);
        rlHotels.setOnClickListener(this);
        rlHolidays.setOnClickListener(this);
        rlTaxi.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date d = new Date();
                NotificationUtils.setAlarm(MainActivity.this, d.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.rl_flights:
                intent = new Intent(MainActivity.this, BookFlightActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_hotels:
                intent = new Intent(MainActivity.this, BookFlightActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_holidays:
                break;
            case R.id.rl_taxi:
                break;
        }
    }
}
