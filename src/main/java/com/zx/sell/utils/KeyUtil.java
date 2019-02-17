package com.zx.sell.utils;

import java.util.Random;

public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式:时间+随机数
     * 多线程的时候还是会产生相同的订单号
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer a = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(a);
    }

    public static void main(String[] args) {
        String s = KeyUtil.genUniqueKey();
        System.out.println(s);
    }
}
