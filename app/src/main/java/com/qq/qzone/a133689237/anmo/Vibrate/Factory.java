package com.qq.qzone.a133689237.anmo.Vibrate;

public class Factory {

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
        String one = "一号震动模式";
        String two = "二号震动模式";
        String three = "三号震动模式";
        String four = "四号震动模式";
        if (flag == 1)      return one;
        if (flag == 2)      return two;
        if (flag == 3)      return three;
        if (flag == 4)      return four;
        return one;
    }

}
