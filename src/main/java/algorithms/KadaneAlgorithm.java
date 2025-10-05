import java.util.Arrays;

public class KadaneAlgorithm {
    
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
    
    public Result findMaximumSubarray(int[] nums) {
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
    
    public int findMaximumSubarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
}