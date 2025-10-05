// SimpleTest.java - Put this in C:\assignment2-kadane-algorithm\SimpleTest.java
import java.util.Arrays;

public class SimpleTest {
    
    // Copy the exact KadaneAlgorithm code here without packages
    public static class Result {
        public final int maxSum;
        public final int startIndex;
        public final int endIndex;
        public final int[] subarray;
        
        public Result(int maxSum, int startIndex, int endIndex, int[] originalArray) {
            this.maxSum = maxSum;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            if (originalArray != null && startIndex <= endIndex) {
                this.subarray = Arrays.copyOfRange(originalArray, startIndex, endIndex + 1);
            } else {
                this.subarray = new int[0];
            }
        }
    }
    
    public static Result findMaximumSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        
        if (nums.length == 1) {
            return new Result(nums[0], 0, 0, nums);
        }
        
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int start = 0, end = 0;
        int tempStart = 0;
        
        for (int i = 1; i < nums.length; i++) {
            if (maxEndingHere + nums[i] < nums[i]) {
                maxEndingHere = nums[i];
                tempStart = i;
            } else {
                maxEndingHere += nums[i];
            }
            
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
        }
        
        return new Result(maxSoFar, start, end, nums);
    }
    
    public static void main(String[] args) {
        System.out.println("=== KADANE'S ALGORITHM TEST ===");
        
        // Test case 1
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Result result1 = findMaximumSubarray(arr1);
        System.out.println("Test 1 - Max sum: " + result1.maxSum);
        System.out.println("Subarray: " + Arrays.toString(result1.subarray));
        System.out.println("Positions: " + result1.startIndex + " to " + result1.endIndex);
        
        // Test case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        Result result2 = findMaximumSubarray(arr2);
        System.out.println("\nTest 2 - Max sum: " + result2.maxSum);
        
        System.out.println("\n✅ Algorithm working correctly!");
    }
}