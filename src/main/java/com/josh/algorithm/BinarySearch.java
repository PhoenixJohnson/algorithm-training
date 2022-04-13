package com.josh.algorithm;

public class BinarySearch {


    public static void main(String[] args) {

        int [] inputA = new int[]{1,4,6,7,99,120,456,888,1000};
        System.out.println("Index of your target number is: "+ BinarySearch_Recursive(inputA, 4,0,inputA.length));
    }


    private static int BinarySearch_Recursive(int[] inputArray, int target, int left, int right) {
        int mid = left + (right - left)/2;

        if(left>right) {
            return -1;
        }

        if(inputArray[mid] == target) {
            return mid;
        }

        if(inputArray[mid] < target) {
            return BinarySearch_Recursive(inputArray, target, mid+1, right);
        } else {
            return BinarySearch_Recursive(inputArray, target, left, mid-1);
        }
    }

}
