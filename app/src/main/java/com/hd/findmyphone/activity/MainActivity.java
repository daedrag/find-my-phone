package com.hd.findmyphone.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hd.findmyphone.R;
import com.hd.findmyphone.service.PhoneStateChangeService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnEnableLocation = (Button) findViewById(R.id.btnEnableLocation);
        btnEnableLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneStateChangeService.startActionEnableLocation(getApplicationContext());
            }
        });

        Button btnDisableLocation = (Button) findViewById(R.id.btnDisableLocation);
        btnDisableLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneStateChangeService.startActionDisableLocation(getApplicationContext());
            }
        });

        Button btnEnableWifi = (Button) findViewById(R.id.btnEnableWifi);
        btnEnableWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneStateChangeService.startActionEnableWifi(getApplicationContext());
            }
        });

        Button btnDisableWifi = (Button) findViewById(R.id.btnDisableWifi);
        btnDisableWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PhoneStateChangeService.startActionDisableWifi(getApplicationContext());
            }
        });

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
