package com.example.jordan.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    private ToastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new ToastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.jordan.broadcast.TOAST");
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    public void send(View view){
        Intent intent = new Intent("com.example.jordan.broadcast.TOAST");
        intent.putExtra("msg", "Este toast e exibido pelo BroadcastReceiver");
        sendBroadcast(intent);
    }
}
