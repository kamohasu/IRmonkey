package com.avcmms.android.internship.irmonkey.Controller;

import android.util.SparseArray;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.avcmms.android.internship.irmonkey.R;
import com.getirkit.irkit.IRKit;
import com.getirkit.irkit.net.IRDeviceAPIService;
import com.getirkit.irkit.net.IRHTTPClient;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import com.avcmms.android.internship.irmonkey.R;

/**
 * Created by ishida.yuta on 2016/01/30.
 */
public class IRkitController {
    SparseArray<Integer[]> mSparseArray = new SparseArray<Integer[]>();
    private int[] ircmd;
    protected void init() {
        mSparseArray = new SparseArray<Integer[]>();
        ircmd = new int[]{};

        // cnl 1
        mSparseArray.put(R.id.btn_cnl1,new Integer[]{6881,3341,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,873,873,2537,873,873,873,873,873,2537,873,2537,873});
        // cnl 2
        mSparseArray.put(R.id.btn_cnl2,new Integer[]{6881,3341,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,2537,873,2537,873,65535,0,65535,0,18662,6881,3341,904,815,815,2537,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,2537,873,2537,873});
        // cnl 3
        mSparseArray.put(R.id.btn_cnl3,new Integer[]{6881,3341,904,815,904,2537,904,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,2537,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,815,2537,815,2537,815,815,815,815,815,2537,815,815,815,815,815,815,815,815,815,815,815,2537,815,815,815,815,815,815,815,815,815,2537,815,815,815,2537,815,2537,815,815,815,2537,815,815,815,815,815,2537,815,2537,815});
        // cnl 4
        mSparseArray.put(R.id.btn_cnl4,new Integer[]{6881,3341,935,761,935,2451,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,2451,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,2451,935,2451,935,761,935,761,935,2451,935,761,935,761,935,761,935,761,935,2451,935,2451,935,761,935,761,935,761,935,761,935,2451,935,761,935,761,935,2451,935,761,935,2451,935,761,935,761,935,2451,935,2451,935,65535,0,65535,0,18031,6881,3341,935,761,935,2451,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,2451,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,761,935,2451,935,2451,935,761,935,761,935,2451,935,761,935,761,935,761,935,761,935,2451,935,2451,935,761,935,761,935,761,935,761,935,2451,935,761,935,761,935,2451,935,761,935,2451,935,761,935,761,935,2451,935,2451,935});
        // cnl 5
        mSparseArray.put(R.id.btn_cnl5,new Integer[]{6881,3341,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,2537,873,65535,0,65535,0,18031,6881,3341,904,815,815,2537,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,815,904,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,873,873,873,873,873,873,873,873,873,873,873,873,2537,873,873,873,873,873,873,873,2537,873,873,873,2537,873,873,873,2537,873,2537,873,873,873,873,873,2537,873,2537,873});
        // cnl 6
        mSparseArray.put(R.id.btn_cnl6,new Integer[]{});
        // cnl 7
        mSparseArray.put(R.id.btn_cnl7,new Integer[]{});
        // cnl 8
        mSparseArray.put(R.id.btn_cnl8,new Integer[]{});
        // cnl 9
        mSparseArray.put(R.id.btn_cnl9,new Integer[]{});
        // cnl 10
        mSparseArray.put(R.id.btn_cnl10,new Integer[]{});
        // cnl 11
        mSparseArray.put(R.id.btn_cnl11,new Integer[]{});
        // cnl 12
        mSparseArray.put(R.id.btn_cnl12,new Integer[]{});

    }

    public void onClick(View v){sendCommand(v.getId());}



    private void sendCommand(int id) {
        Integer integer[] = mSparseArray.get(id);
        int integerlen = integer.length;
        int[] data = new int[integerlen];

        for(int i = 0; i<integerlen; i++) {
            data[i] = integer[i].intValue();
        }

        IRHTTPClient httpClient = IRKit.sharedInstance().getHTTPClient();

        httpClient.setDeviceAPIEndpoint("http://192.168.111.9");
        IRDeviceAPIService deviceAPI = httpClient.getThrottledDeviceAPIService();

        IRDeviceAPIService.PostMessagesRequest req = new IRDeviceAPIService.PostMessagesRequest();
        req.format = "raw"; //固定
        req.freq = 38.0f; //固定
        req.data = data;

        deviceAPI.postMessages(req, new Callback<IRDeviceAPIService.PostMessagesResponse>() {
            @Override
            public void success(IRDeviceAPIService.PostMessagesResponse postMessagesResponse, Response response) {
                //Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                //Toast.makeText(getApplicationContext(), "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
