package com.adjustedAvgTest;

import com.example.adjustedAvg.adjustedAverage;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdjustedAverageOverflowTest {

    @Test
    public void testAllIntegerMaxValues() {
        int[] nums = {
            Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
            Integer.MAX_VALUE, Integer.MAX_VALUE
        };
        // After removing one min and one max (same value), remaining 3 values = Integer.MAX_VALUE
        double expected = Integer.MAX_VALUE;
        assertEquals(expected, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testAllIntegerMinValues() {
        int[] nums = {
            Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE,
            Integer.MIN_VALUE, Integer.MIN_VALUE
        };
        // After removing one min and one max (same value), remaining 3 values = Integer.MIN_VALUE
        double expected = Integer.MIN_VALUE;
        assertEquals(expected, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testMixedLargePositiveAndNegative() {
        int[] nums = {
            Integer.MAX_VALUE, Integer.MIN_VALUE, 100, 200, 300
        };
        // Remove Integer.MAX and Integer.MIN, remaining = [100, 200, 300] => avg = 200.0
        double expected = 200.0;
        assertEquals(expected, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testNearOverflowSum() {
        int[] nums = new int[100000];
        Arrays.fill(nums, Integer.MAX_VALUE);  // Fill very large array with Integer.MAX_VALUE
        nums[0] = Integer.MIN_VALUE;  // Force a very negative min
        // Remove Integer.MIN_VALUE and Integer.MAX_VALUE => remaining 99,998 values of Integer.MAX_VALUE
        double result = adjustedAverage.findAverage(nums);
        assertTrue(result > 0);
    }

    @Test
    public void testLongOverflowEdgeCase() {
        int[] nums = new int[3];
        nums[0] = Integer.MAX_VALUE;
        nums[1] = Integer.MAX_VALUE;
        nums[2] = Integer.MIN_VALUE;
        // Remove max and min → remaining = Integer.MAX_VALUE
        double expected = Integer.MAX_VALUE;
        assertEquals(expected, adjustedAverage.findAverage(nums));
    }
}