package com.zjj.testlib;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass {
//    public int trap(int[] height) {
//        int l = height.length;
//        int[][] w = new int[l][2];
//        int left = 0;
//        int right = 0;
//        for (int i = 0; i < l; i++) {
//            w[i][0] = left;
//            left = Math.max(left, height[i]);
//        }
//        for (int i = l - 1; i >= 0; i--) {
//            w[i][1] = right;
//            right = Math.max(right, height[i]);
//        }
//        int res = 0;
//        for (int i = 0; i < l; i++) {
//            int cur = height[i];
//            if (cur < w[i][0] && cur < w[i][1]) {
//                res += (Math.max(w[i][0], w[i][1]) - cur);
//            }
//        }
//        return res;
//    }

//     public class Claz {
//        public static int adda(String synca) {
//            int b = synca++;
//            return b;
//        }
//        public void a() {
//
//        }
//    }


    public interface A {
        void test();
    }
    public abstract class B implements A {

    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int p = Integer.MAX_VALUE;
        while(r <n) {
            if(sum < target) {
                sum +=nums[r];
                r++;
            } else {
                p = Math.min(p, r - l);
                sum -= nums[l];
                l++;
            }
        }
        return p == Integer.MAX_VALUE ?0:p;
    }
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int n = row;
        int start = 0;
        int end = n - 1;
        // int[][] dir =
        while(start < end) {
            for(int i = 0;i < end - start;i++) {
                int temp = matrix[start][start + i];
                matrix[start][start + i] = matrix[end - i][start];
                matrix[end- i][start] = matrix[end][end - i];
                matrix[end][end - i] = matrix[end][start + i];
                matrix[end][start + i] = temp;
            }
            start +=1;
            end -= 1;
        }

    }
    // 找到最大的回文子串
    // [1,3,5,2,4,6,7,11,8]
    /*
    a < b < c < d
    && aindex < b index <...
     */
    // [1,2,3,4,5,6,7,8,11]
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        int l = s.length();
        for(int i =0;i < l;i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(ct)) {

                if(map.get(ct) == cs) {
                    continue;
                } else {
                    return false;
                }
            } else {
                map.put(ct, cs);
            }
        }
        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode nh = new ListNode(-1, head);
        ListNode pre = nh;
        int cur = -101;
        ListNode p = head;
        while(p != null) {
            if(p.val == cur) {
                pre.next = p.next;
                pre = pre.next;
            } else {
                if(p.next != null && p.next.val == p.val) {
                    cur = p.val;
                    pre.next = p.next;
                } else {
                }
                pre = pre.next;
            }
            p = p.next;
        }
        return nh.next;
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode res = new ListNode(-1, head);
        ListNode pre = res;
        ListNode add = pre;
        ListNode largeHead = null;
        while(pre.next != null) {
            if(pre.next.val < x) {
                if(largeHead == null) {
                    pre = pre.next;
                } else {

                    add.next = pre.next;
                    pre.next = pre.next.next;
                    add.next.next = largeHead;

                }
            } else {
                if(largeHead == null) {
                    add = pre;
                    largeHead = pre.next;
                    pre = pre.next;
                } else {
                    pre = pre.next;
                }
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        PhantomReference<String> a = new PhantomReference<>();
        a.get();
        System.out.println(map.get(null));
//        ListNode head = new ListNode(1);
//        ListNode node1 = new ListNode(4);
//        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(2);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(2);
//        ListNode node6 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
////        node5.next = node6;
//        partition(head,3);
//        int a = 0;
//        int b = ~0;
//        System.out.println(a == b);
        //
//        MyClass cl = new MyClass();
////        int[][] req = {{1,2,3},{4,5,6},{7,8,9}};
//        cl.isIsomorphic("foo", "bar");

//        MyClass cl = new MyClass();
//        int[] req = {0,1,0,2,1,0,1,3,2,1,2,1};
//        System.out.println(cl.trap(req));
//        String a = new String("a");
//        String b = new String("a");
//        String c = "ab";
//        String d = a + "b";
//        String e = d.intern();
//        System.out.println(c == e);
//        System.out.println(c == d);
//        System.out.println(a == b);
//        System.out.println(a == c);
        // ArrayList如果一次添加很多元素， 是否还按照1.5倍扩容
//        ArrayList<Integer> a1 = new ArrayList<>();
//        List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
//        a1.addAll(list);
//        a1.add(2);
//        a1.add(2);
//        a1.add(2);
//        a1.add(2);
//        a1.add(2);
        // 逆变
//        List<? super Number> l1 = new ArrayList<Object>();
//        l1.add(1);
//        Object a = l1.get(1);

        // 协变
//        Integer[] ints = new Integer[2];
//        ints[0] = 1;
//        ints[1] = 2;
//        Number[] numbers = new Number[2];
//        numbers = ints;

        // 协变 & 泛型通配符 ? extends T类型的集合不能放T的子类, 只能放null
//        List<? extends Number> l1 = new ArrayList<>();
//        List<? extends Number> l2 = new ArrayList<>();
//        List<? extends Number> l3 = new ArrayList<Integer>();
//        List<? extends Number> l4 = new ArrayList<Float>();
//        List<Float> l5 = new ArrayList<>();
//        List<Number> l6 = new ArrayList<>();
//        l1 = l5;
//        l6.add(1);
//        l6.add(3.5f);


////        l1.add(new Integer(1)); // error
////        l3.add(1); // error
//        l1.add(null);

        // 数组为null场景， 循环
//        List<String> arr = new ArrayList<>();
//        arr = null;
//        for (String s : arr) {
//            System.out.println(s);
//        }
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