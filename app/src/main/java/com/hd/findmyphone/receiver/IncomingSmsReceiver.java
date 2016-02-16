package com.hd.findmyphone.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.hd.findmyphone.service.PhoneStateChangeService;

/**
 * Created by daoducduy0511 on 16/2/16.
 */
public class IncomingSmsReceiver extends BroadcastReceiver
{
    private final String CLASS_NAME = this.getClass().getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d(CLASS_NAME, "Received sms broadcast");
        PhoneStateChangeService.startActionEnableLocation(context);
    }

}
