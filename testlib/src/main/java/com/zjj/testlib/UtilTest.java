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

    // 饿汉式
    public static class Singleton {
        private static final Singleton INS = new Singleton();
        private Singleton() {

        }
        public static Singleton getIns() {
            return INS;
        }
    }
    // 懒汉式
    public static class Singleton1 {
        private Singleton1() {

        }
        public static Singleton1 getInstance() {
            return INS.ins;
        }

        private static class INS {
            private static final Singleton1 ins = new Singleton1();
        }
    }
    // 双重检查锁
    public static class Singleton2 {
        private static volatile Singleton2 mIns;
        private Singleton2() {

        }
        public static Singleton2 getInstance() {
            if (mIns ==null) {
                synchronized (Singleton2.class) {
                    if (mIns == null) {
                        mIns = new Singleton2();
                    }
                }
            }
            return mIns;
        }
    }
}
