package com.josh.algorithm.solutions;

public class RopeLength {

    /**
     * 绳子覆盖最多的点数
     */

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 3, 5, 7, 9, 10, 55};
        System.out.println(maxPoint(inputArray, 4));
    }

    public static int maxPoint(int[] arr, int l) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= l) {
                right++;
            }
            max = Math.max(max, right - (left++));

        }
        return max;
    }

}
