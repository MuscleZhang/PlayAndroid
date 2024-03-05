package com.zjj.testlib;

import java.util.List;

/**
 * 泛型 测试
 *
 * @author zhangjiajun
 * @since 2024/2/22
 */
public class GenericTest {

    public static class BaseBean {
        public String name = "base";
    }

    public static class BeanA extends BaseBean {
        public String name = "A";
    }

    public static class BeanB extends BaseBean {
        public String name = "B";
    }

    public static class Adapter<T> {

        public List<T> data;

        public void registerProvider(Provider provider){
            provider.adapter = this;
        }
    }
    public static class Provider<T> {
        public Adapter<T> adapter;

        public void printName() {
            System.out.println(adapter.data);
        }
    }
}
