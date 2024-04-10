//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {

        // taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // taking total testcases
        int t = sc.nextInt();

        while (t-- > 0) {

            // taking total number of stairs
            int n = sc.nextInt();

            // creating an object of class DynamicProgramming
            Solution obj = new Solution();

            // calling method of class countWays()
            // of class DynamicProgramming
            System.out.println(obj.countWays(n));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to count number of ways to reach the nth stair
    // when order does not matter.
    Long countWays(int n) {
        // your code here
        
        return (long)(n/2)+1;
       /* if(n ==1){
            return (long)1;
        }
        long dp [] = new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i =2;i<=n;i++){
            dp[i]= dp[i-1]+dp[i-2];
        }
        return dp[n];*/
    }
}
