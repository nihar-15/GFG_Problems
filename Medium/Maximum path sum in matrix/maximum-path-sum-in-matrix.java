//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int matrix[][])
    {
        // code here
          int n = matrix.length;
       int m = matrix[0].length;

         int dp[][]= new   int[n+1][m+1];
       for(int[] a : dp){
        Arrays.fill(a ,-1);
       }
       int mini =(int) -1e9;
       for(int i=0;i<m;i++){
          int ans =  func(matrix, 0 , i, dp);
           mini = Math.max(mini , ans);
     }

        return mini;
    
  
    }
    static int func(int [][]matrix, int i ,int j , int dp[][]){
        if(j>= matrix[0].length || j<0){
            return (int) -1e9;
        }
        if(i==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = matrix[i][j]+func(matrix , i+1,j, dp);
        int left = matrix[i][j]+func(matrix , i+1, j-1,dp);
        int right = matrix[i][j]+func(matrix , i+1, j+1,dp);

        return dp[i][j]=Math.max(down , Math.max(left , right));
    }
}