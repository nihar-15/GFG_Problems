//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int m = sc.nextInt();
            int coins[] = new int[m];
            for (int i = 0; i < m; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.minCoins(coins, m, v));
        }
    }
}
// } Driver Code Ends


class Solution {

    public int minCoins(int coins[], int M, int sum) {
         int dp[][] = new int[sum+1][M+1];
     for(int d[] : dp){
         Arrays.fill(d , -1);
     }
     int ans = func(coins, M, sum, 0 , dp);
    
        return ans == Integer.MAX_VALUE ? -1 : ans ;
    }
    int func(int coins[] , int M , int sum , int idx , int dp[][]){
        if(sum == 0){
            return 0;
        }
        if(sum < 0 || idx >= M){
            return Integer.MAX_VALUE;
        }
        if(dp[sum][idx] != -1){
            return dp[sum][idx];
        }
       int op1 = func(coins, M, sum - coins[idx], idx , dp);
        if (op1 != Integer.MAX_VALUE) {  // Check to avoid overflow
            op1 += 1;
        }
        int op2 = func(coins , M , sum  , idx+1, dp);
        return dp[sum][idx] = Math.min(op1 , op2);
    }
}