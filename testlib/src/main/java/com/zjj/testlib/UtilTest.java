package com.zjj.testlib;

/**
 * @author zhangjiajun
 * @since 2024/6/14
 */
public class UtilTest {
    public static void run() {
        final Data data = new Data();
        System.out.println(data);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(data.i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        System.out.println(data.i);

    }

    public static class Data {

        int i = 0;
    }
}
