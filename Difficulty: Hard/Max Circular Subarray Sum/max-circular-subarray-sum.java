//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    public int circularSubarraySum(int arr[]) {

        // Your code here
        
       int n = arr.length;

        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxNormal = kadane(arr);
        if (maxNormal < 0) return maxNormal; // If all elements are negative

        // Step 2: Find the total sum of the array
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 3: Find the minimum subarray sum using Kadane's algorithm (on -arr)
        int minSubarraySum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i]; // Invert the array
        }
        minSubarraySum = kadane(arr);
        for (int i = 0; i < n; i++) {
            arr[i] = -arr[i]; // Revert the array to original
        }

        // Step 4: Calculate the maximum circular subarray sum
        int circularMax = totalSum + minSubarraySum; // TotalSum - (-minSubarraySum)

        // Step 5: Return the maximum of the two results
        return Math.max(maxNormal, circularMax);
    }

    // Helper method: Kadane's algorithm to find max subarray sum
    private int kadane(int[] arr) {
        int maxSum = arr[0];
        int currSum = 0;
        for (int num : arr) {
            currSum = Math.max(num, currSum + num);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
        
    }
}
