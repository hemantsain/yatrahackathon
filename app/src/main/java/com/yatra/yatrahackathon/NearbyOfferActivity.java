package com.yatra.yatrahackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.yatra.yatrahackathon.notification.NotificationUtils;

/**
 * Created by XVTS8308 on 02/04/2016.
 */
public class NearbyOfferActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearby_offers);

        RelativeLayout rlOffer1 = (RelativeLayout)findViewById(R.id.rl_offer1);
        RelativeLayout rlOffer2 = (RelativeLayout)findViewById(R.id.rl_offer2);
        RelativeLayout rlOffer3 = (RelativeLayout)findViewById(R.id.rl_offer3);
        RelativeLayout rlOffer4 = (RelativeLayout)findViewById(R.id.rl_offer4);

        rlOffer1.setOnClickListener(this);
        rlOffer2.setOnClickListener(this);
        rlOffer3.setOnClickListener(this);
        rlOffer4.setOnClickListener(this);

        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
                Intent intent = new Intent(NearbyOfferActivity.this, AmbulancePosition.class);
                startActivity(intent);
                break;
        }
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
                String message = "It's lunch time and we have best offer for you in your nearby area.";
                NotificationUtils.showNotificationOffer(NearbyOfferActivity.this, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
