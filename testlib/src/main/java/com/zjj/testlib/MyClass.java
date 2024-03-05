package com.zjj.testlib;

import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        GenericTest.Adapter<GenericTest.BaseBean> adapter = new GenericTest.Adapter<>();
        adapter.data = new ArrayList<>();
        adapter.data.add(new GenericTest.BeanA());
        adapter.data.add(new GenericTest.BeanB());
        adapter.data.add(new GenericTest.BeanB());
        GenericTest.Provider<GenericTest.BeanA> provider = new GenericTest.Provider<>();
        adapter.registerProvider(provider);
        provider.printName();
        List<? extends GenericTest.BaseBean> list = provider.adapter.data;
        System.out.println(list.get(0).name);
        for (GenericTest.BaseBean baseBean : list) {
            System.out.println(baseBean.name);
        }
//        for (GenericTest.BaseBean datum : provider.adapter.data) {
//            System.out.println(datum.name);
//        }
        System.out.println("-------------");
        System.out.println(provider.adapter.data);
    }

}