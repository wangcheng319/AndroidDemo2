package com.example.wangc.androiddemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by wangc on 2018/6/26
 * E-MAIL:274281610@QQ.COM
 */
public class AppInstallReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(Intent.ACTION_PACKAGE_ADDED)){
            Log.d("tag","app installed ");
        }else if(action.equals(Intent.ACTION_PACKAGE_REMOVED)){
            Log.d("tag","app uninstalled");
        }
    }

}
