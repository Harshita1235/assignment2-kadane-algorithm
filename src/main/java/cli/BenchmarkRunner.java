package cli;

import algorithms.KadaneAlgorithm;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    
    public static void main(String[] args) {
        System.out.println("Kadane's Algorithm Benchmark");
        System.out.println("=============================");
        
        int[] sizes = {100, 1000, 10000, 100000};
        
        for (int size : sizes) {
            System.out.printf("\nTesting with n = %d\n", size);
            benchmarkWithSize(size);
        }
    }
    
    private static void benchmarkWithSize(int size) {
        KadaneAlgorithm algo = new KadaneAlgorithm();
        int[] testArray = generateTestArray(size);
        
        PerformanceTracker tracker = new PerformanceTracker();
        tracker.startTimer();
        
        KadaneAlgorithm.Result result = algo.findMaximumSubarray(testArray);
        
        tracker.stopTimer();
        tracker.incrementMetric("Comparisons", algo.getComparisonCount());
        tracker.incrementMetric("Array Accesses", algo.getArrayAccessCount());
        
        System.out.printf("Result: %s\n", result);
        tracker.printMetrics();
    }
    
    private static int[] generateTestArray(int size) {
        Random random = new Random(42);
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100) - 25;
        }
        
        return array;
    }
}