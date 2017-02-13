package com.qq.qzone.a133689237.anmo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.qzone.a133689237.anmo.Ad.Adbanner;
import com.qq.qzone.a133689237.anmo.Vibrate.Factory;
import com.qq.qzone.a133689237.anmo.Vibrate.VibratorUtil;
import com.google.android.gms.ads.AdView;
import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends Activity implements View.OnClickListener {

    private static VibratorUtil vib;          //震动管理器
    public int zhonglei  = 1;                 //震动类型
    private boolean vibing = false;           //是否在震动
    private ImageView controlButton;
    private TextView modeText;
    private AVLoadingIndicatorView avlView;
    private ChooseModeFragment dialog = new ChooseModeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        vib = new VibratorUtil(this);
        adBanner();
        Factory.mContext = this;
        borad();
    }

    private void initView(){
        ImageView closeButton = (ImageView) findViewById(R.id.main_close_button);
        closeButton.setOnClickListener(this);
        ImageView menuButton = (ImageView) findViewById(R.id.main_menu_button);
        menuButton.setOnClickListener(this);
        controlButton = (ImageView) findViewById(R.id.main_control_button);
        controlButton.setOnClickListener(this);
        ImageView chooseButton = (ImageView) findViewById(R.id.main_choose_button);
        chooseButton.setOnClickListener(this);
        modeText = (TextView) findViewById(R.id.main_mode_text);
        avlView = (AVLoadingIndicatorView) findViewById(R.id.main_avi);
        avlView.hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_close_button :
                vib.cancel();
                System.exit(0);
                break;
            case R.id.main_menu_button :
                startActivity(new Intent(MainActivity.this, guanyuActivity.class));
                break;
            case R.id.main_control_button :
                if (vibing)     stop();
                else            start();
                break;
            case R.id.main_choose_button :
                stop();
                dialog.mMainActivity = this;
                dialog.show(getFragmentManager(), "CHOOSE_MODE");
                break;
        }
    }

    public void changeMode(int flag){
        zhonglei = flag;
        modeText.setText( Factory.getName(flag) );
        if (vibing)     start();
    }

    private void start(){
        vib.Vibrate(Factory.create(zhonglei));
        vibing = true;
        controlButton.setImageResource(R.drawable.main_stop_button);
        avlView.show();
    }

    private void stop(){
        vib.cancel();
        vibing = false;
        controlButton.setImageResource(R.drawable.main_start_button);
        avlView.hide();
    }

    public void borad(){
        //防止熄屏停止震动
        BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
                    synchronized (vib) {
                        if (vibing){
                            vib.cancel();
                            vib.Vibrate(Factory.create(zhonglei));
                        }
                    }
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(mIntentReceiver, filter);
    }

    private void adBanner(){
        AdView mAdView = (AdView) findViewById(R.id.adView);
        new Adbanner(mAdView, 25000, 60000);
    }

}
