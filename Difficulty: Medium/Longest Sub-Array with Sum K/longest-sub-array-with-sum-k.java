//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
        HashMap<Integer, Integer> sum_index_map
            = new HashMap<>();
        int maxLen = 0;
        int prefix_sum = 0;

        for (int i = 0; i < N; i++) {
            prefix_sum += A[i];

            if (prefix_sum == K) {
                maxLen = i + 1;
            }

            else if (sum_index_map.containsKey(prefix_sum - K)) {
                maxLen = Math.max(
                    maxLen,
                    i - sum_index_map.get(prefix_sum - K));
            }

            if (!sum_index_map.containsKey(prefix_sum)) {
                sum_index_map.put(prefix_sum, i);
            }
        }

        return maxLen;
    }
}
