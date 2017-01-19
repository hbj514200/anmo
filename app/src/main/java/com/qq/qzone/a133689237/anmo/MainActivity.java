package com.qq.qzone.a133689237.anmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.qq.qzone.a133689237.anmo.Ad.AdUtil;
import com.qq.qzone.a133689237.anmo.Vibrate.Factory;
import com.qq.qzone.a133689237.anmo.Vibrate.VibratorUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    private static VibratorUtil vib;
    public int zhonglei  = 1;                 //震动类型
    private boolean vibing = false;           //是否在震动

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
        ImageView controlButton = (ImageView) findViewById(R.id.main_control_button);
        controlButton.setOnClickListener(this);

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
        }
    }

    public void changeMode(int flag){
        zhonglei = flag;
        stop();
        start();
    }

    private void start(){
        //换成方形
        vib.Vibrate(Factory.create(1));
        vibing = true;
    }

    private void stop(){
        //换成圆心
        vib.cancel();
        vibing = false;
    }


}
