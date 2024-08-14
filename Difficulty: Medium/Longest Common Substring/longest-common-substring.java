//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int m = str1.length();
        int n = str2.length();
        int ans = 0;
        int dp[][] = new int[m+1][n+1];
        for(int i = 1; i <= m ; i++){
            for(int j =1; j<=n ; j++){
                if(str1.charAt(i - 1) == str2.charAt(j -1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                    ans = Math.max(ans , dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
         
          return ans; 
    }
}