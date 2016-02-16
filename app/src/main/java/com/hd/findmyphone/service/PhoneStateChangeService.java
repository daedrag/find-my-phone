package com.hd.findmyphone.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;

import com.hd.findmyphone.R;
import com.hd.findmyphone.utils.NotificationUtil;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class PhoneStateChangeService extends IntentService {
    private final String CLASS_NAME = this.getClass().getSimpleName();

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_ENABLE_LOCATION = "com.example.daoducduy0511.myapplication.action.ENABLE_LOCATION";
    private static final String ACTION_DISABLE_LOCATION = "com.example.daoducduy0511.myapplication.action.DISABLE_LOCATION";
    private static final String ACTION_ENABLE_WIFI = "com.example.daoducduy0511.myapplication.action.ENABLE_WIFI";
    private static final String ACTION_DISABLE_WIFI = "com.example.daoducduy0511.myapplication.action.DISABLE_WIFI";

    public PhoneStateChangeService() {
        super("PhoneStateChangeService");
    }

    /**
     * Starts this service to perform action Enable Location Service
     */
    public static void startActionEnableLocation(Context context) {
        Intent intent = new Intent(context, PhoneStateChangeService.class);
        intent.setAction(ACTION_ENABLE_LOCATION);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Disable Location Service
     */
    public static void startActionDisableLocation(Context context) {
        Intent intent = new Intent(context, PhoneStateChangeService.class);
        intent.setAction(ACTION_DISABLE_LOCATION);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Enable Location Service
     */
    public static void startActionEnableWifi(Context context) {
        Intent intent = new Intent(context, PhoneStateChangeService.class);
        intent.setAction(ACTION_ENABLE_WIFI);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Disable Location Service
     */
    public static void startActionDisableWifi(Context context) {
        Intent intent = new Intent(context, PhoneStateChangeService.class);
        intent.setAction(ACTION_DISABLE_WIFI);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            switch (action) {
                case ACTION_ENABLE_LOCATION:
                    handleEnableLocation();
                    break;
                case ACTION_DISABLE_LOCATION:
                    handleDisableLocation();
                    break;
                case ACTION_ENABLE_WIFI:
                    handleEnableWifi();
                    break;
                case ACTION_DISABLE_WIFI:
                    handleDisableWifi();
                    break;
                default:
                    handleError("Unrecognized action");
            }
        }
    }

    private void handleEnableLocation() {
        NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.INFO,
                getResources().getString(R.string.app_name),
                "Success: Location service enabled");
    }

    private void handleDisableLocation() {
        NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.WARNING,
                getResources().getString(R.string.app_name),
                "Success: Location service disabled");
    }

    private void handleEnableWifi() {
        NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.INFO,
                getResources().getString(R.string.app_name),
                "Success: Wifi enabled");
    }

    private void handleDisableWifi() {
        NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.WARNING,
                getResources().getString(R.string.app_name),
                "Success: Wifi disabled");
    }

    private void handleError(String message) {
        NotificationUtil.getInstance().show(this, NotificationUtil.CONTENT_TYPE.ERROR,
                getResources().getString(R.string.app_name),
                "Error: " + message);
    }
}
