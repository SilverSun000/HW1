package com.adjustedAvgTest;

import com.example.adjustedAvg.adjustedAverage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdjustedAverageTest {

    @Test
    public void testTypicalCase() {
        int[] nums = {1, 2, 3, 4, 5};
        // Remove 1 and 5, average of [2, 3, 4] => 3.0
        assertEquals(3.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testWithDuplicates() {
        int[] nums = {1, 1, 2, 3, 4, 5, 5};
        // Remove one 1 and one 5 => sum of [1,2,3,4,5] = 15, avg = 15 / 5 = 3.0
        assertEquals(3.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testAllSameValues() {
        int[] nums = {5, 5, 5, 5, 5};
        // After removing one min and one max (both 5), avg = (5+5+5)/3 = 5.0
        assertEquals(5.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testNegativeValues() {
        int[] nums = {-10, -5, 0, 5, 10};
        // Remove -10 and 10, avg of [-5, 0, 5] = 0.0
        assertEquals(0.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testAllNegativeValues() {
        int[] nums = {-10, -5, 0, -5, -10};
        // Remove -10 and 10, avg of [-5, 0, 5] = -6.67
        assertEquals(-6.67, adjustedAverage.findAverage(nums), 0.01);
    }

    @Test
    public void testShortArrayLengthTwo() {
        int[] nums = {1, 2};
        // Not enough values after removing min and max => return 0
        assertEquals(0.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testShortArrayLengthOne() {
        int[] nums = {5};
        // Not enough values after removing the only int => return 0
        assertEquals(0.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testEmptyArray() {
        int[] nums = {};
        // Not enough values => return 0
        assertEquals(0.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testMinAndMaxAreSame() {
        int[] nums = {3, 3, 3, 3, 3};
        // Remove two 3s, avg = (3+3+3)/3 = 3.0
        assertEquals(3.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testMultipleMinMax() {
        int[] nums = {1, 1, 1, 5, 5, 5, 3};
        // Remove one 1 and one 5 => remaining [1,1,5,5,3] => sum = 15, avg = 15/5 = 3.0
        assertEquals(3.0, adjustedAverage.findAverage(nums));
    }

    @Test
    public void testDecimalAverage() {
        int[] nums = {1, 2, 2, 3, 4};
        // Remove 1 and 4 => [2,2,3] => avg = 2.33...
        assertEquals(2.33, adjustedAverage.findAverage(nums), 0.01); // Allowing small margin for double comparison
    }
}
