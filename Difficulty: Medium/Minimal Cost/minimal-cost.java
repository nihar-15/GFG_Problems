//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minimizeCost(int arr[], int N, int K) {
        // code here
        int dp[] = new int[N+1];
        Arrays.fill(dp , -1);
        
        return func(arr , 0 , N , K , dp);
    }
    
    int func(int arr[] , int i, int n , int k , int dp[]){
        
        if(i == n-1 ){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        int ans = Integer.MAX_VALUE;
        for(int diff = 1; diff<=k ;diff++){
            if(diff+i < n){
                int cost = Math.abs(arr[i+diff] -  arr[i])+ func(arr , i+diff ,n ,k , dp);
                ans = Math.min(ans , cost);
            }
            
        }
       return  dp[i] = ans;
    }
}
