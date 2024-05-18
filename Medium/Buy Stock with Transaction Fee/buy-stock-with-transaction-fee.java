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
            long[] prices = new long[N];
            for (int i = 0; i < N; i++) {
                prices[i] = sc.nextLong();
            }
            int fee = sc.nextInt();
            Solution obj = new Solution();
            long res = obj.maximumProfit(prices, N, fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long maximumProfit(long prices[], int n, int fee) {
        // Code here
          long dp[][] = new long[prices.length+1][2];
       /* for(int d[]: dp){
            Arrays.fill(d , -1);
        }
        */
      for(int day =  prices.length-1 ;day>=0; day -- ){
        for(int canBuy=0;canBuy<=1; canBuy++){
            if(canBuy == 1){
                dp[day][canBuy] = Math.max(-prices[day] + dp[day+1][0] , dp[day+1][1]);
            }else{
                dp[day][canBuy]  =    Math.max( prices[day]+dp[day+1][1]-fee , dp[day+1][0]);
            }
        }
      }

   return dp[0][1];
    }
}