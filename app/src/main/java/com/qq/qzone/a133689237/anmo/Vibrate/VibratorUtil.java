package com.qq.qzone.a133689237.anmo.Vibrate;

import android.app.Activity;
import android.app.Service;
import android.os.Vibrator;

public class VibratorUtil {

    public static void Vibrate(Activity activity, long[] pattern) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.vibrate(pattern, 0);
    }

    public static void cancel(Activity activity) {
        Vibrator vib = (Vibrator) activity.getSystemService(Service.VIBRATOR_SERVICE);
        vib.cancel();
    }

}

