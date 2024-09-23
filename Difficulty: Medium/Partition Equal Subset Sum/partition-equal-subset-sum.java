//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code 
      int sum = 0;
        for (int a : arr) {
            sum += a;
        }
        if (sum % 2 == 1) {
            return 0;
        }
        int dp[][] = new int[N + 1][(sum / 2) + 1];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
        return func(arr, 0, sum / 2, dp);
    }

    static int func(int arr[], int idx, int sum, int dp[][]) {
        if (sum == 0) {
            return 1;  // If the sum is exactly 0, we've found a valid partition
        }
        if (idx >= arr.length || sum < 0) {
            return 0;  // If out of bounds or sum becomes negative, return failure
        }
        if (dp[idx][sum] != -1) {
            return dp[idx][sum];  // Use cached result
        }
        // Recursive case: explore taking or not taking the current element
        int take = func(arr, idx + 1, sum - arr[idx], dp);
        int notTake = func(arr, idx + 1, sum, dp);
        
        // Store the result: if either take or notTake succeeds, the answer is 1 (true)
        return dp[idx][sum] = (take == 1 || notTake == 1) ? 1 : 0;
    }
}







