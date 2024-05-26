//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMinCost(String x, String y, int costX, int costY) {
        
        int len = lcs(x ,y);
        int ans =0;
        int n = x.length(),m = y.length();
        ans = (n-len)*costX + (m-len)*costY ;
        return ans;
        
    }
    public int lcs(String text1 , String text2){
        int n = text1.length();
     int m = text2.length();
     int dp[][] = new int[n][m];
     for(int a[] :dp){
        Arrays.fill(a , -1);
     }
    return  func(text1 , text2 , n-1, m-1, dp);

        }
        int func(String text1 , String text2, int n , int m, int dp[][]){
            if(n <0 || m<0){
                return 0;
            }
            if(dp[n][m] != -1){
                return dp[n][m];
            }
            if(text1.charAt(n) == text2.charAt(m)){
                return dp[n][m] = 1+ func(text1 , text2 , n-1 , m-1 , dp);
            }
            return dp[n][m]= 0 + Math.max(func(text1 , text2 ,n-1 , m ,dp) , func(text1 , text2 , n , m-1 , dp));
        }



}
