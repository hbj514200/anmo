package com.qq.qzone.a133689237.anmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.qq.qzone.a133689237.anmo.Ad.AdUtil;
import com.qq.qzone.a133689237.anmo.Vibrate.Factory;
import com.qq.qzone.a133689237.anmo.Vibrate.VibratorUtil;
import com.wang.avi.AVLoadingIndicatorView;

public class MainActivity extends Activity implements View.OnClickListener {

    private static VibratorUtil vib;          //震动管理器
    private int zhonglei  = 1;                 //震动类型
    private boolean vibing = false;           //是否在震动
    private ImageView controlButton;
    private TextView modeText;
    private AVLoadingIndicatorView avlView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        vib = new VibratorUtil(this);
        new AdUtil(MainActivity.this);
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
                ChooseModeFragment dialog = new ChooseModeFragment();
                dialog.mMainActivity = this;
                dialog.show(getFragmentManager(), "CHOOSE_MODE");
                break;
        }
    }

    public void changeMode(int flag){
        zhonglei = flag;
        if (vibing)     start();
        modeText.setText( Factory.getName(flag) );
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

}
