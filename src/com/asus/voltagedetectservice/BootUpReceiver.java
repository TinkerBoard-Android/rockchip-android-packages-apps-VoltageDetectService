package com.asus.voltagedetectservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BootUpReceiver extends BroadcastReceiver {
    private final String TAG = "VoltageDetectService";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            try {
                InputStream boardinfoIstream = Runtime.getRuntime().exec("cat /proc/board_info").getInputStream();
                InputStreamReader boardinfoIstreamReader = new InputStreamReader(boardinfoIstream);
                BufferedReader boardinfoBufReader = new BufferedReader(boardinfoIstreamReader);
                String boardName = boardinfoBufReader.readLine();

                if (boardName.equals("Tinker Board S")) {
                    Log.i(TAG, "Start VoltageDetectService");

                    Intent serviceIntent = new Intent(context, VoltageDetectService.class);
                    context.startService(serviceIntent);
                }

                boardinfoBufReader.close();
            } catch (IOException e) {
                Log.e(TAG, "Error detail", e);
            }
        }
    }
}
