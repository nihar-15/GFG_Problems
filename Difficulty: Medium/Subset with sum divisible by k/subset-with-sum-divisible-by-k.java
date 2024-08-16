//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.DivisibleByM(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int DivisibleByM(int[] arr, int k) {
         int n = arr.length;
        int[][] dp = new int[n + 1][k];
        for(int d[] : dp){
            Arrays.fill( d , -1);
        }
        return  func(arr , k , 0 , 0 , dp);
       
    }
    private int func(int[] arr, int k, int sum, int idx, int[][] dp) {
        if (idx == arr.length) {
            // Check if the sum is non-zero and divisible by k
            return (sum != 0 && sum % k == 0) ? 1 : 0;
        }

        // Take sum modulo k to reduce the state space
        int modSum = sum % k;
        if (dp[idx][modSum] != -1) {
            return dp[idx][modSum];
        }

        // Include current element in the subset
        int pick = func(arr, k, sum + arr[idx], idx + 1, dp);
        
        // Exclude current element from the subset
        int notPick = func(arr, k, sum, idx + 1, dp);

        // Store the result in dp array and return
        return dp[idx][modSum] = (pick > 0 || notPick > 0) ? 1 : 0;
    }
}