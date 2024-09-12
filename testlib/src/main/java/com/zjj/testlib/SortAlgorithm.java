package com.zjj.testlib;

import java.util.Arrays;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 6, 8};
//        int[] expectedArr = {1, 2, 3, 5, 6, 8};
        hep(arr);
        System.out.println("arr = " + Arrays.toString(arr));
    }
    // 堆排序
    public static void hep(int[] arr) {
        int len = arr.length;
        for(int i = len / 2;i >=0;i--) {
            buildHeap(arr, i, len);
        }
        for(int i = len - 1;i >=0;i--) {
            swap(arr, 0, i);
            len--;
            buildHeap(arr, 0, len);
        }
    }
    public static void buildHeap(int[] arr, int root, int size) {
        int max = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if(left < size && arr[left] > arr[max]) {
            max = left;
        }
        if(right < size && arr[right] > arr[max]) {
            max = right;
        }
        if(max != root) {
            swap(arr, max, root);
            buildHeap(arr, max, size);
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // 快排
    public static void quick(int[] arr) {
        int l = arr.length;
        int start = 0;
        int end = l - 1;
        quickutil(arr, start, end);
    }
    private static void quickutil (int[] arr, int start, int end) {
        if(start > end) {
            return;
        }
        int s = start;
        int e = end;
        int cur = arr[start];
        while (s < e) {
            while(s < e && arr[e] >= cur) {
                e--;
            }
            while(s < e && arr[s] <= cur) {
                s++;
            }
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
        }
        arr[start] = arr[s];
        arr[s] = cur;
        quickutil(arr, start, s-1);
        quickutil(arr, s+1,end );
    }

    // 希尔排序
    public static void shell(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        while(gap > 0) {
            for(int i = gap;i < len;i++) {
                int cur = arr[i];
                int pre = i - gap;
                while(pre >=0 && arr[pre] > cur) {
                    arr[pre + gap] = arr[pre];
                    pre -= gap;
                }
                arr[pre + gap] = cur;
            }
            gap /= 2;
        }
    }
    // 二分插入
    public static void erfen(int[] arr) {
        int len =arr.length;
        for(int i = 1;i < len;i++) {
            int cur = arr[i];
            int l = 0;
            int r = i - 1;
            int min = i;
            while(l <=r) {
                int mid = (l +r) / 2;
                if(arr[mid] > arr[i]) {
                    r = mid - 1;
                    min = mid;
                } else {
                    l = mid + 1;
                }
            }
            for (int j = i; j >min && j >=1; j--) {
                arr[j] = arr[j - 1];
            }
            arr[min] = cur;

        }
    }
    // 插入排序
    public static void insert(int[] arr) {
        int l = arr.length;
        for(int i = 1;i < l;i++) {
            int cur = arr[i];
            int j = i;
            while(j >0 && cur < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j + 1] = cur;
        }
    }
     // 选择排序
    public static void select(int[] arr) {
        int l = arr.length;
        for (int i = 0; i < l - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < l; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    // 冒泡
    public static void maopao(int[] arr) {
        int l = arr.length;
        int temp = 0;
        for(int i = 0 ;i < l - 1;i++) {
            for(int j = 0;j<l - i - 1;j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
