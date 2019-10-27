package com.example.healthassist;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define the variable of CalendarView type and TextView type;
    CalendarView calendar;
    TextView date_view;
    Date selectedDate;
    public static final int NEW_JOURNAL = 0;
    public static final int OK_RESULT = 1;
    private LinearLayout statusMenu;
    private FloatingActionButton addbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        calendar = (CalendarView)
            findViewById(R.id.calendar);
        date_view = (TextView)
            findViewById(R.id.date_view);
        addbtn = findViewById(R.id.addbtn);

        // Add Listener in calendar
        calendar
            .setOnDateChangeListener(
                new CalendarView
                    .OnDateChangeListener() {
                        @Override
                        // In this Listener have one method
                        // and in this method we will
                        // get the value of DAYS, MONTH, YEARS
                        public void onSelectedDayChange(
                            CalendarView view,
                            int year,
                            int month,
                            int dayOfMonth)
                        {
                            selectedDate = new Date(month, dayOfMonth, year);
                        }
                    });
        // Shows settings when pressing the Settings Button
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                //adding new journal
                Intent new_Journal = new Intent(MainActivity.this, Journal.class);
                startActivityForResult(new_Journal, NEW_JOURNAL);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == NEW_JOURNAL) {
            //if (resultCode == OK_RESULT){
                Bundle extras = data.getExtras();
                int[] hold = extras.getIntArray("numbers");
                Entry new_Journal = new Entry(hold,selectedDate);
            //}
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
