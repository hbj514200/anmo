package com.qq.qzone.a133689237.anmo.Vibrate;

import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

public class VibratorUtil {

    private static Vibrator vib;

    public VibratorUtil(Activity activity){
        vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
    }

    public void Vibrate(long[] pattern) {
        vib.vibrate(pattern, 0);
    }

    public void cancel() {
        vib.cancel();
    }

    public boolean hasVib(){
        return vib.hasVibrator();
    }

}

