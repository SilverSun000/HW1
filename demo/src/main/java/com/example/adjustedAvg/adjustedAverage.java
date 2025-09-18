package com.example.adjustedAvg;

public class adjustedAverage {
    public static double findAverage(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }

        // long type to help with majority of integer overflow cases
        long min = nums[0], max = nums[0];
        long adjustedAvg = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) { max = nums[i]; }
            if (nums[i] < min) { min = nums[i]; }

            adjustedAvg += nums[i];
        }

        return (adjustedAvg - (min + max)) / (double)(nums.length - 2);
    }
}