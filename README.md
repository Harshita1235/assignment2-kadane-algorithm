# Assignment 2 – Kadane’s Algorithm  
**Course:** Algorithmic Analysis and Peer Code Review  
**Student:** [Your Name]  
**Pair:** Pair 3 – Linear Array Algorithms  
**Role:** Student B – Kadane’s Algorithm  

---

##  Overview

This project implements **Kadane’s Algorithm**, an efficient linear-time algorithm for finding the **maximum subarray sum** in an array of integers.  
It tracks not only the maximum sum but also the **starting and ending indices** of the subarray.

The implementation follows professional coding, testing, and performance benchmarking standards using **Java 11** and **Maven** with **JUnit 5**.

---

##  Algorithm Description

**Kadane’s Algorithm** works by iterating through the array and maintaining:
- `currentSum`: Maximum sum of the subarray ending at the current index.
- `maxSum`: Global maximum sum found so far.
- `start` and `end`: Track the subarray boundaries.

### **Time Complexity**
| Case | Complexity | Explanation |
|------|-------------|--------------|
| Best | Ω(n) | Single pass, no resets |
| Average | Θ(n) | Single traversal |
| Worst | O(n) | Still linear – iterates through all elements |

### **Space Complexity**
- O(1) auxiliary space (in-place computation).

---

##  Features & Implementation

| Component | Description |
|------------|--------------|
| **`algorithms/KadaneAlgorithm.java`** | Core implementation returning max sum and indices |
| **`metrics/PerformanceTracker.java`** | Tracks comparisons, array accesses, and execution time |
| **`cli/BenchmarkRunner.java`** | Runs performance tests for various input sizes |
| **`src/test/java/algorithms/KadaneAlgorithmTest.java`** | JUnit tests covering edge cases (empty, single, all negatives, mixed) |

---

## ⚙️ Project Setup

### **1️⃣ Prerequisites**
- Java 25 
- Maven 3.9+  
- Git (for version control)

### **2️⃣ Clone the Repository**
```bash
git clone https://github.com/your-username/assignment2-kadane-algorithm.git
cd assignment2-kadane-algorithm
