package com.hd.findmyphone.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import com.hd.findmyphone.R;

/**
 * Created by daoducduy0511 on 16/2/16.
 * ref: http://developer.android.com/guide/topics/ui/notifiers/notifications.html
 */
public class NotificationUtil {
    public enum CONTENT_TYPE {
        INFO, WARNING, ERROR
    }

    private static NotificationUtil ourInstance = new NotificationUtil();

    public static NotificationUtil getInstance() {
        return ourInstance;
    }

    private int notificationId;

    private NotificationUtil() {
        notificationId = 0;
    }

    public void show(Context context, CONTENT_TYPE type, String title, String message) {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message);

        switch (type) {
            case INFO:
                mBuilder = mBuilder.setSmallIcon(R.drawable.ic_info_outline_black_24dp);
                break;
            case WARNING:
                mBuilder = mBuilder.setSmallIcon(R.drawable.ic_highlight_off_black_24dp);
                break;
            case ERROR:
            default:
                mBuilder = mBuilder.setSmallIcon(R.drawable.ic_report_problem_black_24dp);
        }

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        // Id allows you to update the notification later on.
        mNotificationManager.notify(notificationId, mBuilder.build());

        // Increase notification id to avoid override on the same notification
        notificationId++;
    }
}
