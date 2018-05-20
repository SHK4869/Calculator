package com.example.humaira.practice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService extends Service {
    int count;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        while(count>=0){
        if(count%100 == 0)
            count++;
        Toast.makeText(this, new Integer(count).toString(), Toast.LENGTH_LONG).show();}
        return START_STICKY;
    }

    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, new Integer(count).toString(), Toast.LENGTH_LONG).show();
    }
}
