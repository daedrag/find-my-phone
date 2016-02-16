package com.hd.findmyphone.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.hd.findmyphone.service.PhoneStateChangeService;

public class WifiStateChangeReceiver extends BroadcastReceiver {
    private final String CLASS_NAME = this.getClass().getSimpleName();

    public WifiStateChangeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(CLASS_NAME, "Received WifiStateChange broadcast");
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
            PhoneStateChangeService.startActionEnableWifi(context);
        } else {
            PhoneStateChangeService.startActionDisableWifi(context);
        }
    }
}
