package com.yatra.yatrahackathon;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;

import com.yatra.yatrahackathon.notification.NotificationUtils;
import com.yatra.yatrahackathon.notification.Utils;

import java.util.Calendar;

/**
 * Created by XVTS8308 on 02/04/2016.
 */
public class BookFlightActivity extends Activity {

    private TextView departDate;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flights_activity);

        departDate = (TextView)findViewById(R.id.depatureDate);
        departDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment departDateFragment = new DatePickerFragment();
                departDateFragment.show(getFragmentManager(), "Departure Date");
            }
        });
        final CheckBox checkbox = (CheckBox) findViewById(R.id.checkbox);
        findViewById(R.id.btnBookFlight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox.isChecked()) {
                    long l = (long) departDate.getTag();
                    NotificationUtils.setAlarm(BookFlightActivity.this, l, "You have a flight at 18:00. Do you want to book a cab?");
                }
                Intent intent = new Intent(BookFlightActivity.this, BookingSuccessActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @SuppressLint("ValidFragment")
    public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
            DatePicker datePicker = datePickerDialog.getDatePicker();
            datePicker.setMinDate(c.getTimeInMillis());
            return datePickerDialog;
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            long date = Utils.getLongTimeFromStringDate((month + 1) + "." + day + "." + year, Utils.DATE_FORMAT_MM_dd_yyyy);
            String dd = Utils.getDateStringFromLong(date);
            departDate.setText(dd);
            departDate.setTag(date);
        }
    }
}
