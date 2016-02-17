package com.hd.findmyphone.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hd.findmyphone.R;
import com.hd.findmyphone.service.PhoneStateChangeService;
import com.hd.findmyphone.utils.NotificationUtil;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_RECEIVE_SMS = 0;

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

        requestPermissions(Manifest.permission.RECEIVE_SMS, PERMISSIONS_REQUEST_RECEIVE_SMS);
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

    private void requestPermissions(String permission, int requestCode) {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(this, "Granting permission is necessary!", Toast.LENGTH_LONG).show();

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{permission},
                        requestCode);

                // requestCode is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_RECEIVE_SMS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.INFO,
                            getResources().getString(R.string.app_name),
                            "Permission granted!");

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                    NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.ERROR,
                            getResources().getString(R.string.app_name),
                            "Permission denied! App not function correctly");
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
