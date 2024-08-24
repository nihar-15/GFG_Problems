//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String St[] = read.readLine().split(" ");
            
            int X = Integer.parseInt(St[0]);
            int S = Integer.parseInt(St[1]);
            int M = Integer.parseInt(St[2]);
            int L = Integer.parseInt(St[3]);
            int CS = Integer.parseInt(St[4]);
            int CM = Integer.parseInt(St[5]);
            int CL = Integer.parseInt(St[6]);

            Solution ob = new Solution();
            System.out.println(ob.getPizza(X,S,M,L,CS,CM,CL));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getPizza(int X, int S, int M, int L, int CS, int CM, int CL) {
        // code here
        int cost[] = new int[3];
        int size[] = new int[3];
        cost[0] = CS;
        cost[1] = CM;
        cost[2] = CL;
        size[0] = S;
        size[1] = M;
        size[2] = L;
        int dp[] = new int[X+1];
        Arrays.fill(dp , -1);
        return func(X , cost , size , dp);
    }
    private static int func(int X , int cost[] , int size[] ,  int dp[]){
        
        if(X <= 0){
            return 0;
        }
        if(dp[X] != -1){
            return dp[X];
        }
        int op1 = cost[0] + func(X - size[0], cost , size, dp);
        int op2 = cost[1] + func(X - size[1], cost , size, dp);
        int op3 = cost[2] +func(X - size[2], cost , size, dp);
        return dp[X] = Math.min(op1 , Math.min(op2 , op3));
    }
};