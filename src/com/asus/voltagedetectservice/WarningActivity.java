package com.asus.voltagedetectservice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class WarningActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
        builder.setMessage(R.string.warningtext)
                  .setIcon(R.drawable.plug04)
                  .setTitle(R.string.warningtitle);
        builder.setPositiveButton(R.string.hide, new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int id) {
               finish();
           }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
