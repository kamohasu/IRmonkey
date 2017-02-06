package com.avcmms.android.internship.irmonkey.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.avcmms.android.internship.irmonkey.R;

public class ConnectionReceiver extends BroadcastReceiver {

    Observer mObserver;

    ConnectionReceiver(Observer mObserver) {
        this.mObserver = mObserver;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info == null) {
            // disconnected
            mObserver.onDisconnect();
            Log.d("ConnectionReceiver", context.getString(R.string.toast_network_false));
        } else {
            // connected
            if (NetworkInfo.DetailedState.CONNECTED.equals((info.getDetailedState())) && mObserver != null) {
                Log.d("ConnectionReceiver", context.getString(R.string.toast_network_true));
                mObserver.onConnect();
            }
        }
    }

    interface Observer {
        void onConnect();

        void onDisconnect();
    }
}
