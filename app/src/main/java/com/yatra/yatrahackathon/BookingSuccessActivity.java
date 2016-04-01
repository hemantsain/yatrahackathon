package com.yatra.yatrahackathon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ibm_admin on 4/1/2016.
 */
public class BookingSuccessActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booking_success);

        Button btnBookCab = (Button)findViewById(R.id.btnBookCab);
        Button btnCancel = (Button)findViewById(R.id.btnCancel);
        btnBookCab.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBookCab:
                break;
            case R.id.btnCancel:
                finish();
                break;
        }
    }
}
