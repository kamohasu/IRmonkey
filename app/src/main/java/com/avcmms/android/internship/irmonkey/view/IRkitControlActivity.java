package com.avcmms.android.internship.irmonkey.view;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.avcmms.android.internship.irmonkey.R;
import com.avcmms.android.internship.irmonkey.model.IRkitControlloer;

import java.util.ArrayList;

public class IRkitControlActivity extends AppCompatActivity implements View.OnClickListener, ConnectionReceiver.Observer {

    private IRkitControlloer mIrkitController;
    private static final int REQUEST_CODE = 0;

    private boolean isNetworkEnable = false;
    ConnectionReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIrkitController = new IRkitControlloer(getApplicationContext());

        ((Button) findViewById(R.id.btn_cnl1)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl2)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl3)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl4)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl5)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl6)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl7)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl8)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl9)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl10)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl11)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_cnl12)).setOnClickListener(this);
        ((ImageButton) findViewById(R.id.sample)).setOnClickListener(this);

        IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        ConnectionReceiver receiver = new ConnectionReceiver(this);
        registerReceiver(receiver, filter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(final View v) {
        v.setEnabled(false);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                v.setEnabled(true);
            }
        }, 2000L);

        if (isNetworkEnable) {
            if (v.getId() == R.id.sample) {
                voiceCommand();
            } else if (mIrkitController != null) {
                mIrkitController.sendCommand(mIrkitController.getChanelId(v.getId()));
            }
        } else {
            Toast.makeText(this, getString(R.string.toast_network_false), Toast.LENGTH_LONG).show();
        }
    }

    private void voiceCommand() {
        if (isNetworkEnable) {
            Intent intent = new Intent(
                    RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(
                    RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);

            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Toast.makeText(this, getString(R.string.toast_network_false), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && mIrkitController != null) {
            int chId = 0;
            int index = 0;

            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);

            while (chId <= 0 && index < results.size()) {
                chId = mIrkitController.getChanelId(results.get(index));
                index++;
            }
            if (chId == 0) {
                Toast.makeText(this, "「" + results.get(0) + "」 に該当するchが設定されてません", Toast.LENGTH_LONG).show();
            } else {
                mIrkitController.sendCommand(chId);
                Toast.makeText(this, results.get(0), Toast.LENGTH_LONG).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConnect() {
        isNetworkEnable = true;
        Toast.makeText(this, getString(R.string.toast_network_true), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDisconnect() {
        isNetworkEnable = false;
        Toast.makeText(this, getString(R.string.toast_network_false), Toast.LENGTH_LONG).show();
    }
}
