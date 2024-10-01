package com.zjj.testlib;

public class Interview {
    public static void main(String[] args) {
        int[] test = new int[] {-12,10000,0,0,-20,10001010, 99992,28833,-1213,5,6,7,102};
        sort(test);
        for (int i : test) {
            System.out.println(i);
        }
    }

    private static void sort(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return;
        }
        backStackSort(nums, 0, len - 1);
    }
    private static void backStackSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        backStackSort(nums, start, mid);
        backStackSort(nums, mid + 1, end);
        merge(nums, start, mid, mid + 1, end);
    }
    private static void merge(int[] nums, int lStart, int lEnd, int rStart, int rEnd) {
        int[] temp = new int[rEnd - lStart + 1];
        int tIndex = 0;
        int lCur = lStart;
        int rCur = rStart;
        while (lCur <= lEnd && rCur <= rEnd) {
            int lC = nums[lCur];
            int rC = nums[rCur];
            if (lC < rC) {
                temp[tIndex++] = lC;
                lCur++;
            } else {
                temp[tIndex++] = rC;
                rCur++;
            }
        }
        while (lCur <= lEnd) {
            temp[tIndex++] = nums[lCur];
            lCur++;
        }
        while (rCur <= rEnd) {
            temp[tIndex++] = nums[rCur];
            rCur++;
        }
        for (int i = lStart; i <= rEnd; i++) {
            nums[i] = temp[i - lStart];
        }
    }

}
