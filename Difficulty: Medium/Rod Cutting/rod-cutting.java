//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int len = price.length;
        int dp[][] = new int[n+1][len+1];
        for(int d[] :dp){
            Arrays.fill(d , -1);
        }
        return func(price , n , 0 , dp);
    }
    int func(int price[] , int n , int idx , int dp[][]){
        if(n <= 0 || idx>= price.length){
            return 0;
        }
        int take = Integer.MIN_VALUE;
        if(dp[n][idx] != -1){
            return dp[n][idx];
        }
        if(n >= idx+1){
            take = price[idx] +func(price , n - (idx+1) , idx ,dp);
        }
        int notTake = func(price , n , idx+1 ,dp);
        return dp[n][idx] = Math.max(take , notTake);
    }
}