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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int findMinInsertions(String s){
        // code here
        int dp[][] = new int[s.length()][s.length()];
        for(int d[]: dp){
            Arrays.fill(d , -1);
        }
        return func(s , 0 , s.length()-1 , dp);
    }
    int func(String s , int left , int right , int dp[][]){
        if(left > right || right >= s.length() || left>= s.length() ){
            return 0;
        }
        if(left == right){
            if(s.charAt(left) == s.charAt(right)){
                return 0;
            }else{
                return 1;
            }
        }
        int ans =0;
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        if(s.charAt(left) == s.charAt(right)){
            return dp[left][right] = 0+ func(s , left+1, right-1 , dp);
        }else{
          ans =  Math.min(func(s, left,right-1 ,dp) , func(s , left+1 , right ,dp))+1;
        }
        return dp[left][right] = ans;
    }
}