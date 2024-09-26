//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        // Your code here
             int maxSteps = 0;  // To store the maximum consecutive steps
        int currentSteps = 0;  // To count the current consecutive steps

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                currentSteps++;  // Increment the current consecutive steps
            } else {
                maxSteps = Math.max(maxSteps, currentSteps);  // Update maxSteps if needed
                currentSteps = 0;  // Reset currentSteps since the altitude did not increase
            }
        }

        // Check once more in case the longest sequence is at the end of the array
        maxSteps = Math.max(maxSteps, currentSteps);

        return maxSteps;

    }
}