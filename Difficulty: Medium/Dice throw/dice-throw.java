//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");

            int M = Integer.parseInt(S[0]);
            int N = Integer.parseInt(S[1]);
            int X = Integer.parseInt(S[2]);

            Solution ob = new Solution();
            System.out.println(ob.noOfWays(M, N, X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static long noOfWays(int m, int n, int x) {
        long dp[][] = new long[n+1][x+1];
        for(long d[] : dp){
            Arrays.fill(d , -1);
        }
        return func(m , n , x , dp);
    }
    static long func(int faceValue , int n , int sumRequired , long dp[][]){
     
       if(sumRequired == 0 && n == 0){
         return 1;
     }
     if(sumRequired < 0 || n == 0){
         return 0 ;
     }
     if(dp[n][sumRequired] != -1){
         return dp[n][sumRequired];
     }
     long ways = 0;
        for(int i = 1; i<= faceValue ; i++){
            ways += func(faceValue , n - 1 , sumRequired - i , dp);
        }
        return dp[n][sumRequired] = ways;
    }
};