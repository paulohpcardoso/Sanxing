package io.github.celestialphineas.sanxing;

import java.util.Timer;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.konifar.fab_transformation.FabTransformation;

import java.util.TimerTask;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        // Get the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.calendar_toolbar);
        // Set the toolbar as the default action bar of the window
        setSupportActionBar(toolbar);
        // Disable the title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // Enable the back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Spinner
        AppCompatSpinner spinner = (AppCompatSpinner) findViewById(R.id.toolbar_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.calendar_spinner_array,
                R.layout.calendar_spinner);
        adapter.setDropDownViewResource(R.layout.spinner_items);
        spinner.setAdapter(adapter);
        // Fab and toggle footer navigation
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        final BottomNavigationView bottomNav = (BottomNavigationView) findViewById(R.id.calendar_bottom_navigation);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FabTransformation.with(fab).transformTo(bottomNav);
                // Automatic close after a few seconds
                TimerTask closeBottomNav = new TimerTask() {
                    @Override
                    public void run() {
                        try {
                            if(fab.getVisibility() != View.VISIBLE)
                                FabTransformation.with(fab).transformFrom(bottomNav);
                        } catch(Exception e) {
                            // Do nothing
                        }
                    }
                };
                Timer timer = new Timer();
                // Navigation toggle timeout
                timer.schedule(closeBottomNav, 5000);
            }
        });
    }
}