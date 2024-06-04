package com.zjj.testlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
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
        System.out.println("-------------");
        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 12);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY )+ "," + calendar.get(Calendar.MINUTE));
//        calendar.add(Calendar.MINUTE,30);
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY )+ "," + calendar.get(Calendar.MINUTE));
//        calendar.add(Calendar.MINUTE,30);
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY )+ "," + calendar.get(Calendar.MINUTE));
//        calendar.add(Calendar.MINUTE,30);
//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY )+ "," + calendar.get(Calendar.MINUTE));
        ArrayList<String> listAdd = new ArrayList<>(Arrays.asList("0","1","2","3","4"));
        listAdd.add(1,"x");
        listAdd.add(1,"y");
        System.out.println(listAdd);
        final String pat = "\\*#hp#\\*";
        String patternStr = "123123" + pat +"456456";
        String[] split = patternStr.split(pat);
        for (String s : split) {
            System.out.println(s);

        }

    }

}