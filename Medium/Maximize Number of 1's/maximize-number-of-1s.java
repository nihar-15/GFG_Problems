//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        
        
      int ans = 0;
        int start = 0, end = 0;
        int zeroCount = 0; // count of zeroes in the current window

        while (end < n) {
            if (arr[end] == 0) {
                zeroCount++;
            }

            // If the number of zeroes in the window exceeds m, adjust the window
            while (zeroCount > m) {
                if (arr[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            // Update the answer with the maximum length of consecutive ones
            ans = Math.max(ans, end - start + 1);
            end++;
        }

        return ans;
    }
}