//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer> > triangle= new ArrayList<ArrayList<Integer> >(n);
            for (int i = 0; i < n; i++) {
                ArrayList<Integer>temp=new ArrayList<Integer>();
                for(int j=0;j<=i;j++){
                    int x=sc.nextInt();
                    temp.add(x);
                }
                triangle.add(temp);
            }
            Solution obj = new Solution();
            int ans = obj.minimizeSum(n, triangle);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int minimizeSum(int n, ArrayList<ArrayList<Integer> >grid) {
        // Code here
        int col = grid.get(grid.size()-1).size();
        int dp[][] = new int[col][col];
        for(int a[]: dp){
            Arrays.fill(a , -1);
        }
        
        return func(0 ,0 , grid, dp);
    }
    static int func(int row , int col , ArrayList<ArrayList<Integer>> grid , int dp[][]){
       if(col >= grid.get(row).size()){
           return Integer.MAX_VALUE;
       }
        if(row == grid.size()-1){
            return dp[row][col] = grid.get(row).get(col);
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int a = func(row+1 , col , grid, dp);
        int b = func(row+1 , col+1 , grid, dp);
        
        return dp[row][col] = Math.min(a, b)+grid.get(row).get(col);
    }
}