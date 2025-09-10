package adjustedAVG;

public class adjustedAverage {
    public static double findAverage(int[] nums) {
        // define length to avoid checking in loop
        int length = nums.length;
        int total;

        // loop through given arr
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        
        //return adjusted average
        return total / length;
    }
}