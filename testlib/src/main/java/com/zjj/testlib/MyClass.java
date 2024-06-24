package com.zjj.testlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public class MyClass {

    public static void main(String[] args) {

        // 数组为null场景， 循环
        List<String> arr = new ArrayList<>();
        arr = null;
        for (String s : arr) {
            System.out.println(s);
        }
        // 闹钟权限

//        for (int i = 0; i < 10; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    UtilTest.run();
//                }
//            }).start();
//        }
        // 多线程操作静态方法
//        // hashmap remove后 key为null，但是仍然存在在map中
//        LinkedHashMap<String, String> interviewVideoMap = new LinkedHashMap<String, String>(10, 0.75f, true);
//        interviewVideoMap.put("1", "1v");
//        interviewVideoMap.put("2", "2v");
//        interviewVideoMap.remove("1");
//        for (String s : interviewVideoMap.keySet()) {
//            System.out.println(s);
//        }
//        // calendar 设置 0
//        Calendar calendar = Calendar.getInstance(Locale.getDefault());
//        calendar.setTimeInMillis(0);
//        System.out.println(calendar.getTime());

//        // 使用｜ split
//        String b = "\\|";
//        String a = "GS (2023)551号 | GS (2023)2175号";
//        String[] split = a.split(b);
//        System.out.println(split.length);

//        GenericTest.Adapter<GenericTest.BaseBean> adapter = new GenericTest.Adapter<>();
//        adapter.data = new ArrayList<>();
//        adapter.data.add(new GenericTest.BeanA());
//        adapter.data.add(new GenericTest.BeanB());
//        adapter.data.add(new GenericTest.BeanB());
//        GenericTest.Provider<GenericTest.BeanA> provider = new GenericTest.Provider<>();
//        adapter.registerProvider(provider);
//        provider.printName();
//        List<? extends GenericTest.BaseBean> list = provider.adapter.data;
//        System.out.println(list.get(0).name);
//        for (GenericTest.BaseBean baseBean : list) {
//            System.out.println(baseBean.name);
//        }
//        for (GenericTest.BaseBean datum : provider.adapter.data) {
//            System.out.println(datum.name);
//        }
//        System.out.println("-------------");
//        System.out.println(provider.adapter.data);
//        System.out.println("-------------");
//        Calendar calendar = Calendar.getInstance();
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

//        ArrayList<String> listAdd = new ArrayList<>(Arrays.asList("0","1","2","3","4"));
//        listAdd.add(1,"x");
//        listAdd.add(1,"y");
//        System.out.println(listAdd);
//        final String pat = "\\*#hp#\\*";
//        String patternStr = "123123" + pat +"456456";
//        String[] split = patternStr.split(pat);
//        for (String s : split) {
//            System.out.println(s);
//
//        }

    }

}