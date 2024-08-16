//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String s1){
        // code here
  String s2 = (new StringBuilder(s1)).reverse().toString();
        int n = s1.length();
        int dp[][] = new int[n+1][n+1];
        int ans = 0;
        int end = 0;
        
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    
                    // Check if this palindrome is longer than the previous longest one
                    if(dp[i][j] > ans){
                        int beforeRev = n - j; // Mapping index in s2 to s1
                        if(beforeRev + dp[i][j] == i){ // Ensure this is a valid palindrome
                            ans = dp[i][j];
                            end = i; // Set the ending position of the palindrome
                        }
                    }
                }
            }
        }
        return s1.substring(end - ans, end);
}
}