package com.qq.qzone.a133689237.anmo.Vibrate;

import android.content.Context;

import com.qq.qzone.a133689237.anmo.R;

public class Factory {

    public static Context mContext;

    public static long[] create(int flag){
        long[] one =   {0, 1000, 0, 1000};
        long[] two =   {1000, 800, 1000, 800};
        long[] three = {500, 300, 500, 300};
        long[] four =  {3000, 1000, 3000, 1000};

        if (flag == 1)      return one;
        if (flag == 2)      return two;
        if (flag == 3)      return three;
        if (flag == 4)      return four;
        return one;
    }

    public static String getName(int flag){
        String one = mContext.getString(R.string.one_mode);
        String two = mContext.getString(R.string.two_mode);
        String three = mContext.getString(R.string.three_mode);
        String four = mContext.getString(R.string.four_mode);
        if (flag == 1)      return one;
        if (flag == 2)      return two;
        if (flag == 3)      return three;
        if (flag == 4)      return four;
        return one;
    }

}
