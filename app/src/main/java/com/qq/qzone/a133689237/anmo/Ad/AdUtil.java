package com.qq.qzone.a133689237.anmo.Ad;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class AdUtil {

    private InterstitialAd mInterstitialAd;
    private Handler myHandler =  new Handler(){
        @Override
        public void handleMessage(Message msg) {
            showInterstitial();
            super.handleMessage(msg);
        }
    };

    public AdUtil(Context context) {
        mInterstitialAd = newInterstitialAd(context);
        loadInterstitial();
        dinshi();
    }

    private InterstitialAd newInterstitialAd(Context context) {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId("ca-app-pub-6630898560544189/2911375352");
        return interstitialAd;
    }

    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded())
            mInterstitialAd.show();
    }

    private void loadInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }

    private void dinshi(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(40000); } catch (Exception e) { }
                myHandler.sendMessage(new Message());
            }
        }).start();
    }

}
