package com.qq.qzone.a133689237.anmo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.qq.qzone.a133689237.anmo.Vibrate.VibratorUtil;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        ImageView closeButton = (ImageView) findViewById(R.id.main_close_button);
        closeButton.setOnClickListener(this);
        ImageView menuButton = (ImageView) findViewById(R.id.main_menu_button);
        menuButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_close_button :
                VibratorUtil.cancel(this);
                System.exit(0);
                break;
            case R.id.main_menu_button :
                startActivity(new Intent(MainActivity.this, guanyuActivity.class));
                break;
        }
    }

}
