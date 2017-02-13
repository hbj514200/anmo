package com.qq.qzone.a133689237.anmo.Ad;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
/**
 *    参数AdView获取的方法：AdView mAdView = (AdView) findViewById(R.id.adView);
 *    使用方法：直接new就可以了
 */

public class Adbanner {
    private AdView mAdView;
    private Handler myHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what==1)    show();
            if (msg.what==2)    mAdView.setVisibility(View.GONE);
            return true;
        }
    });

    public Adbanner(AdView mAdView, int yanchi, int gone){
        this.mAdView = mAdView;
        dinshi(yanchi, gone);
    }

    private void dinshi(final int time, final int gone){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(time); } catch (Exception e){}
                Message message1 = new Message();   message1.what = 1;
                myHandler.sendMessage(message1);
                try { Thread.sleep(gone); } catch (Exception e){}
                Message message2 = new Message();   message2.what = 2;
                myHandler.sendMessage(message2);
            }
        }).start();
    }

    private void show(){
        AdRequest adRequest = new AdRequest.Builder().build();
        try {
            mAdView.loadAd(adRequest);
        } catch (Exception e){
            Log.i("AdBanner", "banner广告异常");
        }
    }

}
