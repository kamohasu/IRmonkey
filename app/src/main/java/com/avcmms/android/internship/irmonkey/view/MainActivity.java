package com.avcmms.android.internship.irmonkey.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.avcmms.android.internship.irmonkey.R;
import com.avcmms.android.internship.irmonkey.model.IRkitControlloer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private IRkitControlloer mIrkitController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        mIrkitController.sendCommand(v.getId());
    }
}
