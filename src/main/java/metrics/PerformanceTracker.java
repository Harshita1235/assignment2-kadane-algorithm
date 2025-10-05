package metrics;

import java.util.HashMap;
import java.util.Map;

public class PerformanceTracker {
    private long startTime;
    private long endTime;
    private Map<String, Long> metrics;
    
    public PerformanceTracker() {
        this.metrics = new HashMap<>();
        reset();
    }
    
    public void startTimer() {
        startTime = System.nanoTime();
    }
    
    public void stopTimer() {
        endTime = System.nanoTime();
    }
    
    public long getElapsedTimeNanos() {
        return endTime - startTime;
    }
    
    public double getElapsedTimeMillis() {
        return (endTime - startTime) / 1_000_000.0;
    }
    
    public void incrementMetric(String metric, long value) {
        metrics.put(metric, metrics.getOrDefault(metric, 0L) + value);
    }
    
    public long getMetric(String metric) {
        return metrics.getOrDefault(metric, 0L);
    }
    
    public void reset() {
        startTime = 0;
        endTime = 0;
        metrics.clear();
    }
    
    public void printMetrics() {
        System.out.println("=== Performance Metrics ===");
        System.out.printf("Time elapsed: %.3f ms\n", getElapsedTimeMillis());
        for (Map.Entry<String, Long> entry : metrics.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
