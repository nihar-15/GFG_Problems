//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int prices[]) {
        // code here
          int dp[][][] = new int[2][K+1][prices.length];
        for(int [][]d: dp){
            for(int a[] : d){
            Arrays.fill( a , -1);
        }
        }
      return func(prices , 0, 1 , K, dp);
    }
   static  int func(int prices[] , int day , int canBuy,  int capacity , int dp[][][]){
       if(capacity <=0 || day >= prices.length){
        return 0;
       }
       if(dp[canBuy][capacity][day] != -1 ){
         return dp[canBuy][capacity][day] ;
       }
       if(canBuy == 1 ){
        return dp[canBuy][capacity][day] =  Math.max(-prices[day]+func(prices, day+1, 0 , capacity , dp), func(prices, day+1, 1, capacity ,dp));
       }
       return dp[canBuy][capacity][day] = Math.max( prices[day]+func(prices, day+1, 1, capacity-1 ,dp) , func(prices, day+1 ,0 , capacity ,dp));
    }
    
    
}