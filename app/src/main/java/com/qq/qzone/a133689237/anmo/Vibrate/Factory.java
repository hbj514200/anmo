package com.qq.qzone.a133689237.anmo.Vibrate;

import android.animation.AnimatorSet;

public class Factory {

    public static long[] create(int flag){
        long[] one =   {1000, 1000};
        long[] two =   {2000, 2000};
        long[] three = {3000, 3000};
        long[] four =  {2000, 2000};
        long[] five =  {2000, 2000};
        long[] six =   {2000, 2000};
        long[] seven = {2000, 2000};

        if (flag == 1)      return one;
        if (flag == 2)      return two;
        if (flag == 3)      return three;
        if (flag == 4)      return four;
        if (flag == 5)      return five;
        if (flag == 6)      return six;
        if (flag == 7)      return seven;
        return one;
    }

}
