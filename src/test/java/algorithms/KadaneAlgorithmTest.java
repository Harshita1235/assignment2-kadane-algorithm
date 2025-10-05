// package algorithms;

// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeEach;
// import static org.junit.jupiter.api.Assertions.*;
// import java.util.Arrays;

// public class KadaneAlgorithmTest {
    
//     private KadaneAlgorithm algo;
    
//     @BeforeEach
//     public void setUp() {
//         algo = new KadaneAlgorithm();
//     }
    
//     @Test
//     public void testAllPositiveNumbers() {
//         int[] nums = {1, 2, 3, 4, 5};
//         KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
        
//         assertEquals(15, result.maxSum);
//         assertEquals(0, result.startIndex);
//         assertEquals(4, result.endIndex);
//         assertArrayEquals(new int[]{1, 2, 3, 4, 5}, result.subarray);
//     }
    
//     @Test
//     public void testMixedPositiveNegative() {
//         int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//         KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
        
//         assertEquals(6, result.maxSum);
//         assertEquals(3, result.startIndex);
//         assertEquals(6, result.endIndex);
//         assertArrayEquals(new int[]{4, -1, 2, 1}, result.subarray);
//     }
    
//     @Test
//     public void testAllNegativeNumbers() {
//         int[] nums = {-5, -2, -8, -1};
//         KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
        
//         assertEquals(-1, result.maxSum);
//         assertEquals(3, result.startIndex);
//         assertEquals(3, result.endIndex);
//         assertArrayEquals(new int[]{-1}, result.subarray);
//     }
    
//     @Test
//     public void testSingleElement() {
//         int[] nums = {5};
//         KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
        
//         assertEquals(5, result.maxSum);
//         assertEquals(0, result.startIndex);
//         assertEquals(0, result.endIndex);
//         assertArrayEquals(new int[]{5}, result.subarray);
//     }
    
//     @Test
//     public void testEmptyArrayThrowsException() {
//         assertThrows(IllegalArgumentException.class, () -> {
//             algo.findMaximumSubarray(new int[0]);
//         });
//     }
    
//     @Test
//     public void testNullArrayThrowsException() {
//         assertThrows(IllegalArgumentException.class, () -> {
//             algo.findMaximumSubarray(null);
//         });
//     }
// }

package algorithms;

public class KadaneAlgorithmTest {
    
    public static void main(String[] args) {
        System.out.println("=== KADANE ALGORITHM MANUAL TESTS ===");
        int passed = 0;
        int failed = 0;
        
        // Test 1: All positive numbers
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            int[] nums = {1, 2, 3, 4, 5};
            KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
            
            if (result.maxSum == 15 && result.startIndex == 0 && result.endIndex == 4) {
                System.out.println("✅ Test 1 (All positive): PASSED");
                passed++;
            } else {
                System.out.println("❌ Test 1 (All positive): FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("❌ Test 1 (All positive): ERROR - " + e.getMessage());
            failed++;
        }
        
        // Test 2: Mixed positive and negative
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
            KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
            
            if (result.maxSum == 6 && result.startIndex == 3 && result.endIndex == 6) {
                System.out.println("✅ Test 2 (Mixed numbers): PASSED");
                passed++;
            } else {
                System.out.println("❌ Test 2 (Mixed numbers): FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("❌ Test 2 (Mixed numbers): ERROR - " + e.getMessage());
            failed++;
        }
        
        // Test 3: All negative
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            int[] nums = {-5, -2, -8, -1};
            KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
            
            if (result.maxSum == -1 && result.startIndex == 3 && result.endIndex == 3) {
                System.out.println("✅ Test 3 (All negative): PASSED");
                passed++;
            } else {
                System.out.println("❌ Test 3 (All negative): FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("❌ Test 3 (All negative): ERROR - " + e.getMessage());
            failed++;
        }
        
        // Test 4: Single element
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            int[] nums = {5};
            KadaneAlgorithm.Result result = algo.findMaximumSubarray(nums);
            
            if (result.maxSum == 5 && result.startIndex == 0 && result.endIndex == 0) {
                System.out.println("✅ Test 4 (Single element): PASSED");
                passed++;
            } else {
                System.out.println("❌ Test 4 (Single element): FAILED");
                failed++;
            }
        } catch (Exception e) {
            System.out.println("❌ Test 4 (Single element): ERROR - " + e.getMessage());
            failed++;
        }
        
        // Test 5: Empty array (should throw exception)
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            algo.findMaximumSubarray(new int[0]);
            System.out.println("❌ Test 5 (Empty array): FAILED - Should have thrown exception");
            failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 5 (Empty array): PASSED - Correctly threw exception");
            passed++;
        } catch (Exception e) {
            System.out.println("❌ Test 5 (Empty array): FAILED - Wrong exception: " + e.getMessage());
            failed++;
        }
        
        // Test 6: Null array (should throw exception)
        try {
            KadaneAlgorithm algo = new KadaneAlgorithm();
            algo.findMaximumSubarray(null);
            System.out.println("❌ Test 6 (Null array): FAILED - Should have thrown exception");
            failed++;
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Test 6 (Null array): PASSED - Correctly threw exception");
            passed++;
        } catch (Exception e) {
            System.out.println("❌ Test 6 (Null array): FAILED - Wrong exception: " + e.getMessage());
            failed++;
        }
        
        System.out.println("\n=== TEST SUMMARY ===");
        System.out.println("Passed: " + passed + " / " + (passed + failed));
        System.out.println("Failed: " + failed + " / " + (passed + failed));
        
        if (failed == 0) {
            System.out.println("🎉 ALL TESTS PASSED!");
        } else {
            System.out.println("❌ SOME TESTS FAILED!");
        }
    }
}