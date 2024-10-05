//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int MOD = 1003;
     static int[][][] dp; // 3D DP array for memoization
    
    static int countWays(int n, String s){
        // Initialize dp array with -1, meaning not computed yet
        dp = new int[n][n][2];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }
        return func(s, 0, n - 1, 1);
    }
    
    static int func(String s, int i, int j, int isTrue){
        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue == 1){
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        
        // Check if already computed
        if(dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }

        int ways = 0;
        for(int k = i + 1; k <= j - 1; k += 2){
           int lT = func(s, i, k - 1, 1) % MOD;
            int lF = func(s, i, k - 1, 0) % MOD;
            int rT = func(s, k + 1, j, 1) % MOD;
            int rF = func(s, k + 1, j, 0) % MOD;
            
            char currentSymbol = s.charAt(k);
            if(currentSymbol == '&'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lT * rF) % MOD + (rT * lF) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if(currentSymbol == '|'){
                if(isTrue == 1){
                    ways = (ways + (lT * rT) % MOD + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else if(currentSymbol == '^'){ // XOR operator
                if(isTrue == 1){
                    ways = (ways + (lT * rF) % MOD + (lF * rT) % MOD) % MOD;
                } else {
                    ways = (ways + (lT * rT) % MOD + (lF * rF) % MOD) % MOD;
                }
            }
        }
        
        // Store result in dp array
        dp[i][j][isTrue] = ways;
        return ways;
    }
}