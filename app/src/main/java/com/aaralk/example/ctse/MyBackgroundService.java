package com.aaralk.example.ctse;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyBackgroundService extends Service {

    private final static String TAG = "Lifecycle_watch_service";

    public MyBackgroundService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG,"Lifecycle Event: onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"Lifecycle Event: onDestroy");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String state = intent == null ? "Null Intent" : "Not Null Intent";

        Log.i(TAG,"Lifecycle Event: onStartCommand " + state);
        return START_REDELIVER_INTENT;
    }

}
