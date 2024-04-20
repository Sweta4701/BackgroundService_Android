package com.example.startedservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartedService extends Service {

    private static final String TAG = "StartedService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service is started ");
    }

    public StartedService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int a=0;a<10;a++){
                    try{
                        Thread.sleep(5000);
                    }catch (Exception e){

                    }

                    Log.i(TAG, "Service has completed the task !!!" + Integer.toString(a));
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service is destroyed ");
    }
}